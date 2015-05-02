package md.ardimval.rusu;

import javax.swing.JFrame;

public class Main extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setSize(800, 900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.add(new Frame());
		f.setVisible(true);
		
	}

}
