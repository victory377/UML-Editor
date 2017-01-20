package Mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Lines.Composition;
import Lines.PreviewLine;
import Lines.generalLine;
import Mycanvas.*;
import Port.Port;
import shape.*;

public class composite extends Mode {
	Mycanvas canvas = Mycanvas.getInstance();
	ArrayList<shape> list = canvas.getArrayList();
	PreviewLine preview = canvas.getPreview();
	shape x1, a;
	Port start;
	boolean flag = false;

	public void mousepress(MouseEvent e) {
		a = canvas.Isarea(e);
		if (a != null && a.getGroup() != true) {
			x1 = new Composition();
			start = a.findCloser(e.getX(), e.getY());
			start.setPort(true);
			x1.setSPort(start); // 傳入press座標
			preview.setsx(start.getRX() + start.getParent().getX());
			preview.setsy(start.getRY() + start.getParent().getY());
			preview.setdx(start.getRX() + start.getParent().getX());
			preview.setdy(start.getRY() + start.getParent().getY());
			flag = true;
		} else {
			preview.reset();
			flag = false;
		}
	}

	public void mousedrag(MouseEvent e) {
		if(start != null){
		preview.setdx(e.getX());
		preview.setdy(e.getY());}
	}

	public void mouserelease(MouseEvent e) { // 方便demo辨識
		a = canvas.Isarea(e);
		if (flag) {
			if (a != null && a.getGroup() != true) {
				x1.setEPort(a.findCloser(e.getX(), e.getY()));// 確保雙向都是物件
				list.add(x1);
				flag = false;
			}
		}
		if(start!=null)
			start.setPort(false);
		start = null;
		preview.reset();
	}
}