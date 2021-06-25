/**
 * an abstract class for state
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package graphicState;

import vehicleHub.Scene;

public abstract class State {
	
	protected Scene context;
	
	protected static EmptyHub emptyHub;
	protected static FilledHub filledHub;
	
	abstract public State emptyHub(); 
	abstract public State filledHub(); 

}
