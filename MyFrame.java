package digital_clock;

import java.awt.Color;
//import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
//import java.util.Locale;
import java.util.TimeZone;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Calendar calendar;
	SimpleDateFormat timeFormat;
	JLabel timeLabel;
	JLabel timeLabel2;
	JLabel timeLabel3;
	String time;
	String time2;
	String time3;
	JLabel location;
	JLabel location2;
	JLabel location3;
	
	JButton myb = new JButton("Stop Watch");
	JButton myb2 = new JButton("Timer");
//	private JFrame frame;
	
	//public static final String nl = System.getProperty("line.separator");
	
	
	MyFrame(){
		
		JPanel p1 = new JPanel();
		//p1.setBackground(Color.red);
		p1.setBounds(0,0,500,75);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setBounds(0,75,500,75);
		
		JPanel p3 = new JPanel();
	//	p3.setBackground(Color.green);
		p3.setBounds(0,150,500,65);
		
		JPanel p4 = new JPanel();
		p4.setBackground(Color.white);
		p4.setBounds(0,215,500,75);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Digital Clock Project");
		this.setLayout(null);
		this.setSize(500,300);
		this.setResizable(false);
		//this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		myb.setBounds(100,300,100,50);
		myb.setFont(new Font ("Agency FB", Font.PLAIN, 20));
		myb.setFocusable(false);
		myb.addActionListener(this);
		
		myb2.setBounds(200,300,100,50);
		myb2.setFont(new Font ("Agency FB", Font.PLAIN, 20));
		myb2.setFocusable(false);
		myb2.addActionListener(this);
		
		
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		
		timeLabel = new JLabel();
		location = new JLabel("<html> <br>Lagos<br></html>");
		location.setFont(new Font("Agency FB", Font.PLAIN, 20));
		timeLabel.setFont(new Font("Agency FB", Font.BOLD, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		
		
		
		timeLabel2 = new JLabel();
		location2 = new JLabel("<html> <br>New York<br> </html>");
		location2.setFont(new Font("Agency FB", Font.PLAIN, 20));
		timeLabel2.setFont(new Font("Agency FB", Font.BOLD, 35));
		timeLabel2.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel2.setOpaque(true);
		timeLabel2.setBackground(Color.WHITE);
		
		timeLabel3 = new JLabel();
		location3 = new JLabel("Berlin");
		location3.setFont(new Font("Agency FB", Font.PLAIN, 20));
		timeLabel3.setFont(new Font("Agency FB", Font.BOLD, 35));
		timeLabel3.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel3.setOpaque(true);
		
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		p1.add(location);
		p1.add(timeLabel);
//		
//		//this.add(nl);
//		
		p2.add(location2);
		p2.add(timeLabel2);
		
		p3.add(location3);
		p3.add(timeLabel3);
//		
		p4.add(myb);
		p4.add(myb2);
		
		this.setVisible(true);
		
		setTime();
	}
	public void setTime() {
		while(true) {
		TimeZone.setDefault(TimeZone.getTimeZone("Africa/Lagos"));
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		Date t3 = new Date();
		time = timeFormat.format(t3);
		timeLabel.setText(time);
		
//		time = timeFormat.format(Calendar.getInstance().getTime());
//		timeLabel.setText(time);
//		
		//Calendar cal = Calendar.getInstance();
//		cal.setTimeZone(TimeZone.getTimeZone("Europe/Sofia"));
//		System.out.println(cal);
		//time2 = timeFormat.format(cal);
		//timeLabel2.setText(time2);
		
		 TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
		//timeFormat.format(Calendar.getInstance().getTime());
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		Date t = new Date();
		time2 = timeFormat.format(t);
		timeLabel2.setText(time2);
		
		 TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
			//timeFormat.format(Calendar.getInstance().getTime());
			timeFormat = new SimpleDateFormat("hh:mm:ss a");
			Date t2 = new Date();
			time3 = timeFormat.format(t2);
			timeLabel3.setText(time3);
			
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myb) {
			this.dispose();
			StopWatch s = new StopWatch();
		}
		if(e.getSource()==myb2) {
			this.dispose();
			TimerC t = new TimerC();
		}
	}

}
