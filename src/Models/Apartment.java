package Models;

import Interfaces.IPrintable;

public class Apartment extends Residence implements IPrintable {
    private Integer floor;

    public Apartment(String address, Integer area, Integer price, Integer floor){
        super(address, area, price);
        this.floor = floor;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    @Override
    public String toString() {
        return "House{" +
                "id = " + super.getId() +
                ", address = '" + super.getAddress() + '\'' +
                ", area = " + super.getArea() + " m2" +
                ", price = '" + super.getPrice() + '$' +
                ", floor = " + this.getFloor() +
                "}\n";
    }
}
