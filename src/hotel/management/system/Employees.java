
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

public class Employees extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Employees(){
        setLayout(null);
        setBounds(300,200,880,480);
        getContentPane().setBackground(Color.WHITE);
     
        //Info Labels
        JLabel name = new JLabel("Name");
        name.setBounds(5,10,100,20);
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(110,10,100,20);
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(220,10,100,20);
        add(gender);
        
        JLabel job = new JLabel("Job");
        job.setBounds(330,10,100,20);
        add(job);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(440,10,100,20);
        add(salary);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(550,10,100,20);
        add(phone);
        
         JLabel email = new JLabel("Email");
        email.setBounds(660,10,100,20);
        add(email);
        
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(770,10,100,20);
        add(aadhar);
        
        
        table = new JTable();
        table.setBounds(0,40,880,300);
        add(table);
        
        try{
        Conn c = new Conn();
        String query = "select * from employee";
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
        new Employees();
    }
}


