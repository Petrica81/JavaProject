package Models;

import Interfaces.IPrintable;

public class Client extends User implements IPrintable {
    private Integer wallet;

    public Client(String firstName, String lastName, String email, Integer wallet) {
        super(firstName,lastName,email);
        this.wallet = wallet;
    }
    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }
    @Override
    public String toString() {
        return "Client{" +
                "firstName = '" + super.getFirstName() + '\'' +
                ", lastName = '" + super.getLastName() + '\'' +
                ", email = '" + super.getEmail() + '\'' +
                ", wallet = " + this.wallet + '$' +
                "}\n";
    }
}
