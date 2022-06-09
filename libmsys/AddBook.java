package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;
import Project.ConnectionProvider;

class AddBook extends Main implements Frame {
	
	AddBook() {
			
	ActionListener a = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
	
			
			bd.setBounds(0, 0, 0, 0);
			bi.setBounds(0, 0, 0, 0);
			br.setBounds(0, 0, 0, 0);
			bav.setBounds(0, 0, 0, 0);
			bas.setBounds(0, 0, 0, 0);
			bds.setBounds(0, 0, 0, 0);
			cs.setBounds(0, 0, 0, 0);
			
			la6.setBounds(0, 0, 0, 0);
			ta6.setBounds(0, 0, 0, 0);
			
			
			p.setBounds(533, 220, 500, 400);
		
			lb.setText("________________________");
			lb.setBounds(542, 240, 500, 50);
			lb.setForeground(new Color(150, 78,2));
			lb.setFont(new Font("Serif", Font.BOLD, 40));
			
			lb2.setBounds(542, 505, 500, 50);
			
			l.setIcon(ic);
			l2.setText("ADD BOOK");
			l2.setFont(new Font("Serif", Font.BOLD, 35));
			l2.setBounds(694, 225, 300, 60);
			
			la.setText("BOOK ID                    ---");
			la.setBounds(570, 310, 200, 50);
			la.setForeground(new Color(150, 78,2));
			la.setFont(new Font("Serif", Font.BOLD, 15));
			
			la2.setText("BOOK NAME             ---");
			la2.setBounds(570, 355, 200, 50);
			la2.setForeground(new Color(150, 78,2));
			la2.setFont(new Font("Serif", Font.BOLD, 15));
			
			la3.setText("PUBLISHER               ---");
			la3.setBounds(570, 400, 200, 50);
			la3.setForeground(new Color(150, 78,2));
			la3.setFont(new Font("Serif", Font.BOLD, 15));
			
			la4.setText("PUBLISHED YEAR    ---");
			la4.setBounds(570, 444, 200, 50);
			la4.setForeground(new Color(150, 78,2));
			la4.setFont(new Font("Serif", Font.BOLD, 15));
			
			la5.setText("PRICE                         ---");
			la5.setBounds(570, 488, 200, 50);
			la5.setForeground(new Color(150, 78,2));
			la5.setFont(new Font("Serif", Font.BOLD, 15));
			
						
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
			
			ta5.setBounds(740, 501, 248, 27);
			ta5.setFont(new Font("Serif", Font.BOLD, 16)); 
			ta5.setForeground(new Color(150, 78,2));
			ta5.setText("");
			
			
			ba.setText("SAVE");
			ba.setBounds(198, 350, 105, 29);
			ba.setFont(new Font("Serif", Font.PLAIN, 17));
			ba.setForeground(new Color(150, 78,2));
			ba.setBorder(bor);
			ba.setFocusable(false);
				
			
			ActionListener ab = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------					
					String bid = ta.getText();
					String bn = ta2.getText();
					String pub = ta3.getText();
					String pubyr = ta4.getText();
					String prc = ta5.getText();
					
					if (bid.equals("") || bn.equals("") || pub.equals("") || pubyr.equals("") || prc.equals("")) {
						
						JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY, YOU MUST FILL ALL FIELDS", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
						
					}
					
					else {
					
						try {
						
							Connection con = ConnectionProvider.getCon();
							Statement st = con.createStatement();
						
							ResultSet rs = st.executeQuery("SELECT s_no FROM "+user+"books WHERE book_id = '"+bid+"' AND book_name = '"+bn+"'");
							
							if(rs.next())
								JOptionPane.showMessageDialog(null, "BOOK ALREADY EXIST", "OOPS !!", JOptionPane.WARNING_MESSAGE);
							
							else {
								
								st.executeUpdate("INSERT INTO "+user+"books (book_id, book_name, publisher, published_year, price) VALUES ('"+bid+"', '"+bn+"', '"+pub+"', '"+pubyr+"', '"+prc+"')");
						
								JOptionPane.showMessageDialog(null, "BOOK ADDED SUCCESSFULLY", "GREAT !!", JOptionPane.INFORMATION_MESSAGE);
								
							}
						
						}
					
						catch (Exception a) {
						
							JOptionPane.showMessageDialog(null, "INVALID DETAILS, PLEASE CHECK AGAIN ", "OOPS !!", JOptionPane.ERROR_MESSAGE);
						
						}
						
					}
					
				}};
				
			ba.addActionListener(ab);	

		}};
		
		bm.addActionListener(a);
		
	}		
}
