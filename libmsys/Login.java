package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


class Login implements Frame{
	
	Login() {

		
		lb.setBounds(0, 0, 0, 0);
		lb2.setBounds(0, 0, 0, 0);
		bm9.setBounds(0, 0, 0, 0);
		
		l.remove(l3);
		bs.setBounds(0, 0, 0, 0);
				
		ImageIcon i = new ImageIcon("welcomeblur.png");
		l.setIcon(i);
				
		p.setBounds(590, 270, 390, 285);
		p.setLayout(null);
		
		p.setBorder(bord);
				
			
		l2.setBounds(689, 285, 200, 60);
		l2.setText("LOGIN");
		l2.setFont(new Font("Serif", Font.BOLD, 60));
		l2.setBackground(null);
		l2.setBorder(null);
				
					
		ln.setText("New User?");
		ln.setFont(new Font("Serif", Font.BOLD, 18));
		ln.setForeground(new Color(150, 78,2));
		ln.setBounds(38, 229, 90, 25);			
			
		t.setText("USER-ID");
		t.setBounds(655, 370, 265, 35);
		t.setFont(new Font("Serif", Font.ITALIC, 15)); 
		t.setForeground(new Color(150, 78,2));
				
		t2.setText("PASSWORD");
		t2.setBounds(655, 432, 265, 35);
		t2.setFont(new Font("Serif", Font.ITALIC, 15));
		t2.setForeground(new Color(150, 78,2));
				
		b.setBounds(139, 225, 115, 35);
		b.setText("LogIn");
		b.setFont(new Font("Serif", Font.BOLD, 22));
		b.setForeground(new Color(150, 78,2));
		b.setBorder(bor);
		b.setFocusable(false);
				
				
		l.add(p);
		l.add(t);
		l.add(t2);
			
		p.add(ln);
		p.add(b);
		
						
// ------------------------------------------------------ KEY LISTENER FOR DELETING TEXT(USER-ID) FROM LOGIN TEXTFIELD 1  -----------------------------------------------
		
		KeyListener kt = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				String str = t.getText();
				if(str.equals("USER-ID")) {
					
					t.setText("");
					t.setFont(new Font("Serif", Font.BOLD, 20));
					
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}};
		 
			t.addKeyListener(kt);
		 
// -------------------------------------------------------- MOUSE LISTENER FOR DELETING TEXT(PASSWORD) FROM LOGIN TEXTFIELD 2 --------------------------------------------
			
			MouseListener mt = new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					
					String str2 = t2.getText();
					if (str2.equals("PASSWORD")) {
						
						t2.setText("");
						t2.setFont(new Font("Serif", Font.BOLD, 20));
						
					}	
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}};
			
			t2.addMouseListener(mt);
			
			MouseListener m = new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					@SuppressWarnings("unused")
					Signup s = new Signup();
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					ln.setForeground(Color.BLUE);
					ln.setBounds(35, 229, 95, 25);
					ln.setFont(new Font("Serif", Font.BOLD, 20));					
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					ln.setForeground(new Color(150, 78,2));
					ln.setBounds(38, 229, 90, 25);	
					ln.setFont(new Font("Serif", Font.BOLD, 18));
					
				}};
				
			ln.addMouseListener(m);	
						
	}
}
