package Models;

public abstract class Residence {
    private String address;
    private Integer area;
    private Integer price;

    public Residence(String address, Integer area, Integer price){
        this.address = address;
        this.area = area;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
