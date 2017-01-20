package Mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import BasicObj.Usershape;
import Mycanvas.*;
import shape.*;

public class usecase extends Mode {
	Mycanvas canvas = Mycanvas.getInstance();
	ArrayList<shape> list = canvas.getArrayList();

	// 僅在press時，產生物件
	public void mousepress(MouseEvent e) {
		shape x = new Usershape();
		x.setXY(e.getX(), e.getY());
		x.setWH(80, 40);
		x.connection(x);
		list.add(x);
	}
}