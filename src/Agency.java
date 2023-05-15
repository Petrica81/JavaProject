import Exceptions.DataException;
import Exceptions.LoginException;
import Models.*;

import javax.xml.crypto.Data;
import java.util.*;

public class Agency {
    private List<User> usersList = new ArrayList<>();
    private List<Contract> contractsList = new ArrayList<>();
    private Map<String, List<Residence>> residenceMap = new HashMap<String, List<Residence>>() {{
        put("House",new ArrayList<>());
        put("Apartment", new ArrayList<>());
        put("Penthouse", new ArrayList<>());
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

        List<Residence> residences = residenceMap.get("House");
        residences.add(new House("Bucuresti",30,9000, 10));
        residences.add(new House("Bucuresti",60,15000, 80));

        residences = residenceMap.get("Apartment");

        residences = residenceMap.get("Penthouse");
    }
    public List<User> getUsersList() {
        return usersList;
    }
    public List<Agent> getAgentsList(){
        List<Agent> aux = new ArrayList<>();
        for(User u: usersList){
            if(u instanceof Agent)
                aux.add((Agent) u);
        }
        if(aux.isEmpty())
            throw new DataException("No agents in database!");
        return aux;
    }
    public List<Client> getClientsList(){
        List<Client> aux = new ArrayList<>();
        for(User u: usersList){
            if(u instanceof Client)
                aux.add((Client) u);
        }
        if(aux.isEmpty())
            throw new DataException("No clients in database!");
        return aux;
    }
    public List<Contract> getContractsList() {
        if(contractsList.isEmpty())
            throw new DataException("No contracts in database!");
        return contractsList;
    }

    public Map<String, List<Residence>> getResidenceMap() {
        return residenceMap;
    }

    public List<Residence> getHouses(){
        List<Residence> aux = residenceMap.get("House");
        if(aux.isEmpty())
            throw new DataException("There are no houses in database!");
        return aux;
    }
    public List<Residence> getApartments(){
        List<Residence> aux = residenceMap.get("Apartment");
        if(aux.isEmpty())
            throw new DataException("There are no apartments in database!");
        return aux;
    }
    public List<Residence> getPenthouses(){
        List<Residence> aux = residenceMap.get("Penthouse");
        if(aux.isEmpty())
            throw new DataException("There are no penthouses in database!");
        return aux;
    }

    public void addResidence(Residence newResidence){
        String clasa = newResidence.getClass().getSimpleName();

        List<Residence> lista = residenceMap.get(clasa);

        lista.add(newResidence);
        residenceMap.put(clasa, lista);
    }
    public Optional<Agent> getAgentByName(String firstName, String lastName){
        for(User a: usersList)
            if(a instanceof Agent && a.getFirstName().equalsIgnoreCase(firstName) && a.getLastName().equalsIgnoreCase(lastName))
                return Optional.of((Agent) a);
        throw new DataException("This agent don't exist!");
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
            throw new LoginException("There is no agent with given name in database!");

        return agent.get();
    }
    public Client clientLogin(String firstName, String lastName){
        Optional<Client> client = getClientByName(firstName, lastName);
        if(client.isEmpty())
            throw new LoginException("There is no client with given name in database!");

        return client.get();
    }
    public void addUser(User user){
        usersList.add(user);
    }

    public Residence getResidenceById(UUID id){
        for(Residence casa: residenceMap.get("House"))
            if(casa.getId() == id)
                return casa;
        for(Residence casa: residenceMap.get("Apartment"))
            if(casa.getId() == id)
                return casa;
        for(Residence casa: residenceMap.get("Penthouse"))
            if(casa.getId() == id)
                return casa;

        throw new DataException("The residence with given id don't exist!");
    }
    public void addContract(Contract contract){
        contractsList.add(contract);
    }
    public void deleteResidence(Residence casa){
        List<Residence> lista = residenceMap.get(casa.getClass().getSimpleName());
        lista.remove(casa);
    }
}
