
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lblRoomNumber,lblCheckinTime,lblCheckoutTime;
    JButton checkout,back;
    Checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Checkout Customer");
        title.setForeground(Color.BLUE);
        title.setBounds(100,20,200,30);
        title.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(title);
        
        JLabel lblId = new JLabel("Customer Id");
        lblId.setBounds(30,80,100,30);
        add(lblId);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,30);
        ccustomer.setBackground(Color.WHITE);
        add(ccustomer);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel tick = new JLabel(i1);
        tick.setBounds(320,80,20,20);
        add(tick);
        
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30,130,100,30);
        add(lblRoom);
        
        
        lblRoomNumber = new JLabel();
        lblRoomNumber.setBounds(150,130,100,30);
        add(lblRoomNumber);
        
        JLabel lblCheckin = new JLabel("Checkin Time");
        lblCheckin.setBounds(30,180,100,30);
        add(lblCheckin);
            
        lblCheckinTime = new JLabel();
        lblCheckinTime.setBounds(150,180,150,30);
        add(lblCheckinTime);
        
         
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                ccustomer.add(rs.getString(2));
                lblRoomNumber.setText(rs.getString("roomnumber"));
                lblCheckinTime.setText(rs.getString("checkin"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblCheckout = new JLabel("Checkout Time");
        lblCheckout.setBounds(30,230,100,30);
        add(lblCheckout);
            
        Date date = new Date();
        lblCheckoutTime = new JLabel("" + date);
        lblCheckoutTime.setBounds(150,230,150,30);
        add(lblCheckoutTime);
        
        checkout = new JButton("CHECK OUT");
        checkout.setBounds(30,290, 120,30);
        checkout.setFont(new Font("Tahoma",Font.PLAIN,13));
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);
        
         back = new JButton("Back");
        back.setBounds(200,290, 120,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,13));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image img = i3.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        i3 = new ImageIcon(img);
        JLabel cover = new JLabel(i3);
        cover.setBounds(350,50,400,250);
        add(cover);
        
        
            
        
        
        
        setBounds(380,200,800,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
            try{
                Conn con = new Conn();
                String query1  = "delete from customer where number = '"+ ccustomer.getSelectedItem() +"'";
                String query2 = "update rooms set availability = 'Available' where roomNumber = '" + lblRoomNumber.getText()+ "'";
                
                int i = con.s.executeUpdate(query1);
                        con.s.executeUpdate(query2);
                        
                if(i>0)
                    JOptionPane.showMessageDialog(null, "Customer checked out sucessfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new AddReception();
        }
        
    }
    
    public static void main(String[] args) {
        new Checkout();
    }
    
}
