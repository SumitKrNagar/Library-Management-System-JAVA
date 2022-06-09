package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements Frame {
	
	About() {
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ta.setBounds(0, 0, 0,0);
				ta2.setBounds(0, 0, 0, 0);
				ta3.setBounds(0, 0, 0, 0);
				ta4.setBounds(0, 0, 0, 0);
				ta5.setBounds(0, 0, 0, 0);
				ta6.setBounds(0, 0, 0, 0);
				
				bd.setBounds(0, 0, 0, 0);
				bi.setBounds(0, 0, 0, 0);
				ba.setBounds(0, 0, 0, 0);
				bav.setBounds(0, 0, 0, 0);
				br.setBounds(0, 0, 0, 0);
				bas.setBounds(0, 0, 0, 0);
				cs.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				
				p.setBounds(533, 220, 500, 400);
				
				lb.setText("________________________");
				lb.setBounds(542, 240, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
			
				lb2.setText("________________________");
				lb2.setBounds(542, 505, 500, 50);
				lb2.setForeground(new Color(150, 78,2));
				lb2.setFont(new Font("Serif", Font.BOLD, 40));
				
				l.setIcon(ic);
				l2.setText("HELP ?");
				l2.setFont(new Font("Serif", Font.BOLD, 33));
				l2.setBounds(720, 225, 300, 60);
				
				la.setText("HELLO THERE,");
				la.setBounds(550, 290, 150, 50);
				la.setForeground(new Color(150, 78,2));
				la.setFont(new Font("Serif", Font.BOLD, 15));
				
				la2.setText("I AM SUMIT, DEVELOPER OF THIS DESKTOP APPLICATION");
				la2.setBounds(570, 330, 500, 50);
				la2.setForeground(new Color(150, 78,2));
				la2.setFont(new Font("Serif", Font.BOLD, 15));
				
				la3.setText("IF YOU HAVE SOMETHING IN MIND, I AM OPEN TO ANY");
				la3.setBounds(570, 354, 500, 50);
				la3.setForeground(new Color(150, 78,2));
				la3.setFont(new Font("Serif", Font.BOLD, 15));
				
				la4.setText("FEEDBACK.");
				la4.setBounds(570, 378, 400, 50);
				la4.setForeground(new Color(150, 78,2));
				la4.setFont(new Font("Serif", Font.BOLD, 15));
				
				la5.setText("CONTACT ME THROUGH EMAIL: skn.sumit2001@gmail.com");
				la5.setBounds(570, 425, 500, 50);
				la5.setForeground(new Color(150, 78,2));
				la5.setFont(new Font("Serif", Font.BOLD, 15));
				
				la6.setText("-- THANK YOU");
				la6.setBounds(905, 480, 200, 50);
				la6.setForeground(new Color(150, 78,2));
				la6.setFont(new Font("Serif", Font.BOLD, 15));
				
				
			
				
		}};
		
		bm9.addActionListener(a);
		
	}

}