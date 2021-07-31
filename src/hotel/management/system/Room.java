
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
    
     JTable t1;
     JButton b1,b2,b3;
      JComboBox c1,c2,c3,c4;
     
    Room(){
        
        JLabel status = new JLabel("Status :");
       status.setFont(new Font("Tahoma", Font.PLAIN , 16));
       status.setBounds(20,10,120,30);
       add(status);
       
       String stat[] = {"Available","Occupied","Maintenance"};
       c1 = new JComboBox(stat);
       c1.setBackground(Color.WHITE);
       c1.setBounds(100,10,150,30);
       add(c1);
       
       JLabel type = new JLabel("Bed Type :");
       type.setFont(new Font("Tahoma", Font.PLAIN , 16));
       type.setBounds(280,10,120,30);
       add(type);       
       
       String bedtype[] = (new String[]{"Single Bed","Double Bed"});
       c2 = new JComboBox(bedtype);
       c2.setBackground(Color.WHITE);
       c2.setBounds(380,10,150,30);
       add(c2);
       
       JLabel roomtype = new JLabel("Room Type :");
       roomtype.setFont(new Font("Tahoma", Font.PLAIN , 16));
       roomtype.setBounds(560,10,120,30);
       add(roomtype);       
       
       String room_type[] = {"A/C","NON A/C"};
       c3 = new JComboBox(room_type);
       c3.setBackground(Color.WHITE);
       c3.setBounds(680,10,150,30);
       add(c3);
     
        JLabel l1 = new JLabel("Room No");
        l1.setBounds(60,70,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Bed Type");
        l2.setBounds(230,70,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Room type");
        l3.setBounds(380,70,70,20);
        add(l3);
       
        JLabel l4 = new JLabel("Status");
        l4.setBounds(570,70,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Price");
        l5.setBounds(730,70,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Clean Status");
        l6.setBounds(870,70,100,20);
        add(l6);
        
               
        t1 = new JTable();
        t1.setBounds(0,100,1000,500);
        add(t1);
        
      
        b1 = new JButton("Load Data");
        b1.setBounds(350,620,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530,620,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Load");
        b3.setBounds(850,10,120,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);
        
//        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(200,10,1000,710);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setResizable(false);
        setTitle("Hotel Lemon");
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
      
        if(ae.getSource() == b1){
        try{
            conn c = new conn();
            String str = "select * from rooms ";
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
     else if(ae.getSource() == b3){
        try{
           
           String stat = (String) c1.getSelectedItem();
            String bedtype = (String) c2.getSelectedItem();
            String rtype = (String) c3.getSelectedItem();
            System.out.println(bedtype);
            conn c1 = new conn();
            String str = "SELECT * FROM rooms where bedtype = '"+bedtype+"' and status = '"+stat+"' and roomtype = '"+rtype+"'";
            ResultSet rs = c1.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(Exception e){
          System.out.println(e);
         }
      }
        
    }
    
    public static void main(String[] args){
        new Room().setVisible(true);
   }
    
}
