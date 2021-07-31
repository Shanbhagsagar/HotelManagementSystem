
package hotel.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class UpdateEmployeeStatus extends JFrame implements ActionListener {
    
    Choice c1;
    JTextField t1,t2,t3,t4,t5,t6;
    JDateChooser dc1;
    JComboBox c2,c3,c4;
    JRadioButton r1,r2;
    JButton b1,b2,b3,b4;  
    
    UpdateEmployeeStatus(){
       JLabel title = new JLabel("Update Employee Status");
       title.setFont(new Font("Verdana", Font.BOLD, 25));
       title.setBounds(110, 10, 400, 30);
       add(title);
       
       
       JLabel did = new JLabel("Employee ID:");
       did.setFont(new Font("Tahoma", Font.PLAIN , 16));
       did.setBounds(140,60,100,30);
       add(did);   
       
       c1 = new Choice();
       try{
           conn c = new conn();
           String str = "select * from employee;";
           ResultSet rs = c.s.executeQuery(str);
           
           while(rs.next()){
             c1.add(Integer.toString(rs.getInt("id")));
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
       
       
       JLabel address = new JLabel("Address:");
       address.setFont(new Font("Tahoma", Font.PLAIN , 17));
       address.setBounds(140,160,100,30);
       add(address); 
       
       t2 = new JTextField();
       t2.setBounds(270,160,150,30);
       add(t2);
       
        JLabel DOB = new JLabel("DOB:");
       DOB.setFont(new Font("Tahoma", Font.PLAIN , 17));
       DOB.setBounds(140,210,100,30);
       add(DOB); 
       
       dc1 = new JDateChooser();
       dc1.setDateFormatString("yyyy-MM-dd");
       dc1.setBackground(Color.WHITE);
       dc1.setBounds(270,210,150,30);
       add(dc1);
       
        JLabel gender = new JLabel("Gender :");
       gender.setFont(new Font("Tahoma", Font.PLAIN , 17));
       gender.setBounds(140,260,100,30);
       add(gender); 
       
       String gen[] = {"Male","Female"};
       c2 = new JComboBox(gen);
       c2.setBackground(Color.WHITE);
       c2.setBounds(270,260,150,30);
       add(c2);
       
       JLabel job = new JLabel("JOB :");
       job.setFont(new Font("Tahoma", Font.PLAIN, 17));
       job.setBounds(140,310,100,30);
       add(job); 
       
       String jobOption[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
       c3 = new JComboBox(jobOption);
       c3.setBackground(Color.WHITE);
       c3.setBounds(270,310,150,30);
       add(c3);
       
       JLabel sal = new JLabel("SALARY :");
       sal.setFont(new Font("Tahoma", Font.PLAIN, 17));
       sal.setBounds(140,360,100,30);
       add(sal); 
       
       
       t3 = new JTextField();
       t3.setBounds(270,360,150,30);
       add(t3);
       
       
       JLabel phone = new JLabel("PHONE :");
       phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
       phone.setBounds(140,410,100,30);
       add(phone); 
       
             
       t4 = new JTextField();
       t4.setBounds(270,410,150,30);
       add(t4);
       
           
       JLabel aadhar = new JLabel("AADHAR :");
       aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
       aadhar.setBounds(140,460,100,30);
       add(aadhar); 
       
             
       t5 = new JTextField();
       t5.setBounds(270,460,150,30);
       add(t5);
       
       
       JLabel shifts = new JLabel("Shift :");
       shifts.setFont(new Font("Tahoma", Font.PLAIN, 17));
       shifts.setBounds(140,510,100,30);
       add(shifts); 
       
             
        String shiftOption[] = {"9 A.M. - 7 P.M.","7 P.M. - 9 A.M."};
       c4 = new JComboBox(shiftOption);
       c4.setBackground(Color.WHITE);
       c4.setBounds(270,510,150,30);
       add(c4);
       
       b1 = new JButton("Load");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(140,560,120,30);
       b1.addActionListener(this);
       add(b1);
       
       b2 = new JButton("Update");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(300,560,120,30);
       b2.addActionListener(this);
       add(b2);
       
       b4 = new JButton("Delete");
       b4.setForeground(Color.WHITE);
       b4.setBackground(Color.BLACK);
       b4.setBounds(140,610,120,30);
       b4.addActionListener(this);
       add(b4);
       
       b3 = new JButton("Cancel");
       b3.setForeground(Color.WHITE);
       b3.setBackground(Color.BLACK);
       b3.setBounds(300,610,120,30);
       b3.addActionListener(this);
       add(b3);
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(320,50,600,750);
       setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setResizable(false);
       setTitle("Hotel Lemon");
       setLayout(null);
       setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent ae){
    
         if(ae.getSource()==b1){
        String id = (String) c1.getSelectedItem();
        conn c = new conn();
        String str = "select * from employee where id='"+id+"'";
        
        try{
        
           ResultSet rs =  c.s.executeQuery(str);
           while(rs.next()){
             t1.setText(rs.getString("name"));  
             t2.setText(rs.getString("address"));
             t3.setText(rs.getString("salary"));
             t4.setText(rs.getString("phone"));
             c2.setSelectedItem(rs.getString("gender"));
             c3.setSelectedItem(rs.getString("job"));
             t5.setText(rs.getString("aadhar"));
             c4.setSelectedItem(rs.getString("shift"));
             String dt = rs.getString("dob");             
             ((JTextField)dc1.getDateEditor().getUiComponent()).setText(dt);
           }
        
        }catch(Exception e){
          System.out.println(e);
        }
       }
       
       else if(ae.getSource()==b2){
           
         String id = (String) c1.getSelectedItem();
         String name = t1.getText();
         String address = t2.getText();
         String dob =  ((JTextField)dc1.getDateEditor().getUiComponent()).getText();
         String gender = (String) c2.getSelectedItem();
         String job = (String) c3.getSelectedItem();
         String salary = t3.getText();
         String phone = t4.getText();
         String aadhar = t5.getText();
         String shift = (String) c4.getSelectedItem();
         
         
         conn c = new conn();
         String str1 = "update employee set name = '"+name+"',address = '"+address+"', dob = '"+dob+"', gender = '"+gender+"', job = '"+job+"', salary ='"+salary+"',phone = '"+phone+"', aadhar = '"+aadhar+"' , shift = '"+shift+"' where id = "+id;  
         try{
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Employee Status Updated");
            this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
        
       }  
       else if(ae.getSource()==b3){
            this.setVisible(false);
       }
        
        else if(ae.getSource()==b4){
        
         String id = (String) c1.getSelectedItem();
         conn c = new conn();
         String str1 = "delete from employee where id = "+id;  
         try{
           c.s.executeUpdate(str1);
           JOptionPane.showMessageDialog(null, "Employee Deleted");
           this.setVisible(false);
         }
         catch(Exception e){
           System.out.println(e);
         }
            
            
       }  
    
    }
    
    public static void main(String[] args){
       new UpdateEmployeeStatus().setVisible(true);
    }
}
