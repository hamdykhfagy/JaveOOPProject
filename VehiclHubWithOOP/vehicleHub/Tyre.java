/**
 *
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Tyre {
	private int diameter;
	private int thickness;
	
	public Tyre() {
		thickness = 10;
		
	}
	
	public void setTyreThickness(int newThickness) {
		this.thickness = newThickness;
	}
	
	public int getTyreThickness() {
		return this.thickness;
	}
	
	public void setDiameter(int newDiameter) {
		this.diameter = newDiameter;
	}
	
	public int getDiaameter() {
		return this.diameter;
	}
	
	public void drawAt(int x, int y, int width, int height) {
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillOval(x, y, width, height);

	}

}
