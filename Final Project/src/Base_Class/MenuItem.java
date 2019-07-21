package Base_Class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import GUI.Draw_Area;

public class MenuItem extends JMenuItem implements ActionListener {
	
	public JFrame frame;
	public Mode CurrentMode;
	protected Draw_Area draw_area;
	
	public MenuItem(String name) {
		this.setText(name);
		addActionListener(this);
		draw_area = Draw_Area.getDrawarea(); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
