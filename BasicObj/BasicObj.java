package BasicObj;

import Port.*;
import shape.*;

public class BasicObj extends shape {
	Port[] port = new Port[4];
	String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSeleted(boolean select){
		super.setSeleted(select);
		for(Port e: port)
			e.setPort(select);
	}
	
	public void connection(shape x) {
		double[] w = { 0.5, 1, 0.5, 0 };
		double[] h = { 0, 0.5, 1, 0.5 };
		for (int i = 0; i < 4; i++) {
			port[i] = new Port();
			port[i].setParent(x);
			port[i].setXY(getWidth() * w[i] - 4, getHeight() * h[i] - 4);
		}
	}

	public Port findCloser(int x, int y) {
		int min = 100000, d = 0;
		for (int i = 0; i < 4; i++) {
			if (Math.pow(((port[i].getRX() + getX()) - x), 2) + Math.pow(((port[i].getRY() + getY()) - y), 2) < min) {
				min = (int) (Math.pow(((port[i].getRX() + getX()) - x), 2)
						+ Math.pow(((port[i].getRY() + getY()) - y), 2));
				d = i;
			}
		}
		return port[d];
	}

	public boolean Inarea(int px, int py) {
		if ((px >= getX()) && (px <= (getX() + getWidth()))) {
			if ((py >= getY()) && (py <= (getY() + getHeight()))) {
				return true;
			} else
				return false;
		} else
			return false;
	}
}
