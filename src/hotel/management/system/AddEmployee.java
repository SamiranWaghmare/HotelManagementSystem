
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField txtname,txtage,txtsalary,txtphone,txtemail,txtaadhar;
    JRadioButton rbmale,rbfemale;
    JComboBox cbjobs;
    JButton submit;
    
    AddEmployee(){
      
    //setting up the frame dimensions
     setLayout(null);
     setBounds(350,200,850,540);
     getContentPane().setBackground(Color.WHITE);
     
     //adding jlables,jtexts,radiobuttons and combo boxes
     //setting name and age
     JLabel lblname = new JLabel("NAME");
     lblname.setBounds(60,30,120,30);
     lblname.setFont(new Font("Tahoma", PLAIN ,17));
     add(lblname);
     
      txtname = new JTextField();
     txtname.setBounds(200,30,150,30);
     add(txtname);
     
     JLabel lblage = new JLabel("AGE");
     lblage.setBounds(60,80,120,30);
     lblage.setFont(new Font("Tahoma", PLAIN ,17));
     add(lblage);
     
      txtage = new JTextField();
     txtage.setBounds(200,80,150,30);
     add(txtage);
     
     //setting gender radio buttons
     JLabel lblgender = new JLabel("GENDER");
     lblgender.setBounds(60,130,120,30);
     lblgender.setFont(new Font("Tahoma", PLAIN, 17));
     add(lblgender);
     
      rbmale = new JRadioButton("Male");
     rbmale.setBounds(200,130,70,30);
     rbmale.setFont(new Font("Tahoma",PLAIN,14));
     rbmale.setBackground(Color.WHITE);
     add(rbmale);
     
      rbfemale = new JRadioButton("Female");
     rbfemale.setBounds(280,130,70,30);
     rbfemale.setFont(new Font("Tahoma",PLAIN,14));
     rbfemale.setBackground(Color.WHITE);
     add(rbfemale);
     
     ButtonGroup bg = new ButtonGroup();
     bg.add(rbmale);
     bg.add(rbfemale);
     
     // setting job dropdown/combobox
     JLabel lbljob = new JLabel("JOB");
     lbljob.setBounds(60,180,120,30);
     lbljob.setFont(new Font("Tahoma", PLAIN ,17));
     add(lbljob);
     
     String jobs[] = {"Front Desk Clerks","Porters","Housekeeping" , "Kitchen Staff", "Room Serviece" ,"Chefs", "Waiter/Waitress","Manager","Accountant"};
      cbjobs = new JComboBox(jobs);
     cbjobs.setBackground(Color.WHITE);
     cbjobs.setBounds(200,180,150,30);
     add(cbjobs);
     
     //setting salary , phone email and aadhar
     JLabel lblsalary = new JLabel("SALARY");
     lblsalary.setBounds(60,230,120,30);
     lblsalary.setFont(new Font("Tahoma", PLAIN ,17));
     add(lblsalary);
     
      txtsalary = new JTextField();
     txtsalary.setBounds(200,230,150,30);
     add(txtsalary);
     
     JLabel lblphone = new JLabel("PHONE");
     lblphone.setBounds(60,280,120,30);
     lblphone.setFont(new Font("Tahoma", PLAIN ,17));
     add(lblphone);
     
      txtphone = new JTextField();
     txtphone.setBounds(200,280,150,30);
     add(txtphone);
     
      JLabel lblemail = new JLabel("EMAIL");
     lblemail.setBounds(60,330,120,30);
     lblemail.setFont(new Font("Tahoma", PLAIN ,17));
     add(lblemail);
     
      txtemail = new JTextField();
     txtemail.setBounds(200,330,150,30);
     add(txtemail);
     
     JLabel lblaadhar = new JLabel("AADHAR");
     lblaadhar.setBounds(60,380,120,30);
     lblaadhar.setFont(new Font("Tahoma", PLAIN ,17));
     add(lblaadhar);
     
      txtaadhar = new JTextField();
     txtaadhar.setBounds(200,380,150,30);
     add(txtaadhar);
     
     
     //submit button
     submit = new JButton("SUBMIT");
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.setBounds(200,430,150,30);
     submit.addActionListener(this);
     add(submit);
     
     
     // setting and scaling background image
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
     Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
     i1 = new ImageIcon(i2);
     JLabel image = new JLabel(i1); 
     image.setBounds(380,60,450,370);
     add(image);
     
     
           
           setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = txtname.getText();
        String age = txtage.getText();
        String salary = txtsalary.getText();
        String phone = txtphone.getText();
        String email = txtemail.getText();
        String aadhar = txtaadhar.getText();
        
        String gender = null;
        if(rbmale.isSelected())
            gender = "Male";
        else if(rbfemale.isSelected())
            gender = "Female";
        
        String job = (String)cbjobs.getSelectedItem();
        
    //validations
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"please enter a valid name" );
            return;
        }
        if(!email.contains("@") && !email.contains(".com")){
            JOptionPane.showMessageDialog(null,"Enter a valid email address");
            return;
        }
        
        
        try{
            Conn con = new Conn();
            String query = "insert into employee values('" + name + "','" + age + "','"+ gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee Added Sucessfully");
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main (String Arg[]){
        new AddEmployee();
        
    }
}
