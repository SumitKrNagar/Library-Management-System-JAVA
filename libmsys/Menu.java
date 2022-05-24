package libmsys;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

class Menu implements Frame {
	
	Menu(){
		
		ImageIcon i = new ImageIcon("menu.jpg");
		l.setIcon(i);
						
		p.remove(ln);
		p.remove(b);
		l.remove(t);
		l.remove(t2);
					
		p.setBounds(533, 220, 500, 400);
		p.setBorder(bo);
						
		l2.setText("CHOOSE AN OPTION");
		l2.setFont(new Font("Serif", Font.BOLD, 35));
		l2.setBounds(605, 378, 400, 60);
						
		
		lb.setText("________________________");
		lb.setBounds(542, 240, 500, 50);
		lb.setForeground(new Color(150, 78,2));
		lb.setFont(new Font("Serif", Font.BOLD, 40));
		
		lb2.setText("________________________");
		lb2.setBounds(542, 505, 500, 50);
		lb2.setForeground(new Color(150, 78,2));
		lb2.setFont(new Font("Serif", Font.BOLD, 40));
	
						
		lo.setBounds(1380, 765, 130, 50);
		lo.setText("LOGOUT");
		lo.setFont(new Font("Serif", Font.BOLD, 18));
		lo.setForeground(new Color(150, 78,2));
		lo.setBorder(bord);
		lo.setFocusable(false);
						
		bm.setBounds(133, 30, 200, 70);
		bm.setText("ADD BOOK");
		bm.setFont(new Font("Serif", Font.BOLD, 25));
		bm.setForeground(new Color(150, 78,2));
		bm.setBorder(bord);
		bm.setFocusable(false);
						
		bm2.setBounds(400, 30, 200, 70);
		bm2.setText("DELETE BOOK");
		bm2.setFont(new Font("Serif", Font.BOLD, 24));
		bm2.setForeground(new Color(150, 78,2));
		bm2.setBorder(bord);
		bm2.setFocusable(false);
						
		bm3.setBounds(667, 30, 200, 70);
		bm3.setText("ISSUE BOOK");
		bm3.setFont(new Font("Serif", Font.BOLD, 25));
		bm3.setForeground(new Color(150, 78,2));
		bm3.setBorder(bord);
		bm3.setFocusable(false);
						
		bm4.setBounds(934, 30, 200, 70);
		bm4.setText("RETURN BOOK");
		bm4.setFont(new Font("Serif", Font.BOLD, 24));
		bm4.setForeground(new Color(150, 78,2));
		bm4.setBorder(bord);
		bm4.setFocusable(false);
						
		bm5.setBounds(1201, 30, 200, 70);
		bm5.setText("BOOK AVAILABLITY");
		bm5.setFont(new Font("Serif", Font.BOLD, 18));
		bm5.setForeground(new Color(150, 78,2));
		bm5.setBorder(bord);
		bm5.setFocusable(false);
						
		bm6.setBounds(410, 715, 200, 70);
		bm6.setText("ADD STUDENT");
		bm6.setFont(new Font("Serif", Font.BOLD, 23));
		bm6.setForeground(new Color(150, 78,2));
		bm6.setBorder(bord);
		bm6.setFocusable(false);
						
		bm7.setBounds(677, 715, 200, 70);
		bm7.setText("DELETE STUDENT");
		bm7.setFont(new Font("Serif", Font.BOLD, 20));
		bm7.setForeground(new Color(150, 78,2));
		bm7.setBorder(bord);
		bm7.setFocusable(false);
						
		bm8.setBounds(944, 715, 200, 70);
		bm8.setText("CHECK STUDENT");
		bm8.setFont(new Font("Serif", Font.BOLD, 21));
		bm8.setForeground(new Color(150, 78,2));
		bm8.setBorder(bord);
		bm8.setFocusable(false);
		
		bm9.setBounds(20, 758, 150, 60);
		bm9.setText("HELP?");
		bm9.setFont(new Font("Serif", Font.BOLD, 28));
		bm9.setForeground(new Color(150, 78,2));
		bm9.setBorder(bord);
		bm9.setFocusable(false);
							
					
	}
}
