package TTT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JButton;


import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

public class TTT {
	int gcount;
	static String s1="player1",s2="player 2";
	private Toolkit toolkit;
	JToolBar toolbaar;
	static int count=0;
	JButton btn[][];
	static int ramu,kalu,oldramu,oldkalu;
	char arr[][]=new char[3][3];
	public JFrame frame;
	JPanel panel = new JPanel();
	
	JButton Upar = new JButton("new Game");
	/**
	 * @wbp.nonvisual location=261,739
	 */
	static private JLabel status = new JLabel("Status:  "+s1+" won: "+ramu+"  times  "+s2+" won: "+kalu+"  times  ");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
					do s1=	JOptionPane.showInputDialog("enter first player name"); while((s1==null)||(s1==" ")||(s1.charAt(0)==' '));
					do s2=	JOptionPane.showInputDialog("enter Second player name"); while((s2==null)||(s2==" ")||(s2.charAt(0)==' '));
					TTT window = new TTT();
					window.frame.setVisible(true);
					window.frame.setTitle("Tick tack tow");
				} 
				catch(java.lang.StringIndexOutOfBoundsException e)
				{
					JOptionPane.showMessageDialog(null,"Error please enter a name");
					run();
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TTT() {
		
			initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Default();
		frame = new JFrame();
		frame.setTitle("Tick Tack tow");
		toolkit=frame.getToolkit();
		frame.setBounds(100, 100, 547, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size=toolkit.getScreenSize();
		size.height=size.height/4;
		size.width=size.width/4;
		frame.setMinimumSize(size);
		JMenuBar menu=new JMenuBar();
		System.out.println(s1+s2);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(menu,BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 5, 5));
		
		JMenu newGame=new JMenu("new game");
		menu.add(newGame);
		newGame.add(Upar);
		
		Upar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				TTT window =new TTT();
				Default();
				window.frame.setVisible(true);
				window.frame.setBounds(frame.getBounds());
				window.Default();
				frame.dispose();
			}
		});
		newGame.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent ae){ //frame.removeAll(); 
			Upar.doClick();
			
		System.out.println("remove"); }});
		 btn= new JButton[3][3];
		for(int i=0;i<3;i++)
		{
		for(int j=0;j<3;j++)
		{
			
			btn[i][j]=new JButton(i+""+j);
		btn[i][j].setForeground(new Color(0, 255, 255));
		btn[i][j].setBackground(new Color(0, 255, 255));
		btn[i][j].setFont(new Font("Tahoma", Font.PLAIN, 70));
		btn[i][j].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					JButton B=(JButton) e.getSource();
					
				String cmd=e.getActionCommand();
				int i=0,j=0;
				try{
				i=cmd.charAt(0);
				j=cmd.charAt(cmd.length()-1);
				System.out.println(B.getText());
				i=i-48;
				j=j-48;
				if(gcount==9)
				{
					
					
				}
				if(arr[i][j]!=' ')
				{
					toolkit.beep();
				}
				
				else if(count==0)
				{
					gcount++;
				B.setText("X");
				arr[i][j]='X';
				B.setBackground(new Color(255,10,10));
				count=1;
				status.setText("Status:  "+s1+" won: "+ramu+"  times  "+s2+" won: "+kalu+"  times  "+"   "+s2+" turn");
				}
				else
				{
					gcount++;
					B.setText("O");
					arr[i][j]='O';
					B.setBackground(new Color(111,10,10));
					B.setBackground(Color.green);
					
					count=0;
					status.setText("Status:  "+s1+" won: "+ramu+"  times  "+s2+" won: "+kalu+"  times  "+"   "+s1+" turn");
				}
				showResult(btn);
				
			}
			catch(Exception e1)
				{
				toolkit.beep();
				
				}
			}
		});
		panel.add(btn[i][j]);
		frame.add(status, BorderLayout.SOUTH);
		status.setSize(150, 5);
		}
		}
		
		
	}
	void check()
	{		
		

			for(int i=0;i<3;i++)
				{
						if(arr[i][0]==arr[i][1])
								if(arr[i][1]==arr[i][2])
										if(arr[i][0]=='X')
											{	ramu++;
											break;
											}
										else
											{	
												if(arr[i][0]=='O'){ kalu++;
												 break;
												}
											}
									
								
							
						 if(arr[0][i]==arr[1][i])
							{
								if(arr[1][i]==arr[2][i])
									{
										if(arr[0][i]=='X')
											{
											
											ramu++;
											 
										 break;
											}
										else
											{
												if(arr[0][i]=='O') kalu++;
												 
												 break;
											}
									}
								
							}
							if(arr[0][0]==arr[1][1])
								{
								if(arr[1][1]==arr[2][2])
									{
										if(arr[0][0]=='X')
											{
											
											ramu++;
											 
											 break;
											}
										else
											{
												if(arr[0][0]=='O') {
												kalu++;};
												 
												break;
												
											}
									}
								
								}
									if(arr[0][2]==arr[1][1])
								{
								if(arr[1][1]==arr[2][0])
									{
										if(arr[1][1]=='X')
											{
											
											ramu++;
											 
											 break;
											}
										else
											{
												if(arr[1][1]=='O'){
												 kalu++;}
												 
												break;
												
											}
									}
								
								}
									if(arr[0][i]==arr[1][i])
										if(arr[1][i]==arr[2][i])
												if(arr[0][i]=='X')
													{	ramu++;
													break;
													}
												else
													{	
														if(arr[0][i]=='O'){ kalu++;
														 break;
														}
													}
											
									
									
			
				}
		
	}
	void Default()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
		{
				arr[i][j]=' ';
			}
			
		}
	}
	void showResult(JButton[][] btn)
	{
		check();
		if(ramu>oldramu)
		{
			JOptionPane.showMessageDialog(this.frame, s1+" won");
			System.out.println(s1+" won");
			oldramu=ramu;
			toolkit.beep();
			frame.setTitle(s1+" WON");
			int n=JOptionPane.showConfirmDialog(frame, s1+" won"+" "+ramu+" times"
					+ " Do You Want to Continue Playing");
			status.setText("Status:  "+s1+" won: "+ramu+"  times  "+s2+" won: "+kalu+"  times  "+"   "+s2+" turn");
			if(n==JOptionPane.NO_OPTION)
			{
				System.exit(5);
			}
			if(n==JOptionPane.YES_OPTION)
			{
				Upar.doClick();
			}
		}
		else if(kalu>oldkalu)
		{
			JOptionPane.showMessageDialog(this.frame, s2+" won");
			int n=JOptionPane.showConfirmDialog(frame, s2+" won"+" "+kalu+" times"
					+ " Do You Want to Continue Playing");
			status.setText("Status:  "+s1+" won: "+ramu+"  times  "+s2+" won: "+kalu+"  times  "+"   "+s1+" turn");
			System.out.println(s2+" won");
			oldkalu=kalu;
			toolkit.beep();	
			frame.setTitle(s2+" WON");
			Upar.setText("new Game");
			if(n==JOptionPane.NO_OPTION)
			{
				System.exit(5);
			}
			if(n==JOptionPane.YES_OPTION)
			{
				Upar.doClick();
			}
			
			
		}
		else if(gcount==9 )
		{
			toolkit.beep();
			int ask=JOptionPane.showConfirmDialog(frame, "Game Draw Do You Want to Continue Playing?");
			if((ask==JOptionPane.NO_OPTION)||(JOptionPane.CANCEL_OPTION==ask))
			{
				System.exit(0);
			}
		else
			{
			gcount=0;
			frame.setVisible(false);
			frame.removeAll();
			TTT window =new TTT();
			Default();
			window.frame.setVisible(true);
			window.frame.setBounds(frame.getBounds());
			window.Default();
			frame.dispose();
			}
			
			
		}
	}
}

/**Pong
Breakout
Tetris
Bomberman
Flappy Bird*/
