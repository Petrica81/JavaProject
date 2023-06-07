package database;

import java.sql.*;
public class SQLiteConnection implements ISQLiteConnection{
    private final String URL = "jdbc:sqlite:C:/sqlite/PAOdatabase/PAO.db";
    private Connection conn;
    static SQLiteConnection instance = null;

    private SQLiteConnection(){
        try {
            this.conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static public SQLiteConnection getInstance() {
        if (instance == null){
            instance = new SQLiteConnection();
        }
        return instance;
    }

    @Override
    public Connection getCon() {
        return conn;
    }

    @Override
    public void close() throws SQLException{
        conn.close();
    }
}
