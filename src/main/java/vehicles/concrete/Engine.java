package vehicles.concrete;

public abstract class Engine {
    private short powerStock;
    private short model;
    private Boolean power;
    private Boolean cost;
    private short noise;
    private Boolean destroyed;
    public void destroy(){
        this.setDestroyed(true);
    }
    public abstract void noiseSuppress();

    protected short getPowerStock() {
        return powerStock;
    }

    protected void setPowerStock(short powerStock) {
        this.powerStock = powerStock;
    }

    protected short getModel() {
        return model;
    }

    protected void setModel(short model) {
        this.model = model;
    }

    protected Boolean getPower() {
        return power;
    }

    protected void setPower(Boolean power) {
        this.power = power;
    }

    protected Boolean getCost() {
        return cost;
    }

    protected void setCost(Boolean cost) {
        this.cost = cost;
    }

    protected short getNoise() {
        return noise;
    }

    protected void setNoise(short noise) {
        this.noise = noise;
    }

    protected Boolean getDestroyed() {
        return destroyed;
    }

    protected void setDestroyed(Boolean destroyed) {
        this.destroyed = destroyed;
    }
}
