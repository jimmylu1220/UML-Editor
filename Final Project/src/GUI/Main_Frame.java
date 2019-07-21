package GUI;

import javax.swing.JFrame;

public class Main_Frame extends JFrame {
	private JFrame frame;
	private int window_w = 1000,window_h = 630;
	private Button_Panel b_panel;
	private Draw_Area draw_area;
	private MenuBar menuBar;
	
	public Main_Frame() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("UML_EDITOR");
		frame.setBounds(100, 100, window_w,window_h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		b_panel = Button_Panel.getButtonpanel();
		frame.getContentPane().add(b_panel);
		
		draw_area = Draw_Area.getDrawarea();
		frame.getContentPane().add(draw_area);
		
		menuBar =  MenuBar.getMenuBar();
		menuBar.frame = frame;
		frame.setJMenuBar(menuBar);
	}

}
