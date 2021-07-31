
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class EmployeeInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    
    EmployeeInfo(){
        
        JLabel l1 = new JLabel("Id");
        l1.setBounds(40,10,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(130,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Address");
        l3.setBounds(220,10,70,20);
        add(l3);
       
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(330,10,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Job");
        l5.setBounds(430,10,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("DOB");
        l6.setBounds(530,10,70,20);
        add(l6);
        
        JLabel l7 = new JLabel("Aadhar");
        l7.setBounds(630,10,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("Phone");
        l8.setBounds(730,10,70,20);
        add(l8);
        
        JLabel l9 = new JLabel("Salary");
        l9.setBounds(830,10,70,20);
        add(l9);
        
        JLabel l10 = new JLabel("Shifts");
        l10.setBounds(930,10,70,20);
        add(l10);
        
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
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setResizable(false);
        setTitle("Hotel Lemon");
        setLayout(null);
        setBounds(300,100,1000,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      
     if(ae.getSource() == b1){
        try{
           
            conn c = new conn();
            String str = "SELECT * FROM employee;";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(Exception e){
          System.out.println(e);
         }
      }
     else if(ae.getSource() == b2){
          this.setVisible(false);
      }
    
    }
    
    public static void main(String[] args){
      new EmployeeInfo().setVisible(true);
    }
}
