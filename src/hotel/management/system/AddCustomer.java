
package hotel.management.system;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c3;
    Choice c2;
    JButton b1,b2;
    JRadioButton r1,r2;
    JDateChooser d1,d2;
    
    AddCustomer(){
        
       JLabel name = new JLabel("Name :");
       name.setFont(new Font("Tahoma", Font.PLAIN , 16));
       name.setBounds(50,10,120,30);
       add(name);
       
       t1 = new JTextField();
       t1.setBounds(180,10,150,30);
       add(t1);
       
       JLabel phone = new JLabel("Cell No:");
       phone.setFont(new Font("Tahoma", Font.PLAIN , 16));
       phone.setBounds(50,60,120,30);
       add(phone);
       
       t2 = new JTextField();
       t2.setBounds(180,60,150,30);
       add(t2);
       
       JLabel gender = new JLabel("Gender :");
       gender.setFont(new Font("Tahoma", Font.PLAIN , 16));
       gender.setBounds(50,110,120,30);
       add(gender);
       
       r1 = new JRadioButton("Male");
       r1.setFont(new Font("Tahoma", Font.PLAIN , 17));
       r1.setBackground(Color.WHITE);
       r1.setBounds(180,110,60,30);
       add(r1);
       
       r2 = new JRadioButton("Female");
       r2.setFont(new Font("Tahoma", Font.PLAIN , 17));
       r2.setBackground(Color.WHITE);
       r2.setBounds(260,110,100,30);
       add(r2);
       
       ButtonGroup bg=new ButtonGroup();    
       bg.add(r1); bg.add(r2);
       
       JLabel proof = new JLabel("Proof :");
       proof.setFont(new Font("Tahoma", Font.PLAIN , 16));
       proof.setBounds(50,160,120,30);
       add(proof);
       
       String proofOption[] = {"Passport", "Aadhar Card", "Voter Id", "Driving license"};
       c1 = new JComboBox(proofOption);
       c1.setBackground(Color.WHITE);
       c1.setBounds(180,160,150,30);
       add(c1);
       
       JLabel proof_id = new JLabel("Proof Id:");
       proof_id.setFont(new Font("Tahoma", Font.PLAIN , 16));
       proof_id.setBounds(50,210,120,30);
       add(proof_id);
       
       t3 = new JTextField();
       t3.setBounds(180,210,150,30);
       add(t3);
       
       JLabel nog = new JLabel("No of Guest:");
       nog.setFont(new Font("Tahoma", Font.PLAIN , 16));
       nog.setBounds(50,260,120,30);
       add(nog);
       
       t4 = new JTextField();
       t4.setBounds(180,260,150,30);
       add(t4);
       
       JLabel allotedRoom = new JLabel("Alloted Room Number:");
       allotedRoom.setFont(new Font("Tahoma", Font.PLAIN , 16));
       allotedRoom.setBounds(50,310,120,30);
       add(allotedRoom);
       
       c2 = new Choice();
       try{
           conn c = new conn();
           String str = "SELECT * FROM rooms where status = 'Available';";
           ResultSet rs = c.s.executeQuery(str);
           
           while(rs.next()){
             c2.add(rs.getString("roomno"));
           }
           
       }catch(Exception e){}
       
       c2.setBackground(Color.WHITE);
       c2.setBounds(180,310,150,30);
       add(c2);
       
       JLabel deposit = new JLabel("Deposit:");
       deposit.setFont(new Font("Tahoma", Font.PLAIN , 16));
       deposit.setBounds(50,360,120,30);
       add(deposit);
       
       t5 = new JTextField();
       t5.setBounds(180,360,150,30);
       add(t5);
       
       JLabel checkIn = new JLabel("Check-In:");
       checkIn.setFont(new Font("Tahoma", Font.PLAIN , 16));
       checkIn.setBounds(50,420,120,30);
       add(checkIn);
       
       
       d1 = new JDateChooser();
       d1.setDateFormatString("yyyy-MM-dd");
       d1.setBackground(Color.WHITE);
       d1.setBounds(180,420,150,30);
       add(d1);    
       
       JLabel checkOut = new JLabel("Check-Out:");
       checkOut.setFont(new Font("Tahoma", Font.PLAIN , 16));
       checkOut.setBounds(50,470,120,30);
       add(checkOut);
       
       d2 = new JDateChooser();
       d2.setDateFormatString("yyyy-MM-dd");
       d2.setBackground(Color.WHITE);
       d2.setBounds(180,470,150,30);
       add(d2); 
       
       JLabel checkstat = new JLabel("CheckInStatus:");
       checkstat.setFont(new Font("Tahoma", Font.PLAIN , 16));
       checkstat.setBounds(50,520,120,30);
       add(checkstat); 
       
       String stat[] = {"Yes","No"};
       c3 = new JComboBox(stat);
       c3.setBackground(Color.WHITE);
       c3.setBounds(180,520,150,30);
       add(c3);
       
       b1 = new JButton("Book");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(50,570,120,30);
       b1.addActionListener(this);
       add(b1);
       
       b2 = new JButton("Cancel");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(200,570,120,30);
       b2.addActionListener(this);
       add(b2);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/cust.jpg"));
       Image i2 = i1.getImage().getScaledInstance(480, 550, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(380,48,480,550);
       add(l1);
       
         
       JLabel title = new JLabel("ADD CUSTOMER DETAILS");
       title.setFont(new Font("Verdana", Font.BOLD, 25));
       title.setBounds(430, 10, 400, 30);
       add(title);
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(260,50,900,660);
       setTitle("Hotel Lemon");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setLayout(null);
        setResizable(false);
       setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
         if(ae.getSource() == b1){
       
         String name = t1.getText();
         String phone = t2.getText();
         String gender = null;
         if(r1.isSelected()){
           gender = "Male";
          }
         else if(r2.isSelected()){
           gender = "Female";
         }
         String proof = (String) c1.getSelectedItem();
         String proofId = t3.getText();
         String nog = t4.getText();
         String allotedRoom = c2.getSelectedItem();
         String deposit = t5.getText();
         String price =  null ;
         int pending = 0;
         String checkIn = ((JTextField)d1.getDateEditor().getUiComponent()).getText();
         String checkOut = ((JTextField)d2.getDateEditor().getUiComponent()).getText();
         String checkStat = (String)c3.getSelectedItem();
         
         conn c = new conn();
         String str2 = "SELECT * FROM rooms where roomno = '"+allotedRoom+"';";
          try{
            
           ResultSet rs = c.s.executeQuery(str2);
           while(rs.next()){
            price = rs.getString("price");
            pending = Integer.parseInt(price) - Integer.parseInt(deposit);
           }
           
       }catch(Exception e){}
          
        String balance = Integer.toString(pending);
          
         String str = "insert into customer values('"+name+"','"+phone+"','"+gender+"','"+proof+"','"+proofId+"','"+nog+"','"+allotedRoom+"','"+deposit+"','"+checkIn+"','"+checkOut+"','"+price+"','"+balance+"','"+checkStat+"');";  
         String str1 = "update rooms set status = 'Occupied' where roomno = '"+allotedRoom+"'";
         try{
           c.s.executeUpdate(str);
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Room Alloted");
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
      new AddCustomer().setVisible(true);    
    }
    
}
