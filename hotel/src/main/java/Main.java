import java.sql.*;

public class Main {

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
    }
}
