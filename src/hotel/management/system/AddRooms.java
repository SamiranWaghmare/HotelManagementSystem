
package hotel.management.system;

import javax.swing.JFrame;
import java.awt.Color; 
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener{
    JTextField txtroomno,txtprice;
    JComboBox jcAvailable,jcCleaned,jcBedType;
    JButton addRoomButton;
    
    AddRooms(){
        setBounds(330,200,940,470);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("TAHOMA",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        txtroomno = new JTextField();
        txtroomno.setBounds(200, 80 , 150,30);
        add(txtroomno);
        
        JLabel lblavailability = new JLabel("Availability");
        lblavailability.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblavailability.setBounds(60,130,120,30);
        add(lblavailability);
        
        String[] availabilityOptions = {"Available","Occupied"};
        jcAvailable = new JComboBox(availabilityOptions);
        jcAvailable.setBackground(Color.WHITE);
        jcAvailable.setBounds(200,130,150,30);
        add(jcAvailable);
        
        JLabel lblcleanOptions = new JLabel("Cleaning Status");
        lblcleanOptions.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblcleanOptions.setBounds(60,180,120,30);
        add(lblcleanOptions);
        
        String[] cleanOptions = {"Clean","Dirty"};
        jcCleaned = new JComboBox(cleanOptions);
        jcCleaned.setBackground(Color.WHITE);
        jcCleaned.setBounds(200,180,150,30);
        add(jcCleaned);
        
        //room price
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        
        txtprice = new JTextField();
        txtprice.setBounds(200, 230 , 150,30);
        add(txtprice);
        
        //bed type
        JLabel lblBedType = new JLabel("Bed Type");
        lblBedType.setFont(new Font("TAHOMA",Font.PLAIN,14));
        lblBedType.setBounds(60,280,120,30);
        add(lblBedType);
        
        String[] bedTypeOptions = {"Single Bed","Double Bed"};
        jcBedType = new JComboBox(bedTypeOptions);
        jcBedType.setBackground(Color.WHITE);
        jcBedType.setBounds(200,280,150,30);
        add(jcBedType);
        
        //add and cancel buttons
        addRoomButton = new JButton("Add Room");
        addRoomButton.setForeground(Color.WHITE);
        addRoomButton.setBackground(Color.BLACK);
        addRoomButton.setBounds(60,350,130,30);
        addRoomButton.addActionListener(this);
        add(addRoomButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(220,350,130,30);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        // adding image to jframe
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel i2 = new JLabel(i1);
        i2.setBounds(400,30,500,300);
        add(i2);
        
        
         
        
        
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
    if(ae.getSource() == addRoomButton){
            String roomNumber = txtroomno.getText();
            String price = txtprice.getText();
            String availability = (String)jcAvailable.getSelectedItem();
            String isCleaned = (String)jcCleaned.getSelectedItem();
            String bedType = (String)jcBedType.getSelectedItem();
    //establishing connection with jdbc
            try{
                Conn con = new Conn();
                String query = "insert into rooms values('" + roomNumber+ "','" + availability + "','" + isCleaned + "','" + price + "','" + bedType + "')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "new room logged");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
  
    }else{
          setVisible(false);
    }
        
        
        
    }
    
    
    
    public static void main(String Args[]){
        new AddRooms();
    }
}
