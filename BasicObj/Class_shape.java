package BasicObj;

import java.awt.Graphics;
import Port.*;
import shape.shape;

public class Class_shape extends BasicObj {
	
	@Override
	public void draw(Graphics g) {
		//if (getSeleted()) {
		for (Port element : port)
			element.draw(g);
		//} 
		
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.drawLine(getX(), getY() + (getHeight() / 2), getX() + getWidth(), getY() + (getHeight() / 2));

		if (name != null)
			g.drawString(name, getX() + 10, getY() + 10);
	}
}