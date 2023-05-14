import Exceptions.LoginException;
import Models.*;

import java.util.*;

public class Agency {
    private List<User> usersList = new ArrayList<>();
    private List<Contract> contractsList = new ArrayList<>();
    private Map<String, List<Residence>> ResidenceMap = new HashMap<>();
    private static class SingletonHolder{
        private static final Agency INSTANCE = new Agency();
    }

    public static Agency getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public List<User> getUsersList() {
        return usersList;
    }
    public List<Contract> getContractsList() {
        return contractsList;
    }

    public Map<String, List<Residence>> getResidenceMap() {
        return ResidenceMap;
    }

    public Optional<Agent> getAgentByName(String firstName, String lastName){
        for(User a: usersList)
            if(a instanceof Agent && a.getFirstName().equalsIgnoreCase(firstName) && a.getLastName().equalsIgnoreCase(lastName))
                return Optional.of((Agent) a);
        return Optional.empty();
    }
    public Optional<Client> getClientByName(String firstName, String lastName){
        for(User c: usersList)
            if(c instanceof Client && c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName))
                return Optional.of((Client) c);
        return Optional.empty();
    }
    public Agent agentLogin(String firstName, String lastName){
        Optional<Agent> agent = getAgentByName(firstName, lastName);
        if(agent.isEmpty())
            throw new LoginException("There is no agent with given name in database");

        return agent.get();
    }
    public Client clientLogin(String firstName, String lastName){
        Optional<Client> client = getClientByName(firstName, lastName);
        if(client.isEmpty())
            throw new LoginException("There is no client with given name in database");

        return client.get();
    }
    public void addUser(User user){
        usersList.add(user);
    }
}
