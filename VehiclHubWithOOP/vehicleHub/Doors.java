/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Doors {
	private Door frontDoor, backDoor; //aggrigate
	private Windows windows; //aggrigate
	private int width;
	private int height;
	private  int doorMargin;
	private Color color;

	public Doors(Color color, int width, int height) {
		this.width = width;
		this.height = height;
		this.color = color;
		this.doorMargin = (int) (this.width * 0.05);
		backDoor = new Door(color, this.width - doorMargin , height);
		frontDoor = new Door(color, this.width - doorMargin, height);
		windows = new Windows();
	}

	public void drawAt(int left, int bottom) {
		backDoor.drawAt(left, bottom );
		frontDoor.drawAt(left + width + doorMargin, bottom);
		windows.drawAt(left, bottom);
	}

	public void setWidth(int newWidth) {
		this.width = newWidth;
		this.doorMargin = (int) (this.width * 0.05);
		frontDoor.setWidth(this.width - doorMargin);
		backDoor.setWidth(this.width - doorMargin);
		
	}

	public void setColor(Color newColor) {
		this.color = newColor;
		frontDoor.SetColor(color);
		backDoor.SetColor(color);
		
	}

	public void setHeight(int newHeight) {
		this.height = newHeight;
		frontDoor.setHeight(this.height);
		backDoor.setHeight(this.height);
	}
}
