
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener {
    
     JTable t1;
    JButton b1,b2;
    
    CustomerInfo(){
    
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,10,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Cell No");
        l2.setBounds(100,10,70,20);
        add(l2);
        
              
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(170,10,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Proof");
        l5.setBounds(250,10,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Proof Id");
        l6.setBounds(320,10,70,20);
        add(l6);
        
        JLabel l7 = new JLabel("NOG");
        l7.setBounds(400,10,150,20);
        add(l7);
        
        JLabel l8 = new JLabel("Alloted Room");
        l8.setBounds(460,10,100,20);
        add(l8);
        
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(560,10,70,20);
        add(l9);
        
        JLabel l10 = new JLabel("Check-In");
        l10.setBounds(630,10,70,20);
        add(l10);
        
        JLabel l11 = new JLabel("Check-Out");
        l11.setBounds(700,10,70,20);
        add(l11);
        
        JLabel l12 = new JLabel("Room Price");
        l12.setBounds(775,10,70,20);
        add(l12);
        
        JLabel l13 = new JLabel("Balance");
        l13.setBounds(860,10,70,20);
        add(l13);
        
        JLabel l14 = new JLabel("Check Status");
        l14.setBounds(930,10,70,20);
        add(l14);
        
  
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
        setBounds(300,100,1020,650);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setResizable(false);
        setTitle("Hotel Lemon");
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
          if(ae.getSource() == b1){
        try{
           
            conn c = new conn();
            String str = "SELECT * FROM customer;";
            ResultSet rs = c.s.executeQuery(str);
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
      new CustomerInfo().setVisible(true);
    }
}
