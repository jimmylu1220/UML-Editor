package Line_Objects;

import java.awt.Graphics;

import Base_Class.Canvas_Object;
import Base_Class.Line_Object;

public class Generalization_Line extends Line_Object {
	
	private int Arrow_size = 4;
	public Generalization_Line(Canvas_Object StartGraphic ,Canvas_Object EndGraphic ,int StartPort_Index ,int EndPort_Index) {
		super(StartGraphic, EndGraphic, StartPort_Index, EndPort_Index);
	}
	
	protected void paintArrow(Graphics g) {
		switch(EndPort_Index) {
			case 1:
				g.drawLine( Start.x-getLocation().x, Start.y-getLocation().y , End.x-getLocation().x,  End.y-getLocation().y-Arrow_size);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x-Arrow_size, End.y-getLocation().y-Arrow_size);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x+Arrow_size, End.y-getLocation().y-Arrow_size);
				g.drawLine(End.x-getLocation().x-Arrow_size, End.y-getLocation().y-Arrow_size, 
									 End.x-getLocation().x+Arrow_size, End.y-getLocation().y-Arrow_size);
				break;
			case 2:
				g.drawLine( Start.x-getLocation().x, Start.y-getLocation().y , End.x-getLocation().x-Arrow_size,  End.y-getLocation().y);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x-Arrow_size, End.y-getLocation().y+Arrow_size);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x-Arrow_size, End.y-getLocation().y-Arrow_size);
				g.drawLine(End.x-getLocation().x-Arrow_size, End.y-getLocation().y-Arrow_size, 
									 End.x-getLocation().x-Arrow_size, End.y-getLocation().y+Arrow_size);
				break;
			case 3:
				g.drawLine( Start.x-getLocation().x, Start.y-getLocation().y , End.x-getLocation().x+Arrow_size,  End.y-getLocation().y);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x+Arrow_size, End.y-getLocation().y-Arrow_size);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x+Arrow_size, End.y-getLocation().y+Arrow_size);
				g.drawLine(End.x-getLocation().x+Arrow_size, End.y-getLocation().y-Arrow_size, 
									 End.x-getLocation().x+Arrow_size, End.y-getLocation().y+Arrow_size);
				break;
			case 4:
				g.drawLine( Start.x-getLocation().x, Start.y-getLocation().y , End.x-getLocation().x,  End.y-getLocation().y+Arrow_size);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x-Arrow_size, End.y-getLocation().y+Arrow_size);
				g.drawLine(End.x-getLocation().x, End.y-getLocation().y, End.x-getLocation().x+Arrow_size, End.y-getLocation().y+Arrow_size);
				g.drawLine(End.x-getLocation().x-Arrow_size, End.y-getLocation().y+Arrow_size, 
									 End.x-getLocation().x+Arrow_size, End.y-getLocation().y+Arrow_size);
				break;
		}
	}
	
}
