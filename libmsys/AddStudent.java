package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.sql.*;
import Project.ConnectionProvider;

class AddStudent extends Main implements Frame  {
	
	AddStudent(){
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				la5.setBounds(0, 0, 0, 0);
				la6.setBounds(0, 0, 0, 0);
				
				ta5.setBounds(0, 0, 0, 0);
				ta6.setBounds(0, 0, 0, 0);
				
				bd.setBounds(0, 0, 0, 0);
				bi.setBounds(0, 0, 0, 0);
				ba.setBounds(0, 0, 0, 0);
				bav.setBounds(0, 0, 0, 0);
				br.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				cs.setBounds(0, 0, 0, 0);
				
				p.setBounds(533, 220, 500, 350);
				
				l.setIcon(ic);
				
				lb.setText("________________________");
				lb.setBounds(542, 240, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
				
				lb2.setBounds(542, 458, 500, 50);
				
				l2.setText("ADD STUDENT");
				l2.setFont(new Font("Serif", Font.BOLD, 35));
				l2.setBounds(665, 225, 300, 60);
				
				la.setText("ADMISSION NO.       ---");
				la.setBounds(570, 310, 200, 50);
				la.setForeground(new Color(150, 78,2));
				la.setFont(new Font("Serif", Font.BOLD, 15));
				
				la2.setText("NAME                         ---");
				la2.setBounds(570, 355, 200, 50);
				la2.setForeground(new Color(150, 78,2));
				la2.setFont(new Font("Serif", Font.BOLD, 15));
				
				la3.setText("FATHER'S NAME     ---");
				la3.setBounds(570, 400, 200, 50);
				la3.setForeground(new Color(150, 78,2));
				la3.setFont(new Font("Serif", Font.BOLD, 15));
				
				la4.setText("PHONE NO.               ---");
				la4.setBounds(570, 444, 200, 50);
				la4.setForeground(new Color(150, 78,2));
				la4.setFont(new Font("Serif", Font.BOLD, 15));
				
				
				ta.setBounds(740, 321, 248, 27);
				ta.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta.setForeground(new Color(150, 78,2));
				ta.setText("");
				
				ta2.setBounds(740, 366, 248, 27);
				ta2.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta2.setForeground(new Color(150, 78,2));
				ta2.setText("");
				
				ta3.setBounds(740, 411, 248, 27);
				ta3.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta3.setForeground(new Color(150, 78,2));
				ta3.setText("");
				
				ta4.setBounds(740, 456, 248, 27);
				ta4.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta4.setForeground(new Color(150, 78,2));
				ta4.setText("");
				
			
				bas.setText("ADD");
				bas.setBounds(198, 300, 105, 29);
				bas.setFont(new Font("Serif", Font.PLAIN, 17));
				bas.setForeground(new Color(150, 78,2));
				bas.setBorder(bor);
				bas.setFocusable(false);
				
				ActionListener ab = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------
						String adm = ta.getText();
						String n = ta2.getText();
						String fname = ta3.getText();
						String pno = ta4.getText();
						
						if (adm.equals("") || n.equals("") || fname.equals("") || pno.equals("")) {
							
							JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY, YOU MUST FILL ALL FIELDS", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
							
						}
						
						else {
							
							try {
								
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
								
								st.executeUpdate("INSERT INTO "+user+"students values ('"+adm+"', '"+n+"', '"+fname+"', '"+pno+"')");
								
								JOptionPane.showMessageDialog(null, "STUDENT ADDED SUCCESSFULLY", "GREAT !!", JOptionPane.INFORMATION_MESSAGE);
								
								
							}
							catch (Exception as) {
								
								JOptionPane.showMessageDialog(null, "INVALID DETAILS, PLEASE CHECK AGAIN", "OOPS !!", JOptionPane.ERROR_MESSAGE);
								
							}
							
						}
						
						
					}};
					
				bas.addActionListener(ab);	
				
			}};

		bm6.addActionListener(a);
		
	}
	
}
