package Repositories;

import Models.*;
import database.ISQLiteConnection;

import java.sql.Statement;
import java.util.List;

public class JDBCUsers {

    private final ISQLiteConnection databaseConnection;
    private static final String getAgents = "SELECT * " +
                                            "FROM agents";

    public List<Agent> getAgentsList(){
        Statement st = databaseConnection.getCon().CreateStatement();
    }
}
