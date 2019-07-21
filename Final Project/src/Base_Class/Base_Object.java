package Base_Class;

import java.awt.Point;

public class Base_Object extends Canvas_Object {
    
	public Base_Object(Point p) {
		super();
		setLayout(null);
		this.setLocation(p);
	}
	
	protected void Create_Object(int width,int height) {
		this.setBounds(getLocation().x, getLocation().y,width, height);
		UP = new Port(width/2-Port.Port_Length/2,1);
		Left = new Port(1,height/2-Port.Port_Length/2);
		Right = new Port(width-Port.Port_Length-1,height/2-Port.Port_Length/2);
		Down = new Port(width/2-Port.Port_Length/2,height-Port.Port_Length-1);
		this.add(UP);
		this.add(Left);
		this.add(Right);
		this.add(Down);
	}
	
    public int DefineArea(Point mouse,Point location,int width,int height) { //�M�w�ƹ��I���b���Ӱϰ�
    	if(height*mouse.x + width*mouse.y <=  height*location.x + width*(location.y+height)  && 
    		height*mouse.x - width*mouse.y >= height*location.x - width*location.y) { //�ݩ�W�����d��
			this.side = 1; 
		}
		else if(height*mouse.x + width*mouse.y <  height*location.x + width*(location.y+height)  && 
				  	height*mouse.x - width*mouse.y < height*location.x - width*location.y) { //�ݩ��䪺�d��
			this.side = 2;
		}
		else if(height*mouse.x + width*mouse.y >  height*location.x + width*(location.y+height)  && 
					height*mouse.x - width*mouse.y > height*location.x - width*location.y) { //�ݩ�k�䪺�d��
			this.side = 3;
		}
		else if(height*mouse.x + width*mouse.y >=  height*location.x + width*(location.y+height)  && 
					height*mouse.x - width*mouse.y <= height*location.x - width*location.y) { //�ݩ�U�����d��
			this.side = 4;
		}
		else 
			this.side = -1;
    	return this.side;
    }
    
    protected void DrawPort() {
    	if(Is_Select == true) {	
    		UP.Is_Select = Is_Select;
    		Left.Is_Select = Is_Select;
    		Right.Is_Select = Is_Select;
    		Down.Is_Select = Is_Select;
    	}
    	else if(Is_Select == false) {
    		UP.Is_Select = Is_Select;
    		Left.Is_Select = Is_Select;
    		Right.Is_Select = Is_Select;
    		Down.Is_Select = Is_Select;
    	}
    }
    
}
