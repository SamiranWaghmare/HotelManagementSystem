
package hotel.management.system;

import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AddReception extends JFrame implements ActionListener{
    JButton newCustomerForm,rooms,department,allEmployees,managerInfo,customerInfo;
    
    AddReception(){
        setLayout(null);
        getContentPane().setBackground(WHITE);
        setBounds(350,120,900,680);
        
        //setting out buttons
        newCustomerForm = new JButton("New Customer Form");
        newCustomerForm.setBackground(BLACK);
        newCustomerForm.setForeground(WHITE);
        newCustomerForm.setBounds(10,30,220,30);
        newCustomerForm.addActionListener(this);
        add(newCustomerForm);
        
        rooms = new JButton("Rooms");
        rooms.setBackground(BLACK);
        rooms.setForeground(WHITE);
        rooms.setBounds(10,80,220,30);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBackground(BLACK);
        department.setForeground(WHITE);
        department.setBounds(10,130,220,30);
        department.addActionListener(this);
        add(department);
        
        allEmployees = new JButton("All Employees");
        allEmployees.setBackground(BLACK);
        allEmployees.setForeground(WHITE);
        allEmployees.setBounds(10,180,220,30);
        allEmployees.addActionListener(this);
        add(allEmployees);
        
        customerInfo = new JButton("Customer Info");
        customerInfo.setBackground(BLACK);
        customerInfo.setForeground(WHITE);
        customerInfo.setBounds(10,230,220,30);
        customerInfo.addActionListener(this);
        add(customerInfo);
        
        managerInfo = new JButton("Manager Info");
        managerInfo.setBackground(BLACK);
        managerInfo.setForeground(WHITE);
        managerInfo.setBounds(10,280,220,30);
        managerInfo.addActionListener(this);
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
    
    public void actionPerformed(ActionEvent ae) {
    setVisible(false);

    switch(ae.getActionCommand()) {
        case "New Customer Form": new AddCustomer(); break;    
        case "Rooms": new Rooms(); break;
        case "Department": new Departments(); break;
        case "All Employees": new Employees(); break;
        case "Manager Info" : new Manager(); break;
        case "Customer Info" : new Customers(); break;
        default:
            break;
    }
}

    
    public static void main(String args[]){
        new AddReception();
    }
}
