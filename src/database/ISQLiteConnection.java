package database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISQLiteConnection {
        Connection getCon();
        void close() throws SQLException;
}
