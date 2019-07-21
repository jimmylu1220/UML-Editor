package Modes;

import java.awt.event.MouseEvent;

import Base_Class.Mode;
import Objects.UseCase_Object;;

public class UseCaseMode extends Mode {
	public UseCaseMode() {
		super();
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		bobj = new UseCase_Object(e.getPoint());
		bobj.depth = draw_area.Depth;
		draw_area.Depth --;
		draw_area.ObjectVector.add(bobj);
		draw_area.add(bobj);
	}
}
