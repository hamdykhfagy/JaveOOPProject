/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;


public class Windows {
	private Window frontWindow, backWindow;

	public Windows() {
		frontWindow = new Window();
		backWindow = new Window();
	}

	public void drawAt(int left, int bottom) {
		frontWindow.drawAt(left, bottom);
		backWindow.drawAt(left, bottom);
	}
}
