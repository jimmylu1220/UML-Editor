package Modes;

import java.awt.Point;
import java.awt.event.MouseEvent;

import Base_Class.Mode;

public class SelectMode extends Mode {
	private boolean Group_Select = false,Move_Object = false;
	private int move_index;
	private Point Group_Start,Group_End;
	public SelectMode() {
		super();
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int overlap_count = 0;
		int temp_select = -1;
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			if(draw_area.ObjectVector.elementAt(i).IsInsideGraphics(e.getPoint(),draw_area.ObjectVector.elementAt(i).getLocation()) == true) {
				overlap_count++;
				if(overlap_count > 1) {
					if(draw_area.ObjectVector.elementAt(i).depth < draw_area.ObjectVector.elementAt(temp_select).depth) {
						draw_area.ObjectVector.elementAt(i).Is_Select = true;
						draw_area.ObjectVector.elementAt(temp_select).Is_Select = false;
					}
					temp_select = i;
				}
				else {
					draw_area.ObjectVector.elementAt(i).Is_Select = true;
					temp_select = i;
				}
			}
			else
				draw_area.ObjectVector.elementAt(i).Is_Select = false;
		}
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
		Group_Select = true;
		Move_Object = false;
		int overlap_count = 0;
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			if(draw_area.ObjectVector.elementAt(i).IsInsideGraphics(e.getPoint(),draw_area.ObjectVector.elementAt(i).getLocation()) == true) {
				Group_Select = false;
				overlap_count++;
				if(overlap_count > 1) {
					if(draw_area.ObjectVector.elementAt(i).depth < draw_area.ObjectVector.elementAt(move_index).depth) {
						move_index = i;
					}
				}
				else 
					move_index = i;	
			}
		}
		if(Group_Select == true) {
			Group_Start = new Point();
			Group_Start = e.getPoint();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Group_Select == false) {
			Move_Object = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Group_Select == true) {
			Group_End = new Point();
			Group_End = e.getPoint();
			if(Group_Start.x > Group_End.x && Group_Start.y > Group_End.y) {
				Group_Select(Group_End,Group_Start);
			}
			else
				Group_Select(Group_Start,Group_End);
		}
		
		if(Move_Object == true) {
			draw_area.ObjectVector.elementAt(move_index).setLocation(e.getPoint());
			draw_area.ObjectVector.elementAt(move_index).repaint();
		}
	}
	
	
	private void Group_Select(Point start,Point end) {
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			if(Group_Check(start,end,draw_area.ObjectVector.elementAt(i).getLocation(),
					draw_area.ObjectVector.elementAt(i).width,draw_area.ObjectVector.elementAt(i).height))
				draw_area.ObjectVector.elementAt(i).Is_Select = true;
			else
				draw_area.ObjectVector.elementAt(i).Is_Select = false;
		}
	}
	
	private boolean Group_Check(Point start,Point end,Point location,int w,int h) {
		if(start.x<=location.x && start.y <= location.y && location.x+w <=end.x && location.y+h<=end.y)
			return true;
		else 
			return false;
	}
	
}
