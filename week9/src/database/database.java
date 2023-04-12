package database;

import java.sql.*;

import static view.view.getUser;

public class database {
    private static final String url = "jdbc:mySQL://localhost:3006/account";
    private static Statement statement;
    private static Connection connection;

    public database() throws SQLException {
//        Connection connection = DriverManager.getConnection(url);
//        statement = connection.createStatement();
    }

    public static Connection createConnection() throws SQLException {
        connection = null;
        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);
        String Url = "jdbc:mySQL://localhost:3306/account";
        String username = "root";
        String password ="";
        connection = DriverManager.getConnection(Url,username,password);
        statement = connection.createStatement();

        return  connection;
    }

    public static void closeDB(Connection c) throws SQLException {
        c.close();
    }
    public static void Insert(String name, String pass) throws SQLException {
        String query = "INSERT INTO account (username, pass)\n" +
                "VALUES (\""+name+"\", \""+pass+"\");";
        getStatement().executeUpdate(query);
    }
    public static void deleteTable(String name_table) throws SQLException {
        String query = "DROP TABLE " + name_table +";";
        getStatement().executeUpdate(query);
    }
    public static void deleteData(String name_table, String condition) throws SQLException {
        String query = "DELETE FROM "+name_table+" WHERE " +condition+";";
        getStatement().executeUpdate(query);
    }
     public static void update(String table_name,String username, String pass,String condition) throws SQLException {
        String query = "UPDATE "+table_name+"\n" +
                "SET username ='"+username+"', pass ='"+pass+"' " +
                "WHERE "+condition+";";
         getStatement().executeUpdate(query);
     }
    public static ResultSet select(String sl, String from, String condition) throws SQLException {
        String query = "SELECT "+sl+" FROM "+from+" \n" +
                "WHERE "+condition;
        ResultSet result =getStatement().executeQuery(query);

        return result;

    }
    public static Statement getStatement() {
        return statement;
    }

    public static Connection getConnection() {
        return connection;
    }
}
