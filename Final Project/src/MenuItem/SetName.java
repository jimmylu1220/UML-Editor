package MenuItem;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Base_Class.MenuItem;

public class SetName extends MenuItem {
	public SetName(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog(frame,"¿é¤J¦W¦r","");
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			if(draw_area.ObjectVector.elementAt(i).Is_Select == true) {
				if(name != null)
					draw_area.ObjectVector.elementAt(i).Object_Name = name;
			}
		}
		draw_area.Repaint(draw_area.getGraphics());
	}
	
	

}
