import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
class paymnt implements ActionListener
{
JTextArea ta;
 JButton b,b1;
 JFrame fr;
 JTable jt;
 JScrollPane s;
int a;

 Object r[][]=new Object[100][100];
 Object c[]={"REG NO","NAME","COURSE","FEE"};
paymnt()
{
 fr=new JFrame();
ta=new JTextArea();
ta.setBounds(0,0,400,500);
Connection conn;
PreparedStatement pst;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("select * from pymnt where regn=?");
pst.setInt(1,Integer.parseInt(profile.regn));
ResultSet rs=pst.executeQuery();
while(rs.next())
{
r[a][0]=rs.getInt(1);
r[a][1]=rs.getString(2);
r[a][2]=rs.getString(3);
r[a][3]=rs.getString(4);
a++;
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error-"+e);
}
jt=new JTable(r,c);
s=new JScrollPane(jt);
ta.add(s);
s.setBounds(0,0,400,300);

fr.add(ta);
b=new JButton("Print");
b.setBounds(0,500,100,30);
b.addActionListener(this);
fr.add(b);
b1=new JButton("Back");
b1.setBounds(300,500,100,30);
fr.add(b1);
b1.addActionListener(this);
fr.setLayout(null);
fr.setBounds(0,0,600,700);
fr.setVisible(true);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==b)
{
try
{
ta.print();
}
catch(Exception j)
{
}
}
if(k.getSource()==b1)
{
fr.dispose();
new profile();
}
}
public static void main( String[] args )
 {
new paymnt();
	}
}