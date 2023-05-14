import Exceptions.LoginException;
import Models.*;

import java.util.*;

public class Agency {
    private List<User> usersList = new ArrayList<>();
    private List<Contract> contractsList = new ArrayList<>();
    private Map<String, Residence> residenceMap = new HashMap<String, Residence>() {{
        put("House",new House("Bucuresti",60,15000, 80));
        put("Apartment", new Apartment("Bucuresti",60,10000, 3));
        put("Penthouse", new Penthouse("Bucuresti",70,30000, 200));
    }};
    private static class SingletonHolder{
        private static final Agency INSTANCE = new Agency();
    }
    public static Agency getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public void init(){
        usersList = new ArrayList<>(Arrays.asList(
                new Agent("Mihai","Popescu","popescumihai@gmail.pao",2300),
                new Agent("Adela","Corbeanu","corbeanuadela@gmail.cat",5000),
                new Client("Vasile","Ion","ionvasile@gmail.pao",40000),
                new Client("Stefan","Diaconu","diaconustefan@gmail.pao",100000),
                new Client("Andrei","Tava","tavaandrei@gmail.pao",500)
        ));
        residenceMap.put("House", new House("Bucuresti",30,9000, 10));

    }
    public List<User> getUsersList() {
        return usersList;
    }
    public List<Contract> getContractsList() {
        return contractsList;
    }

    public Map<String, Residence> getResidenceMap() {
        return residenceMap;
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
