package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddCustomer extends JFrame implements ActionListener {
    JComboBox comboId; 
    JTextField tfNumber,tfName,tfCountry,tfDeposit;
    JRadioButton genderMale,genderFemale;
    Choice croom;
    JLabel checkInTime;
    JButton add,back;
    
    AddCustomer(){
        setLayout(null);
        setBounds(350,200   ,800,500);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(100,20,300,30);
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        heading.setForeground(Color.BLUE);
        add(heading);
        
         JLabel text = new JLabel("ID");
        text.setBounds(35,80,100,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        String[] options = {"Aadhar Card", "Passport","Driving Liscence","Pan Card","Voter ID Card"};
        comboId = new JComboBox(options);
        comboId.setBackground(Color.WHITE);
        comboId.setBounds(200,80,150,25);
        add(comboId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(35,120,100,30);
        lblNumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblNumber);
        
        tfNumber = new JTextField();
        tfNumber.setBounds(200,120,150,25);
        tfNumber.setBackground(Color.WHITE);
        add(tfNumber);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(35,160,100,30);
        lblName.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200,160,150,25);
        tfName.setBackground(Color.WHITE);
        add(tfName);
        
        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(35,200,100,30);
        lblGender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblGender);
        
        genderMale = new JRadioButton("Male");
        genderMale.setBounds(200, 200 ,80 ,25);
        genderMale.setBackground(Color.WHITE);
        add(genderMale);
        
        genderFemale = new JRadioButton("Female");
        genderFemale.setBounds(280, 200 ,80 ,25);
        genderFemale.setBackground(Color.WHITE);
        add(genderFemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(genderMale);
        bg.add(genderFemale);
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(35,240,100,30);
        lblCountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblCountry);
        
        tfCountry = new JTextField();
        tfCountry.setBounds(200,240,150,25);
        tfCountry.setBackground(Color.WHITE);
        add(tfCountry);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,280,160,30);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);
        
        croom = new Choice();
        croom.setBounds(200,280,150,25);
        add(croom);
        
         
        try {
            Conn c = new Conn();
            String query = "select * from rooms where availability = 'Available'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                croom.add(rs.getString(1));
            }
            c.s.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        JLabel lblTime = new JLabel("Checkin Time");
        lblTime.setBounds(35,320,160,30);
        lblTime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblTime);
        
      
        java.util.Date date = new java.util.Date();
        
        checkInTime = new JLabel("" + date);
        checkInTime.setBounds(200,320,160,30);
        checkInTime.setFont(new Font("Raleway",Font.PLAIN, 15));
        add(checkInTime);
        
        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setBounds(35,360,100,30);
        lblDeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblDeposit);
        
        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,360,150,25);
        tfDeposit.setBackground(Color.WHITE);
        add(tfDeposit);
        
        add = new JButton("ADD");
        add.setBounds(35,400,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("BACK");
        back.setBounds(200,400,150,40);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,300,400);
        add(image);    
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            try {
                String id = (String)comboId.getSelectedItem();
                String number = tfNumber.getText();
                String name = tfName.getText();
                String country = tfCountry.getText();
                String gender = null;
                if(genderMale.isSelected())
                    gender = "male";
                else if(genderFemale.isSelected())
                    gender = "female";
                
                String roomnumber = croom.getSelectedItem();
                String checkin = checkInTime.getText();
                String deposit = tfDeposit.getText();
                
                String query = "insert into customer values(?,?,?,?,?,?,?,?)";
                Conn c = new Conn();
                PreparedStatement ps = c.c.prepareStatement(query);
                ps.setString(1, id);
                ps.setString(2, number);
                ps.setString(3, name);
                ps.setString(4, gender);
                ps.setString(5, country);
                ps.setString(6, roomnumber);
                ps.setString(7,checkin);
                ps.setString(8, deposit);
                
                int i = ps.executeUpdate();
                if(i > 0 ){
                    System.out.println("row added sucessfully");
                    JOptionPane.showMessageDialog(null,"Customer added Sucessfully");
                    String queryMakeOccupied = "update rooms set availability = 'Occupied' where roomNumber = '" +roomnumber + "'";
                    c.s.execute(queryMakeOccupied);
                    System.out.println("room status updated to occupied");
                    setVisible(false);
                    new AddReception();
                }else{
                    System.out.println("cound not add new Customer");
                }
                
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
                    
        }else if(ae.getSource() == back){
            
            setVisible(false);
            new AddReception();
        }
            
        
    }
    public static void main(String args[]){
        new AddCustomer();
    }
    
}
