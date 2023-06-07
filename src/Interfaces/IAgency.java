package Interfaces;
import Models.*;
import java.util.Optional;
import java.util.UUID;

public interface IAgency {
    void init();
    Optional<Agent> getAgentByName(String firstName, String lastName);
    Optional<Client> getClientByName(String firstName, String lastName);
    Agent agentLogin(String firstName, String lastName);
    Client clientLogin(String firstName, String lastName);
    void addUser(User user);
    Residence getResidenceById(UUID id);
    void addContract(Contract contract);
    void deleteResidence(Residence casa);
}
