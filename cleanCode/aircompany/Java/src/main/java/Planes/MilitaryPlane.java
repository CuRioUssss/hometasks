package planes;

import models.MilitaryType;

public class MilitaryPlane extends Plane {

    private MilitaryType militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = type;
    }

    public MilitaryType getType() {
        return militaryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;

        MilitaryPlane that = (MilitaryPlane) o;

        return militaryType == that.militaryType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + militaryType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MilitaryPlane{" +
                "militaryType=" + militaryType +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }
}


