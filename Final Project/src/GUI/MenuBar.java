package GUI;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Base_Class.MenuItem;
import Base_Class.Mode;
import MenuItem.Group;
import MenuItem.SetName;
import MenuItem.UnGroup;

public class MenuBar extends JMenuBar implements MenuListener{
	
	public JFrame frame;
	public Mode CurrentMode;
	private Vector <MenuItem> MenuVector = new Vector<MenuItem>();
	private JMenu mnEdit;
	private MenuItem group,ungroup,setname;
	
	private static MenuBar Unique_MenuBar;
	private MenuBar() {
		initialize();
	}
	
	public static MenuBar getMenuBar() {
		if(Unique_MenuBar == null)
			Unique_MenuBar = new MenuBar();

        return Unique_MenuBar;
	}
	
	private void initialize() {
		mnEdit = new JMenu("Edit");
		mnEdit.addMenuListener(this);
		this.add(mnEdit);
		
		group = new Group("Group");
		mnEdit.add(group);
		MenuVector.add(group);
		ungroup = new UnGroup("UnGroup");
		mnEdit.add(ungroup);
		MenuVector.add(ungroup);
		setname = new SetName("Change Name");
		setname.frame = frame;
		mnEdit.add(setname);
		MenuVector.add(setname);
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mnEdit) {
			for(int i =0;i<MenuVector.size();i++) {
				MenuVector.elementAt(i).CurrentMode = CurrentMode;
			}
		}
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

}
