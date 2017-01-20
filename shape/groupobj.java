package shape;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import Mycanvas.Mycanvas;

/*
 * group object裡面實作remove及ungroup的method 
 * remove主要是把被虛線所圈選到的物件，新增至group物件的arraylist內
 * ungroup主要看選取到哪一個group物件，從最外層開始解構，依序將group物件加回canvas的list內
 * Inarea主要負責接收canvas派發的mouse press的位置，來判定是否有被選到，若有在將位置派給list內的shape物件
 * */

public class groupobj extends shape {
	Mycanvas drawarea = Mycanvas.getInstance();
	ArrayList<shape> canvasList = drawarea.getArrayList();

	ArrayList<shape> list = new ArrayList<shape>();
	ArrayList<Integer> ref_x = new ArrayList<Integer>();
	ArrayList<Integer> ref_y = new ArrayList<Integer>();
	ArrayList<Integer> shape_x = new ArrayList<Integer>();
	ArrayList<Integer> shape_y = new ArrayList<Integer>();

	public void remove() {
		for (int i = 0; i < canvasList.size(); i++) {
			int sx = canvasList.get(i).getX();
			int sy = canvasList.get(i).getY();
			int swidth = canvasList.get(i).getX() + canvasList.get(i).getWidth();
			int sheight = canvasList.get(i).getY() + canvasList.get(i).getHeight();

			if (canvasList.get(i).selected) {
				shape_x.add(sx);
				shape_x.add(swidth);
				shape_y.add(sy);
				shape_y.add(sheight);
				list.add(canvasList.get(i));
				canvasList.remove(canvasList.get(i));
				i--;
			}
		}

		x = Collections.min(shape_x) - 4;
		y = Collections.min(shape_y) - 4;
		width = Collections.max(shape_x) - x + 4;
		height = Collections.max(shape_y) - y + 4;

		for (shape o : list) {
			int sx = o.getX();
			int sy = o.getY();
			ref_x.add(sx - x);
			ref_y.add(sy - y);
			o.setSeleted(false);
		}
	}

	public boolean Inarea(int px, int py) {
		boolean flag = false;
		for (shape Element : list) {
			if (Element.Inarea(px, py)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			for (shape Element : list)
				Element.setSeleted(true);
			return true;
		} else {
			for (shape Element : list)
				Element.setSeleted(false);
			return false;
		}
	}

	public void dismiss() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSeleted(false);
			canvasList.add(list.get(i));
			list.remove(list.get(i));
			i--;
		}
	}

	public void draw(Graphics g) {
		if (getSeleted()) {
			for (shape o : list)
				o.setSeleted(true);
			g.drawRect(x, y, width, height);
		} else {
			for (shape o : list)
				o.setSeleted(false);
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setXY(x + ref_x.get(i), y + ref_y.get(i));
			list.get(i).draw(g);
		}
		//g.drawRect(x, y, width, height);
	}
}