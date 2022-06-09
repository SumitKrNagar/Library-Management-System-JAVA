package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.*;
import Project.ConnectionProvider;

class IssueBook extends Main implements Frame {
	
	IssueBook(){
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				bd.setBounds(0, 0, 0, 0);
				ba.setBounds(0, 0, 0, 0);
				br.setBounds(0, 0, 0, 0);
				bav.setBounds(0, 0, 0, 0);
				bas.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				cs.setBounds(0, 0, 0, 0);
				
				p.setBounds(533, 200, 500, 430);
				
				lb.setText("________________________");
				lb.setBounds(542, 220, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
				
				lb2.setBounds(542, 525, 500, 50);
				
				l.setIcon(ic);
				l2.setText("ISSUE BOOK");
				l2.setFont(new Font("Serif", Font.BOLD, 35));
				l2.setBounds(679, 205, 300, 60);
				
				la.setText("BOOK ID                    ---");
				la.setBounds(570, 295, 200, 50);
				la.setForeground(new Color(150, 78,2));
				la.setFont(new Font("Serif", Font.BOLD, 15));
				
				la2.setText("BOOK NAME            ---");
				la2.setBounds(570, 340, 200, 50);
				la2.setForeground(new Color(150, 78,2));
				la2.setFont(new Font("Serif", Font.BOLD, 15));
				
				la3.setText("PUBLISHER               ---");
				la3.setBounds(570, 385, 200, 50);
				la3.setForeground(new Color(150, 78,2));
				la3.setFont(new Font("Serif", Font.BOLD, 15));
				
				la4.setText("PUBLISHED YEAR   ---");
				la4.setBounds(570, 429, 200, 50);
				la4.setForeground(new Color(150, 78,2));
				la4.setFont(new Font("Serif", Font.BOLD, 15));
				
				la5.setText("ADMISSION NO.       ---");
				la5.setBounds(570, 473, 200, 50);
				la5.setForeground(new Color(150, 78,2));
				la5.setFont(new Font("Serif", Font.BOLD, 15));
				
				la6.setText("DUE DATE                 ---");
				la6.setBounds(570, 517, 200, 50);
				la6.setForeground(new Color(150, 78,2));
				la6.setFont(new Font("Serif", Font.BOLD, 15));
				
				
				ta.setBounds(740, 306, 248, 27);
				ta.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta.setForeground(new Color(150, 78,2));
				ta.setText("");
				
				ta2.setBounds(740, 351, 248, 27);
				ta2.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta2.setForeground(new Color(150, 78,2));
				ta2.setText("");
				
				ta3.setBounds(740, 396, 248, 27);
				ta3.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta3.setForeground(new Color(150, 78,2));
				ta3.setText("");
				
				ta4.setBounds(740, 441, 248, 27);
				ta4.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta4.setForeground(new Color(150, 78,2));
				ta4.setText("");
				
				ta5.setBounds(740, 486, 248, 27);
				ta5.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta5.setForeground(new Color(150, 78,2));
				ta5.setText("");
				
				ta6.setBounds(740, 531, 248, 27);
				ta6.setFont(new Font("Serif", Font.ITALIC, 15)); 
				ta6.setForeground(new Color(150, 78,2));
				ta6.setText("DATE FORMAT: YYYY/MM/DD");
				
				MouseListener m = new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						ta6.setText("");
						ta6.setFont(new Font("Serif", Font.BOLD, 16));
						
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
			
				ta6.addMouseListener(m);
			
				bi.setText("ISSUE");
				bi.setBounds(196, 385, 105, 29);
				bi.setFont(new Font("Serif", Font.PLAIN, 16));
				bi.setForeground(new Color(150, 78,2));
				bi.setBorder(bor);
				bi.setFocusable(false);
				
				ActionListener ab = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
							
// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------						
						String bid = ta.getText();
						String bn = ta2.getText();
						String pub = ta3.getText();
						String pubyr = ta4.getText();
						String adno = ta5.getText();
						String dd = ta6.getText();
						
						Date d = new Date();
						SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
						String id = form.format(d);
						
						if (bid.equals("") || bn.equals("") || pub.equals("") || pubyr.equals("") || adno.equals("") || id.equals("") || dd.equals("")) 
							JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY, YOU MUST FILL ALL FIELDS", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
						
						else {
							
							//
							try {
								
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
								
								ResultSet rs = st.executeQuery("SELECT admission_no FROM "+user+"students WHERE admission_no = '"+adno+"' "); 
								
								if(rs.next()) {
									
									ResultSet rs2 = st.executeQuery("SELECT s_no FROM "+user+"books WHERE book_id = '"+bid+"' AND book_name = '"+bn+"' AND publisher = '"+pub+"' AND published_year = '"+pubyr+"' ");
									
									if(rs2.next()) {
										
											st.executeUpdate("INSERT INTO "+user+"issue VALUES ((SELECT s_no FROM "+user+"books WHERE book_id = '"+bid+"' AND book_name = '"+bn+"' AND publisher = '"+pub+"' AND published_year = '"+pubyr+"'), '"+bid+"', '"+bn+"', '"+pub+"', '"+pubyr+"', '"+adno+"','"+id+"', '"+dd+"')  ");
									
											JOptionPane.showMessageDialog(null, "BOOK HAS BEEN ISSUED", "GREAT !!", JOptionPane.INFORMATION_MESSAGE);
										
									}
									
									else {
										
										JOptionPane.showMessageDialog(null, "BOOK NOT FOUND", "OOPS !!", JOptionPane.WARNING_MESSAGE);
										
									}
	
								}
								
								else {
									
									JOptionPane.showMessageDialog(null, "STUDENT NOT FOUND", "OOPS !!", JOptionPane.WARNING_MESSAGE);
									
								}	
							}
							
							catch(Exception i) {
								
								JOptionPane.showMessageDialog(null, i, "OOPS !!", JOptionPane.WARNING_MESSAGE);
								
							}
						
						}
						
					}};
					
				bi.addActionListener(ab);	
					
			}};
			
		bm3.addActionListener(a);
			
	}
}
