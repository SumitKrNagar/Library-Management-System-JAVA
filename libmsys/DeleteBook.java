package libmsys;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import java.sql.*;
import Project.ConnectionProvider;

class DeleteBook implements Frame {
	
	DeleteBook(){
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ba.setBounds(0, 0, 0, 0);
				bi.setBounds(0, 0, 0, 0);
				br.setBounds(0, 0, 0, 0);
				bav.setBounds(0, 0, 0, 0);
				bas.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				cs.setBounds(0, 0, 0, 0);
				
				la5.setBounds(0, 0, 0, 0);
				ta5.setBounds(0, 0, 0, 0);				
				la6.setBounds(0, 0, 0, 0);
				ta6.setBounds(0, 0, 0, 0);
				
				p.setBounds(533, 220, 500, 350);
				
				lb.setText("________________________");
				lb.setBounds(542, 240, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
				
				
				lb2.setBounds(542, 458, 500, 50);
				
				l.setIcon(ic);
				l2.setText("DELETE BOOK");
				l2.setFont(new Font("Serif", Font.BOLD, 35));
				l2.setBounds(659, 225, 300, 60);
				
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
				
	
				bd.setText("DELETE");
				bd.setBounds(198, 300, 105, 29);
				bd.setFont(new Font("Serif", Font.PLAIN, 16));
				bd.setForeground(new Color(150, 78,2));
				bd.setBorder(bor);
				bd.setFocusable(false);
				
				ActionListener ab = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
	
// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------						
						String bid = ta.getText();
						String bn = ta2.getText();
						String pub = ta3.getText();
						String pubyr = ta4.getText();
	
						if (bid.equals("") || bn.equals("") || pub.equals("") || pubyr.equals("")) {
							
							JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY, YOU MUST FILL ALL FIELDS", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
							
						}
						
						else {
							
							try {
							
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
							
								st.executeUpdate("DELETE FROM books WHERE book_id = '"+bid+"' AND book_name = '"+bn+"' AND publisher = '"+pub+"' AND published_year = '"+pubyr+"'");
							
								JOptionPane.showMessageDialog(null, "BOOK DELETED SUCCESSFULLY", "DELETED !!", JOptionPane.INFORMATION_MESSAGE);
							
							
							}
							
							catch(Exception d) {
							
								JOptionPane.showMessageDialog(null, "INVALID DETAILS, PLEASE CHECK AGAIN ", "OOPS !!", JOptionPane.ERROR_MESSAGE);
							
							}
							
						}
						
					}};
					
				bd.addActionListener(ab);	
					
			}};
			
		bm2.addActionListener(a);

	}
}
