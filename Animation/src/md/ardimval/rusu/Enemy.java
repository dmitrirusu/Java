package md.ardimval.rusu;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Object {
	
	Object p = new Object();
	
	Image img = new ImageIcon("res\\car.png").getImage();
	int x;
	int y;
	int v;
	Frame frame;
	
	
	public Enemy(int x, int y, int v, Frame frame){
		this.x =x;
		this.y = y;
		this.v = v;
		this.frame = frame;
	}
	
	public void move(){
		x=x-frame.p.v+v;
		
	}
	
	public Rectangle getrect(){
		return new Rectangle(x, y, 140, 58);
	}
	
	
}
