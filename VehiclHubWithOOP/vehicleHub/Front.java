/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;
import java.awt.Polygon;

class Front {
	private Logo logo;
	private Lid torch;
	private Wheel frontWheel;
	private int height = 100; //default value
	private int width = 100; // default value
	private int slope;
	private Color color;

	public Front() {
		setDefaults();
	}

	public Front(int width, int height) {
		setDefaults();
		//override
		this.width = width;
		this.height = height;
	}

	private void setDefaults() {
		slope = (int) (height * 0.3);
		color = Color.BLACK;
		logo = new Logo();
		torch = new Lid();
		frontWheel = new Wheel();
		String typeRims = "Sport";
		String typeLogo = "Tesla";
		frontWheel.setTypeRims(typeRims);
		logo.setLogo(typeLogo);
		setWheelDiameter((int)(width * 0.35));

	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;
		setWheelDiameter((int)(width * 0.35)); // this is not so good, function do two different things, I will imprrove it soon
	}

	public void setColor(Color newColor) {
		this.color = newColor;
	}

	public void setTypeRims(String newTypeRims) {
		frontWheel.setTypeRims(newTypeRims);
		
	}
	
	public void setTypeLogo(String newTypeLogo) {
		logo.setLogo(newTypeLogo);

	}

	public void drawAt(int left, int bottom) {
		drawCover(left, bottom);
		frontWheel.drawAt(left + frontWheel.getDiameter(), bottom);
		logo.drawAt(left + width, bottom - height + slope);
		torch.drawAt(left + width, bottom - height / 2);
	}

	private void drawCover(int left, int bottom) {
		Drawing.pen().setColor(color);
		Polygon p = placePolygon(left, bottom);
		Drawing.pen().fillPolygon(p);
	}

	private Polygon placePolygon(int left, int bottom) {
		int[] xPoints = { left, left + width, left + width, left, left };
		int[] yPoints = { bottom, bottom - slope, bottom - height + slope, bottom - height, bottom };
		int nPoints = 5;

		return new Polygon(xPoints, yPoints, nPoints);
	}

	public void setWheelDiameter(int newDiameter) {
		frontWheel.setDiameter(newDiameter);
	}

	public void setHeight(int newHeight) {
		this.height = newHeight;
		
	}

	

	
}
