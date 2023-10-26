package application;

import java.sql.*;

public class DatabaseConnection {

    private static final String url = "jdbc:sqlite:DataAnalyticsHub.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void initialize() {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            String sqlUsers = "CREATE TABLE IF NOT EXISTS Users ("
                    + "username TEXT PRIMARY KEY,"
                    + "password TEXT NOT NULL,"
                    + "firstName TEXT,"
                    + "lastName TEXT,"
                    + "isVIP BOOLEAN NOT NULL DEFAULT FALSE);";

            String sqlPosts = "CREATE TABLE IF NOT EXISTS Posts ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "content TEXT,"
                    + "author TEXT,"
                    + "likes INTEGER,"
                    + "shares INTEGER,"
                    + "dateTime TEXT);";

            stmt.execute(sqlUsers);
            stmt.execute(sqlPosts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addUser(String username, String password, String firstName, String lastName, boolean isVIP) {
        String sql = "INSERT INTO Users(username, password, firstName, lastName, isVIP) VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setBoolean(5, isVIP);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            if(e.getMessage().contains("SQLITE_CONSTRAINT")) {
                System.out.println("Error: The username '" + username + "' already exists.");
            } else {
                e.printStackTrace();
            }
        }
    }

    public static void addPost(String content, String author, int likes, int shares, String dateTime) {
        String sql = "INSERT INTO Posts(content, author, likes, shares, dateTime) VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, content);
            pstmt.setString(2, author);
            pstmt.setInt(3, likes);
            pstmt.setInt(4, shares);
            pstmt.setString(5, dateTime);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initialize(); // Initialize database and tables

        // Add users and posts as necessary
        addUser("Deepak", "password", "Deepak", "Gajmer", false);
        addPost("This is a post content.", "Deepak", 5, 2, "2021-10-22 10:30:00");
    }
}
