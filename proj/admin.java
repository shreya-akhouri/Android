import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

class admin implements ActionListener
{
JFrame Fr;
JLabel l1,l2,l3,l4,l_pic,lmsg,l_pic2,lmsg2,lpic,l5,l6,l7,l8,l9;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
JPanel P,P_new,P_update,P_stud,P_del;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
Timer t;
int count;
JMenuBar jmb;
JMenu m1,m2,m3,m4;
JMenuItem i1,i2,i3,i4,i5,i6;
admin()
{

count=1;
Fr=new JFrame();
l_pic=new JLabel();
l_pic.setBounds(0,0,200,100);
l_pic.setIcon(new ImageIcon("C:/Users/Shreya/Desktop/pictures/iconn.png"));
Fr.add(l_pic);
lmsg=new JLabel("<html><body><font color=blue size=8>Student Helpdesk</font></body></html>");
Fr.add(lmsg);
lmsg.setBounds(210,30,400,50);

l_pic2=new JLabel();
l_pic2.setIcon(new ImageIcon("C:/Users/Shreya/Desktop/pictures/k4.png"));
l_pic2.setBounds(100,120,600,220);
t=new Timer(1000,new ActionListener(){
public void actionPerformed(ActionEvent k)
{
if(count==5)
count=1;
l_pic2.setIcon(new ImageIcon("C:/Users/Shreya/Desktop/pictures/"+"k"+count+".png"));
count++;
}
});
t.start();
Fr.add(l_pic2);
jmb=new JMenuBar();
jmb.setBounds(0,340,500,30);
m1=new JMenu("Course");
i1=new JMenuItem("Add course");
i1.addActionListener(this);
i2=new JMenuItem("Delete course");
i2.addActionListener(this);
i3=new JMenuItem("Update fee");
i3.addActionListener(this);
m2= new JMenu("Certificates");
i4=new JMenuItem("Students");
i4.addActionListener(this);
m3=new JMenu("Student");
i6=new JMenuItem("show record");
i6.addActionListener(this);
m4=new JMenu("Back");
i5=new JMenuItem("back");
i5.addActionListener(this);
jmb.add(m1);
jmb.add(m2);
jmb.add(m3);
jmb.add(m4);
m2.add(i4);
m1.add(i1);
m1.add(i2);
m1.add(i3);
m3.add(i6);
m4.add(i5);
Fr.add(jmb);
P_new=new JPanel();
P_new.setLayout(new GridLayout(4,2));
P_new.setBounds(280,400,200,100);
l1=new JLabel("Course Name:");
t1=new JTextField();
l2=new JLabel("Fee:");
t2=new JTextField();
l3=new JLabel("Duration:");
t3=new JTextField();
b1=new JButton("SAVE");
b1.addActionListener(this);
b2=new JButton("RESET");
b2.addActionListener(this);
P_new.add(l1);
P_new.add(t1);
P_new.add(l2);
P_new.add(t2);
P_new.add(l3);
P_new.add(t3);
P_new.add(b1);
P_new.add(b2);
P_new.setVisible(false);
Fr.add(P_new);
P_del=new JPanel();
P_del.setLayout(new GridLayout(2,2));
P_del.setBounds(280,400,200,50);
l4=new JLabel("Course:");
t4=new JTextField();
b3=new JButton("DELETE");
b3.addActionListener(this);
b4=new JButton("RESET");
b4.addActionListener(this);
P_del.add(l4);
P_del.add(t4);
P_del.add(b3);
P_del.add(b4);
P_del.setVisible(false);
Fr.add(P_del);
P_update=new JPanel();
P_update.setLayout(new GridLayout(3,2));
P_update.setBounds(280,400,200,100);
l5=new JLabel("Course name:");
t5=new JTextField();
l6=new JLabel("Fee to be updated:");
t6=new JTextField();
b5=new JButton("UPDATE");
b5.addActionListener(this);
b6=new JButton("RESET");
b6.addActionListener(this);
P_update.add(l5);
P_update.add(t5);
P_update.add(l6);
P_update.add(t6);
P_update.add(b5);
P_update.add(b6);
P_update.setVisible(false);
Fr.add(P_update);
P_stud=new JPanel();
P_stud.setLayout(new GridLayout(3,2));
P_stud.setBounds(280,400,200,50);
l7=new JLabel("Enter Reg no.:");
t7=new JTextField();
l8=new JLabel("Status:");
t8=new JTextField();
b7=new JButton("SAVE");
b7.addActionListener(this);
b9=new JButton("RESET");
b9.addActionListener(this);
P_stud.add(l7);
P_stud.add(t7);
P_stud.add(l8);
P_stud.add(t8);
P_stud.add(b7);
P_stud.add(b9);
P_stud.setVisible(false);
Fr.add(P_stud);

Fr.setLayout(null);
Fr.setBounds(0,0,900,800);
Fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==i6)
{
Fr.dispose();
new jtablee();
}
if(k.getSource()==i5)
{
Fr.dispose();
new billing();
}
if(k.getSource()==i1)
{
P_new.setVisible(true);
P_update.setVisible(false);
P_stud.setVisible(false);
P_del.setVisible(false);
}
if(k.getSource()==i2)
{
P_new.setVisible(false);
P_update.setVisible(false);
P_stud.setVisible(false);
P_del.setVisible(true);
}
if(k.getSource()==i3)
{
P_new.setVisible(false);
P_update.setVisible(true);
P_stud.setVisible(false);
P_del.setVisible(false);
}
if(k.getSource()==i4)
{
P_new.setVisible(false);
P_update.setVisible(false);
P_stud.setVisible(true);
P_del.setVisible(false);
}
if(k.getSource()==b1)
{
Connection conn;
PreparedStatement pst;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("Insert into crse values(?,?,?)");
pst.setString(1,t1.getText());
pst.setInt(2,Integer.parseInt(t2.getText()));
pst.setString(3,t3.getText());
pst.executeUpdate();
JOptionPane.showMessageDialog(null,"DATA SAVED");

conn.close();
pst.close();
Fr.dispose();
new admin();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error-"+e);

}
}
if(k.getSource()==b2)
{
t1.setText("");
t2.setText("");
t3.setText("");
}
if(k.getSource()==b3)
{
Connection conn;
PreparedStatement pst;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("Delete from crse where cnme=?");
pst.setString(1,t4.getText());
pst.executeUpdate();
JOptionPane.showMessageDialog(null,"DATA DELETED");

conn.close();
pst.close();
Fr.dispose();
new admin();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error-"+e);

}
}
if(k.getSource()==b4)
{
t4.setText("");
}
if(k.getSource()==b5)
{
Connection conn;
PreparedStatement pst;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("update crse set fee=? where cnme=?");
pst.setString(1,t6.getText());
pst.setString(2,t5.getText());
pst.executeUpdate();

JOptionPane.showMessageDialog(null,"FEE UPDATED");

conn.close();
pst.close();
Fr.dispose();
new admin();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error-"+e);

}
}
if(k.getSource()==b6)
{
}
if(k.getSource()==b7)
{
Connection conn;
PreparedStatement pst;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("Insert into cert values(?,?)");
pst.setString(1,t7.getText());
pst.setString(2,t8.getText());
pst.executeUpdate();
JOptionPane.showMessageDialog(null,"DATA SAVED");

conn.close();
pst.close();
Fr.dispose();
new admin();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error-"+e);

}
}
if(k.getSource()==b9)
{
}
}

public static void main(String kr[])
{
new admin();
}
}