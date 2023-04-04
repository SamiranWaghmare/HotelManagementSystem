package hotel.management.system;

import javax.swing.*;
import java.awt.*;


public class AddCustomer extends JFrame {
    JComboBox comboId; 
    JTextField tfNumber,tfName,tfCountry;
    JRadioButton genderMale,genderFemale;
    
    AddCustomer(){
        setLayout(null);
        setBounds(350,200   ,800,500);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(100,20,300,30);
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        heading.setForeground(Color.BLUE);
        add(heading);
        
         JLabel text = new JLabel(" ID");
        text.setBounds(35,80,100,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        String[] options = {"Aadhar Card", "Passport","Driving Liscence","Pan Card","Voter ID Card"};
        comboId = new JComboBox(options);
        comboId.setBackground(Color.WHITE);
        comboId.setBounds(200,80,150,25);
        add(comboId);
        
        JLabel lblNumber = new JLabel(" NUMBER");
        lblNumber.setBounds(35,120,100,30);
        lblNumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblNumber);
        
        tfNumber = new JTextField();
        tfNumber.setBounds(200,120,150,25);
        tfNumber.setBackground(Color.WHITE);
        add(tfNumber);
        
        JLabel lblName = new JLabel("NAME");
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
        
        JLabel lblCountry = new JLabel("COUNTRY");
        lblCountry.setBounds(35,240,100,30);
        lblCountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblCountry);
        
        tfCountry = new JTextField();
        tfCountry.setBounds(200,240,150,25);
        tfCountry.setBackground(Color.WHITE);
        add(tfCountry);
        
        
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        new AddCustomer();
    }
    
}
