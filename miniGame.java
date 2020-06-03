/* Horror Game
* P: to play the mini-game
* June 1st 2020
* Arjun Anand
* miniGame.java
*/ 

package ISP;

import java.awt.EventQueue;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class miniGame {
	
	static int check2 = 0;

	static int check = 0;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		main();

	}
public static void main() {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				miniGame window = new miniGame();
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
	public miniGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1036, 735);
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 

        StringBuilder sb = new StringBuilder(25); 
  
        for (int i = 0; i < 25; i++) { 

            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            sb.append(AlphaNumericString.charAt(index)); 
        } 
		
		
		JLabel lblNewLabel = new JLabel(sb.toString());
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(233, 129, 564, 114);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblNewLabel.getText().contains(textField.getText())) {
					check = 1;
					btnNewButton.setText("Confirmed");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(427, 528, 169, 71);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 30));
		textField.setBounds(233, 341, 564, 114);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Order/scroll.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1024, 700);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	
	}
	


	public static int sendcheck(int check2) {
		// TODO Auto-generated method stub
		return check;
	}
}
