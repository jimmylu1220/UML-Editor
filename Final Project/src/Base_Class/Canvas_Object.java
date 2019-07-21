package Base_Class;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JPanel;

public class Canvas_Object extends JPanel {
	
	//Object Variable
	public int depth; //物件深度
	public int width; //base object的寬度
	public int height; // base object的高度
	public String Object_Name = ""; // object name
    public boolean Is_Select = false; //是否被選擇
    public Point group_location = new Point(); //如果有group 圖形在group裡的位置
    
    protected int side = -1; //記錄從哪個port出來
    protected boolean Is_Inside = false; //是否點擊在圖形內
    protected boolean UnGroup = false; 
    protected Vector <Canvas_Object> group_member; //group的成員
    protected Port UP,Left,Right,Down; //4個port
    protected static int Port_Length = 6; 
    
    //Line Variable
    public Canvas_Object Start_Object,End_Object; //Line object的起始跟結束的object
	protected int  StartPort_Index ,EndPort_Index ; //Line object的起始跟結束的port
	protected Point Start;
	protected Point End;
    
    public Canvas_Object() {
		this.setVisible(true);
		this.setOpaque(false);
	}
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    }
	
   //Object Method
    protected void Create_Object(int width,int height) {} 
    
    public boolean Ungroup() {return UnGroup;}
    
    public boolean IsInsideGraphics(Point mouse,Point location) {return Is_Inside;}
    
    public int DefineArea(Point mouse,Point location,int width,int height) {return this.side;}
    
    //Line Method 
    protected void DrawPort() {}
    
    protected void paintArrow(Graphics g) {}
    
    
    
    
}
