package Models;

public class House extends Residence {
    private Integer gardenArea;

    public House(String address, Integer area, Float price, Integer gardenArea){
        super(address, area, price);
        this.gardenArea = gardenArea;
    }

    public Integer getGardenArea() {
        return gardenArea;
    }

    public void setGardenArea(Integer gardenArea) {
        this.gardenArea = gardenArea;
    }
}
