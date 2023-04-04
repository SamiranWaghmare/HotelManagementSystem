
package hotel.management.system;

import static java.awt.Color.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AddReception extends JFrame{
    
    AddReception(){
        setLayout(null);
        getContentPane().setBackground(WHITE);
        setBounds(350,120,900,680);
        
        //setting out buttons
        JButton newCustomerForm = new JButton("New Customer Form");
        newCustomerForm.setBackground(BLACK);
        newCustomerForm.setForeground(WHITE);
        newCustomerForm.setBounds(10,30,220,30);
        add(newCustomerForm);
        
        JButton rooms = new JButton("Rooms");
        rooms.setBackground(BLACK);
        rooms.setForeground(WHITE);
        rooms.setBounds(10,80,220,30);
        add(rooms);
        
        JButton deperatment = new JButton("Department");
        deperatment.setBackground(BLACK);
        deperatment.setForeground(WHITE);
        deperatment.setBounds(10,130,220,30);
        add(deperatment);
        
        JButton allEmployees = new JButton("All Employees");
        allEmployees.setBackground(BLACK);
        allEmployees.setForeground(WHITE);
        allEmployees.setBounds(10,180,220,30);
        add(allEmployees);
        
        JButton customerInfo = new JButton("Customer Info");
        customerInfo.setBackground(BLACK);
        customerInfo.setForeground(WHITE);
        customerInfo.setBounds(10,230,220,30);
        add(customerInfo);
        
         JButton managerInfo = new JButton("Manager Info");
        managerInfo.setBackground(BLACK);
        managerInfo.setForeground(WHITE);
        managerInfo.setBounds(10,280,220,30);
        add(managerInfo);
        
        JButton checkOut = new JButton("Check Out");
        checkOut.setBackground(BLACK);
        checkOut.setForeground(WHITE);
        checkOut.setBounds(10,330,220,30);
        add(checkOut);
        
         JButton updateStatus = new JButton("Update Status");
        updateStatus.setBackground(BLACK);
        updateStatus.setForeground(WHITE);
        updateStatus.setBounds(10,380,220,30);
        add(updateStatus);
        
        JButton updateRoomStatus = new JButton("Update Room Status");
        updateRoomStatus.setBackground(BLACK);
        updateRoomStatus.setForeground(WHITE);
        updateRoomStatus.setBounds(10,430,220,30);
        add(updateRoomStatus);
        
         JButton pickupService = new JButton("Pickup Service");
        pickupService.setBackground(BLACK);
        pickupService.setForeground(WHITE);
        pickupService.setBounds(10,480,220,30);
        add(pickupService);
        
        JButton searchRoom = new JButton("Search Room");
        searchRoom.setBackground(BLACK);
        searchRoom.setForeground(WHITE);
        searchRoom.setBounds(10,530,220,30);
        add(searchRoom);
        
         JButton logout = new JButton("Logout");
        logout.setBackground(BLACK);
        logout.setForeground(WHITE);
        logout.setBounds(10,580,220,30);
        add(logout);
        
        //setting image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,600,600);
        add(image);
        
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        new AddReception();
    }
}
