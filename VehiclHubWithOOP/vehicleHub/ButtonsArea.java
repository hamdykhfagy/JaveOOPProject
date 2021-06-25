/**
 * An interface for rectangular objects.
 * 
 * @author Hamdy Elrefaee, Mohammed Shamim
 * @version 3.0
 */

package vehicleHub;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsArea extends JPanel implements ActionListener {
		private static final long serialVersionUID = 1L;
		private DrawingArea drawingArea;
		
		private JButton addVehicle = new JButton("Add Vehicle");
		private JButton removeVehicles = new JButton("Remove Vehicles");
		private JButton drawVehicles = new JButton("Draw Vehicles");
		private JButton removeRandomVehicle = new JButton("Remove Random Vehicle");
		//private JButton makeYourOwnVehicle = new JButton("make Your Own Vehicle");

		
		public ButtonsArea() {
			setLayout(new GridLayout(18, 1, 15, 20));
			
			addVehicle.addActionListener(this);
			removeVehicles.addActionListener(this);
			drawVehicles.addActionListener(this);
			removeRandomVehicle.addActionListener(this);
			//makeYourOwnVehicle.addActionListener(this);
			
			this.add(addVehicle);
			this.add(removeVehicles);
			this.add(drawVehicles);
			this.add(removeRandomVehicle);
			//this.add(makeYourOwnVehicle);
			
		}
		
		@Override
		protected void paintComponent(Graphics pen) {
			
			super.paintComponent(pen);
			Drawing.set(pen);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addVehicle) {
				tidyUP();
				drawingArea.getScene().addNewVehicle();
			} else if(e.getSource() == removeVehicles) {
				tidyUP();
				drawingArea.getScene().changeToEmptyHub();
				
			} else if (e.getSource() == drawVehicles) {
				tidyUP();
				drawingArea.getScene().changeToFilledHub();

			} else if (e.getSource() == removeRandomVehicle) {
				drawingArea.getScene().removeRandomVehicle();
				tidyUP();
			/*} else if (e.getSource() == makeYourOwnVehicle) {
				drawingArea.removeAll();
				drawingArea.revalidate();
				drawingArea.repaint();
				drawingArea.getScene().setupVehicle();*/
			}			
		}
		
		private void tidyUP() {
			drawingArea.removeAll();
			drawingArea.revalidate();
			drawingArea.repaint();
		}

		public void setDrawingArea(DrawingArea drawingArea) {
			this.drawingArea = drawingArea;
			
		}
}
