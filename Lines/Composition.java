package Lines;

import java.awt.Graphics;
import Port.*;
import shape.shape;

/* 透過計算簡單的向量來畫方形
 * 以線當作一個向量取其法向量後
 * 計算出方形的四個點
 * */
public class Composition extends Lines {
	public void draw(Graphics g) {
		int sx = start.getRX() + start.getParent().getX();
		int sy = start.getRY() + start.getParent().getY();
		int dx = end.getRX() + end.getParent().getX();
		int dy = end.getRY() + end.getParent().getY();

		int px = dx - sx; // 向量
		int py = dy - sy;

		int p_x = dx - px / 20;
		int p_y = dy - py / 20;

		int px_size = px / 20;
		int py_size = py / 20;

		int qx = py; // 向量
		int qy = -px;

		int Qx_size = qx / 20;
		int Qy_size = qy / 20;

		g.drawLine(sx, sy, p_x - px_size, p_y - py_size);
		g.drawLine(p_x - px_size, p_y - py_size, p_x - Qx_size, p_y + Qy_size);
		g.drawLine(p_x - px_size, p_y - py_size, p_x + Qx_size, p_y - Qy_size);
		g.drawLine(p_x - Qx_size, p_y + Qy_size, dx, dy);
		g.drawLine(p_x + Qx_size, p_y - Qy_size, dx, dy);
	}
}