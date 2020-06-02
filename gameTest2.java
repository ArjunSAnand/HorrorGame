package ISP;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileWriter;

import javax.sound.sampled.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class gameTest2 {

	private static JFrame frame;
	static int counter = 0;
	static JLabel[] pro = new JLabel[21];
	static JLabel[] proflashlight = new JLabel[21];
	static JLabel[] prohorror = new JLabel[21];
	static JLabel[] prohorror2 = new JLabel[21];
	static JLabel[] prohorrorlight = new JLabel[21];
	static JLabel battery = new JLabel();
	static JLabel countdownlabel = new JLabel();
	static JLabel death = new JLabel();
	static JLabel win = new JLabel();
	static JLabel healthbar = new JLabel();


	static int x;
	static int counterhorror1;
	static int flashlight = 0;
	static int counterleaves = 0;
	static int randommonster1 = 0;
	static int randommonster2 = 0;
	static int percent = 100;
	static int check = 0;
	static int monster = 0;
	static int counterdeath = 0;
	static int monstercheck = 0;
	static int z = 0;
	static int dead = 0;
	private int mX, mY;
	int bufferX = 0;
	int bufferY = 0;
	int count = 0;
	static int check2 = 0;
	static int countdown = 200;
	static int health = 10;
	static int laugh = 0;

	/**
	 * Launch the application.
	 */
	public static void main() {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameTest2 window = new gameTest2();
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
	public gameTest2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 776, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();

		// X: 1919 Y:1016
		frame.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent event) {
				
				if(laugh == 0 || laugh == 1 ) {
				if (event.getKeyCode() == 70) {
					flashlightsound();
					System.out.println("Counterhorror = " + counterhorror1);
					System.out.println("x = " + x);
					
					if (counterhorror1 == 0) {
						flashlight = flashlight + 1;
						clear();
						if (flashlight % 2 == 1) {
							percent--;
							battery.setText(percent + "%");
	proflashlight[x].setVisible(true);						
						}
						else {
							pro[x].setVisible(true);
						}			
						}	
					if (counterhorror1 >= 1) {
						flashlight = flashlight + 1;
						clear();
						if (flashlight % 2 == 1) {
							percent--;
							battery.setText(percent + "%");
	proflashlight[x].setVisible(true);	
	
	if(counterhorror1 == 1 && x == 0) {
	counterhorror1 = 0;
	monster = 0;
	health--;
	healthcheck();
	}
	if(counterhorror1 == 2 && x == 6) {
	counterhorror1 = 0;
	monster = 0;
	health--;
	healthcheck();

	}
	
						}
						else {
							prohorror[x].setVisible(true);
						}
						
						}				
				}
			}
				
				
				if(laugh == 3) {
					Timer timer2 = new Timer();

					timer2.schedule(new TimerTask() {
						@Override
						public void run() {

							clear();

							x++;
							if (x > 6) {
								x = 6;
								counterleaves = 1;
							}

							if (counterhorror1 == 0) {
								pro[x].setVisible(true);
							}
							else if (counterhorror1 == 1) {
								prohorror[x].setVisible(true);
							}
							else if (counterhorror1 == 2) {
								prohorror2[x].setVisible(true);
							}
							else {
								pro[x].setVisible(true);
							}

							if (counterleaves == 0) {

								try {
									AudioInputStream audioInputStream = AudioSystem
											.getAudioInputStream(new File("leaves.wav").getAbsoluteFile());
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
								} catch (Exception ex) {
									System.out.println("Error with playing sound.");
									ex.printStackTrace();
								}
								counterleaves = 0;

							}
						}
					}, 1);
			}
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
//X: 1919  Y:1016
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_165328439766000");
		panel.setLayout(null);

		battery = new JLabel(percent + "%");
		battery.setBackground(Color.red);
		battery.setFont(new Font("Times New Roman", Font.BOLD, 50));
		battery.setBounds(1775, 800, 300, 300);
		panel.add(battery);

		
		
		countdownlabel = new JLabel(countdown + "");
		countdownlabel.setBackground(Color.red);
		countdownlabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		countdownlabel.setBounds(20, 0, 150, 150);
		panel.add(countdownlabel);


		healthbar = new JLabel("");
		healthbar.setIcon(new ImageIcon("Order\\100.jpg"));
		healthbar.setBounds(550, 10, 735, 103);
		panel.add(healthbar);

		// pro
		pro[0] = new JLabel("");
		pro[0].setBounds(-1538, 5, 3840, 1080);
		pro[0].setIcon(new ImageIcon("Order\\1.jpg"));
		panel.add(pro[0]);

		pro[1] = new JLabel("");
		pro[1].setBounds(-1538, 5, 3840, 1080);
		pro[1].setIcon(new ImageIcon("Order\\2.jpg"));
		panel.add(pro[1]);

		pro[2] = new JLabel("");
		pro[2].setIcon(new ImageIcon("Order\\3.jpg"));
		pro[2].setBounds(-1538, 5, 3840, 1080);
		panel.add(pro[2]);

		pro[3] = new JLabel("");
		pro[3].setIcon(new ImageIcon("Order\\4.jpg"));
		pro[3].setBounds(-1538, 5, 3840, 1080);
		panel.add(pro[3]);

		pro[4] = new JLabel("");
		pro[4].setIcon(new ImageIcon("Order\\5.jpg"));
		pro[4].setBounds(-1538, 5, 3840, 1080);
		panel.add(pro[4]);

		pro[5] = new JLabel("");
		pro[5].setIcon(new ImageIcon("Order\\6.jpg"));
		pro[5].setBounds(-1538, 5, 3840, 1080);
		panel.add(pro[5]);

		pro[6] = new JLabel("");
		pro[6].setIcon(new ImageIcon("Order\\7.jpg"));
		pro[6].setBounds(-1538, 5, 3840, 1080);
		panel.add(pro[6]);

		// prohorror
		prohorror[0] = new JLabel("");
		prohorror[0].setBounds(-1538, 5, 3840, 1080);
		prohorror[0].setIcon(new ImageIcon("Order\\1bossadded.jpg"));
		panel.add(prohorror[0]);

		prohorror[1] = new JLabel("");
		prohorror[1].setBounds(-1538, 5, 3840, 1080);
		prohorror[1].setIcon(new ImageIcon("Order\\2.jpg"));
		panel.add(prohorror[1]);

		prohorror[2] = new JLabel("");
		prohorror[2].setIcon(new ImageIcon("Order\\3.jpg"));
		prohorror[2].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror[2]);

		prohorror[3] = new JLabel("");
		prohorror[3].setIcon(new ImageIcon("Order\\4.jpg"));
		prohorror[3].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror[3]);

		prohorror[4] = new JLabel("");
		prohorror[4].setIcon(new ImageIcon("Order\\5.jpg"));
		prohorror[4].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror[4]);

		prohorror[5] = new JLabel("");
		prohorror[5].setIcon(new ImageIcon("Order\\6.jpg"));
		prohorror[5].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror[5]);

		prohorror[6] = new JLabel("");
		prohorror[6].setIcon(new ImageIcon("Order\\7.jpg"));
		prohorror[6].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror[6]);

		// prohorror2
		prohorror2[0] = new JLabel("");
		prohorror2[0].setBounds(-1538, 5, 3840, 1080);
		prohorror2[0].setIcon(new ImageIcon("Order\\1.jpg"));
		panel.add(prohorror2[0]);

		prohorror2[1] = new JLabel("");
		prohorror2[1].setBounds(-1538, 5, 3840, 1080);
		prohorror2[1].setIcon(new ImageIcon("Order\\2.jpg"));
		panel.add(prohorror2[1]);

		prohorror2[2] = new JLabel("");
		prohorror2[2].setIcon(new ImageIcon("Order\\3.jpg"));
		prohorror2[2].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror2[2]);

		prohorror2[3] = new JLabel("");
		prohorror2[3].setIcon(new ImageIcon("Order\\4.jpg"));
		prohorror2[3].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror2[3]);

		prohorror2[4] = new JLabel("");
		prohorror2[4].setIcon(new ImageIcon("Order\\5.jpg"));
		prohorror2[4].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror2[4]);

		prohorror2[5] = new JLabel("");
		prohorror2[5].setIcon(new ImageIcon("Order\\6.jpg"));
		prohorror2[5].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror2[5]);

		prohorror2[6] = new JLabel("");
		prohorror2[6].setIcon(new ImageIcon("Order\\7bossadded.jpg"));
		prohorror2[6].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorror2[6]);



		// prohorrorlight
		prohorrorlight[0] = new JLabel("");
		prohorrorlight[0].setBounds(-1538, 5, 3840, 1080);
		prohorrorlight[0].setIcon(new ImageIcon("Order\\figureadded1light.jpg"));
		panel.add(prohorrorlight[0]);

		prohorrorlight[1] = new JLabel("");
		prohorrorlight[1].setBounds(-1538, 5, 3840, 1080);
		prohorrorlight[1].setIcon(new ImageIcon("Order\\figureadded2light.jpg"));
		panel.add(prohorrorlight[1]);

		prohorrorlight[2] = new JLabel("");
		prohorrorlight[2].setIcon(new ImageIcon("Order\\3 light.jpg"));
		prohorrorlight[2].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorrorlight[2]);

		prohorrorlight[3] = new JLabel("");
		prohorrorlight[3].setIcon(new ImageIcon("Order\\4 light.jpg"));
		prohorrorlight[3].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorrorlight[3]);

		prohorrorlight[4] = new JLabel("");
		prohorrorlight[4].setIcon(new ImageIcon("Order\\5 light.jpg"));
		prohorrorlight[4].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorrorlight[4]);

		prohorrorlight[5] = new JLabel("");
		prohorrorlight[5].setIcon(new ImageIcon("Order\\6flashlight.jpg"));
		prohorrorlight[5].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorrorlight[5]);

		prohorrorlight[6] = new JLabel("");
		prohorrorlight[6].setIcon(new ImageIcon("Order\\7flashlight.jpg"));
		prohorrorlight[6].setBounds(-1538, 5, 3840, 1080);
		panel.add(prohorrorlight[6]);

		// proflashlight
		proflashlight[0] = new JLabel("");
		proflashlight[0].setBounds(-1538, 5, 3840, 1080);
		proflashlight[0].setIcon(new ImageIcon("Order\\1 light.jpg"));
		panel.add(proflashlight[0]);

		proflashlight[1] = new JLabel("");
		proflashlight[1].setBounds(-1538, 5, 3840, 1080);
		proflashlight[1].setIcon(new ImageIcon("Order\\2 light.jpg"));
		panel.add(proflashlight[1]);

		proflashlight[2] = new JLabel("");
		proflashlight[2].setIcon(new ImageIcon("Order\\3 light.jpg"));
		proflashlight[2].setBounds(-1538, 5, 3840, 1080);
		panel.add(proflashlight[2]);

		proflashlight[3] = new JLabel("");
		proflashlight[3].setIcon(new ImageIcon("Order\\4 light.jpg"));
		proflashlight[3].setBounds(-1538, 5, 3840, 1080);
		panel.add(proflashlight[3]);

		proflashlight[4] = new JLabel("");
		proflashlight[4].setIcon(new ImageIcon("Order\\5 light.jpg"));
		proflashlight[4].setBounds(-1538, 5, 3840, 1080);
		panel.add(proflashlight[4]);

		proflashlight[5] = new JLabel("");
		proflashlight[5].setIcon(new ImageIcon("Order\\6flashlight.jpg"));
		proflashlight[5].setBounds(-1538, 5, 3840, 1080);
		panel.add(proflashlight[5]);

		proflashlight[6] = new JLabel("");
		proflashlight[6].setIcon(new ImageIcon("Order\\7flashlight.jpg"));
		proflashlight[6].setBounds(-1538, 5, 3840, 1080);
		panel.add(proflashlight[6]);



		death = new JLabel("");
		death.setBounds(0, 0, 2000, 1500);
		death.setIcon(new ImageIcon("Order\\characters\\death.png"));
		panel.add(death);
		
		win = new JLabel("");
		win.setBounds(0, 0, 2000, 1100);
		win.setIcon(new ImageIcon("Order\\characters\\win.png"));
		panel.add(win);

	

		win.setVisible(false);



		pro[1].setVisible(false);
		pro[2].setVisible(false);
		pro[3].setVisible(false);
		pro[4].setVisible(false);
		pro[5].setVisible(false);
		pro[6].setVisible(false);

		proflashlight[0].setVisible(false);
		proflashlight[1].setVisible(false);
		proflashlight[2].setVisible(false);
		proflashlight[3].setVisible(false);
		proflashlight[4].setVisible(false);
		proflashlight[5].setVisible(false);
		proflashlight[6].setVisible(false);

		prohorror[0].setVisible(false);
		prohorror[1].setVisible(false);
		prohorror[2].setVisible(false);
		prohorror[3].setVisible(false);
		prohorror[4].setVisible(false);
		prohorror[5].setVisible(false);
		prohorror[6].setVisible(false);

		prohorror2[0].setVisible(false);
		prohorror2[1].setVisible(false);
		prohorror2[2].setVisible(false);
		prohorror2[3].setVisible(false);
		prohorror2[4].setVisible(false);
		prohorror2[5].setVisible(false);
		prohorror2[6].setVisible(false);


		prohorrorlight[0].setVisible(false);
		prohorrorlight[1].setVisible(false);
		prohorrorlight[2].setVisible(false);
		prohorrorlight[3].setVisible(false);
		prohorrorlight[4].setVisible(false);
		prohorrorlight[5].setVisible(false);
		prohorrorlight[6].setVisible(false);
		death.setVisible(false);

		JLabel moveRight = new JLabel("");
		moveRight.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseEntered(MouseEvent e) {

				
				if(laugh == 0) {
				Timer timer2 = new Timer();

				timer2.schedule(new TimerTask() {
					@Override
					public void run() {

						clear();

						x++;
						if (x > 6) {
							x = 6;
							counterleaves = 1;
						}

						if (counterhorror1 == 0) {
							pro[x].setVisible(true);
						}
						else if (counterhorror1 == 1) {
							prohorror[x].setVisible(true);
						}
						else if (counterhorror1 == 2) {
							prohorror2[x].setVisible(true);
						}
						else {
							pro[x].setVisible(true);
						}

						if (counterleaves == 0) {

							try {
								AudioInputStream audioInputStream = AudioSystem
										.getAudioInputStream(new File("music\\leaves.wav").getAbsoluteFile());
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
							} catch (Exception ex) {
								System.out.println("Error with playing sound.");
								ex.printStackTrace();
							}
							counterleaves = 0;

						}
					}
				}, 1);
				}
				if(laugh == 1 || laugh == 3) {
					Timer timer = new Timer();

					timer.schedule(new TimerTask() {
						@Override
						public void run() {

							clear();
							x--;
							if (x < 0) {
								x = 0;
								counterleaves = 1;
							}

							if (counterhorror1 == 0) {
								pro[x].setVisible(true);
							}
							else if (counterhorror1 == 1) {
								prohorror[x].setVisible(true);
							}
							else if (counterhorror1 == 2) {
								prohorror2[x].setVisible(true);
							}
							else {
								pro[x].setVisible(true);
							}

							if (counterleaves == 0) {
								try {
									AudioInputStream audioInputStream = AudioSystem
											.getAudioInputStream(new File("music\\leaves.wav").getAbsoluteFile());
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
								} catch (Exception ex) {
									System.out.println("Error with playing sound.");
									ex.printStackTrace();
								}
							}
							counterleaves = 0;

						}
					}, 1);
					if (flashlight == 1) {
						flashlight = 0;
					}
				}	

			}
		});

		moveRight.setBounds(1835, 1, 75, 1000);
		panel.add(moveRight);

		JLabel moveLeft = new JLabel("");
		moveLeft.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseEntered(MouseEvent e) {

				
				if(laugh == 1) {
				Timer timer2 = new Timer();

				timer2.schedule(new TimerTask() {
					@Override
					public void run() {

						clear();

						x++;
						if (x > 6) {
							x = 6;
							counterleaves = 1;
						}

						if (counterhorror1 == 0) {
							pro[x].setVisible(true);
						}
						else if (counterhorror1 == 1) {
							prohorror[x].setVisible(true);
						}
						else if (counterhorror1 == 2) {
							prohorror2[x].setVisible(true);
						}
						else {
							pro[x].setVisible(true);
						}

						if (counterleaves == 0) {

							try {
								AudioInputStream audioInputStream = AudioSystem
										.getAudioInputStream(new File("music\\leaves.wav").getAbsoluteFile());
								Clip clip = AudioSystem.getClip();
								clip.open(audioInputStream);
								clip.start();
							} catch (Exception ex) {
								System.out.println("Error with playing sound.");
								ex.printStackTrace();
							}
							counterleaves = 0;

						}
					}
				}, 1);
				}
				if(laugh == 0) {
					Timer timer = new Timer();

					timer.schedule(new TimerTask() {
						@Override
						public void run() {

							clear();
							x--;
							if (x < 0) {
								x = 0;
								counterleaves = 1;
							}

							if (counterhorror1 == 0) {
								pro[x].setVisible(true);
							}
							else if (counterhorror1 == 1) {
								prohorror[x].setVisible(true);
							}
							else if (counterhorror1 == 2) {
								prohorror2[x].setVisible(true);
							}
							else {
								pro[x].setVisible(true);
							}

							if (counterleaves == 0) {
								try {
									AudioInputStream audioInputStream = AudioSystem
											.getAudioInputStream(new File("music\\leaves.wav").getAbsoluteFile());
									Clip clip = AudioSystem.getClip();
									clip.open(audioInputStream);
									clip.start();
								} catch (Exception ex) {
									System.out.println("Error with playing sound.");
									ex.printStackTrace();
								}
							}
							counterleaves = 0;

						}
					}, 1);
					if (flashlight == 1) {
						flashlight = 0;
					}
				}
				if(laugh == 3) {
						flashlightsound();
						System.out.println("Counterhorror = " + counterhorror1);
						System.out.println("x = " + x);
						
						if (counterhorror1 == 0) {
							flashlight = flashlight + 1;
							clear();
							if (flashlight % 2 == 1) {
								percent--;
								battery.setText(percent + "%");
		proflashlight[x].setVisible(true);						
							}
							else {
								pro[x].setVisible(true);
							}			
							}	
						if (counterhorror1 >= 1) {
							flashlight = flashlight + 1;
							clear();
							if (flashlight % 2 == 1) {
								percent--;
								battery.setText(percent + "%");
		proflashlight[x].setVisible(true);	
		
		if(counterhorror1 == 1 && x == 0) {
		counterhorror1 = 0;
		monster = 0;
		health--;
		healthcheck();
		}
		if(counterhorror1 == 2 && x == 6) {
		counterhorror1 = 0;
		monster = 0;
		health--;
		healthcheck();

		}
		
							}
							else {
								prohorror[x].setVisible(true);
							}
							
							}				
					
					
				}
			}
		});
		moveLeft.setBounds(0, 1, 75, 1000);
		panel.add(moveLeft);


		miniGame start4 = new miniGame();
		check = miniGame.sendcheck(check);
		// System.out.println(check);

		
		z = (int) ((Math.random() * ((4 - 1) + 1)) + 1);
		Timer timerdeath = new Timer();

		timerdeath.scheduleAtFixedRate(new TimerTask() {
			public void run() {

				 System.out.println("counterdeath = " + counterdeath);
				if (counterhorror1 > 0) {
					counterdeath++;
					if (counterdeath >= 6500) {
						cleareverything();

						if (dead == 0) {
							dead = 1;
							try {
								deadd();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				}
				
				if(countdown < 0 && check == 5) {
					cleareverything();
					try {
						counterdeath = 0;
						countdown = 1000;
						countdownlabel.setVisible(false);
						winn();
						win();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//	winn();
				}
			//	System.out.println("check: " + check);
				if(countdown < 0 && check != 5) {
					cleareverything();

					if (dead == 0) {
						dead = 1;
						try {
							deadd();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}, 1, 10);

		Timer endgame = new Timer();

		endgame.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				countdown--;
				countdownlabel.setText(countdown + "");
				if (countdown == 0) {

				}
			}
		}, 1, 1000);

		Timer timermonster = new Timer();

		timermonster.scheduleAtFixedRate(new TimerTask() {
			public void run() {

				System.out.println("counterhorror = " + counterhorror1);

				int z = (int) ((Math.random() * ((14 - 1) + 1)) + 1);

				if (z == 5 && counterhorror1 == 0) {
					clear();
					prohorror[x].setVisible(true);
					counterhorror1 = 1;
					monster1spawn();

				}
				
				if (z == 6 && counterhorror1 == 0) {
					clear();
					prohorror2[x].setVisible(true);
					counterhorror1 = 2;
					monster2spawn();

				}

			}
		}, 1, 1000);

	}

	public static void playSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\scary.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			 gainControl.setValue(-6.0f);
			clip.start();
			//clip.stop();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void playCrow() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("music\\Crow.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			// gainControl.setValue(-6.0f);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void playClick() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\Click.wav").getAbsoluteFile());
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-6.0f);
			clip1.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void flashlightsound() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\flashlightsound.wav").getAbsoluteFile());
			Clip clip2 = AudioSystem.getClip();
			clip2.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6.0f);
			clip2.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void monster1spawn() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\monster1spawn.wav").getAbsoluteFile());
			Clip clip3 = AudioSystem.getClip();
			clip3.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6.0f);
			clip3.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void monster2spawn() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\monster2spawn.wav").getAbsoluteFile());
			Clip clip4 = AudioSystem.getClip();
			clip4.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6.0f);
			clip4.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void breathe() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\breathe.wav").getAbsoluteFile());
			Clip clip4 = AudioSystem.getClip();
			clip4.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6.0f);
			clip4.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	public static void winn() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\victory.wav").getAbsoluteFile());
			Clip clip4 = AudioSystem.getClip();
			clip4.open(audioInputStream);
		//	FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
		//	gainControl.setValue(6.0f);
			clip4.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	
	public static void laughing() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("music\\breathe.wav").getAbsoluteFile());
			Clip clip4 = AudioSystem.getClip();
			clip4.open(audioInputStream);
		//	FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
		//	gainControl.setValue(6.0f);
			clip4.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}


	public static void clear() {

		pro[0].setVisible(false);
		pro[1].setVisible(false);
		pro[2].setVisible(false);
		pro[3].setVisible(false);
		pro[4].setVisible(false);
		pro[5].setVisible(false);
		pro[6].setVisible(false);

		proflashlight[0].setVisible(false);
		proflashlight[1].setVisible(false);
		proflashlight[2].setVisible(false);
		proflashlight[3].setVisible(false);
		proflashlight[4].setVisible(false);
		proflashlight[5].setVisible(false);
		proflashlight[6].setVisible(false);

		prohorror[0].setVisible(false);
		prohorror[1].setVisible(false);
		prohorror[2].setVisible(false);
		prohorror[3].setVisible(false);
		prohorror[4].setVisible(false);
		prohorror[5].setVisible(false);
		prohorror[6].setVisible(false);

		prohorror2[0].setVisible(false);
		prohorror2[1].setVisible(false);
		prohorror2[2].setVisible(false);
		prohorror2[3].setVisible(false);
		prohorror2[4].setVisible(false);
		prohorror2[5].setVisible(false);
		prohorror2[6].setVisible(false);

	


		prohorrorlight[0].setVisible(false);
		prohorrorlight[1].setVisible(false);
		prohorrorlight[2].setVisible(false);
		prohorrorlight[3].setVisible(false);
		prohorrorlight[4].setVisible(false);
		prohorrorlight[5].setVisible(false);
		prohorrorlight[6].setVisible(false);

	}

	public static void cleareverything() {

		pro[0].setVisible(false);
		pro[1].setVisible(false);
		pro[2].setVisible(false);
		pro[3].setVisible(false);
		pro[4].setVisible(false);
		pro[5].setVisible(false);
		pro[6].setVisible(false);

		proflashlight[0].setVisible(false);
		proflashlight[1].setVisible(false);
		proflashlight[2].setVisible(false);
		proflashlight[3].setVisible(false);
		proflashlight[4].setVisible(false);
		proflashlight[5].setVisible(false);
		proflashlight[6].setVisible(false);

		prohorror[0].setVisible(false);
		prohorror[1].setVisible(false);
		prohorror[2].setVisible(false);
		prohorror[3].setVisible(false);
		prohorror[4].setVisible(false);
		prohorror[5].setVisible(false);
		prohorror[6].setVisible(false);

		prohorror2[0].setVisible(false);
		prohorror2[1].setVisible(false);
		prohorror2[2].setVisible(false);
		prohorror2[3].setVisible(false);
		prohorror2[4].setVisible(false);
		prohorror2[5].setVisible(false);
		prohorror2[6].setVisible(false);



		prohorrorlight[0].setVisible(false);
		prohorrorlight[1].setVisible(false);
		prohorrorlight[2].setVisible(false);
		prohorrorlight[3].setVisible(false);
		prohorrorlight[4].setVisible(false);
		prohorrorlight[5].setVisible(false);
		prohorrorlight[6].setVisible(false);


		
		


		battery.setVisible(false);
		
	}

	public static int sendcheck2(int checked) {
		// TODO Auto-generated method stub
		return check2;
	}

	public static void deadd() throws InterruptedException {
		breathe();
countdownlabel.setText("");
		while (z == 1) {

			death.setVisible(true);
			
			frame.disable();

			Timer timer = new Timer();

			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					System.exit(1);
				}
			}, 7000);
			// System.exit(1);

		}
		while (z == 2) {

			death.setVisible(true);
			
			frame.disable();

			Timer timer = new Timer();

			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					System.exit(1);
				}
			}, 7000);
		}
		while (z == 3) {

			death.setVisible(true);
			
			frame.disable();

			Timer timer = new Timer();

			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					System.exit(1);
				}
			}, 7000);
		}
		while (z != 3 && z != 2 && z != 1) {

			death.setVisible(true);

			frame.disable();
			Timer timer = new Timer();

			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					System.exit(1);
				}
			}, 7000);

		}
	}


	public static void win() throws InterruptedException {
	
		
	
		
countdownlabel.setText("");
	
			win.setVisible(true);
			
			frame.disable();

			Timer timer = new Timer();

			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					System.exit(1);
				}
			}, 7000);
			// System.exit(1);

		
		}

public static void healthcheck() {
	if (health == 8) {
		healthbar.setIcon(new ImageIcon("Order\\80.jpg"));
		laugh = 1;
		laughing();
	}
	else if (health == 6) {
		healthbar.setIcon(new ImageIcon("Order\\60.jpg"));
		laugh = 0;
		laughing();

	}
	else if (health == 4) {
		healthbar.setIcon(new ImageIcon("Order\\40.jpg"));
		laugh = 1;
		laughing();

	}
	else if (health == 2) {
		healthbar.setIcon(new ImageIcon("Order\\20.jpg"));
		laugh = 3;
		laughing();

	}
	else if(health <= 0) {
		try {
			cleareverything();
			win();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


}
