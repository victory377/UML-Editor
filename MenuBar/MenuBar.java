package MenuBar;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Lines.dottedLine;
import Mycanvas.Mycanvas;
import shape.groupobj;
import shape.shape;

public class MenuBar {
	static private MenuBar MenuItem = new MenuBar();

	static public MenuBar getInstance() {
		return MenuItem;
	}

	ArrayList<JMenuItem> menu = new ArrayList<JMenuItem>();

	private MenuBar() {
		menu.add(new setName());
		menu.add(new Group());
		menu.add(new UnGroup());
	}

	public ArrayList<JMenuItem> getMenu() {
		return menu;
	}
}
/*
 * 當使用者按下change name的按鈕後，就可以設定被選到的物件的名子
 * */
class setName extends JMenuItem {
	Mycanvas drawarea = Mycanvas.getInstance();
	ArrayList<shape> list = drawarea.getArrayList();

	setName() {
		super("Change Name");
		this.addActionListener((ActionEvent event) -> {
			String input = JOptionPane.showInputDialog("請輸入");
			if (input != null) {
				for (int i = 0; i < list.size(); i++)
					if (list.get(i).getSeleted())
						list.get(i).setName(input);
			}
			drawarea.repaint();
		});
	}
}
/*
 * 使用者經由menubar按下group後，會new 出一個group物件
 * */
class Group extends JMenuItem {
	Mycanvas drawarea = Mycanvas.getInstance();
	ArrayList<shape> list = drawarea.getArrayList();
	dottedLine tmp = drawarea.getFrontend();

	Group() {
		super("Group");
		this.addActionListener((ActionEvent event) -> {
			shape group = new groupobj();
			group.remove();
			group.setGroup(true);
			group.setSeleted(true);
			list.add(group);
			drawarea.repaint();
		});
	}
}
/*
 * 使用者按下ungroup按鈕後，會先從canvas內的list，找到group物件list
 * */
class UnGroup extends JMenuItem {
	Mycanvas drawarea = Mycanvas.getInstance();
	ArrayList<shape> list = drawarea.getArrayList();

	UnGroup() {
		super("UnGroup");
		addActionListener((ActionEvent event) -> {
			for (int i = 0; i < list.size(); i++)
				if (list.get(i).getGroup() && list.get(i).getSeleted()) {
					list.get(i).dismiss();
					list.remove(list.get(i));
					break;
				}
			drawarea.repaint();
		});
	}
}