package Mode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.util.*;

import Mycanvas.*;
import shape.*;

/* 抽象類別提供四種滑鼠事件
 * 讓每種mode都可以有個別的滑鼠事件的處理
 * */
public class Mode {
	public void mouseclick(MouseEvent e) {
	}

	public void mousepress(MouseEvent e) {
	}

	public void mousedrag(MouseEvent e) {
	}

	public void mouserelease(MouseEvent e) {
	}
}
