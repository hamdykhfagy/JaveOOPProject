/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;
import java.util.ArrayList;

import graphicState.EmptyHub;
import graphicState.FilledHub;
import graphicState.State;

public class Scene {
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private int vehicleID;
	private Random random;
	private static State graphicState;
	
	public Scene() {
		random = new Random();
		graphicState = EmptyHub.getInstance(this);
	}
	
	public void changeToFilledHub() {
		graphicState = graphicState.filledHub();
	}
	
	public void changeToEmptyHub() {
		graphicState = graphicState.emptyHub();
	}
	
	private boolean vacantProperty(Vehicle vehicle) {
		boolean result = true;
		for(Vehicle v : vehicles)
			if(vehicle.intersects(v)) {
				result = false;
				break;
			}
		return result;
	}
	
	private int getVehicleID(Vehicle v) {
		return vehicles.indexOf(v);
	}
	
	public void drawVehicles() {
		while (vehicles.size() < 10) {
			addNewVehicle();
		}
	}
	
	public void addNewVehicle() {
		Vehicle newVehicle = new Vehicle();
		final int LOWER_LIMIT_HEIGHT = 50;
		final int LOWER_LIMIT_WIDTH = 50;
		final int LOWER_LIMIT_LEFT = 0;
		final int UPPER_LIMIT_HEIGHT = 150;
		final int LOWER_LIMIT_BOTTOM = UPPER_LIMIT_HEIGHT;
		final int UPPER_LIMIT_WIDTH = 100;
		final int UPPER_LIMIT_LEFT = 1000;
		final int UPPER_LIMIT_BOTTOM = 800;
		newVehicle.setLeft(random.between(LOWER_LIMIT_LEFT, UPPER_LIMIT_LEFT));
		newVehicle.setBottom(random.between(LOWER_LIMIT_BOTTOM, UPPER_LIMIT_BOTTOM));
		newVehicle.setLength(random.between(LOWER_LIMIT_WIDTH, UPPER_LIMIT_WIDTH));
		newVehicle.setHeight(random.between(LOWER_LIMIT_HEIGHT, UPPER_LIMIT_HEIGHT));
		newVehicle.setTypeRims("Sport");
		newVehicle.setColor(random.randomColor());
		
		if(vacantProperty(newVehicle)) {
			vehicleID++;
			newVehicle.setID(vehicleID);
			vehicles.add(newVehicle);
		}
		else
			System.out.println("(" + newVehicle.getLeft() + ", " + newVehicle.getBottom() + ") is busy!!");
	}
	
	public void removeVehicles() {
		vehicles.clear();
		vehicleID = 0; 
	}
	
	public void removeRandomVehicle() {
		if(vehicles.size() > 0) {
		vehicles.remove(random.between(0, vehicles.size()-1));
		vehicleID--;
		}
	}
	
	public void setupVehicle() {
		//everything is controlable and just need the input way
		Vehicle newVehicle = new Vehicle();
		//setters needed are available
		newVehicle.draw();

	}
	
	public void showStatistics() {
		for (Vehicle v:vehicles) {
			System.out.println(v.getHeight());
			System.out.println(v.getLength());
			System.out.println(v.getColor());
			System.out.println(getVehicleID(v));
			System.out.println(v.getBottom());
		}
	}
	
	public void addNewVehicle(int left, int bottom, int width, int height) {
		Vehicle newVehicle = new Vehicle();
		newVehicle.setLeft(left);
		newVehicle.setBottom(bottom);
		newVehicle.setLength(width);
		newVehicle.setHeight(height);
		newVehicle.setTypeRims("Sport");
		newVehicle.setColor(Color.CYAN);
		
		if(vacantProperty(newVehicle)) {
			vehicleID++;
			newVehicle.setID(vehicleID);
			vehicles.add(newVehicle);
		}
		else 
			System.out.println("(" + left + ", " + bottom + ") is busy!!");
	} 
	
	public void draw() {
		for(Vehicle v: vehicles)
			v.draw();
	}
	
}