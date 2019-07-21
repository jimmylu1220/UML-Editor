package Buttons;

import javax.swing.ImageIcon;

import Base_Class.Button;
import Modes.CompositionLineMode;

public class CompositionLineButton extends Button{
	public CompositionLineButton(int x, int y) {
		super(x, y);
		this.currentmode = new CompositionLineMode();
		ImageIcon img = new ImageIcon("icon/composition_line.jpg");
		this.setIcon(img);
	}
}
