package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.sql.*;
import Project.ConnectionProvider;

class DeleteStudent implements Frame {
	
	DeleteStudent(){
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				la2.setBounds(0, 0, 0, 0);
				la3.setBounds(0, 0, 0, 0);
				la4.setBounds(0, 0, 0, 0);
				la5.setBounds(0, 0, 0, 0);
				la6.setBounds(0, 0, 0, 0);
					
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
				
				p.setBounds(533, 220, 500, 350);
				
				l.setIcon(ic);
				
				lb.setText("________________________");
				lb.setBounds(542, 240, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
				
				lb2.setBounds(542, 458, 500, 50);
				
				l2.setText("DELETE STUDENT");
				l2.setFont(new Font("Serif", Font.BOLD, 35));
				l2.setBounds(626, 225, 320, 60);
				
				la.setText("STUDENT ADMISSION NO.");
				la.setBounds(658, 335, 280, 50);
				la.setForeground(new Color(150, 78,2));
				la.setFont(new Font("Serif", Font.BOLD, 20));
				
				ta.setBounds(675, 390, 220, 30);
				ta.setFont(new Font("Serif", Font.BOLD, 20)); 
				ta.setForeground(new Color(150, 78,2));
				ta.setText("");
				
				bds.setText("DELETE");
				bds.setBounds(198, 300, 105, 29);
				bds.setFont(new Font("Serif", Font.PLAIN, 16));
				bds.setForeground(new Color(150, 78,2));
				bds.setBorder(bor);
				bds.setFocusable(false);
				
				ActionListener ab = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------
						String sadm = ta.getText();
						
						if (sadm.equals("")) {
							
							JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY, YOU MUST FILL ALL FIELDS", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
							
						}
						
						else {
							
							try {
								
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
								
								ResultSet rs = st.executeQuery("SELECT * FROM students WHERE admission_no = '"+sadm+"' ");
								
								if(rs.next()) {
									st.executeUpdate("DELETE FROM students where admission_no = '"+sadm+"'");								
									JOptionPane.showMessageDialog(null, "STUDENT DELETED SUCCESSFULLY", "DELETED !!", JOptionPane.INFORMATION_MESSAGE);
									
								}
								else
									JOptionPane.showMessageDialog(null, "STUDENT NOT FOUND", "OOPS !!", JOptionPane.INFORMATION_MESSAGE);
								
							}
							catch (Exception ds){
								
								JOptionPane.showMessageDialog(null, "INVALID DETAILS, PLEASE CHECK AGAIN", "OOPS !!", JOptionPane.ERROR_MESSAGE);
								
							}
							
							
							
						}
						
						
						
						
					}};
					
				bds.addActionListener(ab);	
				
			}};

		bm7.addActionListener(a);
		
		
	}

}
