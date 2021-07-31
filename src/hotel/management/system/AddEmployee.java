package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;


public class AddEmployee extends JFrame implements ActionListener {
  
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1;
    JDateChooser dc;
    JRadioButton r1,r2;
    
    
   AddEmployee(){
     
       JLabel name = new JLabel("Name :");
       name.setFont(new Font("Tahoma", Font.PLAIN , 17));
       name.setBounds(60,30,120,30);
       add(name);
       
       t1 = new JTextField();
       t1.setBounds(200,30,150,30);
       add(t1);
       
       JLabel address = new JLabel("Address:");
       address.setFont(new Font("Tahoma", Font.PLAIN , 17));
       address.setBounds(60,80,120,30);
       add(address);
       
       t2 = new JTextField();
       t2.setBounds(200,80,150,30);
       add(t2);
       
       JLabel DOB = new JLabel("Date of Birth:");
       DOB.setFont(new Font("Tahoma", Font.PLAIN , 17));
       DOB.setBounds(60,130,120,30);
       add(DOB);
       
       dc = new JDateChooser();
       dc.setDateFormatString("yyyy-MM-dd");
       
       Calendar cal = Calendar.getInstance();
       cal.add(Calendar.YEAR, -70);//15 year before
       Date min = cal.getTime();
       Calendar cal1 = Calendar.getInstance();
       cal1.add(Calendar.YEAR, -18);
       Date max = cal1.getTime();
       
       dc.setSelectableDateRange(min, max);
       dc.setBackground(Color.WHITE);
       dc.setBounds(200,130,150,30);
       add(dc);
       
       JLabel gender = new JLabel("Gender :");
       gender.setFont(new Font("Tahoma", Font.PLAIN , 17));
       gender.setBounds(60,180,120,30);
       add(gender);
       
       r1 = new JRadioButton("Male");
       r1.setFont(new Font("Tahoma", Font.PLAIN , 17));
       r1.setBackground(Color.WHITE);
       r1.setBounds(200,180,60,30);
       add(r1);
       
       r2 = new JRadioButton("Female");
       r2.setFont(new Font("Tahoma", Font.PLAIN , 17));
       r2.setBackground(Color.WHITE);
       r2.setBounds(280,180,100,30);
       add(r2);
       
       ButtonGroup bg=new ButtonGroup();    
       bg.add(r1); bg.add(r2);
       
       JLabel job = new JLabel("JOB :");
       job.setFont(new Font("Tahoma", Font.PLAIN, 17));
       job.setBounds(60, 230, 120, 30);
       add(job);
			
       String jobOption[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
       c1 = new JComboBox(jobOption);
       c1.setBackground(Color.WHITE);
       c1.setBounds(200,230,150,30);
       add(c1);
       
       JLabel sal = new JLabel("SALARY :");
       sal.setFont(new Font("Tahoma", Font.PLAIN, 17));
       sal.setBounds(60, 280, 150, 30);
       add(sal);
			
       t3 = new JTextField();
       t3.setBounds(200, 280, 150, 30);
       add(t3);
	
       JLabel phone = new JLabel("PHONE :");
       phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
       phone.setBounds(60, 330, 150, 27);
       add(phone);
	
       t4 = new JTextField();
       t4.setBounds(200, 330, 150, 30);
       add(t4);
	
       JLabel aadhar = new JLabel("AADHAR :");
       aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
       aadhar.setBounds(60, 380, 120, 27);
       add(aadhar);
			
       t5 = new JTextField();
       t5.setBounds(200, 380, 150, 30);
       add(t5);
       
       JLabel shifts = new JLabel("Shift :");
       shifts.setFont(new Font("Tahoma", Font.PLAIN, 17));
       shifts.setBounds(60, 430, 120, 27);
       add(shifts);
			
       String shiftOption[] = {"9 A.M. - 7 P.M.","7 P.M. - 9 A.M."};
       c2 = new JComboBox(shiftOption);
       c2.setBackground(Color.WHITE);
       c2.setBounds(200,430,150,30);
       add(c2);
            
       
       b1 = new JButton("Submit");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.addActionListener(this);
       b1.setBounds(80,490,200,30);
       add(b1);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/images/tenth.jpg"));
       Image i2 = i1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l1 = new JLabel(i3);
       l1.setBounds(380,60,450,450);
       add(l1);
       
     
       
       JLabel title = new JLabel("ADD EMPLOYEE DETAILS");
       title.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
       title.setBounds(420, 30, 400, 30);
       add(title);
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       setBounds(230,100,900,600);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("hotel/management/system/images/i2.png")).getScaledInstance(500, 500, Image.SCALE_DEFAULT));
       setTitle("Hotel Lemon");
       setResizable(false);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
     String name = t1.getText();
     String address = t2.getText();
     String dob = ((JTextField)dc.getDateEditor().getUiComponent()).getText();
     String sal = t3.getText();
     String phone = t4.getText();
     String aadhar = t5.getText();
     
     String gender = null;
     
     if(r1.isSelected()){
      gender = "Male";
     }
     else if(r2.isSelected()){
       gender = "Female";
     }
             
     String job = (String) c1.getSelectedItem();
     String shift = (String) c2.getSelectedItem();
     
     conn c = new conn();
     
     if(name.length()== 0 || address.length() == 0 || dob.length() == 0 || sal.length() == 0 || phone.length() == 0 || aadhar.length() == 0 || job.length() == 0 || shift.length() == 0){
        JOptionPane.showMessageDialog(null,"Fields cannot be empty");    
     }
     else if(phone.length() != 10 || aadhar.length() != 12 ){
     JOptionPane.showMessageDialog(null,"Phone no should be of 10 digits and aadhar should be of 12 digits");  
   }
     else{         
     String str = "insert into employee (name,address,gender,job,dob,aadhar,phone,salary,shift) values('"+name+"','"+address+"','"+gender+"','"+job+"','"+dob+"','"+aadhar+"','"+phone+"','"+sal+"','"+shift+"');";
     try{
     c.s.executeUpdate(str);
     JOptionPane.showMessageDialog(null,"New Employee Added");
     this.setVisible(false);
     }
     catch(Exception e){
      System.out.println(e);
     }
     
     }
   }
   
   public static void main(String[] args){
     new AddEmployee();
   }
     
}
