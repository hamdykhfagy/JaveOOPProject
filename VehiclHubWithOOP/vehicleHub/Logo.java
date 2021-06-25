/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Logo {
	private String logo = "Tesla";
	private Color color;
	
	public void setLogo(String newLogo) {
		this.logo = newLogo;
	}
	
	private void shapeLogo() {
		if (this.logo == "Tesla") {
			this.color = Color.RED;
		} else if (this.logo == "BMW") {
			this.color = Color.BLUE;
		} else if (this.logo == "Mercedes-Benz") {
			this.color = Color.BLACK;
		} else {
			this.color = Color.WHITE; //naive Logo
		}
	}
	
	public void drawAt(int left, int bottom) {
		shapeLogo();
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(left-10, bottom - 20 , 10, 20);
		Drawing.pen().fillOval(left - 15, bottom - 15 , 20, 10);
		
	}

}
