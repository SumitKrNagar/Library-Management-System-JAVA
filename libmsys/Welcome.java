package libmsys;


import javax.swing.*;
import java.awt.*;

class Welcome implements Frame {
	
	Welcome() {
		
		ImageIcon i = new ImageIcon("images\\welcome.jpg");
		
		l.setSize(1920, 1080);
		l.setIcon(i);
		
		l2.setBounds(843, 365, 285, 55);
		l2.setText("WELCOME");
		l2.setForeground(new Color(150, 78, 2));
		l2.setFont(new Font("Serif", Font.BOLD, 50));
		l2.setBackground(Color.WHITE);
		l2.setOpaque(true);
		
		
		l2.setBorder(bo);
		
		l3.setBounds(801, 730, 380, 36);
		l3.setText(" CLICK HERE TO CONTINUE");
		l3.setForeground(new Color(150, 78, 2));
		l3.setFont(new Font("Serif", Font.BOLD, 26));
		l3.setBackground(Color.WHITE);
		l3.setOpaque(true);
		l3.setBorder(bord);
		
		
		l.add(l2);
		l.add(l3);
		
		
		Frame.f();
					
	}
}
