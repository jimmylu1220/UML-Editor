package GUI;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame main = new Main_Frame();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
