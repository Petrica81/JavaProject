public class Penthouse extends Residence{
    private Integer poolSize;

    public Penthouse(String address, Integer area, Float price, Integer poolSize){
        super(address, area, price);
        this.poolSize = poolSize;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }
}
