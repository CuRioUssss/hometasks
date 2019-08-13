import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static Airport airport = new Airport(planes);
    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    private static MilitaryPlane transportMilitaryPlane=new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT);
    private static MilitaryPlane bomberMilitaryPlane=new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER);
    private static MilitaryPlane fighterMilitaryPlane=new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER);
    private static List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
    private static List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
    private static List<MilitaryPlane> fighterMilitaryPlanes = airport.getFighterMilitaryPlanes();
    private static Comparator<Plane> maxDistanceComparator=airport.getMaxDistanceComparator();
    private static Comparator<Plane> maxSpeedComparator=airport.getMaxSpeedComparator();
    private static Comparator<Plane> maxLoadCapacityComparator=airport.getMaxLoadCapacityComparator();
    @Test
    public void listOfTransportMilitaryPlanesShouldContainTransportMilitaryPlane() {
        Assert.assertTrue(transportMilitaryPlanes.contains(transportMilitaryPlane));
    }

    @Test
    public void listOfTransportMilitaryPlanesShouldNotContainBomberMilitaryPlane() {
        Assert.assertFalse(transportMilitaryPlanes.contains(bomberMilitaryPlane));
    }

    @Test
    public void listOfTransportMilitaryPlanesShouldNotContainFighterMilitaryPlane() {
        Assert.assertFalse(transportMilitaryPlanes.contains(fighterMilitaryPlane));
    }

    @Test
    public void listOfBomberMilitaryPlanesShouldContainBomberMilitaryPlane() {
        Assert.assertTrue(bomberMilitaryPlanes.contains(bomberMilitaryPlane));
    }

    @Test
    public void listOfBomberMilitaryPlanesShouldNotContainTransportMilitaryPlane() {
        Assert.assertFalse(bomberMilitaryPlanes.contains(transportMilitaryPlane));
    }

    @Test
    public void listOfBomberMilitaryPlanesShouldNotContainFighterMilitaryPlane() {
        Assert.assertFalse(bomberMilitaryPlanes.contains(fighterMilitaryPlane));
    }

    @Test
    public void listOfFighterMilitaryPlanesShouldContainFighterMilitaryPlane() {
        Assert.assertTrue(fighterMilitaryPlanes.contains(fighterMilitaryPlane));
    }

    @Test
    public void listOfFighterMilitaryPlanesShouldNotContainTransportMilitaryPlane() {
        Assert.assertFalse(fighterMilitaryPlanes.contains(transportMilitaryPlane));
    }

    @Test
    public void listOfFighterMilitaryPlanesShouldNotContainBomberMilitaryPlane() {
        Assert.assertFalse(fighterMilitaryPlanes.contains(bomberMilitaryPlane));
    }

    @Test
    public void methodGetPassengerPlaneWithMaxCapacityShouldReturnPlaneWithMaxPassengerCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void maxDistanceComparatorShouldReturnPositiveNumberIfFirstPlaneMaxDistanceIsMoreThanSecondOne(){
        Assert.assertTrue(maxDistanceComparator.compare(bomberMilitaryPlane,fighterMilitaryPlane)>0);
    }

    @Test
    public void maxDistanceComparatorShouldReturnNegativeNumberIfFirstPlaneMaxDistanceIsLessThanSecondOne(){
        Assert.assertTrue(maxDistanceComparator.compare(fighterMilitaryPlane,bomberMilitaryPlane)<0);
    }

    @Test
    public void maxDistanceComparatorShouldReturnZeroIfFirstPlaneMaxDistanceIsEqualsToSecondOne(){
        Assert.assertTrue(maxDistanceComparator.compare(fighterMilitaryPlane,fighterMilitaryPlane)==0);
    }

    @Test
    public void maxSpeedComparatorShouldReturnPositiveNumberIfFirstPlaneMaxSpeedIsMoreThanSecondOne(){
        Assert.assertTrue(maxSpeedComparator.compare(fighterMilitaryPlane,bomberMilitaryPlane)>0);
    }

    @Test
    public void maxSpeedComparatorShouldReturnNegativeNumberIfFirstPlaneMaxSpeedIsLessThanSecondOne(){
        Assert.assertTrue(maxSpeedComparator.compare(bomberMilitaryPlane,fighterMilitaryPlane)<0);
    }

    @Test
    public void maxSpeedComparatorShouldReturnZeroIfFirstPlaneMaxSpeedIsEqualsToSecondOne(){
        Assert.assertTrue(maxSpeedComparator.compare(fighterMilitaryPlane,fighterMilitaryPlane)==0);
    }

    @Test
    public void maxLoadCapacityComparatorShouldReturnPositiveNumberIfFirstPlaneMaxLoadCapacityIsMoreThanSecondOne(){
        Assert.assertTrue(maxLoadCapacityComparator.compare(transportMilitaryPlane,bomberMilitaryPlane)>0);
    }

    @Test
    public void maxLoadCapacityComparatorShouldReturnNegativeNumberIfFirstPlaneMaxLoadCapacityIsLessThanSecondOne(){
        Assert.assertTrue(maxLoadCapacityComparator.compare(bomberMilitaryPlane,transportMilitaryPlane)<0);
    }

    @Test
    public void maxLoadCapacityComparatorShouldReturnZeroIfFirstPlaneMaxLoadCapacityIsEqualsToSecondOne(){
        Assert.assertTrue(maxLoadCapacityComparator.compare(transportMilitaryPlane,transportMilitaryPlane)==0);
    }
}
