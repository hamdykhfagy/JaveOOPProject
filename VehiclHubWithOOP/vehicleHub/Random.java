/**
 * a class to generate random numbers and random colors.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Color;

public class Random {
	public int between(int min, int max) {
		int r = (int) (Math.random() * ((max - min) + 1) + min);
		return r;
	}
	
	public Color randomColor() {
		Color result = new Color(between(0,1000));
		
		return result;
	}
}
