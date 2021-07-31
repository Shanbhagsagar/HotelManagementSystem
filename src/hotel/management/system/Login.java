package hotel.management.system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    
    Login (){
      
        l1 = new JLabel("Username :");
        l1.setFont(new Font("serif", Font.PLAIN , 18));
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password :");
        l2.setFont(new Font("serif", Font.PLAIN , 18));
        l2.setBounds(40,70,100,30);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);
        
        p1 = new JPasswordField();
        p1.setBounds(150,70,150,30);
        add(p1);
        
        b1 = new JButton("Login");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,150,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(180,150,120,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,200,200);
        add(l3);
        
     
        getContentPane().setBackground(Color.WHITE);
        setTitle("Hotel Lemon");
        setLayout(null);
        setBounds(370,200,600,270);
         setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== b1){
          String username = t1.getText();
          String password = p1.getText();
          conn c = new conn();
          
          String verify = "select * from login where username = '"+username+"' and password = '"+password+"'";
         
         
          try{
           ResultSet rs = c.s.executeQuery(verify);
           
           if(rs.next()){
              new Admin().setVisible(true);
             this.setVisible(false); 
           }else{
             JOptionPane.showMessageDialog(null,"Invalid username and Password");
             this.setVisible(false);
         }
           
          }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Server Down !! Unable to login");
            this.setVisible(false);
          }
         
        }else if(ae.getSource()== b2){
          System.exit(0);        
        }
    
    }
    
    public static void main(String[] args){
       new Login();
    }
    
}
