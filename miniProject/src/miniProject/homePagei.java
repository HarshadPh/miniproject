package miniProject;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homePagei  {
	homePagei(){
		JFrame f= new JFrame();
		f.setTitle("Wildlife Tourism : Home page");
		f.getContentPane().setBackground(new Color(0, 0, 0));
	 f.setBounds(100,100,1550,830);
	f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	f.setLocationRelativeTo(null);
	f.getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Dropbox\\tiger.jpg"));
	lblNewLabel.setBounds(0, 0, 590, 590);
	f.getContentPane().add(lblNewLabel);
	f.setVisible(true);
	
	JLabel lblNewLabel_1 = new JLabel("Welcome to");
	lblNewLabel_1.setFont(new Font("French Script MT", Font.BOLD, 32));
	lblNewLabel_1.setForeground(new Color(0, 206, 209));
	lblNewLabel_1.setBackground(new Color(255, 153, 255));
	lblNewLabel_1.setBounds(591, 249, 130, 40);
	f.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("Maharashtra's Wildlife Tourism");
	lblNewLabel_1_1.setForeground(new Color(72, 209, 204));
	lblNewLabel_1_1.setFont(new Font("Niagara Engraved", Font.PLAIN, 55));
	lblNewLabel_1_1.setBackground(new Color(139, 0, 0));
	lblNewLabel_1_1.setBounds(602, 256, 482, 92);
	f.getContentPane().add(lblNewLabel_1_1);
	
	JButton btnNewButton = new JButton("Click here to Continue");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
			new homePageii();
		}
	});
	btnNewButton.setFont(new Font("Vivaldi", Font.BOLD, 18));
	btnNewButton.setBounds(612, 337, 254, 21);
	f.getContentPane().add(btnNewButton);
	btnNewButton.setBackground(new Color(0, 0, 0));
	btnNewButton.setForeground(new Color(0, 255, 255));
	
	
	}

	
	public static void main(String[] args) {
		new homePagei();
	}
}
