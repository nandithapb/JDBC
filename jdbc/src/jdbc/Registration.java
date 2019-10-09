package jdbc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Registration {
	static ConnectionManager cm=new ConnectionManager();
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","");  
		Statement statement = (Statement)con.createStatement();
		JFrame fr=new JFrame();
		final JTextField n=new JTextField();
		final JTextField p=new JTextField();
		 n.setBounds(150,  50, 150, 20);
		 p.setBounds(150, 100, 150, 20);
		 JButton b1=new JButton("Sign Up");  
		 b1.setBounds(50,150,95,30); 
		 JButton b2=new JButton("Log In");  
		 b2.setBounds(150,150,95,30); 
		 JLabel l1,l2;  
		    l1=new JLabel("User name:"); 
		    l2=new JLabel("Password :"); 
		    l1.setBounds(50,50, 100,30);  
		    l2.setBounds(50,100, 100,30); 
		    fr.add(l1); fr.add(l2);
		    b1.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			      try {
					cm.reg();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
					       }  
					   });	
		    b2.addActionListener(new ActionListener(){  
			   public void actionPerformed(ActionEvent e){ 
				   try {
					   
					   JLabel l3,l4;
					   
					ResultSet sr=statement.executeQuery("SELECT User_name,Password FROM registration");
					int count=0;
					while(sr.next()) {
					if(n.getText().equals(sr.getString(1)) && p.getText().equals(sr.getString(2))){
						l3=new JLabel("Login Successfully...");
						l3.setBounds(100,200, 150,30); 
						fr.add(l3);
						count=1;
						break;
					}
					}
					if(count==0) {
						l3=new JLabel("invalid user name or password");
						l3.setBounds(100,200, 150,30); 
						fr.add(l3);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					       }  
					   });	
		    
		    fr.add(b1); fr.add(b2);
		    fr.add(n);  fr.add(p); 
		    fr.setSize(400,500);  
		    fr.setLayout(null);  
		    fr.setVisible(true); 
	}
}