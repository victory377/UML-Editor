package Lines;

import java.awt.Graphics;
import Port.*;
import shape.shape;

/* Line物件中記錄著開始與結束的物件參考
 * 在畫線的時候，動態更新被選物件最近的port
 * */
public class generalLine extends Lines {
	public void draw(Graphics g) {
		g.drawLine(start.getRX() + start.getParent().getX(), start.getRY() + start.getParent().getY(),
				end.getRX() + end.getParent().getX(), end.getRY() + end.getParent().getY());
	}
}
