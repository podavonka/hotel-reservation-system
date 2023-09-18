import services.*;
import entity.*;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Utils {

    private EntityManagerFactory emf;
    private BreakfastService breakfastService;
    private MealService mealService;
    private HotelService hotelService;
    private EmploymentService employmentService;
    private EmployeeService employeeService;

    public Utils(EntityManagerFactory emf) {
        this.emf = emf;
        breakfastService = new BreakfastService(emf);
        mealService = new MealService(emf);
        hotelService = new HotelService(emf);
        employmentService = new EmploymentService(emf);
        employeeService = new EmployeeService(emf);
    }

    public boolean reserve_meal_in_hotel(Guest guest, Hotel hotel, LocalDate date, Reservation reservation, LocalTime reservedTime) {
        Breakfast breakfast = breakfastService.getBreakfastByPK(new BreakfastPK(hotel.getHotelId(), date));
        int currPortions = breakfast.getPortions();
        int currReserved = breakfast.getReserved();

        if (currReserved >= currPortions) return false;

        breakfast.setReserved(breakfast.getReserved() + 1);
        breakfastService.updateBreakfast(breakfast);

        Meal meal = new Meal(guest, breakfast, reservation, reservedTime);
        mealService.addMeal(meal);

        return true;
    }

    public void changeBreakfastMenuOfHotel(Hotel hotel, String oldMenu, String newMenu) {
        List<Breakfast> breakfasts = breakfastService.getAllBreakfasts(hotel);
        for (Breakfast breakfast : breakfasts) {
            if (breakfast.getMenu().equals(oldMenu)) {
                breakfast.setMenu(newMenu);
                breakfastService.updateBreakfast(breakfast);
            }
        }
    }

    public List<String> hotelsThatServeBavarianSausageOrClubSandwich() {
        List<Breakfast> breakfasts = breakfastService.getAllBreakfasts();
        List<Hotel> hotels = new ArrayList<>();
        for (Breakfast breakfast : breakfasts) {
            if (breakfast.getMenu().equals("bavarian sausage") || breakfast.getMenu().equals("club sandwich")) {
                Hotel hotel = hotelService.getHotelById(breakfast.getBreakfastPK().getHotel());
                hotels.add(hotel);
            }
        }
        return hotels.stream()
                .map(Hotel::getName)
                .distinct()
                .collect(toList());
    }

    public void insertEmployeeHotelHistory() {
        List<Employment> employments = employmentService.getAllEmployments();
        for (Employment employment : employments) {
            Employee employee = employment.getEmployee();
            Hotel hotel = employment.getHotel();

            employee.addHotel(hotel);
            hotel.addEmployee(employee);

            employeeService.updateEmployee(employee);
            hotelService.updateHotel(hotel);
        }
    }

    public void deleteEmployeeHotelHistory() {
        List<Employee> employees = employeeService.getAllEmployees();
        List<Hotel> hotels = hotelService.getAllHotels();

        for (Employee employee : employees) {
            employee.deleteHotels();
            employeeService.updateEmployee(employee);
        }

        for (Hotel hotel : hotels) {
            hotel.deleteEmployees();
            hotelService.updateHotel(hotel);
        }
    }
}