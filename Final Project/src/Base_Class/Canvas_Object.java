package Base_Class;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JPanel;

public class Canvas_Object extends JPanel {
	
	//Object Variable
	public int depth; //����`��
	public int width; //base object���e��
	public int height; // base object������
	public String Object_Name = ""; // object name
    public boolean Is_Select = false; //�O�_�Q���
    public Point group_location = new Point(); //�p�G��group �ϧΦbgroup�̪���m
    
    protected int side = -1; //�O���q����port�X��
    protected boolean Is_Inside = false; //�O�_�I���b�ϧΤ�
    protected boolean UnGroup = false; 
    protected Vector <Canvas_Object> group_member; //group������
    protected Port UP,Left,Right,Down; //4��port
    protected static int Port_Length = 6; 
    
    //Line Variable
    public Canvas_Object Start_Object,End_Object; //Line object���_�l�򵲧���object
	protected int  StartPort_Index ,EndPort_Index ; //Line object���_�l�򵲧���port
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
