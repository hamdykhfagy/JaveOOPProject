/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Wheel {
	private WheelRims rims;
	private Tyre tyre;
	private String typeRims;
	private int diameter; 

	public Wheel() {
		tyre = new Tyre();
		String DEFAULT_TYPE_RIM = "Sport";
		setTypeRims(DEFAULT_TYPE_RIM);
		setDiameter(50);
		setTyreThickness();

	}
	
	public Wheel(String typeRims) {
		setTypeRims(typeRims);
		tyre = new Tyre();
		setTyreThickness();
	}
	
	public boolean setTypeRims(String newTypeRims) {
		
		if (newTypeRims == "Sport") {
			rims = new SportRims();
			this.typeRims = newTypeRims;
			return true;
		} else if (newTypeRims == "Winter") {
			rims = new WinterRims();
			this.typeRims = newTypeRims;
			return true;
		}
		
		return false;
	}
	
	private void setTyreThickness() {
		if (typeRims == "Sport") {
			tyre.setTyreThickness((int) (0.1 * diameter));
		}
		else if (typeRims == "Winter") { 
			tyre.setTyreThickness((int) (0.2 * diameter));
		}
		
	}

	public void drawAt(int left, int bottom) {
		drawSpaceAboveTyre(left, bottom);
		drawTyre(left, bottom);
		drawRims(left, bottom);
		
	}

	private void drawSpaceAboveTyre(int left, int bottom) {
		Drawing.pen().setColor(Color.WHITE);
		Drawing.pen().fillOval(left - this.diameter, bottom - this.diameter / 2, diameter + tyre.getTyreThickness(), diameter + tyre.getTyreThickness());

	}
	
	private void drawTyre(int left, int bottom) {
		tyre.drawAt(left - this.diameter + tyre.getTyreThickness(), bottom - diameter / 2 + tyre.getTyreThickness(), diameter -  tyre.getTyreThickness(), diameter - tyre.getTyreThickness());
		
	}
	
	private void drawRims(int left, int bottom) {
		rims .setWidth(diameter - 3 * tyre.getTyreThickness());
		rims.drawAt(left - this.diameter + 2 * tyre.getTyreThickness(), bottom - diameter / 2 + 2 * tyre.getTyreThickness());
		
	}

	public int getDiameter() {
		return this.diameter;
	}
	
	public void setDiameter(int newDiamater) {
		this.diameter = newDiamater;
		setTyreThickness();
	}

}
