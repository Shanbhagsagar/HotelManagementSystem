
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddDrivers extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1,c2;
    JButton b1,b2;
    
    AddDrivers(){
  
       JLabel name = new JLabel("Name :");
       name.setFont(new Font("Tahoma", Font.PLAIN , 16));
       name.setBounds(60,20,120,30);
       add(name);
       
       t1 = new JTextField();
       t1.setBounds(200,20,150,30);
       add(t1);
       
       JLabel gender = new JLabel("Gender:");
       gender.setFont(new Font("Tahoma", Font.PLAIN , 16));
       gender.setBounds(60,70,120,30);
       add(gender);
       
       String gen[] = {"Male","Female"};
       c1 = new JComboBox(gen);
       c1.setBackground(Color.WHITE);
       c1.setBounds(200,70,150,30);
       add(c1);
       
      
       JLabel phone = new JLabel("Phone No:");
       phone.setFont(new Font("Tahoma", Font.PLAIN , 16));
       phone.setBounds(60,120,120,30);
       add(phone);
       
       t2 = new JTextField();
       t2.setBounds(200,120,150,30);
       add(t2);
       
         
       JLabel aadhar = new JLabel("Aadhar No:");
       aadhar.setFont(new Font("Tahoma", Font.PLAIN , 16));
       aadhar.setBounds(60,170,120,30);
       add(aadhar);       
       
       t3 = new JTextField();
       t3.setBounds(200,170,150,30);
       add(t3);
       
       JLabel dlic = new JLabel("D License No:");
       dlic.setFont(new Font("Tahoma", Font.PLAIN , 16));
       dlic.setBounds(60,220,120,30);
       add(dlic);       
       
       t4 = new JTextField();
       t4.setBounds(200,220,150,30);
       add(t4);
       
       JLabel car = new JLabel("Car Model:");
       car.setFont(new Font("Tahoma", Font.PLAIN , 16));
       car.setBounds(60,270,120,30);
       add(car);       
       
       t5 = new JTextField();
       t5.setBounds(200,270,150,30);
       add(t5);
       
       JLabel carlic = new JLabel("C License No:");
       carlic.setFont(new Font("Tahoma", Font.PLAIN , 16));
       carlic.setBounds(60,320,120,30);
       add(carlic);       
       
       t6 = new JTextField();
       t6.setBounds(200,320,150,30);
       add(t6);
       
       JLabel status = new JLabel("Status:");
       status.setFont(new Font("Tahoma", Font.PLAIN , 16));
       status.setBounds(60,370,120,30);
       add(status);
       
       String stat[] = {"Available","Occupied","Not Available"};
       c2 = new JComboBox(stat);
       c2.setBackground(Color.WHITE);
       c2.setBounds(200,370,150,30);
       add(c2);
       
          
       b1 = new JButton("Add");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(60,430,120,30);
       b1.addActionListener(this);
       add(b1);
       
       b2 = new JButton("Cancel");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(220,430,120,30);
       b2.addActionListener(this);
       add(b2);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/eleven.jpg"));
       Image i2 = i1.getImage().getScaledInstance(650, 410, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(380,48,530,410);
       add(l1);
       
       
       JLabel title = new JLabel("ADD DRIVER DETAILS");
       title.setFont(new Font("Verdana", Font.BOLD, 30));
       title.setBounds(450, 10, 400, 30);
       add(title);
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(240,100,960,530);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setTitle("Hotel Lemon");
       setResizable(false);
       setLayout(null);
       setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == b1){
       
         String name = t1.getText();
         String phone = t2.getText();
         String gender = (String) c1.getSelectedItem();
         String aadhar = t3.getText();
         String dlicense = t4.getText();
         String carmodel = t5.getText();
         String clicense = t6.getText();
         String status = (String) c2.getSelectedItem();
         
         conn c = new conn();
         String str = "insert into drivers (name,phone,gender,aadhar,dlicense,carmodel,clicense,status) values('"+name+"','"+phone+"','"+gender+"','"+aadhar+"','"+dlicense+"','"+carmodel+"','"+clicense+"','"+status+"');";  
         
         if(name.length()== 0 || phone.length() == 0 || aadhar.length() == 0 || dlicense.length() == 0 || carmodel.length() == 0 || clicense.length() == 0 || status.length() == 0){
           JOptionPane.showMessageDialog(null,"Fields cannot be empty");    
         }
         else if(phone.length() != 10 || aadhar.length() != 12 || dlicense.length() != 10 || clicense.length() != 10 ){
           JOptionPane.showMessageDialog(null,"Phone no should be of 10 digits and aadhar should be of 12 digits and dlicense should be of 10 digits and clicense should be of 10 digits");  
         }
         else{
         try{
           c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "New Driver Added");
           this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
        }
     }
     else if(ae.getSource() == b2){
        new Admin().setVisible(true);  
       this.setVisible(false);     
     }
    
    }
    
    public static void main(String[] args){
      new AddDrivers().setVisible(true);
    }
}
