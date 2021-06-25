/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package graphicState;

import vehicleHub.Scene;

public class FilledHub extends State {
private static FilledHub instance;
	
	private FilledHub(Scene context) {
		this.context = context;
		filledHub = this;
	}
	
	public static FilledHub getInstance(Scene context) {
		if(instance == null) {
			instance = new FilledHub(context);
		}
		return instance;
	}

	@Override
	public State emptyHub() {
		context.removeVehicles();
		return EmptyHub.getInstance(context);
	}

	@Override
	public State filledHub() {
		context.drawVehicles();
		return this;
	}
}
