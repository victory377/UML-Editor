package Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Mode.Class;
import Mode.Mode;
import Mode.associate;
import Mode.composite;
import Mode.generalize;
import Mode.select;
import Mode.usecase;
import Mycanvas.Mycanvas;

public class Button {
	/* singleton */
	static private Button Btn = new Button();

	static public Button getInstance() {
		return Btn;
	}

	ArrayList<JButton> btn = new ArrayList<JButton>();

	private Button() {
		btn.add(new B_select("src/select.png"));
		btn.add(new B_associate("src/associate.png"));
		btn.add(new B_composite("src/composite.png"));
		btn.add(new B_generalize("src/generalize.png"));
		btn.add(new B_Class("src/class.png"));
		btn.add(new B_usecase("src/usecase.png"));
		btn.add(new B_garbage("src/garbage.png"));
	}

	public ArrayList<JButton> getButton() {
		return btn;
	}

	public void resetButton() {
		for (int i = 0; i < btn.size(); i++)
			btn.get(i).setEnabled(true);
	}
}

class B_select extends JButton {
	Mycanvas canvas = Mycanvas.getInstance();

	B_select(String path) {
		super(new ImageIcon(path));
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.getInstance().resetButton();
				Mode select = new select();
				canvas.setMode(select);
				setEnabled(false);
			}
		});
	}
}

class B_associate extends JButton {
	Mycanvas canvas = Mycanvas.getInstance();

	B_associate(String path) {
		super(new ImageIcon(path));
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.getInstance().resetButton();
				Mode associate = new associate();
				canvas.setMode(associate);
				setEnabled(false);
			}
		});
	}
}

class B_generalize extends JButton {
	Mycanvas canvas = Mycanvas.getInstance();

	B_generalize(String path) {
		super(new ImageIcon(path));
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.getInstance().resetButton();
				Mode generalize = new generalize();
				canvas.setMode(generalize);
				setEnabled(false);
			}
		});
	}
}

class B_composite extends JButton {
	Mycanvas canvas = Mycanvas.getInstance();

	B_composite(String path) {
		super(new ImageIcon(path));
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.getInstance().resetButton();
				Mode composite = new composite();
				canvas.setMode(composite);
				setEnabled(false);
			}
		});
	}
}

class B_Class extends JButton {
	Mycanvas canvas = Mycanvas.getInstance();

	B_Class(String path) {
		super(new ImageIcon(path));
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.getInstance().resetButton();
				Mode Class = new Class();
				canvas.setMode(Class);
				setEnabled(false);
			}
		});
	}
}

class B_usecase extends JButton {
	Mycanvas canvas = Mycanvas.getInstance();

	B_usecase(String path) {
		super(new ImageIcon(path));
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.getInstance().resetButton();
				Mode usecase = new usecase();
				canvas.setMode(usecase);
				setEnabled(false);
			}
		});
	}
}

class B_garbage extends JButton {
	Mycanvas canvas = Mycanvas.getInstance();

	B_garbage(String path) {
		super(new ImageIcon(path));
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.getInstance().resetButton();
				for (int i = 0; i < canvas.getArrayList().size(); i++) {
					canvas.getArrayList().remove(canvas.getArrayList().get(i));
					i--;
				}
				canvas.setMode(null);
				canvas.repaint();
				setEnabled(false);
			}
		});
	}
}