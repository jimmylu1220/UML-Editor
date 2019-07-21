package Objects;

import java.awt.Graphics;
import java.awt.Point;

import Base_Class.Base_Object;

public class UseCase_Object extends Base_Object {
	
	public UseCase_Object(Point p) {
		super(p);
		this.width = 100;
		this.height = 50;
		Create_Object(width,height);
	}
	
	public boolean IsInsideGraphics(Point mouse,Point location) {
		int center_x = location.x + (width/2), center_y = location.y + (height/2);
		float a =mouse.x - center_x,b = width/2,c = mouse.y-center_y, d = height/2;
		float xy_location = ((a*a)/(b*b)) + ((c*c)/(d*d));
		if(xy_location < 1) 
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
		g.drawOval(0, 0, width-1, height-1);
		DrawPort();
	}
	
}
