
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class CheckOutDetails extends JFrame implements ActionListener {
    
    
     Choice c1;
     JButton b1,b2;
    
    CheckOutDetails(){
        
       JLabel title = new JLabel("Check Out");
       title.setFont(new Font("Verdana", Font.BOLD, 25));
       title.setBounds(200, 10, 400, 30);
       add(title);
       
       JLabel roomno = new JLabel("Room No :");
       roomno.setFont(new Font("Tahoma", Font.PLAIN , 16));
       roomno.setBounds(140,60,100,30);
       add(roomno);   
       
       c1 = new Choice();
       try{
           conn c = new conn();
           String str = "SELECT * FROM rooms where status = 'Occupied';";
           ResultSet rs = c.s.executeQuery(str);
           
           while(rs.next()){
             c1.add(rs.getString("roomno"));
           }
           
       }catch(Exception e){}
       c1.setBounds(270,60,150,30);
       add(c1);
       
       b1 = new JButton("Check-Out");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(140,120,120,30);
       b1.addActionListener(this);
       add(b1);
       
       b2 = new JButton("Cancel");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(300,120,120,30);
       b2.addActionListener(this);
       add(b2);
    
       getContentPane().setBackground(Color.WHITE);
       setBounds(400,200,600,240);
       setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setResizable(false);
       setTitle("Hotel Lemon");
       setLayout(null);
       setVisible(true);  
         
    }
       
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
    
        String allotedRoom = c1.getSelectedItem();
        conn c = new conn();
        
        String str1 = "delete from customer where allotedRoom = '"+allotedRoom+"'";
        String str2 = "update rooms set status = 'Available' where roomno = '"+allotedRoom+"'";
        try{
        
            c.s.executeUpdate(str1);
            c.s.executeUpdate(str2);
            
           JOptionPane.showMessageDialog(null, "Check-out Successful");
           new Reception().setVisible(true);
           this.setVisible(false);
            
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
         new CheckOutDetails().setVisible(true);
    }
}
