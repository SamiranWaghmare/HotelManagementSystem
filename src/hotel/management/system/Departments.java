
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

public class Departments extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Departments(){
        setLayout(null);
        setBounds(400,200,700,480);
        getContentPane().setBackground(Color.WHITE);
     
        
        JLabel roomNo = new JLabel("Department");
        roomNo.setBounds(150,10,100,20);
        add(roomNo);
        
        JLabel availability = new JLabel("Budget");
        availability.setBounds(480,10,100,20);
        add(availability);
        
        
        
        table = new JTable();
        table.setBounds(0,40,700,300);
        add(table);
        
        try{
        Conn c = new Conn();
        String query = "select * from department";
        java.sql.ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        c.s.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(270,360,150,40);
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
        new Departments();
    }
}


