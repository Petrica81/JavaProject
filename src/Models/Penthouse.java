package Models;

import Interfaces.IPrintable;

public class Penthouse extends Residence implements IPrintable {
    private Integer poolSize;

    public Penthouse(String address, Integer area, Integer price, Integer poolSize){
        super(address, area, price);
        this.poolSize = poolSize;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }
    @Override
    public String toString() {
        return "Penthouse{" +
                "id = " + super.getId() +
                ", address = '" + super.getAddress() + '\'' +
                ", area = " + super.getArea() + " m2" +
                ", price = '" + super.getPrice() + '$' +
                ", poolSize = " + this.getPoolSize() + " L" +
                "}\n";
    }
}
