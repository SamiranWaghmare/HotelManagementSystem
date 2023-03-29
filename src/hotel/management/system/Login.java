
package hotel.management.system;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {
    JTextField username,password;
    JButton cancel,login;
    
    Login(){
        
    getContentPane().setBackground(Color.WHITE);
           //setting dimensions and position of jframe
     setSize(600,300);
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     
     int centerX = (int)screenSize.getWidth()/2;
     int centerY = (int)screenSize.getHeight()/2;
     
     int width = getSize().width;
     int height = getSize().height;
     
     int x = centerX - width/2 ;
     int y = centerY - height/2;
     
     setLocation(x,y);
     
     //setting username and textfields
     setLayout(null);
     
     JLabel user = new JLabel("Username");
     user.setBounds(40,20,100,30);
     add(user);
     
     username = new JTextField();
     username.setBounds(150,20,150,30);
     add(username);
     
     JLabel pass = new JLabel("Password");
     pass.setBounds(40,70,100,30);
     add(pass);
     
     password = new JTextField();
     password.setBounds(150,70,150,30);
     add(password);
     
     //Login and Cancel buttons
     login = new JButton("Login");
     login.setBounds(40,150,120,30);
     login.setBackground(Color.BLACK);
     login.setForeground(Color.WHITE);
     login.addActionListener(this);
     add(login);
     
     cancel = new JButton("Cancel");
     cancel.setBounds(180,150,120,30);
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.addActionListener(this);
     add(cancel);
     
     //adding image to the frame
     ImageIcon personImg = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
     Image image2 = personImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     personImg = new ImageIcon(image2);
     JLabel image = new JLabel(personImg);
     image.setBounds(350,10,200,200);
     add(image);
     
     
     
     
     setVisible(true);


    }
    
    //overriding actionperformed method of actionListener
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String user = username.getText();
            String pass = password.getText();
            
            try{
                Conn c = new Conn();
                
                String query = "select*from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                    
                }else{
                    JOptionPane.showMessageDialog(null,"invalid username or password ");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if( ae.getSource() == cancel){
           setVisible(false); 
        }
 
        
    }
    
    
    public static void main(String[] Args){
        new Login();
    }
}
