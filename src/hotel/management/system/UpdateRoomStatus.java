
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateRoomStatus extends JFrame implements ActionListener{
    
    JTextField t2;
    JComboBox c1,c2,c3,c4;
    JButton b1,b2,b3,b4;
    Choice c5;
    
    UpdateRoomStatus(){
     
       JLabel name = new JLabel("Room No :");
       name.setFont(new Font("Tahoma", Font.PLAIN , 16));
       name.setBounds(60,50,120,30);
       add(name);
       
       c5 = new Choice();
       try{
           conn c = new conn();
           String str = "SELECT * FROM rooms;";
           ResultSet rs = c.s.executeQuery(str);
           
           while(rs.next()){
             c5.add(rs.getString("roomno"));
           }
           
       }catch(Exception e){}
       c5.setBounds(200,50,150,30);
       add(c5);
       
       JLabel status = new JLabel("Status :");
       status.setFont(new Font("Tahoma", Font.PLAIN , 16));
       status.setBounds(60,100,120,30);
       add(status);
       
       String stat[] = {"Available","Occupied","Maintenance"};
       c1 = new JComboBox(stat);
       c1.setBackground(Color.WHITE);
       c1.setBounds(200,100,150,30);
       add(c1);
       
       
       JLabel price = new JLabel("Price :");
       price.setFont(new Font("Tahoma", Font.PLAIN , 16));
       price.setBounds(60,150,120,30);
       add(price);
       
       t2 = new JTextField();
       t2.setBounds(200,150,150,30);
       add(t2);
       
         
       JLabel type = new JLabel("Bed Type :");
       type.setFont(new Font("Tahoma", Font.PLAIN , 16));
       type.setBounds(60,200,120,30);
       add(type);       
       
       String bedtype[] = {"Single Bed","Double Bed"};
       c2 = new JComboBox(bedtype);
       c2.setBackground(Color.WHITE);
       c2.setBounds(200,200,150,30);
       add(c2);
       
       JLabel roomtype = new JLabel("Room Type :");
       roomtype.setFont(new Font("Tahoma", Font.PLAIN , 16));
       roomtype.setBounds(60,250,120,30);
       add(roomtype);       
       
       String room_type[] = {"A/C","NON A/C"};
       c3 = new JComboBox(room_type);
       c3.setBackground(Color.WHITE);
       c3.setBounds(200,250,150,30);
       add(c3);
       
       JLabel cleanstat = new JLabel("Cleaning Status:");
       cleanstat.setFont(new Font("Tahoma", Font.PLAIN , 16));
       cleanstat.setBounds(60,300,120,30);
       add(cleanstat);       
       
       String clean_stat[] = {"Cleaned","Dirty"};
       c4 = new JComboBox(clean_stat);
       c4.setBackground(Color.WHITE);
       c4.setBounds(200,300,150,30);
       add(c4);
       
       b3 = new JButton("Load");
       b3.setForeground(Color.WHITE);
       b3.setBackground(Color.BLACK);
       b3.setBounds(60,350,120,30);
       b3.addActionListener(this);
       add(b3);
       
       
       b1 = new JButton("Update");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(220,350,120,30);
       b1.addActionListener(this);
       add(b1);
       
       b4 = new JButton("Delete");
       b4.setForeground(Color.WHITE);
       b4.setBackground(Color.BLACK);
       b4.setBounds(60,400,120,30);
       b4.addActionListener(this);
       add(b4);
       
       b2 = new JButton("Cancel");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(220,400,120,30);
       b2.addActionListener(this);
       add(b2);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/room.jpg"));
       Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(380,48,450,380);
       add(l1);
       
       
       JLabel title = new JLabel("UPDATE ROOM DETAILS");
       title.setFont(new Font("Verdana", Font.BOLD, 25));
       title.setBounds(435, 10, 400, 30);
       add(title);
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(250,150,900,510);
       setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setResizable(false);
       setTitle("Hotel Lemon");
       setLayout(null);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
       if(ae.getSource()==b3){
        String roomno = (String) c5.getSelectedItem();
        conn c = new conn();
        String str = "select * from rooms where roomno='"+roomno+"'";
        
        try{
        
           ResultSet rs =  c.s.executeQuery(str);
           while(rs.next()){
             c1.setSelectedItem(rs.getString("status"));  
             t2.setText(rs.getString("price"));
             c2.setSelectedItem(rs.getString("bedtype"));
             c3.setSelectedItem(rs.getString("roomtype"));
             c4.setSelectedItem(rs.getString("cleanstat"));
           }
        
        }catch(Exception e){
          System.out.println(e);
        }
       }
       else if(ae.getSource()== b1){
         
         String roomno = (String) c5.getSelectedItem();
         String price = t2.getText();
         String status = (String) c1.getSelectedItem();
         String bedtype = (String) c2.getSelectedItem();
         String roomtype = (String) c3.getSelectedItem();
         String cleanstat = (String) c4.getSelectedItem();
         
         conn c = new conn();
         String str1 = "update rooms set price = '"+price+"',status = '"+status+"', bedtype = '"+bedtype+"', roomtype = '"+roomtype+"', cleanstat = '"+cleanstat+"' where roomno = '"+roomno+"'";  
         try{
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Room Status Updated");
           new Reception().setVisible(true);
           this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
                 
       }else if(ae.getSource() == b2){
          new Reception().setVisible(true);
          this.setVisible(false);
       }
       
        else if(ae.getSource()==b4){
        
         String id = (String) c5.getSelectedItem();
             
         conn c = new conn();
         String str1 = "delete from rooms where roomno = '"+id+"'";  
         try{
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Room Deleted");
           new Reception().setVisible(true);
           this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
                       
       }  
       
    }
    
    public static void main(String[] args){
      new UpdateRoomStatus().setVisible(true);
    }
    
}
