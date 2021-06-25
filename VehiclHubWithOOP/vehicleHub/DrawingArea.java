/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
	private Scene scene = null;

	@Override
	protected void paintComponent(Graphics pen) {
		
		super.paintComponent(pen);
		Drawing.set(pen);
		if(scene != null) {
			scene.draw();
		} else 
			scene = new Scene();
	}
	public Scene getScene() {
		return this.scene;
	}
}