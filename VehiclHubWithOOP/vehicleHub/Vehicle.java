/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Point;
import java.awt.Color;

public class Vehicle implements LocatedRectangle{
	private int left;
	private int bottom;
	private Front front; // composite
	private Middle body; //composite
	private Back back; //composite
	private int carLength = 200; //default value
	private int height = 100;
	private static int LOWR_LIMIT_CAR_LENGTH = 250;
	private static int  UPPER_LIMIT_LENGTH = 500;
	private Color color;

	public Vehicle() {
		setDefaults();
	}
	
	public Vehicle(int left, int bottom) {
		setDefaults();
		//override 
		setLeft(left);
		setBottom(bottom);
		setLengthVehicleParts();

	}
	
	public Vehicle(int left, int bottom, int width, int height) {
		setDefaults();
		//override 
		setLeft(left);
		setBottom(bottom);
		setLength(width);
		setHeight(height);
		setLengthVehicleParts();

	}
	
	private void setDefaults() {		
		back = new Back();
		body = new Middle();
		front = new Front();
		
		setLengthVehicleParts();
	}
	
	private void setLengthVehicleParts() {
		int widthBack = (int) (0.3 * this.carLength);
		int widthMiddle = (int) (0.4 * this.carLength);
		int widthFront = (int) (0.3 * this.carLength);
		back.setWidth(widthBack);
		body.setWidth(widthMiddle);
		front.setWidth(widthFront);
	}
	
	public void setID(int ID) {
		back.setVehicleID(ID);
	}
	
	public int getID() {
		return back.getVehicleID();
	}
	
	public boolean setLength(int newLength) {
		if(newLength >= LOWR_LIMIT_CAR_LENGTH && newLength <= UPPER_LIMIT_LENGTH) {
			this.carLength = newLength;
			setLengthVehicleParts();
			return true;
		} else
			return false;
	}
	
	public boolean setHeight(int newHeight) {
		if(newHeight > 0) {
			this.height = newHeight;
			body.setHeight(this.height);
			back.setHeight(this.height);
			front.setHeight(this.height);
		}
		else
			return false;
		return true;
		
	}
	
	public boolean setLeft(int newHeight) {
		if(newHeight > 0)
			this.left = newHeight;
		else
			return false;
		return true;
		
	}
	
	public boolean setBottom(int newBottom) {
		if(newBottom > 0)
			this.bottom = newBottom;
		else
			return false;
		return true;
		
	}
	
	public int getLength() {
		return this.carLength;
	}
	
	public int getHeight() {
		return (int) ( 1.8 * this.height); // roof + body
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		front.setColor(color);
		body.setColor(color);
		back.setColor(color);
		//this.color =color;
	}

	public boolean setTypeRims(String newTypeRims) {
		front.setTypeRims(newTypeRims);
		back.setTypeRims(newTypeRims);
		return true;
	}
	
	public void drawAt(int left, int bottom) {
		back.drawAt(left, bottom);
		body.drawAt(left + back.getWidth(), bottom);
		front.drawAt(left + back.getWidth() + body.getWidth(), bottom);
	}
	
	@Override
	public Point address() {
		return new Point(this.left, this.bottom);
	}
	
	@Override
	public int width() {
		return this.carLength;
	}
	
	@Override
	public int height() {
		return this.getHeight();
	}
	
	@Override
	public void draw() {
		drawAt(this.left, this.bottom);
	}

	public int getBottom() {
		return this.bottom;
	}

	public int getLeft() {
		return this.left;
	}

}
