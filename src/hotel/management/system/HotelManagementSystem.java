
package hotel.management.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

 HotelManagementSystem(){
     //setting dimensions and position of jframe
     setSize(1366,565);
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     
     int centerX = (int)screenSize.getWidth()/2;
     int centerY = (int)screenSize.getHeight()/2;
     
     int width = getSize().width;
     int height = getSize().height;
     
     int x = centerX - width/2 ;
     int y = centerY - height/2;
     
     setLocation(x,y);
     
     //setting layout to null
     setLayout(null);
     
     //adding an image to the jframe
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
     JLabel image = new JLabel(i1);
     image.setBounds(0,0,width,height);
     add(image);
     
     JLabel text = new JLabel("Hotel Management System");
     text.setBounds(50,430,600,70);
     text.setForeground(Color.white);
     text.setFont(new Font("serif",Font.PLAIN,50));
     image.add(text);
     
     
     JButton next = new JButton("Next");
     next.setBounds(1150,450,150,50);
     image.add(next);
     next.setBackground(Color.white);
     next.addActionListener(this);
     next.setFont(new Font("serif",Font.PLAIN,18));
     
     

     
     setVisible(true);
     
     //blinking heading text
     while(true){
         text.setVisible(false);
         try {
             Thread.sleep(500);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         text.setVisible(true);
         try {
             Thread.sleep(500);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
     }
     
 }
 
 
 //overriding the actionPerformed method of the ActionListener interface
    public void actionPerformed(ActionEvent ae){
        //closing the main Jframe and launching the Login Jframe
        setVisible(false);
        new Login();
    }
 
    public static void main(String[] args) {
      new HotelManagementSystem(); 
    }
    
}
