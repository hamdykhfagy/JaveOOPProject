/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class WheelRims {
	private int diameter;

	public WheelRims() {
		int DEFAULT_RIM_DIAMETER = 40;
		setWidth(DEFAULT_RIM_DIAMETER);
	}

	public int getWidth() {
		return diameter;
	}
	
	public void setWidth(int newWidth) {
		this.diameter = newWidth;
	}
	
	public void drawAt(int left, int bottom) {
		drawAxes(left, bottom);
	}
	
	public void drawAxes(int left, int bottom) {
		int AxisDiameter = (int) (this.diameter * 0.2);
		Drawing.pen().setColor(Color.BLACK);
		Drawing.pen().fillOval(left - AxisDiameter / 2 , bottom - AxisDiameter / 2, AxisDiameter, AxisDiameter);
	}
}
