package shape;

import java.awt.BasicStroke;

import java.awt.BorderLayout;
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
import Port.*;

/* shape 讓物件可以自己畫出自己
 * 所以紀錄物件的長寬與press的座標
 * 同時紀錄每個物件的四個connection port座標
 * */
public class shape {
	int x, y, width, height;
	boolean selected = false;
	boolean group = false;

	public boolean getSeleted() {
		return selected;
	}

	public void setPort(boolean select){
	}
	
	public void setSeleted(boolean selected) {
		this.selected = selected;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setWH(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean Inarea(int px, int py) {
		return false;
	}

	public Port findCloser(int x, int y) {
		return null;
	}

	public void connection(shape x) {
	}

	public void draw(Graphics g) {
	}

	public void setSPort(Port start) {
	}

	public void setEPort(Port End) {
	}

	public Port getSPort() {
		return null;
	}

	public Port getEPort() {
		return null;
	}

	public void remove() {
	}

	public void dismiss() {
	}

	public void setGroup(boolean group){
		this.group = group;
	}
	
	public boolean getGroup(){
		return group;
	}
	
	public void setName(String name) {
	}
}
