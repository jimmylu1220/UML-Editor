package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Base_Class.Canvas_Object;
import Base_Class.Mode;


public class Draw_Area extends JPanel  implements MouseListener, MouseMotionListener {
	public Mode CurrentMode;
	public int Depth = 99;
	public Vector <Canvas_Object> ObjectVector = new Vector<Canvas_Object>();
	public Vector <Canvas_Object> LineVector = new Vector<Canvas_Object>();
	Graphics g = getGraphics();	
	
	private static Draw_Area Unique_Draw_area;
	private  Draw_Area() {
		initialize();
	}
	
	public static Draw_Area getDrawarea(){
        if(Unique_Draw_area == null)
        	Unique_Draw_area = new Draw_Area();

        return Unique_Draw_area;
    }
	
	private void initialize() {
		this.setBounds(100, 10, 870, 550);
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK));
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		CurrentMode.mouseDragged(e);
		Repaint(g);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CurrentMode.mouseClicked(e);
		Repaint(g);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		CurrentMode.mousePressed(e);	
		Repaint(g);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		CurrentMode.mouseReleased(e);
		Repaint(g);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void Repaint(Graphics g) {
		for(int i=0;i<LineVector.size();i++) {	
			LineVector.elementAt(i).repaint();
		}
		for(int i=0;i<ObjectVector.size();i++) {
			ObjectVector.elementAt(i).repaint();
		}
	}
	
}
