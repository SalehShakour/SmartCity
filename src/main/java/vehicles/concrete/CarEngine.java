package vehicles.concrete;

public class CarEngine extends Engine {

    @Override
    public void noiseSuppress() {
        this.setNoise((short) (this.getNoise() - 1));
    }
}
