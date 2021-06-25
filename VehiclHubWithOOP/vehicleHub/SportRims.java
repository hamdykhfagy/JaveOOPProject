/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;
import java.awt.Point;

public class SportRims extends WheelRims{

	public SportRims() {
		super();
	}
	
	@Override
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(Color.GREEN); //typical color for spotrs :)
		Drawing.pen().fillOval(x, y, getWidth(), getWidth());
		
		super.drawAt(x + getWidth() / 2, y + getWidth() / 2);
	}

}