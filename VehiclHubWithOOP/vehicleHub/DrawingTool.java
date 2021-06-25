/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingTool{
	private JFrame applicationFrame;
	private static DrawingArea drawingArea;
	private static ButtonsArea buttonsArea; 
	
	public DrawingTool(String title) {
		applicationFrame = new JFrame(title);
		drawingArea = new DrawingArea();
		buttonsArea = new ButtonsArea();
		buttonsArea.setDrawingArea(drawingArea);
		Dimension screenSize = applicationFrame.getToolkit().getScreenSize();
		applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		applicationFrame.setVisible(true);
		applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addACanvas(JPanel p, String borderLayout) {
		applicationFrame.add(p, borderLayout);
	}
	
	public static void main(String[] args) {
		DrawingTool anApplication = new DrawingTool("A drawing tool");
		
		anApplication.addACanvas(drawingArea, BorderLayout.CENTER);
		anApplication.addACanvas(buttonsArea, BorderLayout.WEST);
		
	}

	
}