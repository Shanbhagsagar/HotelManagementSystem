
package hotel.management.system;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateDriverStatus extends JFrame implements ActionListener {
    
    Choice c1;
    JTextField t1,t2,t3,t4,t5,t6;
    JDateChooser d1,d2;
    JComboBox c2;
    JButton b1,b2,b3,b4;  
    
    UpdateDriverStatus(){
    
       JLabel title = new JLabel("Update Driver Status");
       title.setFont(new Font("Verdana", Font.BOLD, 25));
       title.setBounds(135, 10, 400, 30);
       add(title);
       
       
       JLabel did = new JLabel("Driver ID:");
       did.setFont(new Font("Tahoma", Font.PLAIN , 16));
       did.setBounds(140,60,100,30);
       add(did);   
       
       c1 = new Choice();
       try{
           conn c = new conn();
           String str = "SELECT * FROM drivers ;";
           ResultSet rs = c.s.executeQuery(str);
           
           while(rs.next()){
             c1.add(rs.getString("did"));
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
       
       
       JLabel phone = new JLabel("Phone :");
       phone.setFont(new Font("Tahoma", Font.PLAIN , 16));
       phone.setBounds(140,160,100,30);
       add(phone); 
       
       t2 = new JTextField();
       t2.setBounds(270,160,150,30);
       add(t2);
       
       JLabel carmodel = new JLabel("Car Model:");
       carmodel.setFont(new Font("Tahoma", Font.PLAIN , 16));
       carmodel.setBounds(140,210,100,30);
       add(carmodel); 
       
       t3 = new JTextField();
       t3.setBounds(270,210,150,30);
       add(t3);
       
       JLabel clicense = new JLabel("Car license:");
       clicense.setFont(new Font("Tahoma", Font.PLAIN , 16));
       clicense.setBounds(140,260,100,30);
       add(clicense); 
       
       t4 = new JTextField();
       t4.setBounds(270,260,150,30);
       add(t4);
       
       JLabel status = new JLabel("Status:");
       status.setFont(new Font("Tahoma", Font.PLAIN , 16));
       status.setBounds(140,310,100,30);
       add(status); 
       
       String carstat[] = {"Available","Occupied","Not Available"};
       c2 = new JComboBox(carstat);
       c2.setBackground(Color.WHITE);
       c2.setBounds(270,310,150,30);
       add(c2);
       
       JLabel room = new JLabel("G-RoomNo:");
       room.setFont(new Font("Tahoma", Font.PLAIN , 16));
       room.setBounds(140,360,100,30);
       add(room); 
       
       
       t5 = new JTextField();
       t5.setBounds(270,360,150,30);
       add(t5);
       
       
       JLabel loc = new JLabel("Location:");
       loc.setFont(new Font("Tahoma", Font.PLAIN , 16));
       loc.setBounds(140,410,100,30);
       add(loc); 
       
             
       t6 = new JTextField();
       t6.setBounds(270,410,150,30);
       add(t6);
       
            
       JLabel pickup = new JLabel("Pickup Date:");
       pickup.setFont(new Font("Tahoma", Font.PLAIN , 16));
       pickup.setBounds(140,460,100,30);
       add(pickup); 
       
             
       d1 = new JDateChooser();
       d1.setDateFormatString("yyyy-MM-dd");
       d1.setBackground(Color.WHITE);
       d1.setBounds(270,460,150,30);
       add(d1);
       
       b1 = new JButton("Load");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(140,510,120,30);
       b1.addActionListener(this);
       add(b1);
       
      b2 = new JButton("Update");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(300,510,120,30);
       b2.addActionListener(this);
       add(b2);
       
       b4 = new JButton("Delete");
       b4.setForeground(Color.WHITE);
       b4.setBackground(Color.BLACK);
       b4.setBounds(140,560,120,30);
       b4.addActionListener(this);
       add(b4);
       
       b3 = new JButton("Cancel");
       b3.setForeground(Color.WHITE);
       b3.setBackground(Color.BLACK);
       b3.setBounds(300,560,120,30);
       b3.addActionListener(this);
       add(b3);
       
       
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(350,50,600,680);
       setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setResizable(false);
       setTitle("Hotel Lemon");
       setLayout(null);
       setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource()==b1){
        String driverid = (String) c1.getSelectedItem();
        conn c = new conn();
        String str = "select * from drivers where did='"+driverid+"'";
        
        try{
        
           ResultSet rs =  c.s.executeQuery(str);
           while(rs.next()){
             t1.setText(rs.getString("name"));  
             t2.setText(rs.getString("phone"));
             t3.setText(rs.getString("carmodel"));
             t4.setText(rs.getString("clicense"));
             c2.setSelectedItem(rs.getString("status"));
             t5.setText(rs.getString("groomno"));
             t6.setText(rs.getString("location"));
             String da = rs.getString("pickupdate");             
             ((JTextField)d1.getDateEditor().getUiComponent()).setText(da);
           }
        
        }catch(Exception e){
          System.out.println(e);
        }
       }
       else if(ae.getSource()== b2){
         
         String did = (String) c1.getSelectedItem();
         String name = t1.getText();
         String phone = t2.getText();
         String carmodel = t3.getText();
         String clicense = t4.getText();
         String status = (String) c2.getSelectedItem();
         String groomno = t5.getText();
         String location = t6.getText();
         String pickupdate =  ((JTextField)d1.getDateEditor().getUiComponent()).getText();
         
         conn c = new conn();
         String str1 = "update drivers set name = '"+name+"',phone = '"+phone+"', carmodel = '"+carmodel+"', clicense = '"+clicense+"', status = '"+status+"',groomno ='"+groomno+"',location = '"+location+"',pickupdate = '"+pickupdate+"' where did = "+did;  
         try{
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Room Status Updated");
           new Reception().setVisible(true);
           this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
                 
       }
        else if(ae.getSource() == b3){
          new Reception().setVisible(true);
          this.setVisible(false);
       }
       
         else if(ae.getSource()==b4){
        
         String id = (String) c1.getSelectedItem();
             
         conn c = new conn();
         String str1 = "delete from drivers where did = "+id;  
         try{
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Driver Deleted");
           new Reception().setVisible(true);
           this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
                       
       }  
        
    }    
    
    public static void main(String[] args){
      new UpdateDriverStatus().setVisible(true);
    }
}
