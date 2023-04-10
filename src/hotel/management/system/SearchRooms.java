
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRooms extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox isAvailable;
    
    SearchRooms(){
        setLayout(null);
        setBounds(280,150,1000,600);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Search For Rooms");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedType = new JComboBox( new String[] {"Single Bed","Double Bed"});
        bedType.setForeground(Color.WHITE);
        bedType.setBounds(160,100,100,20);
        add(bedType);
        
        isAvailable = new JCheckBox("Only Display Available");
        isAvailable.setBounds(650,100,150,25);
        isAvailable.setBackground(Color.WHITE);
        add(isAvailable);
        
        
        
        
        JLabel roomNo = new JLabel("Room Number"); 
        roomNo.setBounds(2,170,100,20);
        add(roomNo);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(200,170,100,20);
        add(availability);
        
        JLabel status = new JLabel("Status");
        status.setBounds(400,170,100,20);
        add(status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(600,170,100,20);
        add(price);
        
        JLabel type = new JLabel("Type");
        type.setBounds(800,170,100,20);
        add(type);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
        Conn c = new Conn();
        String query = "select * from rooms";
        java.sql.ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        c.s.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(300,500,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(500,500,150,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == back){
           setVisible(false);
           new AddReception();
       }
       if(ae.getSource() == submit){
           try{
        Conn c = new Conn();
        String query1 = "select * from rooms where bedType = '" + bedType.getSelectedItem()+ "'";
        String query2 = "select * from rooms where availability = 'Available' AND bedType = '" + bedType.getSelectedItem()+ "'";
        ResultSet rs;
        
        if(isAvailable.isSelected()){
        rs = c.s.executeQuery(query2); 
        }else{
        rs = c.s.executeQuery(query1);
        }
        
        table.setModel(DbUtils.resultSetToTableModel(rs));
        c.s.close();
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
           
       }
        
    }
    
    public static void main (String[] args){
        new SearchRooms();
    }
}



