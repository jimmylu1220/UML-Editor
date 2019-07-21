package Objects;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import Base_Class.Base_Object;
import Base_Class.Canvas_Object;

public class Group_Object extends Base_Object{
	
	public Group_Object(Point p,int width,int height,Vector<Canvas_Object> group_member) {
		super(p);
		this.width = width;
		this.height = height;
		Create_Object(width,height);
		this.group_member = new Vector<Canvas_Object>();
		this.group_member = group_member;
	}
	
	public boolean IsInsideGraphics(Point mouse,Point location) {
		if(mouse.x >= location.x && mouse.x <= location.x+width && mouse.y >= location.y && mouse.y <= location.y+height) 
			this.Is_Inside = true;
		else 
			this.Is_Inside = false;
		
		return Is_Inside;
	}
    
	public boolean Ungroup() {
		this.UnGroup = true;
		return UnGroup;
	}
	
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0;i<group_member.size();i++) {
			group_member.elementAt(i).setLocation(this.getLocation().x + group_member.elementAt(i).group_location.x, this.getLocation().y + group_member.elementAt(i).group_location.y);
		}
		this.setBounds(getLocation().x, getLocation().y,width, height);
		if(Object_Name != null)
			g.drawString(Object_Name,width/3,height/2);
		g.drawRect(0, 0, width-1, height-1);
		DrawPort();
	}
}
