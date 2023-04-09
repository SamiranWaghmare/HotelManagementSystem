
package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.*;

public class Customers extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Customers(){
        setLayout(null);
        setBounds(300,200,880,480);
        getContentPane().setBackground(Color.WHITE);
     
        //Info Labels
        JLabel name = new JLabel("ID");
        name.setBounds(5,10,100,20);
        add(name);
        
        JLabel age = new JLabel("Number");
        age.setBounds(110,10,100,20);
        add(age);
        
        JLabel gender = new JLabel("Name");
        gender.setBounds(220,10,100,20);
        add(gender);
        
        JLabel job = new JLabel("Gender");
        job.setBounds(330,10,100,20);
        add(job);
        
        JLabel salary = new JLabel("Country");
        salary.setBounds(440,10,100,20);
        add(salary);
        
        JLabel phone = new JLabel("Room Number");
        phone.setBounds(550,10,100,20);
        add(phone);
        
         JLabel email = new JLabel("Check-in Time");
        email.setBounds(660,10,100,20);
        add(email);
        
        JLabel aadhar = new JLabel("Deposit");
        aadhar.setBounds(770,10,100,20);
        add(aadhar);
        
        
        table = new JTable();
        table.setBounds(0,40,880,300);
        add(table);
        
        try{
        Conn c = new Conn();
        String query = "select * from customer";
        java.sql.ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        c.s.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(360,380,160,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == back){
           setVisible(false);
           new AddReception();
       }
        
    }
    
    public static void main (String[] args){
        new Customers();
    }
}


