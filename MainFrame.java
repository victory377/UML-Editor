import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Menu;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import Button.*;
import Lines.dottedLine;
import Mode.*;
import Mode.Class;
import Mycanvas.*;
import shape.*;
import MenuBar.*;
/* 主要的框架透過JFrame實作
 * 裡面包含有按鈕及畫布組成
 * 按鈕及畫布之間的溝通
 * 透過設定Mode的方式來完成
 * */

public class MainFrame extends JFrame {

	Mycanvas drawarea = Mycanvas.getInstance();
	MenuBar menu = MenuBar.getInstance();
	Button button = Button.getInstance();
	ArrayList<shape> list = drawarea.getArrayList();

	JFrame frame = new JFrame("UML");
	Box topLeft = Box.createVerticalBox(); // 安裝按鈕的位置

	// Menu
	JMenuBar bar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");

	MainFrame() {
		// button();
		for (int i = 0; i < button.getButton().size(); i++)
			topLeft.add(button.getButton().get(i));
		for (int i = 0; i < menu.getMenu().size(); i++)
			edit.add(menu.getMenu().get(i));
		frame.getContentPane().add(topLeft, BorderLayout.WEST);
		frame.add(drawarea);
		frame.setBounds(600, 600, 700, 700); // 視窗的大小
		bar.add(file);
		bar.add(edit);
		frame.setJMenuBar(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}