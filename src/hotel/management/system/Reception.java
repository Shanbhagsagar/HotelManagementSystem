
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    
    Reception(){
      
        b1 = new JButton("New Customer Booking");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(10,50,220,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Customer Info");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(10,100,220,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Check-in Details ");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(10,150,220,30);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("Check-out");
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setBounds(10,200,220,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Room Info");
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        b5.setBounds(10,250,220,30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Update Room Status");
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.BLACK);
        b6.setBounds(10,300,220,30);
        b6.addActionListener(this);
        add(b6);
        
        b7 = new JButton("Pick-up Service");
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        b7.setBounds(10,350,220,30);
        b7.addActionListener(this);
        add(b7);
        
        b8 = new JButton("Driver-Info");
        b8.setForeground(Color.WHITE);
        b8.setBackground(Color.BLACK);
        b8.setBounds(10,400,220,30);
        b8.addActionListener(this);
        add(b8);
        
        b9 = new JButton("Logout");
        b9.setForeground(Color.WHITE);
        b9.setBackground(Color.BLACK);
        b9.setBounds(10,450,220,30);
        b9.addActionListener(this);
        add(b9);
        
       JLabel title = new JLabel("RECEPTION");
       title.setFont(new Font("Verdana", Font.BOLD, 30));
       title.setBounds(400, 10, 400, 30);
       add(title);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/rece.jpg"));
       Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(260,48,500,430);
       add(l1);
           
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(600,200,800,550);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setResizable(false);
        setTitle("Hotel Lemon");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == b1){
        new AddCustomer().setVisible(true);
        this.setVisible(false);
      }else if(ae.getSource() == b2){
         new CustomerInfo().setVisible(true);
         this.setVisible(false);
      }else if(ae.getSource() == b3){
         new CheckInDetails().setVisible(true);
         this.setVisible(false);
      }else if(ae.getSource() == b4){
        new CheckOutDetails().setVisible(true);
         this.setVisible(false);
      }else if(ae.getSource() == b5){
        new Room().setVisible(true);
        this.setVisible(false);
      }else if(ae.getSource() == b6){
         new UpdateRoomStatus().setVisible(true);
         this.setVisible(false);
      }else if(ae.getSource() == b7){
         new UpdateDriverStatus().setVisible(true);
         this.setVisible(false);
      }else if(ae.getSource() == b8){
         new DriverInfo().setVisible(true);
         this.setVisible(false);
      }else if(ae.getSource() == b9){
        this.setVisible(false);
      }        
    }
    
    public static void main(String[] args){
       new Reception().setVisible(true); 
   }
}
