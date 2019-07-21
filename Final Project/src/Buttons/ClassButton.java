package Buttons;

import javax.swing.ImageIcon;

import Base_Class.Button;
import Modes.ClassMode;

public class ClassButton extends Button{
	public ClassButton(int x, int y) {
		super(x, y);
		this.currentmode = new ClassMode();
		ImageIcon img = new ImageIcon("icon/class.jpg");
		this.setIcon(img);
	}
}
