package Mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Lines.dottedLine;
import Mycanvas.Mycanvas;
import shape.*;

public class select extends Mode {
	Mycanvas canvas = Mycanvas.getInstance();
	ArrayList<shape> list = canvas.getArrayList();
	shape a;
	dottedLine tmp;

	public void mouseclick(MouseEvent e) {
		//dispatch mouse event to shape
		a = canvas.Isarea(e);
		if (a != null) 
			a.setSeleted(true);
	}

	public void mousepress(MouseEvent e) {
		tmp = canvas.getFrontend();
		tmp.setsXY(e.getX(), e.getY());
		tmp.setdxy(e.getX(), e.getY());
	}

	public void mousedrag(MouseEvent e) {
		if (a != null)
			a.setXY(e.getX(), e.getY());
		else
			tmp.setdxy(e.getX(), e.getY());
	}

	public void mouserelease(MouseEvent e) {
		if (a != null) 
			a.setSeleted(false);
		else {
			canvas.showport();
			tmp.setsXY(e.getX(), e.getY());
			tmp.setdxy(e.getX(), e.getY());
		}
	}
}// select End