package md.ardimval.rusu;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Object  {
	Image img_c = new ImageIcon("res\\car.png").getImage();
	Image bg = new ImageIcon("res\\road.png").getImage();
	Image img_l = new ImageIcon("res\\car_l.png").getImage();
	Image img_r = new ImageIcon("res\\car_r.png").getImage();
	Image img=img_c;


	public static final int max_v =100;
	public static final int min_v=0;
	public static final int max_y=0;
	public static final int min_y=600;
	
	
	
	int x;
	int y=30;
	int dy=0;
	int v = 0;
	int dv=0;
	int s = 0 ;
	
	
	
	int layer1 =0;
	int layer2 = 1600;
	
	public Rectangle getrect(){
		return new Rectangle(x, y, 140,58 );
	}
	
	
	public void move(){
	s+= v;
	v += dv;
	
	if(v >= max_v) v=max_v;
	if(v <= min_v) v = min_v;
	if(y <= max_y) y = max_y;
	if(y >= min_y) y = min_y; 
	y -= dy;
	if(layer2 -v <= 0){
		layer1=0;
		layer2=1600;
	}
	
	else{
	layer1-= v;
	layer2-= v;
	}
	}
	

}
