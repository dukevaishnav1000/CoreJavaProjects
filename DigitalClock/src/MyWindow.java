import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel heading;
	private JLabel clockLabel;
	private Font font=new Font("",Font.BOLD,35);
	MyWindow(){
		super.setTitle("My Clock");
		super.setSize(500,400);
		super.setLocation(300,50);
		createGui();
		clockWork();
		super.setVisible(true);

	}
	public void createGui(){
		
		heading=new JLabel("My Clock",SwingConstants.CENTER);
		clockLabel=new JLabel("Clock",SwingConstants.CENTER);
		heading.setFont(font);

		clockLabel.setFont(font);
		
		setLayout(new GridLayout(2,1));
		add(heading);
		add(clockLabel);
	}
	
	public void clockWork(){
		
		Thread t=new Thread(){
	public void run(){
		while(true){
			clockLabel.setText(new Date().toString());
			try{
				
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
		};
	t.start();
		
	}
}
