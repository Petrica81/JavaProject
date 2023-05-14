package Models;

public class Agent extends User{
    private Integer salary;

    public Agent(String firstName, String lastName, String email, Integer salary) {
        super(firstName,lastName,email);
        this.salary = salary;
    }
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "firstName = '" + super.getFirstName() + '\'' +
                ", lastName = '" + super.getLastName() + '\'' +
                ", email = '" + super.getEmail() + '\'' +
                ", salary = " + this.salary + '$' +
                '}';
    }
}
