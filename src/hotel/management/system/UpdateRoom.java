
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfAvailable,tfStatus;
    JButton check,update,back;
   
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Update Room Status");
        heading.setBounds(30,20,250,30);
        heading.setFont(new Font("Thaoma",Font.PLAIN,20));
        add(heading);
        
        JLabel lblId = new JLabel("Customer Id");
        lblId.setBounds(30,80,100,20);
        add(lblId);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        ccustomer.setBackground(Color.WHITE);
        add(ccustomer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                ccustomer.add(rs.getString(2));
            }
            
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);  
        
        JLabel lblAvailablity = new JLabel("Availability");
        lblAvailablity.setBounds(30,180,100,20);
        add(lblAvailablity);
        
        tfAvailable = new JTextField();
        tfAvailable.setBounds(200,180,150,25);
        add(tfAvailable);
        
        JLabel lblStatus = new JLabel("Cleaning ");
        lblStatus.setBounds(30,230,100,20);
        add(lblStatus);
        
        tfStatus = new JTextField();
        tfStatus.setBounds(200,230,150,25);
        add(tfStatus);
        
        
        
        //adding buttons
        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        //adding background image
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
         i1 = new ImageIcon(i2);
         JLabel image = new JLabel(i1);
         image.setBounds(400,50,500,300);
         add(image); 
         
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setBounds(300,200,980,450);
        setVisible(true);
        
    }
    
  
    @Override
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == check){
          
          String subQuery = "select*from rooms where roomNumber =(select roomnumber from customer where number = '"+ccustomer.getSelectedItem()+"')";
          
          try {
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery(subQuery);
              while(rs.next()){
               
                  tfroom.setText(rs.getString("roomNumber"));
                  tfAvailable.setText(rs.getString("availability"));
                  tfStatus.setText(rs.getString("cleaningStatus"));  
              }          
          } catch (SQLException ex) {
             ex.printStackTrace();
          }
      }else if(ae.getSource() == update){

           String room = tfroom.getText();
           String availability = tfAvailable.getText();
           String status = tfStatus.getText();
           
           Conn c = new Conn();
           String query = "update rooms set availability = ? , cleaningStatus = ? where roomNumber = ?";
           
           try{
               PreparedStatement ps = c.c.prepareStatement(query);
               ps.setString(1 , availability);
               ps.setString(2, status);
               ps.setString(3, room);
                
               int i = ps.executeUpdate();
               if(i>0){
                   System.out.println("row updated sucessfully");
                   JOptionPane.showMessageDialog(null, "Room Status updated sucessfully");
               }
               
           }catch(Exception e){
               e.printStackTrace();
           }
      }else if(ae.getSource() == back){
          setVisible(false);
          new AddReception();
      }
      
  }
    
  public static void main(String args[]){
      new UpdateRoom();
  } 
}
