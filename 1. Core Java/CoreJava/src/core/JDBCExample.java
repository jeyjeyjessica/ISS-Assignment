package core;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCExample {

    private static final Logger logger = LogManager.getLogger(JDBCExample.class);

    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/youtube_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "A2009SJs!";

    // SQL queries
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS youtube (id INT AUTO_INCREMENT PRIMARY KEY, video_name VARCHAR(255), no_of_views INT)";
    private static final String INSERT_QUERY = "INSERT INTO youtube (video_name, no_of_views) VALUES (?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM youtube";
    private static final String UPDATE_QUERY = "UPDATE youtube SET video_name = ?, no_of_views = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM youtube WHERE id = ?";

    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                // Create table if not exists
                createTable(conn);

                // Insert data
                insertData(conn, "Introduction to Java", 1000);
                insertData(conn, "Comedy video", 2800);
                insertData(conn, "Mystery video", 38444);

                // Read data
                readData(conn);

                // Update data
                updateData(conn, 1, "Introduction to JDBC", 1200);

                // Read updated data
                readData(conn);

                // Delete data
                deleteData(conn, 1);

                // Read data after deletion
                readData(conn);
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Error executing JDBC operations: ", e);
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(CREATE_TABLE_QUERY);
            logger.info("Table created successfully.");
        }
    }

    private static void insertData(Connection conn, String videoName, int views) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY)) {
            pstmt.setString(1, videoName);
            pstmt.setInt(2, views);
            pstmt.executeUpdate();
            logger.info("Data inserted successfully.");
        }
    }

    private static void readData(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_QUERY);
            logger.info("Data retrieved from database:");
            while (rs.next()) {
                logger.info("ID: " + rs.getInt("id") + ", Video Name: " + rs.getString("video_name") + ", Views: " + rs.getInt("no_of_views"));
            }
        }
    }

    private static void updateData(Connection conn, int id, String videoName, int views) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {
            pstmt.setString(1, videoName);
            pstmt.setInt(2, views);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            logger.info("Data updated successfully.");
        }
    }

    private static void deleteData(Connection conn, int id) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            logger.info("Data deleted successfully.");
        }
    }
}
