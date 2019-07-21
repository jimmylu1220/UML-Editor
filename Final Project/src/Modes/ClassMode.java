package Modes;

import java.awt.event.MouseEvent;

import Base_Class.Mode;
import Objects.Class_Object;

public class ClassMode extends Mode {
	public ClassMode() {
		super();
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		bobj = new Class_Object(e.getPoint());
		bobj.depth = draw_area.Depth;
		draw_area.Depth --;
		draw_area.ObjectVector.add(bobj);
		draw_area.add(bobj);
	}
}
