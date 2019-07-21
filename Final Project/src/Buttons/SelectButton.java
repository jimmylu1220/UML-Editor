package Buttons;

import javax.swing.ImageIcon;

import Base_Class.Button;
import Modes.SelectMode;

public class SelectButton extends Button{
	public SelectButton(int x, int y) {
		super(x, y);
		this.currentmode = new SelectMode();
		ImageIcon img = new ImageIcon("icon/select.jpg");
		this.setIcon(img);
	}
}
