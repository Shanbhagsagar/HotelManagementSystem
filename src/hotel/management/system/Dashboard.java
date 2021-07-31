
package hotel.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
      
        mb = new JMenuBar();
        add(mb);
        
        m1 = new JMenu("HOTEL MANAGEMENT");
        mb.add(m1);
        
        m2 = new JMenu("     ADMIN       ");
        m2.setForeground(Color.RED);
        mb.add(m2);
        
        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("Add Driver");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(0,0,1950,30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1950,1000);
        add(l1);
        
        JLabel l2 = new JLabel("Welcome To Hotel Lemon");
        l2.setBounds(350,40,1000,70);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tahoma", Font.PLAIN , 60));
        l1.add(l2);
        
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        setTitle("Hotel Lemon");
        setBounds(0,0,1950,1030);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getActionCommand().equals("RECEPTION")){
         new Reception().setVisible(true);
      }
      else if(ae.getActionCommand().equals("Add Employee")){
         new AddEmployee().setVisible(true);
      }
      else if(ae.getActionCommand().equals("Add Rooms")){
         new AddRooms().setVisible(true);
      }
       else if(ae.getActionCommand().equals("Add Driver")){
         new AddDrivers().setVisible(true);
      }
    }
    
    public static void main(String[] args){
      new Dashboard().setVisible(true);    
    }
}
