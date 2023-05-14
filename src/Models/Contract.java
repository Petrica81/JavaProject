package Models;

import java.time.LocalDate;

public class Contract {
    private Client buyer;
    private Agent seller;
    private Residence item;
    private LocalDate purchaseDate;

    public Contract(Client buyer, Agent seller, Residence item) {
        this.buyer = buyer;
        this.seller = seller;
        this.item = item;
        this.purchaseDate = LocalDate.now();
    }

    public Client getBuyer() {
        return buyer;
    }

    public void setBuyer(Client buyer) {
        this.buyer = buyer;
    }

    public Agent getSeller() {
        return seller;
    }

    public void setSeller(Agent seller) {
        this.seller = seller;
    }

    public Residence getItem() {
        return item;
    }

    public void setItem(Residence item) {
        this.item = item;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
