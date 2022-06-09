package libmsys;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import java.sql.*;
import Project.ConnectionProvider;

class Signup extends Main implements Frame {
	
	Signup (){
				
				b.setBounds(0, 0, 0, 0);
			
				l2.setBounds(687, 285, 210, 60);
				l2.setText("SIGN UP");
				l2.setFont(new Font("Serif", Font.BOLD, 50));
					
				bs.setBounds(139, 225, 115, 35);
				bs.setText("SIGN UP");
				bs.setFont(new Font("Serif", Font.BOLD, 18));
				bs.setForeground(new Color(150, 78,2));
				bs.setBorder(bor);
				bs.setFocusable(false);
				
				
				ln.setText("LogIn");
				ln.setFont(new Font("Serif", Font.BOLD, 20));
				ln.setForeground(new Color(150, 78,2));
				ln.setBounds(46, 229, 82, 25);	
				
				t.setText("USER-ID");
				t.setBounds(655, 370, 265, 35);
				t.setFont(new Font("Serif", Font.ITALIC, 15)); 
				t.setForeground(new Color(150, 78,2));
						
				t2.setText("PASSWORD");
				t2.setBounds(655, 432, 265, 35);
				t2.setFont(new Font("Serif", Font.ITALIC, 15));
				t2.setForeground(new Color(150, 78,2));
				
				l.add(p);
				l.add(t);
				l.add(t2);
					
				p.add(ln);
			
				
// ------------------------------------------------------ KEY LISTENER FOR DELETING TEXT(USER-ID) FROM LOGIN TEXTFIELD 1  -----------------------------------------------
				
				KeyListener kt = new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {
						String str = t.getText();
						if(str.equals("USER-ID")) {
							
							t.setText("");
							t.setFont(new Font("Serif", Font.BOLD, 20));
							
						}
					}

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}};
				 
					t.addKeyListener(kt);
				 
// -------------------------------------------------------- MOUSE LISTENER FOR DELETING TEXT(PASSWORD) FROM LOGIN TEXTFIELD 2 --------------------------------------------
					
					MouseListener mt = new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							
							String str2 = t2.getText();
							if (str2.equals("PASSWORD")) {
								
								t2.setText("");
								t2.setFont(new Font("Serif", Font.BOLD, 20));
								
							}	
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
					
					t2.addMouseListener(mt);

				
				
				
				p.add(bs);
				
// ----------------------------------------------------------  MOUSE LISTENER TO GO TO LOGIN PAGE FROM SIGNUP PAGE  ---------------------------------------------------
				MouseListener ml = new MouseListener() {

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
						
						ln.setForeground(Color.BLUE);
						ln.setBounds(42, 226, 89, 29);
						ln.setFont(new Font("Serif", Font.BOLD, 22));
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						
						ln.setForeground(new Color(150, 78,2));
						ln.setFont(new Font("Serif", Font.BOLD, 20));
						ln.setBounds(46, 229, 82, 25);	
						
					}};
			
					ln.addMouseListener(ml);


			
			ActionListener as = new ActionListener() {

// ----------------------------------------------------------------  BACKEEND CODE  ---------------------------------------------------------------------------				
				@Override
				public void actionPerformed(ActionEvent e) {
					String uid = t.getText();
					String pass = t2.getText();
					if (!uid.equals("USER-ID") || !pass.equals("PASSWORD")) {
						
						try {
						
							Connection con = ConnectionProvider.getCon();
							Statement st = con.createStatement();
						
							st.executeUpdate("INSERT INTO signup VALUES('"+uid+"', '"+pass+"')");
							st.execute("CREATE TABLE "+uid+"books (s_no int primary key, book_id int, book_name varchar(30), publisher varchar (30), published_year varchar(30), price int)");
							st.execute("CREATE TABLE "+uid+"issue (s_no int primary key, book_id int, book_name varchar(30), publisher varchar (30), published_year varchar(30), admission_no int, issue_date varchar(30))");
							st.execute("CREATE TABLE "+uid+"students (admission_no int, name varchar(30), father_name varchar(30), phone_no int)");
							
							JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY SIGNED UP", "NICE !!", JOptionPane.INFORMATION_MESSAGE);	
						
						}
						
						catch (Exception l) {
						
							JOptionPane.showMessageDialog(null, "USER-ID HAS ALREADY BEEN TAKEN", "SIGN UP FAILED !!", JOptionPane.WARNING_MESSAGE);
						
						}}
					
					else 
						JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID USER-ID OR PASSWORD", "INVALID !!", JOptionPane.ERROR_MESSAGE);
					
				}};
				
				bs.addActionListener(as);
		
	}
}
