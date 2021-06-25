/**
 * a class of Empty Hub state
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package graphicState;

import vehicleHub.Scene;

public class EmptyHub extends State{
	private static EmptyHub instance;
	
	private EmptyHub(Scene context) {
		this.context = context;
		emptyHub = this;
	}
	
	public static EmptyHub getInstance(Scene context) {
		if(instance == null) {
			instance = new EmptyHub(context);
		}
		return instance;
	}


	@Override
	public State emptyHub() {
		context.removeVehicles();
		return this;
	}

	@Override
	public State filledHub() {
		context.drawVehicles();
		return FilledHub.getInstance(context);
	}
}
