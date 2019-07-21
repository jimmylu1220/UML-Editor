package Base_Class;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.Button_Panel;
import GUI.Draw_Area;
import GUI.MenuBar;

public class Button extends JButton implements ActionListener{
	protected Dimension btnSize = new Dimension(70,70);
	protected Mode currentmode;  //當前mode
	public Button_Panel b_panel;
	private Draw_Area draw_area;
	private MenuBar menubar;
	
	public Button(int x,int y) {
		this.setBounds(x,y,btnSize.width,btnSize.height);
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		addActionListener(this);
		draw_area = Draw_Area.getDrawarea();
		menubar = MenuBar.getMenuBar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(Color.BLACK);
		b_panel.CurrentMode = this.currentmode;
		draw_area.CurrentMode = this.currentmode;
		menubar.CurrentMode = this.currentmode;
		UnSelectAll();
	}
	
	private void UnSelectAll() { //換mode取消被選取的object
		for(int i = 0;i<draw_area.ObjectVector.size();i++) {
			draw_area.ObjectVector.elementAt(i).Is_Select = false;
			draw_area.Repaint(draw_area.getGraphics());
		}
	}

}
