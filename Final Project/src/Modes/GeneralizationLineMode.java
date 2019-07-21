package Modes;

import java.awt.event.MouseEvent;

import Base_Class.Canvas_Object;
import Base_Class.Mode;

import Line_Objects.Generalization_Line;

public class GeneralizationLineMode extends Mode {
	private int StartGraphic_Index = -1,EndGraphic_Index = -1,StartPort_Index = -1,EndPort_Index = -1;
	private Canvas_Object temp_obj;
	
	public GeneralizationLineMode() {
		super();
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		StartGraphic_Index = -1;
		EndGraphic_Index = -1;
		int overlap_count = 0;
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			temp_obj = draw_area.ObjectVector.elementAt(i);
			if(temp_obj.IsInsideGraphics(e.getPoint(),temp_obj.getLocation()) == true) {
				overlap_count ++;
				if(overlap_count > 1) {
					if(temp_obj.depth < draw_area.ObjectVector.elementAt(StartGraphic_Index).depth)
						StartGraphic_Index = i;
				}
				else
					StartGraphic_Index = i;
			}
			if(StartGraphic_Index >= 0) {
				temp_obj = draw_area.ObjectVector.elementAt(StartGraphic_Index);
				StartPort_Index = temp_obj.DefineArea(e.getPoint(),temp_obj.getLocation(),temp_obj.width,temp_obj.height);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int overlap_count = 0;
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			temp_obj = draw_area.ObjectVector.elementAt(i);
			if(temp_obj.IsInsideGraphics(e.getPoint(),temp_obj.getLocation()) == true) {
				overlap_count ++;
				if(overlap_count > 1) {
					if(temp_obj.depth < draw_area.ObjectVector.elementAt(EndGraphic_Index).depth)
						EndGraphic_Index = i;
				}
				else
						EndGraphic_Index = i;
			}
			if(EndGraphic_Index >= 0) {
				temp_obj = draw_area.ObjectVector.elementAt(EndGraphic_Index);
				EndPort_Index = temp_obj.DefineArea(e.getPoint(),temp_obj.getLocation(),temp_obj.width,temp_obj.height);
			}
		}
		
		if(overlap_count == 0 || EndGraphic_Index ==  StartGraphic_Index){ //沒連到或是連到自己
			EndGraphic_Index = -1;
			EndPort_Index = -1;
		}
		
		if(StartGraphic_Index != -1 && EndGraphic_Index != -1) {
			lobj = new Generalization_Line(draw_area.ObjectVector.elementAt(StartGraphic_Index), draw_area.ObjectVector.elementAt(EndGraphic_Index)
																  , StartPort_Index, EndPort_Index);	
			/*lobj.depth = draw_area.Depth;
			draw_area.Depth --;*/
			draw_area.LineVector.add(lobj);
			draw_area.add(lobj);
		}
	}
}
