package Port;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BasicObj.BasicObj;
import shape.shape;

public class Port {
	int Rx, Ry;
	boolean select = false;
	shape parent;

	public void setXY(double x, double y) {
		this.Rx = (int) x;
		this.Ry = (int) y;
	}

	public int getRX() {
		return Rx;
	}

	public int getRY() {
		return Ry;
	}

	public void setParent(shape x) {
		this.parent = x;
	}

	public shape getParent() {
		return parent;
	}
	
	public void setPort(boolean select){
		this.select = select;
	}
	
	public void draw(Graphics g) {
		if(select){
			g.setColor(Color.blue);;
			g.fillRect(parent.getX() + Rx, parent.getY() + Ry, 8, 8);}
		g.setColor(Color.BLACK);
	}
}
