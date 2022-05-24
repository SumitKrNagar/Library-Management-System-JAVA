package libmsys;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

interface Frame {
	
	JFrame jf = new JFrame();
	
	JLabel l = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	
	JButton b = new JButton();
	JButton bs = new JButton();
	JPanel p = new JPanel();
	JTextField t = new JTextField();
	JTextField t2 = new JTextField();
	JLabel ln = new JLabel();
	
	
	JButton bm = new JButton();
	JButton bm2 = new JButton();
	JButton bm3 = new JButton();
	JButton bm4 = new JButton();
	JButton bm5 = new JButton();
	JButton bm6 = new JButton();
	JButton bm7 = new JButton();
	JButton bm8 = new JButton();
	JButton bm9 = new JButton();
	JButton lo = new JButton();
	
	JLabel la = new JLabel();
	JLabel la2 = new JLabel();
	JLabel la3 = new JLabel();
	JLabel la4 = new JLabel();
	JLabel la5 = new JLabel();
	JLabel la6 = new JLabel();
	JLabel lb = new JLabel();
	JLabel lb2 = new JLabel();
	
	JTextField ta = new JTextField();
	JTextField ta2 = new JTextField();
	JTextField ta3 = new JTextField();
	JTextField ta4 = new JTextField();
	JTextField ta5 = new JTextField();
	JTextField ta6 = new JTextField();
	
	JButton ba = new JButton();
	JButton bd = new JButton();
	JButton bi = new JButton();
	JButton br = new JButton();
	JButton bav = new JButton();
	JButton bas = new JButton();
	JButton bds = new JButton();
	JButton cs = new JButton();
	
	
	Border bord = BorderFactory.createLineBorder(new Color(150, 78, 2), 3);
	Border bor = BorderFactory.createLineBorder(new Color(150, 78, 2), 1);
	Border bo = BorderFactory.createLineBorder(new Color(150, 78, 2), 5);

	ImageIcon ic = new ImageIcon("menublur.jpg");
	
	static void f() {
		
		jf.setTitle("LIBRARY MANAGER");
		
		ImageIcon ic = new ImageIcon("icon.png");
		jf.setIconImage(ic.getImage());
		
		jf.setSize(1920, 1080);
		jf.setDefaultCloseOperation(1);
		jf.setResizable(false);
		jf.setLayout(null);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setVisible(true);
		
		jf.add(l);
		
		l.add(la);
		l.add(la2);
		l.add(la3);
		l.add(la4);
		l.add(la5);
		l.add(la6);
		l.add(lb);
		l.add(lb2);	
		
		l.add(ta);
		l.add(ta2);
		l.add(ta3);
		l.add(ta4);
		l.add(ta5);
		l.add(ta6);
		
		p.add(ba);
		p.add(bd);
		p.add(bi);
		p.add(br);
		p.add(bav);
		p.add(bas);
		p.add(bds);
		p.add(cs);
		
		l.add(bm);
		l.add(bm2);
		l.add(bm3);
		l.add(bm4);
		l.add(bm5);
		l.add(bm6);
		l.add(bm7);
		l.add(bm8);
		l.add(bm9);
		l.add(lo);
		
	}
	
}
