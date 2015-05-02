package md.ardimval.rusu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener,Runnable {
	
	Object p = new Object();
	Timer maiTimer = new Timer(20,this);
	Thread enemyFactory = new Thread(this);
	ArrayList<Enemy> enemies  = new ArrayList<Enemy>();
	
	public Frame(){
		maiTimer.start();
		enemyFactory.start();
		addKeyListener(new Key());
		setFocusable(true);
	}
	
	public void paint(Graphics g){
		g = (Graphics2D)g;
		
		g.drawImage(p.bg, p.layer1, 0,null);
		g.drawImage(p.bg, p.layer2, 0,null);
		g.drawImage(p.img,p.x,p.y,null);
		Iterator<Enemy> i = enemies.iterator();
		while(i.hasNext()){
			Enemy e= i.next();
			if(e.x >= 2400 || e.x <= -2400){
				i.remove();
			}
			else{
				e.move();
			g.drawImage(e.img,e.x,e.y,null);
			}
		}
		double v = 200/p.max_v*p.v;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.ITALIC,30));
		g.drawString("Скорость: "+ v + "  км/ч  " , 100, 30);
		
	}

	
private void checkColision(){
	Iterator<Enemy> i = enemies.iterator();
	while(i.hasNext()){
		Enemy e = i.next();
		if(e.getrect().intersects(p.getrect())){
			JOptionPane.showMessageDialog(null, "Вы проиграли!!!");
			System.exit(1);
		}
	}
}
		
	
	
  private class Key extends KeyAdapter{
	  public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==e.VK_RIGHT){
				p.dv =1;
			}
			if(e.getKeyCode()==e.VK_LEFT){
				p.dv=-1;
			}
			if(e.getKeyCode()==e.VK_UP){
				p.dy=10;
				p.img=p.img_l;
			}
			if(e.getKeyCode()==e.VK_DOWN){
				p.dy=-10;
				p.img=p.img_r;
			}
		}
	  
	  public void keyReleased(KeyEvent e){
		  if(e.getKeyCode()==e.VK_RIGHT || e.getKeyCode()==e.VK_LEFT ){
				p.dv=0;
			}
		  if(e.getKeyCode()==e.VK_UP || e.getKeyCode()==e.VK_DOWN ){
				p.dy=0;
				p.img=p.img_c;
			}
	  }
	  
  }
  
  @Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			Random r = new Random();
		   try {
				
				Thread.sleep(r.nextInt(2000));
				enemies.add(new Enemy(1200,r.nextInt(600),r.nextInt(80),this));

			}
			
		 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		p.move();
		repaint();
		checkColision();
	}
	
  }


