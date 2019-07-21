package Objects;

import java.awt.Graphics;
import java.awt.Point;

import Base_Class.Base_Object;

public class Class_Object extends Base_Object {
    public Class_Object(Point p) {
		super(p);
		this.width = 100;
		this.height = 50;
		Create_Object(width,height);
	}
	
	public boolean IsInsideGraphics(Point mouse,Point location) {
		if(mouse.x >= location.x && mouse.x <= location.x+width && mouse.y >= location.y && mouse.y <= location.y+height) 
			this.Is_Inside = true;
		else 
			this.Is_Inside = false;
		
		return Is_Inside;
	}
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBounds(getLocation().x, getLocation().y,width, height);
		if(Object_Name != null)
			g.drawString(Object_Name,width/3,height/2);
		g.drawRect(0, 0, width-1, height-1);
		DrawPort();
	}
}
