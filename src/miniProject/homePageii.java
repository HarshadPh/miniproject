package miniProject;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class homePageii  {
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	homePageii(){
		JFrame f= new JFrame();
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\OneDrive\\Pictures\\tiger_edited.jpg"));
		f.setTitle("Wildlife Tourism : Login page");
		f.getContentPane().setBackground(new Color(0, 0, 0));
	 f.setBounds(100,100,1550,830);
	f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	f.setLocationRelativeTo(null);
	f.getContentPane().setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(57, 59, 500, 500);
	f.getContentPane().add(scrollPane);
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	f.getContentPane().add(scrollPane);
	table=new JTable();
	scrollPane.setViewportView(table);
	scrollPane.setBorder(BorderFactory.createTitledBorder("Your search"));
	try {
		Class.forName("com.mysql.cj.Jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/sancturies","root","?Har@2022");
		Statement stmt=con.createStatement();
		String sql="Select * from jungle";
		ResultSet rs=stmt.executeQuery(sql);
		table.setModel(Dbutils.resultSetToTableModel(rs));
	}catch(Exception e) {
		e.printStackTrace();
	}
	

	
	
	
	JMenuBar menuBar = new JMenuBar();
	f.setJMenuBar(menuBar);
	
	JButton btnNewButton = new JButton("Explore");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new homePagei();
		}
	});
	menuBar.add(btnNewButton);
	btnNewButton.setForeground(new Color(0, 255, 255));
	btnNewButton.setBackground(new Color(0, 0, 0));
	btnNewButton.setFont(new Font("Edwardian Script ITC", Font.BOLD, 20));
	
	JButton btnBooking = new JButton("Booking\r\n");
	menuBar.add(btnBooking);
	btnBooking.setForeground(new Color(0, 255, 255));
	btnBooking.setBackground(new Color(0, 0, 0));
	btnBooking.setFont(new Font("Edwardian Script ITC", Font.BOLD, 20));
	
	textField  = new JTextField();
	menuBar.add(textField);
	textField.setColumns(10);
	
	
	
	JButton btnNewButton_1 = new JButton("Search");
	btnNewButton_1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		    
			try {
				
				JLabel lblNewLabel = new JLabel("you were searching for:"+textField.getText());
				lblNewLabel.setForeground(Color.CYAN);
				lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
				lblNewLabel.setBackground(Color.YELLOW);
				lblNewLabel.setBounds(45, 38, 376,80);
				f.getContentPane().add(lblNewLabel);
				
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
  			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sancturies","root","?Har@2022");
				Statement stmt=con.createStatement();
				String sql="select * from jungle where san_name="+textField.getText();
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Present");
					
			        }
				else {
					JOptionPane.showMessageDialog(null, "Upsent");
				
				}
				con.close();
			} catch(Exception e1) {
				 e1.printStackTrace();
			}
			}
	});
	
	
	
	textField.addKeyListener(new KeyAdapter() {
		
		@SuppressWarnings("unused")
		public void KeyPressed(KeyEvent e) {
			JLabel lblNewLabel = new JLabel("you were searching for:"+textField.getText());
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
			lblNewLabel.setBackground(Color.YELLOW);
			lblNewLabel.setBounds(45, 38, 376,80);
			f.getContentPane().add(lblNewLabel);
		}
		
		
	});
	
	btnNewButton_1.setBackground(new Color(128, 128, 128));
	menuBar.add(btnNewButton_1);
	
	
	
	JButton btnNewButton_2 = new JButton("About us");
	menuBar.add(btnNewButton_2);
	btnNewButton_2.setForeground(new Color(0, 255, 255));
	btnNewButton_2.setBackground(new Color(0, 0, 0));
	btnNewButton_2.setFont(new Font("Edwardian Script ITC", Font.BOLD, 20));
	
	JButton btnLogOut = new JButton("Log Out");
	btnLogOut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	menuBar.add(btnLogOut);
	btnLogOut.setForeground(new Color(0, 255, 255));
	btnLogOut.setBackground(new Color(0, 0, 0));
	btnLogOut.setFont(new Font("Edwardian Script ITC", Font.BOLD, 20));
	f.setVisible(true);
	
	
	
	}

	
	public static void main(String[] args) {
		new homePageii();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}