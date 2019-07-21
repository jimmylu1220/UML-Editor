package Buttons;

import javax.swing.ImageIcon;

import Base_Class.Button;
import Modes.GeneralizationLineMode;

public class GeneralizationLineButton extends Button{
	public GeneralizationLineButton(int x, int y) {
		super(x, y);
		this.currentmode = new GeneralizationLineMode();
		ImageIcon img = new ImageIcon("icon/generalization_line.jpg");
		this.setIcon(img);
	}
}
