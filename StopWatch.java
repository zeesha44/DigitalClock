package digital_clock;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//import javax.swing.JLabel;

public class StopWatch extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	JButton startb = new JButton("START");
	JButton resetb = new JButton("RESET");
	//JButton back = new JButton("BACK");
	
	JLabel timelabel = new JLabel();
	int elapsed = 0;
	int sec = 0;
	int min = 0;
	int hr = 0;
	boolean started = false;
	
	String seconds = String.format("%02d", sec);
	String minute = String.format("%02d", min);
	String hours = String.format("%02d", hr);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			elapsed+=1000;
			hr = (elapsed/3600000);
			min = (elapsed/60000) % 60;
			sec = (elapsed/1000) % 60;
			seconds = String.format("%02d", sec);
		    minute = String.format("%02d", min);
			hours = String.format("%02d", hr);
			
			timelabel.setText(hours + ":" + minute + ":" + seconds);	
			
			
		}
	});
	
	StopWatch(){
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.white);
		p1.setBounds(0,25,500,125);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setBounds(0,150,500,150);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.white);
		p3.setBounds(0,0,500,25);
		
		
		timelabel.setText(hours + ":" + minute + ":" + seconds);
		timelabel.setBounds(300,400,200,100);
		timelabel.setFont(new Font ("Agency FB", Font.BOLD, 50));
		timelabel.setBorder(BorderFactory.createBevelBorder(1));
		timelabel.setOpaque(true);
		timelabel.setBackground(Color.white);
		//timelabel.setHorizontalAlignment(JTextField.CENTER);
		
		
		startb.setBounds(100,300,100,50);
		startb.setFont(new Font ("Agency FB", Font.PLAIN, 20));
		startb.setFocusable(false);
		startb.addActionListener(this);
		
		resetb.setBounds(200,300,100,50);
		resetb.setFont(new Font ("Agency FB", Font.PLAIN, 20));
		resetb.setFocusable(false);
		resetb.addActionListener(this);
		
		
		
//		back.setBounds(200,300,100,50);
//		back.setFont(new Font ("Agency FB", Font.PLAIN, 20));
//		back.setFocusable(false);
//		back.addActionListener(this);

		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(timelabel);
		frame.add(startb);
		frame.add(resetb);
		p1.add(timelabel);
		p2.add(startb);
		p2.add(resetb);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Digital Clock Project");
		frame.setLayout(null);
		frame.setSize(500,300);
		frame.setResizable(false);
		//this.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==startb) {
			
			if (started==false) {
				started= true;
				startb.setText("STOP");
				start();
			}
			else {
				started= false;
				startb.setText("START");
				stop();
			}
		}
		
		if(e.getSource()==resetb) {
			started=false;
			startb.setText("START");
			reset();
		}
		
//		if(e.getSource()==back) {
//			this.dispose();
//			Main m = new Main();
//		}
	}
	
	void start() {
		timer.start();
	}
	void stop() {
		timer.stop();
	}
	void reset() {
		timer.stop();
		elapsed =0;
		sec = 0;
		min = 0;
		hr = 0;
		
		seconds = String.format("%02d", sec);
	    minute = String.format("%02d", min);
		hours = String.format("%02d", hr);
		
		timelabel.setText(hours + ":" + minute + ":" + seconds);	
		
	}

}
