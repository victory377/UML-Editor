package Lines;

import java.awt.Graphics;

public class PreviewLine {
	int sx, sy, dx, dy;

	public void setdx(int dx) {
		this.dx = dx;
	}

	public void setdy(int dy) {
		this.dy = dy;
	}

	public void setsx(int sx) {
		this.sx = sx;
	}

	public void setsy(int sy) {
		this.sy = sy;
	}

	public void reset(){
		this.sx = 0;
		this.sy = 0;
		this.dx = 0;
		this.dy = 0;
	}
	
	public void draw(Graphics g) {
		g.drawLine(sx, sy, dx, dy);
	}
}
