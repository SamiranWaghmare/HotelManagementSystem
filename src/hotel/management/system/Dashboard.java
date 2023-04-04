
package hotel.management.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    JMenuItem rooms,employee,drivers,reception;
    
    Dashboard(){
        
     //getting screen dimensions
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     int width = (int)screenSize.getWidth();
     int height = (int)screenSize.getHeight();
     
     //setting the dashboard image
     setLayout(null);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
     Image i2 = i1.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT);
     i1 =  new ImageIcon(i2);
     JLabel image = new JLabel(i1);
     image.setBounds(0,0,width,height);
     add(image);
     
     //setting the head text
     JLabel text = new JLabel("TAJ GROUP WELCOMES YOU");
     text.setBounds(480,80,1000,50);
     text.setFont(new Font("Tahoma" ,Font.PLAIN , 46));
     text.setForeground(Color.WHITE);
     image.add(text);
     
     //setting up the menue bar
     // note 1.menu is added onto menu bar 2.menu items are added onto menu
     JMenuBar mb = new JMenuBar();
     mb.setBounds(0,0,width,30);
     image.add(mb);
     
     JMenu hotel = new JMenu("HOTEL MANAGEMENT");
     hotel.setForeground(Color.red);
     mb.add(hotel);
     
     reception = new JMenuItem("RECEPTION");
     reception.addActionListener(this);
     hotel.add(reception);
     
     JMenu admin = new JMenu("ADMIN");
     admin.setForeground(Color.blue);
     mb.add(admin);
     
     employee = new JMenuItem("ADD EMPLOYEE");
     employee.addActionListener(this);
     admin.add(employee);
     
     rooms = new JMenuItem("ADD ROOMS");
     rooms.addActionListener(this);
     admin.add(rooms );
     
     drivers = new JMenuItem("ADD DRIVERS");
     drivers.addActionListener(this); 
     admin.add(drivers);
     
     
     

        setBounds(0,0,width,height);
        setVisible(true);
        
    }
    
    
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == rooms )
          new AddRooms();
      else if(ae.getSource() == employee)
          new AddEmployee();
      else if(ae.getSource() == drivers)
          new AddDrivers();
      else if (ae.getSource() == reception)
          new AddReception();
          
      
      
  }
    
    
  public static void main(String args[]){
      new Dashboard();
  }
}
