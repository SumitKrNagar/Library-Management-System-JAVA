package libmsys;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.*;
import Project.ConnectionProvider;

class Main implements Frame{
	static String user;
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Welcome w = new Welcome();
		
		
// -------------------------------------------------------  MOUSE LISTENER FOR LABEL: CLICK HERE  -----------------------------------------------		
		
		MouseListener m = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				Login l = new Login();
				
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
				Border borde = BorderFactory.createLineBorder(Color.BLUE, 3);
				l3.setBorder(borde);
				l3.setForeground(Color.BLUE);
				l3.setBounds(790, 730, 400, 40);
				l3.setFont(new Font("Serif", Font.BOLD, 28));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				l3.setBorder(bord);
				l3.setBounds(801, 730, 380, 36);
				l3.setForeground(new Color(150, 78, 2));
				l3.setFont(new Font("Serif", Font.BOLD, 26));
				
			}};
			
			l3.addMouseListener(m);
			

			ActionListener a = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
// ----------------------------------------------------------------  BACKEEND CODE FOR LOGIN  ---------------------------------------------------------------------------					
					String uid = t.getText();
					String pass = t2.getText();
					
					try {
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						
						ResultSet rs = st.executeQuery("SELECT * FROM signup WHERE userid = '"+uid+"' AND password = '"+pass+"' ");
						
						if(rs.next()) {
							user = uid;
							
							@SuppressWarnings("unused")
							Menu m = new Menu();
							
							@SuppressWarnings("unused")
							AddBook ab = new AddBook();
							
							@SuppressWarnings("unused")
							DeleteBook db = new DeleteBook();
							
							@SuppressWarnings("unused")
							IssueBook ib = new IssueBook();
							
							@SuppressWarnings("unused")
							ReturnBook rb = new ReturnBook();
							
							@SuppressWarnings("unused")
							BookAvail ba = new BookAvail();
							
							@SuppressWarnings("unused")
							AddStudent as = new AddStudent();
							
							@SuppressWarnings("unused")
							DeleteStudent ds = new DeleteStudent();
							
							@SuppressWarnings("unused")
							StudentList sl = new StudentList();
							
							@SuppressWarnings("unused")
							Logout lg = new Logout();
							
							@SuppressWarnings("unused")
							About a = new About();
							
						}
						else
							JOptionPane.showMessageDialog(null, "WRONG USER-ID OR PASSWORD", "LOGIN FAILED !!", JOptionPane.WARNING_MESSAGE);
								
						}
						
						catch (Exception q) {
							
							JOptionPane.showMessageDialog(null, "AN ERROR HAS OCCURED", "ERROR !!", JOptionPane.ERROR_MESSAGE);	
							
						}

					
					
				}};
				
			b.addActionListener(a);
			
	}
}
