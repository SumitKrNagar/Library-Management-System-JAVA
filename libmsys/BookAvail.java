package libmsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.sql.*;
import Project.ConnectionProvider;

class BookAvail extends Main implements Frame {
	JFrame j = new JFrame();
	JPanel pn = new JPanel();
	JLabel[] label;
	String[] sarr;
	String c;
	int jsize = 90;
	Boolean flag = false;
	
	BookAvail(){
		
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				la4.setBounds(0, 0, 0, 0);
				la5.setBounds(0, 0, 0, 0);
				
				ta4.setBounds(0, 0, 0, 0);
				ta5.setBounds(0, 0, 0, 0);
				
				la6.setBounds(0, 0, 0, 0);
				ta6.setBounds(0, 0, 0, 0);
				
				
				bd.setBounds(0, 0, 0, 0);
				bi.setBounds(0, 0, 0, 0);
				ba.setBounds(0, 0, 0, 0);
				br.setBounds(0, 0, 0, 0);
				bas.setBounds(0, 0, 0, 0);
				bds.setBounds(0, 0, 0, 0);
				cs.setBounds(0, 0, 0, 0);
				
				p.setBounds(533, 220, 500, 320);
				
				lb.setText("________________________");
				lb.setBounds(542, 240, 500, 50);
				lb.setForeground(new Color(150, 78,2));
				lb.setFont(new Font("Serif", Font.BOLD, 40));
				
				lb2.setBounds(542, 428, 500, 50);
				
				l.setIcon(ic);
				l2.setText("BOOK AVAILABLITY");
				l2.setFont(new Font("Serif", Font.BOLD, 35));
				l2.setBounds(610, 225, 400, 60);
				
				la.setText("BOOK NAME             ---");
				la.setBounds(570, 310, 200, 50);
				la.setForeground(new Color(150, 78,2));
				la.setFont(new Font("Serif", Font.BOLD, 15));
				
				la2.setText("PUBLISHER               ---");
				la2.setBounds(570, 355, 200, 50);
				la2.setForeground(new Color(150, 78,2));
				la2.setFont(new Font("Serif", Font.BOLD, 15));
				
				la3.setText("PUBLISHED YEAR    ---");
				la3.setBounds(570, 400, 200, 50);
				la3.setForeground(new Color(150, 78,2));
				la3.setFont(new Font("Serif", Font.BOLD, 15));
				
				
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
				

				bav.setText("CHECK");
				bav.setBounds(194, 270, 105, 29);
				bav.setFont(new Font("Serif", Font.PLAIN, 16));
				bav.setForeground(new Color(150, 78,2));
				bav.setBorder(bor);
				bav.setFocusable(false);
				
				ActionListener ab = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
							
// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------						
						
						String bn = ta.getText();
						String pub = ta2.getText();
						String pubyr = ta3.getText();
						
						int count = 1;
	
						if (bn.equals("") || pub.equals("") || pubyr.equals("")) {
							
							JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY, YOU MUST FILL ALL FIELDS", "INCOMPLETE DETAILS !!", JOptionPane.WARNING_MESSAGE);
							
						}
						
						else {
							
							try {
							
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
								
								ResultSet rs = st.executeQuery("SELECT s_no FROM "+user+"books WHERE book_name = '"+bn+"' AND publisher = '"+pub+"' AND published_year = '"+pubyr+"' ");
								while(rs.next()) {
									count++;
									if(count > 1)
										jsize = jsize + 30;
									
								}
						
								sarr = new String[count];
													
								if(count > 0) {
									
									ResultSet rs2 = st.executeQuery("SELECT book_id, admission_no FROM "+user+"issue WHERE book_name = '"+bn+"' AND publisher = '"+pub+"' AND published_year = '"+pubyr+"'");
									c = String.valueOf(count);
									String s = c+" BOOK AVAILABLE BUT";
									String s2;
									
									int i = 1;
									
									
									while(rs2.next()) {
										flag = true;
										String bid = rs2.getString("book_id");
										String adn = rs2.getString("admission_no");
										
										String is = String.valueOf(i);
																	
										s2 = is+". BOOK WITH ID: "+bid+" IS ISSUED TO ADMISSION NO. : "+adn;
										
										sarr[0] = s;
										sarr[i] = s2;
										i++;
										
									}
									
									if(flag == false) {
										JOptionPane.showMessageDialog(null, c+" BOOK AVAILABLE", "AVAILABLE !!", JOptionPane.INFORMATION_MESSAGE);}
									
								}
								else 
									JOptionPane.showMessageDialog(null, "BOOK NOT AVAILABLE", "OOPS !!", JOptionPane.WARNING_MESSAGE);
							
							}
							
							catch(Exception ba) {
								//JOptionPane.showMessageDialog(null, "AN ERROR HAS OCCURED", "OOPS !!", JOptionPane.ERROR_MESSAGE);
								System.out.print(ba);
								
							}
							
							
							if(flag == true) {
								label = new JLabel[count];
						
								int k = 0;
							
								pn.setLayout(null);
							
								for(int z = 0; z < count; z++) {
									label[z] = new JLabel();
									label[z].setText(sarr[z]);
									label[z].setForeground(Color.WHITE);
									label[z].setFont(new Font("Serif", Font.BOLD, 12));
									label[z].setBounds(70, k, 400, 20);
									k = k + 25;
									pn.add(label[z]);
								
								}
							
								label[0].setBounds(161, 0, 400, 20);
							
								pn.setBackground(new Color(150, 78,2));
							
							
								j.setTitle("AVAILABLE  !!");
								j.setIconImage(ic.getImage());
							
								j.add(pn);
								j.setDefaultCloseOperation(1);
								j.setResizable(false);		
								j.setLocation(533, 25);
								j.setSize(500, jsize);
								j.setVisible(true); 
							
								flag = false;
							
							}
						
						}
	
					}};
					
				bav.addActionListener(ab);	
					
			}};

		bm5.addActionListener(a);
		
	}

}
