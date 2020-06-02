package ISP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.awt.Color; // Import the Scanner class to read text files

public class characters {

	private JFrame frame;
	private JTextField textField;
	static int x = 0;
	static String data;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					characters window = new characters();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public characters() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 945, 702);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                                                  Characters");
		lblNewLabel.setBounds(0, 0, 933, 35);
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Prev");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(0, 0, 96, 637);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(837, 0, 96, 637);

		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setBounds(0, 637, 933, 30);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(73, 35, 787, 602);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\arjun\\OneDrive\\Desktop\\Order\\characters\\girl.png"));
		textField.setText("Scared of the Light (will not go if hooded figure remains)");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\arjun\\eclipse-workspace\\Grade 11\\Order\\menu.jpg"));
		lblNewLabel_2.setBounds(0, 0, 933, 667);
		frame.getContentPane().add(lblNewLabel_2);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textField.getText().contains("scarecrow")) {
					gameTest2 start = new gameTest2();
					gameTest2.main();
				}
				
				x--;
				if(x < 0) {
					x = 0;
				}
				
				if(x == 0) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\girl.png"));
				textField.setText("Scared of the Light (will not go if hooded figure remains)");
				}
				if(x == 1) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\crows.png"));
				textField.setText("Click to make dissapear, will hinder your movement");
				}
				if(x == 2) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\hood.png"));
				textField.setText("Scared of the Light, protector of the girl in the shadows");
				}
				if(x == 3) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\easteregg.jpg"));
				textField.setText("???");
				}
				
				

				
				
			}
			
			
			
		});
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
				      File myObj = new File("filename.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				         data = myReader.nextLine();
				        System.out.println(data);
				        
	
				      }
				      myReader.close();
				    } catch (FileNotFoundException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
				
		

				
				x++;
				if(x > 3) {
					x = 3;
				}
				
				if(x == 0) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\girl.png"));
				textField.setText("Scared of the Light (will not go if hooded figure remains)");
				}
				if(x == 1) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\crows.png"));
				textField.setText("Click to make dissapear, will hinder your movement");
				}
				if(x == 2) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\hood.png"));
				textField.setText("Scared of the Light, protector of the girl in the shadows");
				}
				if(x == 3) {
				lblNewLabel_1.setIcon(new ImageIcon("Order\\characters\\easteregg.jpg"));
				textField.setText("???");
				}

				
				
			}
		});
		
		
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
				      File myObj = new File("filename.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				         data = myReader.nextLine();
				        System.out.println(data);
				        
				      }
				      myReader.close();
				    } catch (FileNotFoundException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
				
				//&& data.contentEquals("1")
				if(textField.getText().contains("scarecrow") && x == 3) {
					gameTest2 start = new gameTest2();
					gameTest2.main();
				}		
			}
		});

		ActionListener taskPerformer = new ActionListener () {
			public void actionPerformed(ActionEvent evt) {
				//System.out.println("hi");

			}
		};
		Timer t = new Timer(1000, taskPerformer);
		t.start();
		

	
	}
}
