import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class billing implements ActionListener
{
static String path1="",name="",course="",fee="",regn="";
JFrame Fr;
JLabel l1,l2,l3,l_pic,lmsg,l_pic2,lint,lfin,l4,l5;
JTextField t1,t2,t3,t4;
JPanel P,P1;
JButton b1,b2,b3,b4,b5,b6;
Timer t;
int count;
billing()
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
l_pic2.setBounds(100,120,600,300);
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
lint=new JLabel("<html><body><font color=purple size=4>Students--</font></body></html>");
lint.setBounds(80,400,300,40);
Fr.add(lint);
P= new JPanel();

P.setLayout(new GridLayout(4,2));
P.setBounds(80,450,300,100);

l1=new JLabel("Username:");
l2=new JLabel("Password:");
t1=new JTextField();
t2=new JTextField();
b1=new JButton("LOGIN");
b1.addActionListener(this);
b2=new JButton("RESET");
b2.addActionListener(this);
b3=new JButton("REGISTER");
b3.addActionListener(this);
b4=new JButton("EXIT");
b4.addActionListener(this);
P.add(l1);
P.add(t1);
P.add(l2);
P.add(t2);
P.add(b1);
P.add(b2);
P.add(b3);
P.add(b4);
Fr.add(P);
lfin=new JLabel("<html><body><font color=purple size=4>Admin--</font></body></html>");
lfin.setBounds(450,400,300,40);
Fr.add(lfin);
P1= new JPanel();

P1.setLayout(new GridLayout(3,2));
P1.setBounds(450,450,300,70);

l3=new JLabel("Username:");
l4=new JLabel("Password:");
t3=new JTextField();
t4=new JTextField();
b5=new JButton("LOGIN");
b5.addActionListener(this);
b6=new JButton("RESET");
b6.addActionListener(this);
P1.add(l3);
P1.add(t3);
P1.add(l4);
P1.add(t4);
P1.add(b5);
P1.add(b6);
Fr.add(P1);
Fr.setLayout(null);
Fr.setBounds(0,0,900,800);
Fr.setVisible(true);

}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==b1)
{
Connection conn;
PreparedStatement pst;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("select * from regs where name=? and roll=?");
pst.setString(1,t1.getText());
pst.setInt(2,Integer.parseInt(t2.getText()));
ResultSet rs=pst.executeQuery();
if(rs.next())
{
Fr.dispose();
path1=rs.getString(5);
name=rs.getString(1);
course=rs.getString(4);
regn=rs.getString(3);
new profile();
}
else{
JOptionPane.showMessageDialog(null,"Invalid User");
}
conn.close();
pst.close();
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
}
if(k.getSource()==b3)
{
Fr.dispose();
new reg();
}
if(k.getSource()==b4)
{
Fr.dispose();
}
if(k.getSource()==b5)
{
Connection conn;
PreparedStatement pst;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("select * from admn where usrnm=? and pswd=?");
pst.setString(1,t3.getText());
pst.setString(2,t4.getText());
ResultSet rs=pst.executeQuery();
if(rs.next())
{
Fr.dispose();
new admin();
}
else
{
JOptionPane.showMessageDialog(null,"Invalid User");
}
conn.close();
pst.close();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error-"+e);
}
}
if(k.getSource()==b6)
{
t3.setText("");
t4.setText("");
}
}
public static void main(String kr[])
{
new billing();
}
}