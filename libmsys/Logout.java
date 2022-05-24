package libmsys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Logout implements Frame {
	
	Logout() {
		
		 ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				bm.setBounds(0, 0, 0, 0);
				bm2.setBounds(0, 0, 0, 0);
				bm3.setBounds(0, 0, 0, 0);
				bm4.setBounds(0, 0, 0, 0);
				bm5.setBounds(0, 0, 0, 0);
				bm6.setBounds(0, 0, 0, 0);
				bm7.setBounds(0, 0, 0, 0);
				bm8.setBounds(0, 0, 0, 0);
				lo.setBounds(0, 0, 0, 0);
				
				la.setBounds(0, 0, 0, 0);
				la2.setBounds(0, 0, 0, 0);
				la3.setBounds(0, 0, 0, 0);
				la4.setBounds(0, 0, 0, 0);
				la5.setBounds(0, 0, 0, 0);
				la6.setBounds(0, 0, 0, 0);
				

				ta.setBounds(0, 0, 0, 0);
				ta2.setBounds(0, 0, 0, 0);
				ta3.setBounds(0, 0, 0, 0);
				ta4.setBounds(0, 0, 0, 0);
				ta5.setBounds(0, 0, 0, 0);
				ta6.setBounds(0, 0, 0, 0);
				
				
				ba.setBounds(0, 0, 0, 0);
				bd.setBounds(0, 0, 0, 0);
				bi.setBounds(0, 0, 0, 0);
				br.setBounds(0, 0, 0, 0);
				bav.setBounds(0, 0, 0, 0);
				bas.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				cs.setBounds(0, 0, 0, 0);
		
				
				@SuppressWarnings("unused")
				Login l = new Login();
				
			}};
			
		lo.addActionListener(a);	
			
	}
}
