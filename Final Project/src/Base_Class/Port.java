package Base_Class;

import java.awt.Color;
import java.awt.Graphics;

public class Port extends Canvas_Object{
	public Port(int x,int y) {
		super();
		this.setLocation(x, y);
		this.setBounds(getLocation().x, getLocation().y, Port_Length, Port_Length);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(Is_Select == true) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Port_Length, Port_Length);
		}
		else if(Is_Select == false) {
			this.setOpaque(false);
		}
	}
}
