import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;
	
	public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {        
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {if (plane instanceof PassengerPlane) {passengerPlanes.add((PassengerPlane) plane);}}
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            } 
        } 
        return militaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
		int maxCapacity=planeWithMaxCapacity.getPassengersCapacity();
        for (PassengerPlane passengerPlane:passengerPlanes) {			
			int currentCapacity=passengerPlane.getPassengersCapacity();
                if (currentCapacity > maxCapacity) {
                    planeWithMaxCapacity = passengerPlane;
					maxCapacity=currentCapacity;
                }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes=getMilitaryPlanes();
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();        
        for (MilitaryPlane militaryPlane:militaryPlanes) {            
            if (militaryPlane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes=getMilitaryPlanes();
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();        
        for (MilitaryPlane militaryPlane:militaryPlanes) {                
                if (militaryPlane.getType() == MilitaryType.BOMBER) {
                    bomberMilitaryPlanes.add(militaryPlane);
                }
        }
        return bomberMilitaryPlanes;
    }

    public List<MilitaryPlane> getFighterMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes=getMilitaryPlanes();
        List<MilitaryPlane> fighterMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane:militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.FIGHTER) {
                fighterMilitaryPlanes.add(militaryPlane);
            }
        }
        return fighterMilitaryPlanes;
    }

    public void sortByMaxDistance() {
        Collections.sort(planes, getMaxDistanceComparator());
    }    
         
    public void sortByMaxSpeed() {
        Collections.sort(planes, getMaxSpeedComparator());
    }

    public void sortByMaxLoadCapacity() {
        Collections.sort(planes,getMaxLoadCapacityComparator());
    }

    public Comparator<Plane> getMaxDistanceComparator(){
	    return new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        };
    }

    public Comparator<Plane> getMaxSpeedComparator(){
        return new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        };
    }

    public Comparator<Plane> getMaxLoadCapacityComparator(){
        return new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        };
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private String printPlanesList(List<? extends Plane> planesList) {
        StringBuilder planesStringBuilder=new StringBuilder();
        for(Plane plane:planesList){
			planesStringBuilder.append(plane.toString()+"\n") ;
		}
		return planesStringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Airport{" +
                "planes= \n" + printPlanesList(planes) +
                '}';
    }
}
