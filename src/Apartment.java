public class Apartment extends Residence{
    private Integer floor;

    public Apartment(String address, Integer area, Float price, Integer floor){
        super(address, area, price);
        this.floor = floor;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
