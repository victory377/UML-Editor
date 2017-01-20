package Lines;

import java.awt.Graphics;
import Port.*;
import shape.shape;

/* 透過計算簡單的向量來畫三角形
 * 以線當作一個向量取其法向量後
 * 計算出三角形的三個點
 * */
public class association extends Lines {
	public void draw(Graphics g) {
		int sx = start.getRX() + start.getParent().getX();
		int sy = start.getRY() + start.getParent().getY();
		int dx = end.getRX() + end.getParent().getX();
		int dy = end.getRY() + end.getParent().getY();

		int px = dx - sx; // 向量
		int py = dy - sy;
		int p_x = dx - px / 20;
		int p_y = dy - py / 20;

		int qx = py; // 向量
		int qy = -px;

		int Qx_size = qx / 15;
		int Qy_size = qy / 15;

		g.drawLine(sx, sy, p_x, p_y);
		g.drawLine(p_x - Qx_size, p_y + Qy_size, p_x + Qx_size, p_y - Qy_size);
		g.drawLine(p_x - Qx_size, p_y + Qy_size, dx, dy);
		g.drawLine(p_x + Qx_size, p_y - Qy_size, dx, dy);
	}
}