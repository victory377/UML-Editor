package Mycanvas;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.text.html.HTMLDocument.Iterator;

import Lines.PreviewLine;
import Lines.dottedLine;

import java.awt.*;
import java.util.*;

import Mode.*;
import shape.*;

/* 主畫布僅做一件事，不斷取出List中的物件
 * draw根據物件中的描述畫出物件
 * showport主要用於當虛線匡到內的物件，顯示物件的port
 * Inarea 會將mode的滑鼠事件派發到list的各個shape中去判斷是否在範圍內
 * */
public class Mycanvas extends Canvas {
	// singleton
	static private Mycanvas canvas = new Mycanvas();
	static public Mycanvas getInstance() {
		return canvas;
	}

	ArrayList<shape> list = new ArrayList<shape>();
	dottedLine frontend = new dottedLine();
	PreviewLine preview = new PreviewLine();
	Mode m = null;

	public void setMode(Mode m) {
		this.m = m;
	}

	public ArrayList<shape> getArrayList() {
		return list;
	}

	public dottedLine getFrontend() {
		return frontend;
	}

	public PreviewLine getPreview() {
		return preview;
	}

	public void showport() {
		for (shape o:list) {
			if (frontend.Inarea(o.getX(), o.getY(), o.getX() + o.getWidth(), o.getY() + o.getHeight())) 
				o.setSeleted(true);
			else
				o.setSeleted(false);
		}
	}

	public shape Isarea(MouseEvent e) {
		for (shape o:list) 
			if (o.Inarea(e.getX(), e.getY())) 
				return o;
		return null;
	}

	/*
	 * 判斷在Select Mode下所選取的物件 透過前景不斷紀錄座標位置 僅要傳入物件就可回傳是否在範圍內？
	 */
	private Mycanvas() {
		setBackground(Color.white);
		setSize(400, 300);
		// 設定滑鼠事件
		MouseMonitor monitor = new MouseMonitor();
		addMouseListener(monitor);
		addMouseMotionListener(monitor);
	}

	// 取得畫筆
	public void paint(Graphics g) {
		// draw shape
		for(shape o:list)
			o.draw(g);
		// Front end shape
		frontend.draw(g);
		preview.draw(g);
	}

	/*
	 * 多型的發生，讓m可以找到自己的模式 並傳入當下的滑鼠事件的參考
	 */
	private class MouseMonitor extends MouseInputAdapter {
		public void mouseDragged(MouseEvent e) {
			if (m != null)
				m.mousedrag(e);
			repaint();
		}

		public void mouseClicked(MouseEvent e) {
			if (m != null)
				m.mouseclick(e);
			repaint();
		}

		public void mousePressed(MouseEvent e) {
			if (m != null)
				m.mousepress(e);
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
			if (m != null)
				m.mouserelease(e);
			repaint();
		}
	}
}