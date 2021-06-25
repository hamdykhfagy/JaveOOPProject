/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Middle {
	private Frame frame; //aggrigate
	private Doors doors; //aggrigate
	private int height = 100; //question: this variable is important but I don't need it, Should I omit it?
	private int width = 200; //default value

	public Middle() {
		frame = new Frame();
		frame.setColor(Color.WHITE);
		frame.setHeight(height);
		doors = new Doors(Color.DARK_GRAY, (int) (width * 0.4),(int) ( 0.8 * height));
		//setWidth(width);
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int newWidth) {
		this.width =  newWidth;
		frame.setWidth(newWidth);
		doors.setWidth((int) (width * 0.4));
	}
	
	public void drawAt(int left, int bottom) {
		frame.drawAt(left , bottom);
		doors.drawAt(left + (int)( width * 0.1) , bottom - (int)( width * 0.1));
	}

	public void setColor(Color color) {
		doors.setColor(color);
		
	}

	public void setHeight(int newHeight) {
		this.height = newHeight;
		frame.setHeight(newHeight);
		doors.setHeight((int) ( 0.8 * height));
	}

}
