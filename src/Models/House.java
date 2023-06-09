package Models;

import Interfaces.IPrintable;

public class House extends Residence implements IPrintable {
    private Integer gardenArea;

    public House(String address, Integer area, Integer price, Integer gardenArea){
        super(address, area, price);
        this.gardenArea = gardenArea;
    }

    public Integer getGardenArea() {
        return gardenArea;
    }

    public void setGardenArea(Integer gardenArea) {
        this.gardenArea = gardenArea;
    }
    @Override
    public String toString() {
        return "House{" +
                "id = " + super.getId() +
                ", address = '" + super.getAddress() + '\'' +
                ", area = " + super.getArea() + " m2" +
                ", price = " + super.getPrice() + '$' +
                ", gardenArea = " + this.getGardenArea() + " m2"+
                "}\n";
    }
}
