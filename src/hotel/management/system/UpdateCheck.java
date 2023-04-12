
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfName,tfCheckIn,tfPaid,tfDue;
    JButton check,update,back;
   
    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Update Status");
        heading.setBounds(90,20,200,30);
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
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);  
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,160,100,20);
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200,160,150,25);
        add(tfName);
        
        JLabel lblCheckIn = new JLabel("Check-In Time");
        lblCheckIn.setBounds(30,200,100,20);
        add(lblCheckIn);
        
        tfCheckIn = new JTextField();
        tfCheckIn.setBounds(200,200,150,25);
        add(tfCheckIn);
        
        JLabel lblPaid = new JLabel("Amount Paid");
        lblPaid.setBounds(30,240,100,20);
        add(lblPaid);
        
        tfPaid = new JTextField();
        tfPaid.setBounds(200,240,150,25);
        add(tfPaid);
        
        JLabel lblDue = new JLabel("Amount Due");
        lblDue.setBounds(30,280,100,20);
        add(lblDue);
        
        tfDue = new JTextField();
        tfDue.setBounds(200,280,150,25);
        add(tfDue);
        
        //adding buttons
        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        //adding background image
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
         JLabel image = new JLabel(i1);
         image.setBounds(400,50,500,300);
         add(image); 
         
         
        
        
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setBounds(300,200,980,500);
        setVisible(true);
        
    }
    
  
    @Override
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == check){
          String query = "select*from customer where number = '"+ ccustomer.getSelectedItem()+"'";
          
          try {
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery(query);
              while(rs.next()){
               
                  tfroom.setText(rs.getString("roomnumber"));
                  tfName.setText(rs.getString("name"));
                  tfCheckIn.setText(rs.getString("checkin"));
                  tfPaid.setText(rs.getString("deposit")); 
              }
              String query2 = "select*from rooms where roomNumber = '" + tfroom.getText() +"'";
              ResultSet rs2 = c.s.executeQuery(query2);
              while(rs2.next()){
                  String price = rs2.getString("price");
                  tfDue.setText(Integer.parseInt(price)-Integer.parseInt(tfPaid.getText())+"");
              }
              
          } catch (SQLException ex) {
             ex.printStackTrace();
          }
      }else if(ae.getSource() == update){
          // Choice ccustomer;
           //JTextField tfroom,tfName,tfCheckIn,tfPaid,tfDue;
           
           String customerId = ccustomer.getSelectedItem();
           String room = tfroom.getText();
           String name = tfName.getText();
           String checkIn = tfCheckIn.getText();
           String paid = tfPaid.getText();
           
           Conn c = new Conn();
           String query = "update customer set roomnumber = ? , name = ? , checkin = ? , deposit = ? where number = ?";
           
           try{
               PreparedStatement ps = c.c.prepareStatement(query);
               ps.setString(1 , room);
               ps.setString(2, name);
               ps.setString(3, checkIn);
               ps.setString(4, paid);
               ps.setString(5,customerId);
               
               int i = ps.executeUpdate();
               if(i>0){
                   System.out.println("row updated sucessfully");
                   JOptionPane.showMessageDialog(null, "Customer Details Updated Sucessfully");
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
      new UpdateCheck();
  } 
}
