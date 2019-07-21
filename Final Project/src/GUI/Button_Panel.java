package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Base_Class.Button;
import Base_Class.Mode;
import Buttons.*;

public class Button_Panel  extends JPanel implements ActionListener{
	private ArrayList<Button> btn_list = new ArrayList<>();
	public Mode CurrentMode;
	
	private static Button_Panel Unique_Button_panel;
	private Button_Panel() {
		initialize();
	}
	
	public static Button_Panel getButtonpanel() {
		if(Unique_Button_panel == null)
			Unique_Button_panel = new Button_Panel();

        return Unique_Button_panel;
	}
	
	private void initialize() {
		this.setBounds(10, 10, 80, 455);
		this.setBorder(new LineBorder(Color.BLACK));
		this.setLayout(null);
		this.setVisible(true);
		
		Button select_btn = new SelectButton(5,5);
		btn_list.add(select_btn);
		
		Button asso_btn = new AssociationLineButton(5,80);
		btn_list.add(asso_btn);
		
		Button gene_btn = new GeneralizationLineButton(5,155);
		btn_list.add(gene_btn);
		
		Button comp_btn = new CompositionLineButton(5,230);
		btn_list.add(comp_btn);
		
		Button class_btn = new ClassButton(5,305);
		btn_list.add(class_btn);
		
		Button usecase_btn = new UseCaseButton(5,380);
		btn_list.add(usecase_btn);
		
		for(int i = 0;i<btn_list.size();i++) {
			this.add(btn_list.get(i));
			btn_list.get(i).b_panel = this;
			btn_list.get(i).addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0;i<btn_list.size();i++) {
			if(e.getSource() == btn_list.get(i)) 
				btn_list.get(i).setBackground(Color.BLACK);
			else 
				btn_list.get(i).setBackground(Color.WHITE);
		}
	}


}
