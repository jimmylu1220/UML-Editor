package Line_Objects;

import java.awt.Graphics;

import Base_Class.Canvas_Object;
import Base_Class.Line_Object;

public class Association_Line extends Line_Object {

	public Association_Line(Canvas_Object StartGraphic ,Canvas_Object EndGraphic ,int StartPort_Index ,int EndPort_Index) {
		super(StartGraphic, EndGraphic, StartPort_Index, EndPort_Index);	
	}
	
	protected void paintArrow(Graphics g) {
		g.drawLine( Start.x-getLocation().x, Start.y-getLocation().y , End.x-getLocation().x,  End.y-getLocation().y);
	}
}
