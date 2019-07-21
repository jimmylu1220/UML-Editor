package Base_Class;

import java.awt.Graphics;
import java.awt.Point;

public class Line_Object extends Canvas_Object  {
	public Line_Object(Canvas_Object StartGraphic ,Canvas_Object EndGraphic ,int StartPort_Index ,int EndPort_Index) {
		this.Start_Object  = StartGraphic;
		this.End_Object = EndGraphic;
		this.StartPort_Index = StartPort_Index;
		this.EndPort_Index  = EndPort_Index;
		Renew_Location();
		this.setBounds(Math.min(Start.x, End.x), Math.min(Start.y, End.y),Math.abs(Start.x- End.x)+15, Math.abs(Start.y- End.y)+10);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Renew_Location();
		this.setBounds(Math.min(Start.x, End.x)-5, Math.min(Start.y, End.y)-5,Math.abs(Start.x- End.x)+15, Math.abs(Start.y- End.y)+10);
		paintArrow(g);
	}
	
	protected void paintArrow(Graphics g) {} //畫不同的箭頭
	
	private void Renew_Location() { //repaint location
		Start = new Point();
		End = new Point();
		Decide_Location(Start,Start_Object,StartPort_Index);
		Decide_Location(End,End_Object,EndPort_Index);		
	}
	
	private void Decide_Location(Point p,Canvas_Object object,int side) { //決定出來的位置
		switch(side) {
			case 1://上
				p.x = object.getLocation().x + object.width/2;
				p.y = object.getLocation().y;
				break;
			case 2://左
				p.x = object.getLocation().x ;
				p.y =object.getLocation().y+ object.height/2;
				break;
			case 3://右
				p.x = object.getLocation().x + object.width;
				p.y = object.getLocation().y + object.height/2;
				break;
			case 4://下
				p.x = object.getLocation().x + object.width/2;
				p.y = object.getLocation().y + object.height;
				break;
		}
	}
}
