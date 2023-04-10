
package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Rooms(){
        setLayout(null);
        setBounds(280,150,1050,600);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(2,10,100,20);
        add(roomNo);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(100,10,100,20);
        add(availability);
        
        JLabel status = new JLabel("Status");
        status.setBounds(200,10,100,20);
        add(status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(300,10,100,20);
        add(price);
        
        JLabel type = new JLabel("Type");
        type.setBounds(400,10,100,20);
        add(type);
        
        table = new JTable();
        table.setBounds(0,40,500,400);
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
        back.setBounds(200,500,150,40);
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
        new Rooms();
    }
}


