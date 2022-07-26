import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class Book_database extends JFrame implements ActionListener{
	static JFrame f,f1,f2,f3,f4;
	static JMenuBar mb;
	static JMenu Db;
	static JMenuItem insert,update,delete,display,exit,show;
    static String sid,suser,spass;
    static JTextArea t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    static JButton b1,b2,b3,b4,b5;
	static void insert(String a1,String a2,String a3, String a4,String a5){
		try
		{
			DAO db=new DAO();
			Connection conn=db.getConnection();
	
			 String name=a1;
			 String author=a2;
			 int price=Integer.parseInt(a5);
			 int quantity=Integer.parseInt(a4);
			 int pages=Integer.parseInt(a4);
			 
			 String insertQuery="insert into booktable values(?,?,?,?,?)";
			 PreparedStatement preparedStatement;
			 
			 preparedStatement=conn.prepareStatement(insertQuery);
			 preparedStatement.setString(1,name);
			 preparedStatement.setString(2,author);
			 preparedStatement.setString(3,price+"");
			 preparedStatement.setString(4,quantity+"");
			 preparedStatement.setString(5,pages+"");
			 
			 preparedStatement.executeUpdate();
			 
			 l5.setForeground(Color.green);
			 l5.setText("Data Entered Succesfully ");
			 
			 
			 
		}
		catch(Exception e){
			 System.out.println(e);
			 l5.setForeground(Color.red);
			 l5.setText("Exception Occur_Cant submit the data!!");
			
		}
		}
		static String delete(String p){
			String ret="No Record Found!!";
			try{
				DAO db=new DAO();
				Connection conn=db.getConnection();
		
				String name=p;
				
				String deleteQuery="delete from booktable where name=?";
				PreparedStatement preparedStatement;
				
				preparedStatement=conn.prepareStatement(deleteQuery);
				preparedStatement.setString(1, name);
				
				int count=preparedStatement.executeUpdate();
				if(count==0){
					System.out.println("No record Found With Name ");
					return ret;
					}
				else
					{
					//System.out.println("Total "+count+"Record Deleted!!");
					ret="Data deleted Succesfully ";
					return ret;}
				
				
			}
			catch(Exception e){
				System.out.println(e);	
				ret="Exception Occur_Cant Delete the data!!";
				return ret;
				}
		}
		static String search(String b1){
			try{
				DAO db=new DAO();
				Connection conn=db.getConnection();
			
				String selectQuery="select * from booktable";
				PreparedStatement preparedStatement;
				
				String s1=b1;
				preparedStatement=conn.prepareStatement(selectQuery);
				ResultSet result=preparedStatement.executeQuery();
				
				String data="Book Not Found!!";
				while(result.next()){
					if(s1.equalsIgnoreCase(result.getString(1))){
						data="  Name of Book "+result.getString(1)+"/n  Author Name "+result.getString(2)+"/n  Number of Books Available "+result.getString(3)+"/n  Number Of Pages "+result.getString(4);
					}
				}
				return data;
				}
				catch(Exception e){
					return e+"";
				}
		}
	Book_database(){
		f=new JFrame("Book Database");
		f.setLayout(null);
		f.setVisible(true);
		//f.setVisible(false);
		f.setBounds(600, 200, 400, 450);
		
		mb=new JMenuBar();
		mb.setBounds(0,0,800,40);
		f.add(mb);
		
		Db=new JMenu("Book Management ");
		mb.add(Db);
		
		insert=new JMenuItem("Insert");
		insert.addActionListener(this);
		Db.add(insert);
		
		delete=new JMenuItem("Delete");
		delete.addActionListener(this);
		Db.add(delete);
		
		show=new JMenuItem("Display");
		show.addActionListener(this);
		Db.add(show);
		
		display=new JMenuItem("Search");
		display.addActionListener(this);
		Db.add(display);
		
		exit=new JMenuItem("Exit");
		exit.addActionListener(this);
		Db.add(exit);
		
		/*---------------frame 1 for Insertion-------------------*/
				f1=new JFrame();
				f1.setLayout(null);
				f1.setVisible(false);
				//f1.setVisible(true);
				f1.setBounds(400, 200, 800, 600);
				
				l1=new JLabel("Insert Into Database");
				l1.setFont(l1.getFont().deriveFont(20.85632412f));
				l1.setBounds(220, 50, 300, 20);
				f1.add(l1);
				
				l2=new JLabel("Enter the Book Name ");
				l2.setBounds(150, 150, 150, 20);
				f1.add(l2);
				
				l3=new JLabel("Enter Author Name  ");
				l3.setBounds(150, 200, 150, 20);
				f1.add(l3);
				
				l4=new JLabel("Enter the Price ");
				l4.setBounds(150, 250, 150, 20);
				f1.add(l4);
				
				l7=new JLabel("Enter the Quantity ");
				l7.setBounds(150,300,150,20);
				f1.add(l7);
				
				l6=new JLabel("Enter the Number of Pages ");
				l6.setBounds(150,350,150,20);
				f1.add(l6);
				
				l5=new JLabel();
				l5.setBounds(260, 450, 250, 20);
				f1.add(l5);
				
				Border border = BorderFactory.createLineBorder(Color.gray, 2);
				t1=new JTextArea();
				t1.setBounds(360,150,100,20);
				t1.setVisible(true);
				t1.setBorder(border);
				f1.add(t1);
				
				t2=new JTextArea();
				t2.setBounds(360,200,150,20);
				t2.setVisible(true);
				t2.setBorder(border);
				f1.add(t2);
				
				t3=new JTextArea();
				t3.setBounds(360,250,150,20);
				t3.setVisible(true);
				t3.setBorder(border);
				f1.add(t3);
				
				t9=new JTextArea();
				t9.setBounds(360,300,150,20);
				t9.setVisible(true);
				t9.setBorder(border);
				f1.add(t9);
				
				t10=new JTextArea();
				t10.setBounds(360,350,150,20);
				t10.setVisible(true);
				t10.setBorder(border);
				f1.add(t10);
				
				b1=new JButton("Submit ");
				b1.setBounds(260,400,100,20);
				b1.enable();
				b1.addActionListener(this);
				b1.setVisible(true);
				f1.add(b1);
				
				/*-----------------------------------*/
				
				
				/*---------------frame 3 for Delete-------------------*/
				f3=new JFrame();
				f3.setLayout(null);
				f3.setVisible(false);
				//f1.setVisible(true);
				f3.setBounds(400, 200, 800, 350);
				
				l10=new JLabel("Delete Into Database");
				l10.setFont(l1.getFont().deriveFont(20.85632412f));
				l10.setBounds(220, 50, 300, 20);
				f3.add(l10);
				
				l11=new JLabel("Enter Title of user you want to delete");
				l11.setBounds(150, 100, 150, 20);
				f3.add(l11);
				
				t7=new JTextArea();
				t7.setBounds(360,100,100,20);
				t7.setVisible(true);
				t7.setBorder(border);
				f3.add(t7);
				
				b3=new JButton("Delete");
				b3.setBounds(260,160,100,20);
				b3.enable();
				b3.addActionListener(this);
				b3.setVisible(true);
				f3.add(b3);
				
				f3.add(l5);
				
				/*-----------------------------------*/
		        
				/*---------------frame 3 for search -------------------*/
				f4=new JFrame();
				f4.setLayout(null);
				f4.setVisible(false);
				//f1.setVisible(true);
				f4.setBounds(400, 200, 600, 400);
				
				l12=new JLabel("Search the Book ");
				l12.setFont(l1.getFont().deriveFont(20.85632412f));
				l12.setBounds(190, 50, 300, 30);
				f4.add(l12);
				
				l13=new JLabel("");
				l13.setBounds(200, 200, 300, 30);
				f4.add(l13);
				
				t8=new JTextArea();
				t8.setBounds(200,100,200,20);
				t8.setVisible(true);
				t8.setBorder(border);
				f4.add(t8);
				
				b4=new JButton("Search ");
				b4.setBounds(200,150,100,40);
				b4.enable();
				b4.addActionListener(this);
				b4.setVisible(true);
				f4.add(b4);
				
				f4.add(l5);
				
				/*-----------------------------------*/
		
	}
	public void actionPerformed(ActionEvent e) {
		Object z=e.getSource();
		if(z==insert){
			f1.setVisible(true);	
		}
		if(z==b1){
			//System.out.println(t1.getText());
			/*String s1=t1.getText();
			String s2=t2.getText();
			String s3=t3.getText();*/
			insert(t1.getText(),t2.getText(),t3.getText(),t9.getText(),t10.getText());
		}
        if(z==delete){
			f3.setVisible(true);
		}
        if(z==b3){
        	delete(t7.getText());
        }
        if(z==display){
			f4.setVisible(true);
		}
        if(z==b4){
        	l13.setText(search(t8.getText()));
        }
        if(z==show){
        	DisplyAllRecords.display();
        }
        if(z==exit){
			f.dispose();
		}
		
	}

	public static void main(String[] args) {
		new Book_database();
	}

        
}
