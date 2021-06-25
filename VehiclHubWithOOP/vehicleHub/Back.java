/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;
import java.awt.Polygon;

public class Back {
	private Wheel backWheel; //Aggregate
	private Exhust exhust; //Aggregate
	private Wings wings; //Aggregate
	private int vehicleID;
	private int height = 100;
	private int width = 100;
	private int slope;
	private Color color;

	public Back() {
		setDefaults();
	}
	
	public Back(int width, int height) {
		this.width = width;
		this.height = height;
		setDefaults();
	}
	
	public int getVehicleID() {
		return this.vehicleID;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setVehicleID(int ID) {
		this.vehicleID = ID;
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;
		backWheel.setDiameter((int)(this.width * 0.35));
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}

	private void setDefaults() {
		backWheel = new Wheel();
		backWheel.setDiameter((int)(width * 0.35));
		exhust = new Exhust();
		wings = new Wings();
		this.slope = (int) (height * 0.25);
		setColor(Color.BLACK);
	}

	private void drawCover(int left, int bottom) {
		Polygon p = placePolygon(left, bottom);
		Drawing.pen().setColor(this.color);
		Drawing.pen().fillPolygon(p);
		Drawing.pen().setColor(Color.CYAN);
		Drawing.pen().drawString("ID" + vehicleID, left, bottom - this.height / 2);
	}
	
	private Polygon placePolygon(int left, int bottom) {
		int[] xPoints = {left,
				left,
				left + this.width,
				left + this.width,
				left};
		int[] yPoints = {bottom- this.slope,
				bottom - this.height + this.slope,
				bottom - this.height,
				bottom,
				bottom - this.slope};
		int nPoints = 5;
		
		return new Polygon(xPoints,yPoints, nPoints);
	}
	
	public void drawAt(int left, int bottom) {
		drawCover(left, bottom);
		backWheel.drawAt(left + this.width, bottom);
		exhust.drawAt(left, (int) (bottom - height * 0.45));
		
		//wings.drawAt(left, bottom);
	}

	public void setTypeRims(String newTypeRims) {
		backWheel.setTypeRims(newTypeRims);
		
	}
	
	public void setWheelDiameter(int newDiameter) {
		backWheel.setDiameter(newDiameter);
	}

	public void setHeight(int height) {
		this.height = height;
		
	}

}