package BasicObj;

import java.awt.Graphics;
import Port.*;
import shape.shape;

public class Usershape extends BasicObj {
	@Override
	public void draw(Graphics g) {
		for (Port element : port)
				element.draw(g);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		if (name != null)
			g.drawString(name, getX() + 10, getY() + 10);
	}
}