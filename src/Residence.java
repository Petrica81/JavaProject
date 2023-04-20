public abstract class Residence {
    private String address;
    private Integer area;
    private Float price;

    public Residence(String address, Integer area, Float price){
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
