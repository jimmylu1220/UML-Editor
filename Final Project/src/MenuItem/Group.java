package MenuItem;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Vector;

import Base_Class.Canvas_Object;
import Base_Class.MenuItem;
import Objects.Group_Object;

public class Group extends MenuItem {
	
	private Point start;
	private Point end;
	private Vector <Canvas_Object> group_member; //存在group裡面的成員
	private int member_count = 0;
	Canvas_Object obj;
	Canvas_Object gobj;
	
	public Group(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent e) {
		start = new Point(1000,1000);
		end = new Point(0,0);
		Decide_GroupLoca();
		draw_area.Repaint(draw_area.getGraphics());
	}

	private void Decide_GroupLoca() {
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			obj = draw_area.ObjectVector.elementAt(i);
			if(draw_area.ObjectVector.elementAt(i).Is_Select == true) {	//決定group範圍
				member_count ++;
				if(obj.getLocation().x < start.x) 
					start.x = obj.getLocation().x;
				if(obj.getLocation().y < start.y) 
					start.y = obj.getLocation().y;
				if(obj.getLocation().x + obj.width > end.x) 
					end.x = obj.getLocation().x + obj.width;
				if(obj.getLocation().y + obj.height > end.y) 
					end.y = obj.getLocation().y + obj.height;
			}
		}	
		if(member_count <= 1) {
			System.out.println("not group");
			return;
		}
		
		group_member = new Vector<Canvas_Object>();
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {//決定group member在group裡面的位置
			if(draw_area.ObjectVector.elementAt(i).Is_Select == true) {
				obj = draw_area.ObjectVector.elementAt(i);
				obj.group_location.x = obj.getLocation().x - start.x;
				obj.group_location.y = obj.getLocation().y - start.y;
				group_member.add(obj);
			}
		}
		gobj = new Group_Object(start,end.x - start.x,end.y - start.y,group_member);
		gobj.depth = draw_area.Depth;
		draw_area.Depth --;
		draw_area.ObjectVector.add(gobj);
		draw_area.add(gobj);
	}
}
