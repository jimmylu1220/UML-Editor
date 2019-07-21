package MenuItem;

import java.awt.event.ActionEvent;

import Base_Class.MenuItem;

public class UnGroup extends MenuItem {

	public UnGroup(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			if(draw_area.ObjectVector.elementAt(i).Is_Select == true && draw_area.ObjectVector.elementAt(i).Ungroup() == true) {	
				for(int j=0;j<draw_area.LineVector.size();j++) {
					if(draw_area.LineVector.elementAt(j).Start_Object == draw_area.ObjectVector.elementAt(i) || 
						draw_area.LineVector.elementAt(j).End_Object == draw_area.ObjectVector.elementAt(i)) {
						draw_area.remove(draw_area.LineVector.elementAt(j));
					}
				}
				draw_area.remove(draw_area.ObjectVector.elementAt(i));
				draw_area.Repaint(draw_area.getGraphics());
			}
		}	
	}
}
