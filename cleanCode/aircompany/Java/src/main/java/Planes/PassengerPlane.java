package planes;

public class PassengerPlane extends Plane{

    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;

        PassengerPlane that = (PassengerPlane) o;

        return getPassengersCapacity() == that.getPassengersCapacity();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPassengersCapacity();
        return result;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "passengersCapacity=" + passengersCapacity +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }
}
