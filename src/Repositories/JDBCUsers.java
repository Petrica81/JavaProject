package Repositories;

import Models.*;
import database.ISQLiteConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCUsers {

    private final ISQLiteConnection databaseConnection;
    private static final String getAgents = "SELECT * " +
                                            "FROM agents";

    public JDBCUsers(ISQLiteConnection connection){
        this.databaseConnection = connection;
    }
    public List<Agent> getAgentsList(){
        try{
            Statement st = databaseConnection.getCon().createStatement();
            ResultSet result = st.executeQuery(getAgents);

            List<Agent> agents = new ArrayList<>();
            while(result.next()){
                String firstname = result.getString("firstName");
                String lastname = result.getString("lastName");
            }
            return agents;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
