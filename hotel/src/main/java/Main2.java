import services.BreakfastService;
import services.GuestService;
import services.HotelService;
import services.ReservationService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main2 {
    public static void main(String[] args) {
        /* dynamically load the JDBC driver for PostgreSQL */
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /* open a new database connection and then close it */
        Connection c;
        try {
            c = DriverManager.getConnection(
                    "jdbc:postgresql://slon.felk.cvut.cz:5432/klimoval",
                    "klimoval",
                    "hGD6n9yKH2"
            );
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HotelPU");

        Utils utils = new Utils(emf);
        HotelService hotelService = new HotelService(emf);
        BreakfastService breakfastService = new BreakfastService(emf);
        ReservationService reservationService = new ReservationService(emf);
        GuestService guestService = new GuestService(emf);


//        System.out.println(breakfastService.getBreakfastByPK(new BreakfastPK(1, LocalDate.of(2022, 1, 2))).getMenu());
//        utils.reserve_meal_in_hotel(guestService.getGuest(4042), hotelService.getHotelById(1), LocalDate.of(2022, 1, 2), reservationService.getReservationById(115891), LocalTime.of(8,45,0));

//        utils.changeBreakfastMenuOfHotel(hotelService.getHotelById(1), "club sandwich", "club sandwiches");

//        List<String> hotels = utils.hotelsThatServeBavarianSausageOrClubSandwich();
//        for (String hotel : hotels) {
//            System.out.println(hotel);
//        }

//        utils.deleteEmployeeHotelHistory();
//        utils.insertEmployeeHotelHistory();
    }
}
