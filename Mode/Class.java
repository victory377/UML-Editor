package Mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import BasicObj.Class_shape;
import Mycanvas.*;
import shape.*;

public class Class extends Mode {
	Mycanvas canvas = Mycanvas.getInstance();
	ArrayList<shape> list = canvas.getArrayList();

	// 僅在press時，產生物件
	public void mousepress(MouseEvent e) {
		shape x = new Class_shape();
		x.setXY(e.getX(), e.getY());
		x.setWH(70, 70);
		x.connection(x);
		list.add(x);
	}
}
