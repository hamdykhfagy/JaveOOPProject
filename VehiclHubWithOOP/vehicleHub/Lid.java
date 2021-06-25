package vehicleHub;

import java.awt.Color;

public class Lid {

	public void drawAt(int left, int bottom) {
		Drawing.pen().setColor(Color.YELLOW);
		Drawing.pen().fillOval(left, bottom - 10, 10, 10);
		
	}

}
