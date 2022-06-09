package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;
import Project.ConnectionProvider;

class StudentList extends Main implements Frame {
	
	StudentList(){
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				la5.setBounds(0, 0, 0, 0);
				la6.setBounds(0, 0, 0, 0);
				
				ta4.setBounds(0, 0, 0, 0);
				ta5.setBounds(0, 0, 0, 0);
				ta6.setBounds(0, 0, 0, 0);
				
				bd.setBounds(0, 0, 0, 0);
				bi.setBounds(0, 0, 0, 0);
				ba.setBounds(0, 0, 0, 0);
				bav.setBounds(0, 0, 0, 0);
				br.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				bas.setBounds(0, 0, 0, 0);
				
				p.setBounds(533, 220, 500, 350);
				
				l.setIcon(ic);
				
				lb.setText("________________________");
				lb.setBounds(542, 240, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
				
				lb2.setBounds(542, 458, 500, 50);
				
				l2.setText("CHECK STUDENT");
				l2.setFont(new Font("Serif", Font.BOLD, 33));
				l2.setBounds(644, 225, 300, 60);
				
				la.setText("ADMISSION NO.    ----");
				la.setBounds(570, 310, 200, 50);
				la.setForeground(new Color(150, 78,2));
				la.setFont(new Font("Serif", Font.BOLD, 15));
				
				la2.setText("--- OR ---");
				la2.setBounds(720, 351, 200, 50);
				la2.setForeground(new Color(150, 78,2));
				la2.setFont(new Font("Serif", Font.BOLD, 30));				
				
				la3.setText("NAME                      ----");
				la3.setBounds(570, 400, 200, 50);
				la3.setForeground(new Color(150, 78,2));
				la3.setFont(new Font("Serif", Font.BOLD, 15));
				
				la4.setText("FATHER'S NAME  ----");
				la4.setBounds(570, 444, 200, 50);
				la4.setForeground(new Color(150, 78,2));
				la4.setFont(new Font("Serif", Font.BOLD, 15));
				
				
				ta.setBounds(740, 321, 248, 27);
				ta.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta.setForeground(new Color(150, 78,2));
				ta.setText("");
				
				ta2.setBounds(740, 411, 248, 27);
				ta2.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta2.setForeground(new Color(150, 78,2));
				ta2.setText("");
				
				ta3.setBounds(740, 456, 248, 27);
				ta3.setFont(new Font("Serif", Font.BOLD, 16)); 
				ta3.setForeground(new Color(150, 78,2));
				ta3.setText("");
				
				cs.setText("CHECK");
				cs.setBounds(194, 300, 105, 29);
				cs.setFont(new Font("Serif", Font.PLAIN, 17));
				cs.setForeground(new Color(150, 78,2));
				cs.setBorder(bor);
				cs.setFocusable(false);
				
							
				ActionListener ab = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------
						String adm = ta.getText();
						String name = ta2.getText();
						String fname = ta3.getText();
								
						try {
								
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
								ResultSet rs = null;
								ResultSet rs2 = null;
								String n = null;
								String fn = null;
								int pn = 0;
								Boolean flag = false;
								
								
								if (!adm.equals("") && name.equals("") && fname.equals("")) {
									 rs = st.executeQuery("SELECT name, father_name, phone_no FROM "+user+"students WHERE admission_no = '"+adm+"' ");
									 flag = true;
									 
								}
								else if(adm.equals("") && !name.equals("") && !fname.equals("")) { 	
									rs = st.executeQuery("SELECT admission_no, phone_no FROM "+user+"students WHERE name = '"+name+"' AND father_name = '"+fname+"' ");
									
								}	
								else if(!adm.equals("") && !name.equals("") && !fname.equals(""))
									JOptionPane.showMessageDialog(null, "YOU HAVE TO FILL EITHER ADMISSION NO. OR NAME AND FATHER'S NAME", "OOPS !!", JOptionPane.WARNING_MESSAGE);
								
								else if(!adm.equals("") && !name.equals("") || fname.equals(""))
									JOptionPane.showMessageDialog(null, "YOU HAVE TO FILL EITHER ADMISSION NO. OR NAME AND FATHER'S NAME", "OOPS !!", JOptionPane.WARNING_MESSAGE);
								
								else if(adm.equals("") && name.equals("") && fname.equals(""))
									JOptionPane.showMessageDialog(null, "ALL FIELDS ARE EMPTY\nYOU MUST FILL EITHER ADMISSION NO. OR NAME AND FATHER'S NAME", "OOPS !!", JOptionPane.WARNING_MESSAGE);
								
								else if(adm.equals("") && !name.equals("") || fname.equals(""))
									JOptionPane.showMessageDialog(null, "YOU HAVE TO FILL BOTH NAME AND FATHER'S NAME", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
								
								else if(adm.equals("") && name.equals("") || !fname.equals(""))
									JOptionPane.showMessageDialog(null, "YOU HAVE TO FILL BOTH NAME AND FATHER'S NAME", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
								
									
									
								if(flag == true) {
									if(rs.next()) {
										n = rs.getString("name");
										fn = rs.getString("father_name");
										pn = rs.getInt("phone_no");
									
										rs2 = st.executeQuery("SELECT * FROM "+user+"issue WHERE admission_no = '"+adm+"'");
									}
									else
										JOptionPane.showMessageDialog(null, "STUDENT RECORD NOT FOUND", "OOPS !!", JOptionPane.WARNING_MESSAGE);
								}
								else {
									if(rs.next()) {
										adm = rs.getString("admission_no");
										n = name;
										fn = fname;
										pn = rs.getInt("phone_no");
										
										rs2 = st.executeQuery("SELECT * FROM "+user+"issue WHERE admission_no = '"+adm+"'");
									}
									else
										JOptionPane.showMessageDialog(null, "STUDENT RECORD NOT FOUND", "OOPS !!", JOptionPane.WARNING_MESSAGE);
										
								}
										
										
								if(rs2.next()) {
									ResultSet rs3 = st.executeQuery("SELECT book_id, book_name, publisher FROM "+user+"books WHERE s_no = (SELECT s_no FROM "+user+"issue WHERE admission_no = '"+adm+"' )");
									if(rs3.next()) {
										String bid = rs3.getString("book_id");
										String bn = rs3.getString("book_name");
										String pub = rs3.getString("publisher");
													
										JOptionPane.showMessageDialog(null, "  STUDENT RECORD FOUND \n\nADMISSION NO.: "+adm+"\nNAME: "+n.toUpperCase()+"\nFATHER NAME: "+fn.toUpperCase()+"\nPHONE NO: "+pn+"\nBOOK RETURN PENDING\nBOOK ID: "+bid+"\nBOOK NAME: "+bn.toUpperCase()+"\nPUBLISHER: "+pub.toUpperCase(), "GREAT !!", JOptionPane.INFORMATION_MESSAGE);
									
									}											
								}
								else
									JOptionPane.showMessageDialog(null, "  STUDENT RECORD FOUND \n\nADMISSION NO.: "+adm+"\nNAME: "+n.toUpperCase()+"\nFATHER NAME: "+fn.toUpperCase()+"\nPHONE NO: "+pn, "GREAT !!", JOptionPane.INFORMATION_MESSAGE);
									
						}
							catch (Exception as) {
								
								System.out.print(as);
								
							}
							
					}};
					
				cs.addActionListener(ab);	
					
			}};
		
		bm8.addActionListener(a);
		
	}

}
