package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
    JButton b1,b2;
    
    HotelManagementSystem(){
       
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/front.jpg"));
    JLabel j1 = new JLabel(i1);
    j1.setBounds(0,0,1500,800);
    add(j1);

    JLabel j2 = new JLabel("Hotel Management System");
    j2.setBounds(200,20,1000,90);
    j2.setForeground(Color.WHITE);
    j2.setFont(new Font("serif", Font.PLAIN , 90));
    j1.add(j2);
    
    b1 = new JButton("Reception Login");
    b1.setBackground(Color.WHITE);
    b1.setForeground(Color.BLACK);
    b1.setBounds(1100,500,200,70);
    b1.setFont(new Font("serif", Font.PLAIN , 20));
    b1.addActionListener(this);
    j1.add(b1);
    
    b2 = new JButton("Admin Login");
    b2.setBackground(Color.WHITE);
    b2.setForeground(Color.BLACK);
    b2.setBounds(1100,600,200,70);
    b2.setFont(new Font("serif", Font.PLAIN , 20));
    b2.addActionListener(this);
    j1.add(b2);
       
    setLayout(null);
    setBounds(200,120,1500,800);
    setTitle("Hotel Lemon");
   setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
    setVisible(true);
    
    
      while(true){
        j2.setVisible(false);
        try{
          Thread.sleep(500);
        }catch(Exception e){}
        j2.setVisible(true);
        try{
          Thread.sleep(500);
        }catch(Exception e){}
      }
    }
    
    public void actionPerformed(ActionEvent ae){
       
     if(ae.getSource()== b1){
       new ReceptionLogin().setVisible(true);
       this.setVisible(false);
    }else if(ae.getSource()== b2){
         new Login().setVisible(true);
         this.setVisible(false);         
     }
}
  
    public static void main(String[] args) {
      
      new HotelManagementSystem().setVisible(true);
        
    }
    
}
