package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import Project.ConnectionProvider;

class ReturnBook extends Main implements Frame {
	
	ReturnBook(){
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				la5.setBounds(0, 0, 0, 0);
				ta5.setBounds(0, 0, 0, 0);
				la6.setBounds(0, 0, 0, 0);
				ta6.setBounds(0, 0, 0, 0);
				
				
				bd.setBounds(0, 0, 0, 0);
				bi.setBounds(0, 0, 0, 0);
				ba.setBounds(0, 0, 0, 0);
				bav.setBounds(0, 0, 0, 0);
				bas.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				cs.setBounds(0, 0, 0, 0);
				
				p.setBounds(533, 220, 500, 400);
				
				lb.setText("________________________");
				lb.setBounds(542, 240, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
				
				lb2.setBounds(542, 505, 500, 50);
			
				l.setIcon(ic);
				l2.setText("RETURN BOOK");
				l2.setFont(new Font("Serif", Font.BOLD, 35));
				l2.setBounds(659, 225, 300, 60);
				
				la.setText("ADMISSION NO.       ---");
				la.setBounds(570, 310, 200, 50);
				la.setForeground(new Color(150, 78,2));
				la.setFont(new Font("Serif", Font.BOLD, 15));
				
				la2.setText("BOOK ID                    ---");
				la2.setBounds(570, 355, 200, 50);
				la2.setForeground(new Color(150, 78,2));
				la2.setFont(new Font("Serif", Font.BOLD, 15));
				
				la3.setText("BOOK NAME            ---");
				la3.setBounds(570, 400, 200, 50);
				la3.setForeground(new Color(150, 78,2));
				la3.setFont(new Font("Serif", Font.BOLD, 15));
				
				la4.setText("PUBLISHER               ---");
				la4.setBounds(570, 444, 200, 50);
				la4.setForeground(new Color(150, 78,2));
				la4.setFont(new Font("Serif", Font.BOLD, 15));
				
				la5.setText("PUBLISHED YEAR    ---");
				la5.setBounds(570, 488, 200, 50);
				la5.setForeground(new Color(150, 78,2));
				la5.setFont(new Font("Serif", Font.BOLD, 15));
				
				
				
				ta.setBounds(740, 321, 248, 27);
				ta.setFont(new Font("Serif", Font.BOLD, 15)); 
				ta.setForeground(new Color(150, 78,2));
				ta.setText("");
				
				ta2.setBounds(740, 366, 248, 27);
				ta2.setFont(new Font("Serif", Font.BOLD, 15)); 
				ta2.setForeground(new Color(150, 78,2));
				ta2.setText("");
				
				ta3.setBounds(740, 411, 248, 27);
				ta3.setFont(new Font("Serif", Font.BOLD, 15)); 
				ta3.setForeground(new Color(150, 78,2));
				ta3.setText("");
				
				ta4.setBounds(740, 456, 248, 27);
				ta4.setFont(new Font("Serif", Font.BOLD, 15)); 
				ta4.setForeground(new Color(150, 78,2));
				ta4.setText("");
				
				ta5.setBounds(740, 501, 248, 27);
				ta5.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta5.setForeground(new Color(150, 78,2));
				ta5.setText("");
				
				br.setText("RETURN");
				br.setBounds(196, 350, 105, 29);
				br.setFont(new Font("Serif", Font.PLAIN, 16));
				br.setForeground(new Color(150, 78,2));
				br.setBorder(bor);
				br.setFocusable(false);
				
				ActionListener ab = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
							
// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------	
						String adn = ta.getText();
						String bid = ta2.getText();
						String bn = ta3.getText();
						String pub = ta4.getText();
						String pyr = ta5.getText();
						
						if(adn.equals("") || bn.equals("") || pub.equals("") || pyr.equals("") || bid.equals(""))
							JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY, YOU MUST FILL ALL FIELDS", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
						
						else {
							
							try {
								
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
								
								ResultSet rs = st.executeQuery("SELECT issue_date, due_date FROM "+user+"issue WHERE book_id = '"+bid+"' AND book_name = '"+bn+"' AND publisher = '"+pub+"' AND published_year = '"+pyr+"' AND admission_no = '"+adn+"' ");
								
								if(rs.next()) {
									
									String d1 = rs.getString("due_date");		
									Date d = new Date();
									SimpleDateFormat form = new SimpleDateFormat("yyyy/MM//dd");
									String d2 = form.format(d);
									
									String d3 = rs.getString("issue_date");
											
									if(d1.compareTo(d2) > 0 )
										JOptionPane.showMessageDialog(null, "BOOK HAS BEEN RETURNED \nISSUED DATE WAS "+d3+"\nDUE DATE WAS "+d1, "NICE !!", JOptionPane.INFORMATION_MESSAGE);
										
									else if(d1.compareTo(d2) < 0)
										JOptionPane.showMessageDialog(null, "BOOK HAS BEEN RETURNED BUT DUE DATE IS EXPIRED \nISSUED DATE WAS "+d3+"\nDUE DATE WAS "+d1, "LATE", JOptionPane.WARNING_MESSAGE);
									
									st.executeUpdate("DELETE FROM "+user+"issue WHERE book_id = '"+bid+"' AND book_name = '"+bn+"' AND publisher = '"+pub+"' AND published_year = '"+pyr+"' AND admission_no = '"+adn+"' ");
								
								}
								
								else
									JOptionPane.showMessageDialog(null, "WRONG DETAILS, RECORD NOT FOUND", "OOPS !!", JOptionPane.WARNING_MESSAGE);
								
							}
							
							catch(Exception r) {
								
								JOptionPane.showMessageDialog(null, "AN ERROR HAS OCCURED", "OOPS !!", JOptionPane.ERROR_MESSAGE);
								
							} 	
						}
							
					}};
					
				br.addActionListener(ab);	
					
			}};

		bm4.addActionListener(a);
		
	}
}
