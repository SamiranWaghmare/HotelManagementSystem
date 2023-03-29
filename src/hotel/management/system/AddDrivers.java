
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDrivers extends JFrame implements ActionListener{
    JTextField txtname,txtage, txtcompany , txtmodel ,txtlocation,txtprice;
    JComboBox jcAvailable;
    JRadioButton rbMale, rbFemale;
    JButton addDriverButton;
    
    AddDrivers(){
        setBounds(300,200,980,470);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("TAHOMA",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        //name fields
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblname.setBounds(60,60,120,30);
        add(lblname);
        
        txtname = new JTextField();
        txtname.setBounds(200, 60 , 150,30);
        add(txtname);
        
        //age fields
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblage.setBounds(60,100,120,30);
        add(lblage);
        
        txtage = new JTextField();
        txtage.setBounds(200, 100 , 150,30);
        add(txtage);
        
        //gender fields
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblGender.setBounds(60,140,120,30);
        add(lblGender);
        
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200,140,60,30);
        rbMale.setFont(new Font("Tahoma",PLAIN,14));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);
        
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(270,140,80,30);
        rbFemale.setFont(new Font("Tahoma",PLAIN,14));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        
        
        //car company
        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblcompany.setBounds(60,180,120,30);
        add(lblcompany);
        
        txtcompany = new JTextField();
        txtcompany.setBounds(200, 180 , 150,30);
        add(txtcompany);
        
        //car model
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblmodel.setBounds(60,220,120,30);
        add(lblmodel);
        
        txtmodel = new JTextField();
        txtmodel.setBounds(200, 220 , 150,30);
        add(txtmodel);
        
        //availablity jcombobox
        JLabel lblAvailablity = new JLabel("Availability");
        lblAvailablity.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblAvailablity.setBounds(60,260,120,30);
        add(lblAvailablity);
        
        String availability[] = {"Available","Busy"};
        jcAvailable = new JComboBox(availability);
        jcAvailable.setBackground(Color.WHITE);
        jcAvailable.setBounds(200,260,150,30);
        add(jcAvailable);
        
        //set location
        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblLocation.setBounds(60,300,120,30);
        add(lblLocation);
        
        txtlocation = new JTextField();
        txtlocation.setBounds(200, 300 , 150,30);
        add(txtlocation);
        
        
        
        
        
        //add and cancel buttons
        addDriverButton = new JButton("Add Driver");
        addDriverButton.setForeground(Color.WHITE);
        addDriverButton.setBackground(Color.BLACK);
        addDriverButton.setBounds(60,370,130,30);
        addDriverButton.addActionListener(this);
        add(addDriverButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(220,370,130,30);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        // adding image to jframe
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
    if(ae.getSource() == addDriverButton){
            String name = txtname.getText();
            String age = txtage.getText();
            String gender = null;
            if(rbMale.isSelected())
                gender = "Male";
            else if(rbFemale.isSelected())
                gender = "Female";
            String carCompany = txtcompany.getText();
            String carModel = txtmodel.getText();
            String dirverAvailability = (String)jcAvailable.getSelectedItem();
            String location = txtlocation.getText();
       
    //establishing connection with jdbc
            try{
                Conn con = new Conn();
                String query = "insert into drivers values('" + name+ "','" + age + "','" + gender + "','" + carCompany + "','" + carModel+ "','" + dirverAvailability + "','" + location + "')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver sucessfully assigned");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
  
    }else{
          setVisible(false);
    }
        
        
        
    }
    
    
    
    public static void main(String Args[]){
        new AddDrivers();
    }
}

