
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class DriverInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;    
    
    DriverInfo(){
     
        JLabel l1 = new JLabel("Id");
        l1.setBounds(40,10,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(110,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Phone");
        l3.setBounds(190,10,70,20);
        add(l3);
       
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(270,10,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Job");
        l5.setBounds(360,10,70,20);
        add(l5);
        
               
        JLabel l7 = new JLabel("Aadhar");
        l7.setBounds(440,10,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("Phone");
        l8.setBounds(515,10,70,20);
        add(l8);
        
        JLabel l9 = new JLabel("Salary");
        l9.setBounds(600,10,70,20);
        add(l9);
        
        JLabel l10 = new JLabel("DOB");
        l10.setBounds(690,10,70,20);
        add(l10);
        
         JLabel l11 = new JLabel("G-Room No");
        l11.setBounds(760,10,70,20);
        add(l11);
        
         JLabel l12 = new JLabel("Location");
        l12.setBounds(850,10,70,20);
        add(l12);
        
         JLabel l13 = new JLabel("Pickup Date");
        l13.setBounds(920,10,70,20);
        add(l13);
        
        
        t1 = new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530,560,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setResizable(false);
       setTitle("Hotel Lemon");
        setBounds(170,50,1020,650);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == b1){
        try{
           
            conn c = new conn();
            String str = "SELECT * FROM drivers;";
            ResultSet rs = c.s.executeQuery(str);
            String[] columnames = {"Driver id","Driver Name"};
            t1.setModel(DbUtils.resultSetToTableModel(rs));
          }
         catch(Exception e){
          System.out.println(e);
         }
      }
     else if(ae.getSource() == b2){
        new Reception().setVisible(true);
        this.setVisible(false);
      }
      
    }
    
    public static void main(String[] args){
     new DriverInfo().setVisible(true);
    }
}
