
package hotel.management.system;

import java.awt.Choice;
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

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice choiceCar;
    JCheckBox isAvailable;
    
    Pickup(){
        setLayout(null);
        setBounds(280,150,980,600);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Search For Drivers");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Car Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        
        choiceCar =new  Choice();
        choiceCar.setBounds(160,100,100,20);
        add(choiceCar);
        
        try{
            String modelName = "select distinct car_model from drivers";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(modelName);
            
            while(rs.next()){
                choiceCar.add(rs.getString("car_model"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        isAvailable = new JCheckBox("Only Display Available");
        isAvailable.setBounds(650,100,150,25);
        isAvailable.setBackground(Color.WHITE);
        add(isAvailable);
        
        
        
        
        JLabel roomNo = new JLabel("Name"); 
        roomNo.setBounds(2,170,100,20);
        add(roomNo);
        
        JLabel availability = new JLabel("Age");
        availability.setBounds(140,170,100,20);
        add(availability);
        
        JLabel status = new JLabel("Gender");
        status.setBounds(280,170,100,20);
        add(status);
        
        JLabel price = new JLabel("Car Company");
        price.setBounds(420,170,100,20);
        add(price);
        
        JLabel type = new JLabel("Car Model");
        type.setBounds(560,170,100,20);
        add(type);
        
        JLabel available = new JLabel("Availability");
        available.setBounds(700,170,100,20);
        add(available);
        
        JLabel location = new JLabel("Location");
        location.setBounds(840,170,100,20);
        add(location);
        
        table = new JTable();
        table.setBounds(0,200,980,300);
        add(table);
        
        try{
        Conn c = new Conn();
        String query = "select * from drivers";
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
        String query1 = "select * from drivers where car_model = '" + choiceCar.getSelectedItem()+ "'";
        String query2 = "select * from drivers where driver_availability = 'Available' AND car_model = '" + choiceCar.getSelectedItem()+ "'";
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
        new Pickup();
    }
}



