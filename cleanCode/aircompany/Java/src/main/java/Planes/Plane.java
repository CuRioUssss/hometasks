package planes;

public abstract  class Plane {
    protected String model;
    protected int maxSpeed;
    protected int maxFlightDistance;
    protected int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public void setMaxFlightDistance(int maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;

        Plane plane = (Plane) o;

        if (getMaxSpeed() != plane.getMaxSpeed()) return false;
        if (getMaxFlightDistance() != plane.getMaxFlightDistance()) return false;
        if (getMaxLoadCapacity() != plane.getMaxLoadCapacity()) return false;
        return getModel().equals(plane.getModel());
    }

    @Override
    public int hashCode() {
        int result = getModel().hashCode();
        result = 31 * result + getMaxSpeed();
        result = 31 * result + getMaxFlightDistance();
        result = 31 * result + getMaxLoadCapacity();
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }
}


