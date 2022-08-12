package fairyShop.models;

import java.util.Collection;

public class BaseHelper implements Helper {

    @Override
    public void work() {

    }

    @Override
    public void addInstrument(Instrument instrument) {

    }

    @Override
    public boolean canWork() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getEnergy() {
        return 0;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return null;
    }
}
