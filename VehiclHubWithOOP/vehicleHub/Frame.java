/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Frame {
	private int height = 100; //default value
	private int width = 200; //default value
	private int thickness = 5; //default value
	private int slopeRoof;
	private Color color = Color.WHITE;
	
	public Frame() {
		slopeRoof = (int) (width * 0.2);
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;
		slopeRoof = (int) (width * 0.2);
	}
	
	public void setHeight(int newHeight) {
		this.height = newHeight;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void drawAt(int left, int bottom) {
		bodyFrame(left, bottom);
		roofFrame(left, bottom - height);
	}

	private void bodyFrame(int left, int bottom) {
		outer(left, bottom - height);
		inner(left + thickness, bottom - height + thickness);
	}

	private void roofFrame(int left, int bottom) {
		Drawing.pen().setColor(Color.darkGray);
		int[] xPoints = { left,
				left + slopeRoof,
				left + width - slopeRoof,
				left + width,
				left + width - thickness,
				left + width - slopeRoof - thickness,
				left + slopeRoof + thickness,
				left + thickness};
		int roofHeight = (int) (height * 0.7);
		int[] yPoints = { bottom,
				bottom - roofHeight,
				bottom - roofHeight,
				bottom,
				bottom,
				bottom - roofHeight + thickness,
				bottom - roofHeight + thickness,
				bottom};
		
		Drawing.pen().fillPolygon(xPoints, yPoints, 8);
	}

	private void outer(int x, int y) {
		Drawing.pen().setColor(Color.ORANGE);
		Drawing.pen().fillRect(x, y, width, height);
	}

	private void inner(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(x, y, width - 2 * thickness, height - 2 * thickness);
	}
}
