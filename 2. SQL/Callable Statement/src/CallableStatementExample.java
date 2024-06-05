import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class CallableStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fitness_tracker";
        String user = "root";  // MySQL username
        String password = "A2009SJs!";  // MySQL password

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Prepare the callable statement
            String query = "{CALL GetUser(?)}";
            CallableStatement cstmt = con.prepareCall(query);

            // Set the input parameter (user ID)
            cstmt.setInt(1, 1);

            // Execute the stored procedure
            ResultSet rs = cstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Email: " + rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
