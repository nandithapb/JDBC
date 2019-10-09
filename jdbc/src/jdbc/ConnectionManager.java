package jdbc;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public void reg() throws SQLException, ClassNotFoundException {
			
			    JFrame f=new JFrame();  
			    final JTextField tf1=new JTextField();  
			    final JTextField tf2=new JTextField();
			    final JTextField tf3=new JTextField();
			    final JTextField tf4=new JTextField();
			    tf1.setBounds(150,  50, 150, 20);
			    tf2.setBounds(150, 100, 150, 20);
			    tf3.setBounds(150, 150, 150, 20);
			    tf4.setBounds(150, 200, 150, 20);
			    JButton b=new JButton("Agree & Join");  
			    b.setBounds(150,250,95,30); 
			    JLabel l1,l2,l3,l4;  
			    l1=new JLabel("User name:"); 
			    l2=new JLabel("Mobile number :");  
			    l3=new JLabel("Email ID :");
			    l4=new JLabel("Password :");
			    l1.setBounds(50,50, 100,30);  
			    l2.setBounds(50,100, 100,30); 
			    l3.setBounds(50,150, 100,30); 
			    l4.setBounds(50,200, 100,30); 
			    f.add(l1); f.add(l2); f.add(l3); f.add(l4); 
			    b.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			        String name=tf1.getText();
			        String no=tf2.getText();
			        String email=tf3.getText();
			        String password=tf4.getText();
			        try {
			        	Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","");  
						Statement statement = (Statement)con.createStatement();
					    statement.executeUpdate("INSERT INTO registration VALUE('"+name+"','"+no+"','"+email+"','"+password+"')");
					    }catch (SQLException | ClassNotFoundException e1) {
					    	e1.printStackTrace();	
					    }
					       }  
					   });
			    
			    f.add(b);
			    f.add(tf1);  f.add(tf2); f.add(tf3); f.add(tf4);
			    f.setSize(400,500);  
			    f.setLayout(null);  
			    f.setVisible(true); 
	}
}