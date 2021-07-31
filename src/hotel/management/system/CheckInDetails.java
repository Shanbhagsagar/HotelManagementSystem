
package hotel.management.system;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class CheckInDetails extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    JDateChooser d1,d2;
    JComboBox c2;
    JButton b1,b2,b3;    
   CheckInDetails(){
   
       JLabel title = new JLabel("Check In Details");
       title.setFont(new Font("Verdana", Font.BOLD, 25));
       title.setBounds(160, 10, 400, 30);
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
       
       JLabel name = new JLabel("Name :");
       name.setFont(new Font("Tahoma", Font.PLAIN , 16));
       name.setBounds(140,110,100,30);
       add(name); 
       
       t1 = new JTextField();
       t1.setBounds(270,110,150,30);
       add(t1);
       
       JLabel price = new JLabel("Price :");
       price.setFont(new Font("Tahoma", Font.PLAIN , 16));
       price.setBounds(140,160,100,30);
       add(price); 
       
       t2 = new JTextField();
       t2.setBounds(270,160,150,30);
       add(t2);
       
       JLabel paid = new JLabel("Amount Paid:");
       paid.setFont(new Font("Tahoma", Font.PLAIN , 16));
       paid.setBounds(140,210,100,30);
       add(paid); 
       
       t3 = new JTextField();
       t3.setBounds(270,210,150,30);
       add(t3);
       
       JLabel pending = new JLabel("Balance:");
       pending.setFont(new Font("Tahoma", Font.PLAIN , 16));
       pending.setBounds(140,260,100,30);
       add(pending); 
       
       t4 = new JTextField();
       t4.setBounds(270,260,150,30);
       add(t4);
       
       JLabel pay = new JLabel("Pay:");
       pay.setFont(new Font("Tahoma", Font.PLAIN , 16));
       pay.setBounds(140,310,100,30);
       add(pay); 
       
       t5 = new JTextField();
       t5.setBounds(270,310,150,30);
       add(t5);
       
       JLabel checkIn = new JLabel("CheckIn:");
       checkIn.setFont(new Font("Tahoma", Font.PLAIN , 16));
       checkIn.setBounds(140,360,100,30);
       add(checkIn); 
       
             
       d1 = new JDateChooser();
       d1.setDateFormatString("yyyy-MM-dd");
       d1.setBackground(Color.WHITE);
       d1.setBounds(270,360,150,30);
       add(d1);
       
       JLabel checkOut = new JLabel("CheckOut:");
       checkOut.setFont(new Font("Tahoma", Font.PLAIN , 16));
       checkOut.setBounds(140,410,100,30);
       add(checkOut); 
       
             
       d2 = new JDateChooser();
       d2.setDateFormatString("yyyy-MM-dd");
       d2.setBackground(Color.WHITE);
       d2.setBounds(270,410,150,30);
       add(d2);
       
       JLabel checkstat = new JLabel("CheckStatus:");
       checkstat.setFont(new Font("Tahoma", Font.PLAIN , 16));
       checkstat.setBounds(140,460,100,30);
       add(checkstat); 
       
       String stat[] = {"Yes","No"};
       c2 = new JComboBox(stat);
       c2.setBackground(Color.WHITE);
       c2.setBounds(270,460,150,30);
       add(c2);
            
       b1 = new JButton("Load");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(220,510,120,30);
       b1.addActionListener(this);
       add(b1);
       
       b2 = new JButton("Update");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(140,560,120,30);
       b2.addActionListener(this);
       add(b2);
       
       b3 = new JButton("Cancel");
       b3.setForeground(Color.WHITE);
       b3.setBackground(Color.BLACK);
       b3.setBounds(300,560,120,30);
       b3.addActionListener(this);
       add(b3);
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(300,60,600,650);
       setTitle("Hotel Lemon");
       setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setResizable(false);
       setLayout(null);
       setVisible(true);  
}
   
   public void actionPerformed(ActionEvent ae){
     
       if(ae.getSource()==b1){
        String roomno = (String) c1.getSelectedItem();
        conn c = new conn();
        String str = "select * from customer where allotedRoom='"+roomno+"'";
        
        try{
        
           ResultSet rs =  c.s.executeQuery(str);
           while(rs.next()){
             t1.setText(rs.getString("name"));  
             t2.setText(rs.getString("price"));
             t3.setText(rs.getString("deposit"));
             t4.setText(rs.getString("balance"));
             String da = rs.getString("checkIn");
             ((JTextField)d1.getDateEditor().getUiComponent()).setText(da);
             String da1 = rs.getString("checkOut");
             ((JTextField)d2.getDateEditor().getUiComponent()).setText(da1);
             c2.setSelectedItem(rs.getString("checkStat"));
           }
        
        }catch(Exception e){
          System.out.println(e);
        }
       }
       else if(ae.getSource() == b2){
          
         String roomno = (String) c1.getSelectedItem();
         String name = t1.getText();
         String price = t2.getText();
         String deposit = t3.getText();
         String pending = t4.getText();
         String pay = t5.getText();
         int b = Integer.parseInt(pending);
         int p = Integer.parseInt(pay);
         int pay1 = Integer.parseInt(pending) - Integer.parseInt(pay);
         int deposit1 = Integer.parseInt(deposit) + Integer.parseInt(pay);
         String pay2 = Integer.toString(pay1);
         String deposit2 = Integer.toString(deposit1);
         String checkIn = ((JTextField)d1.getDateEditor().getUiComponent()).getText();
         String checkOut = ((JTextField)d2.getDateEditor().getUiComponent()).getText();
         String checkStat = (String) c2.getSelectedItem();
         
         conn c = new conn();
         String str1 = "update customer set name = '"+name+"',price = '"+price+"', deposit = '"+deposit2+"', balance = '"+pay2+"', checkIn = '"+checkIn+"',checkOut = '"+checkOut+"',checkStat = '"+checkStat+"' where allotedRoom = '"+roomno+"'";   
         if (p > b){
            JOptionPane.showMessageDialog(null, "Payment is more than balance");
         }
         else{ 
         try{
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Check In Status Updated");
           new Reception().setVisible(true);
           this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
        }          
       }
       else if(ae.getSource() == b3){
          new Reception().setVisible(true);
          this.setVisible(false);
       }
       
   }

   public static void main(String[] args){
    new CheckInDetails().setVisible(true);   
   }
    
}
