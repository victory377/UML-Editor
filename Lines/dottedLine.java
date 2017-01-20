package Lines;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import Mycanvas.Mycanvas;
import shape.shape;

/* 畫虛線的物件
 * 記錄著使用者press與releaase得點
 * */
public class dottedLine {
	int dX, dY, sX, sY;

	public void setdxy(int dX,int dY) {
		this.dX = dX;
		this.dY = dY;
	}

	public int getdx() {
		return dX;
	}

	public int getdy() {
		return dY;
	}

	public void setsXY(int sX,int sY) {
		this.sX = sX;
		this.sY = sY;
	}

	public int getsX() {
		return sX;
	}

	public int getsY() {
		return sY;
	}
	//若虛線範圍內的物件及回傳true，否則就是false 
	public boolean Inarea(int sx, int sy, int dx, int dy) {
		if (sX > dX && sY > dY) {
			if (dx < sX && sx > dX)
				if (dy < sY && sy > dY)
					return true;
			return false;
		} else {
			if (dx < dX && sx > sX)
				if (dy < dY && sy > sY)
					return true;
			return false;
		}
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		float[] arr = { 4.0f, 2.0f };
		BasicStroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, arr, 0);
		g2.setStroke(stroke);

		if ((dX >= sX) && (dY >= sY)) {
			Rectangle2D.Float rect = new Rectangle2D.Float(sX, sY, (dX - sX), (dY - sY));
			g2.draw(rect);
		} else {
			Rectangle2D.Float rect = new Rectangle2D.Float(dX, dY, (sX - dX), (sY - dY));
			g2.draw(rect);
		}
		/* set the pen to real line */
		BasicStroke s = new BasicStroke();
		g2.setStroke(s);
	}
}