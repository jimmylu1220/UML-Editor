package Buttons;

import javax.swing.ImageIcon;

import Base_Class.Button;
import Modes.AssociationLineMode;

public class AssociationLineButton extends Button{
	public AssociationLineButton(int x, int y) {
		super(x, y);
		currentmode = new AssociationLineMode();
		ImageIcon img = new ImageIcon("icon/association_line.jpg");
		this.setIcon(img);
	}
}
