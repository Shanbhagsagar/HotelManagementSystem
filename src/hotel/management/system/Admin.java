
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    
    Admin(){
      
        b1 = new JButton("Add Employee");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(60,60,220,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update Employee");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(60,110,220,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Employee Info");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(60,160,220,30);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("Add Room");
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setBounds(60,210,220,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Add Driver");
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        b5.setBounds(60,260,220,30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Logout");
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.BLACK);
        b6.setBounds(60,310,220,30);
        b6.addActionListener(this);
        add(b6);
        
       JLabel title = new JLabel("Admin");
       title.setFont(new Font("Verdana", Font.BOLD, 30));
       title.setBounds(450, 10, 400, 30);
       add(title);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/second.jpg"));
       Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(360,55,300,300);
       add(l1);
           
       getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(240,100,750,430);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setResizable(false);
        setTitle("Hotel Lemon");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == b1){
        new AddEmployee().setVisible(true);
      }else if(ae.getSource() == b2){
         new UpdateEmployeeStatus().setVisible(true);
      }else if(ae.getSource() == b3){
         new EmployeeInfo().setVisible(true);
      }else if(ae.getSource() == b4){
        new AddRooms().setVisible(true);
      }else if(ae.getSource() == b5){
        new AddDrivers().setVisible(true);
        }else if(ae.getSource() == b6){
         this.setVisible(false);
      }        
    }
    
    public static void main(String[] args){
       new Admin().setVisible(true); 
   }
}
