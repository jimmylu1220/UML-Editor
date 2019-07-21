package Buttons;

import javax.swing.ImageIcon;

import Base_Class.Button;
import Modes.UseCaseMode;;

public class UseCaseButton extends Button{
	public UseCaseButton(int x, int y) {
		super(x, y);
		this.currentmode = new UseCaseMode();
		ImageIcon img = new ImageIcon("icon/use_case.jpg");
		this.setIcon(img);
	}
}
