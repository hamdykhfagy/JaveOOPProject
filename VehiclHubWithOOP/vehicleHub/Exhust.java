/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Exhust {

	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.RED);
		Drawing.pen().fillOval(left-10, bottom , 10, 20);
		
	}

}
