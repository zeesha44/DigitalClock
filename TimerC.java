package digital_clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.Duration;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerC extends JFrame implements ActionListener {
JFrame frame = new JFrame();
//JButton startb = new JButton("START");
//JButton resetb = new JButton("RESET");
//JButton enter = new JButton("Enter");

private static final long serialVersionUID = 1l;
DecimalFormat formatter = new DecimalFormat("00");
long hours, minutes, seconds;
long inputtime, lastticktime, runningtime, timeLeft;

JLabel labeltime, h, min, sec;
JComboBox<String> hourComboBox, minutesComboBox, secondsComboBox;
JButton  reset, start, pause;

Timer timer;

	
	TimerC(){
		hours = minutes = seconds = 0;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Digital Clock Project");
		frame.setLayout(new FlowLayout());
		frame.setSize(500,300);
		frame.setResizable(false);
		//frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		labeltime = new JLabel();
		changeLabelTimer();
		labeltime.setBounds(300,400,200,100);
		labeltime.setFont(new Font ("Agency FB", Font.BOLD, 50));
		frame.add(labeltime);
		
		hourComboBox = new JComboBox<String>();
		for(int i = 0; i <= 24; i++) {
			hourComboBox.addItem(formatter.format(i));
		}
		hourComboBox.setBounds(300,400,200,100);
		hourComboBox.addActionListener(this);
		hourComboBox.setFont(new Font ("Agency FB", Font.BOLD, 50));
		((JLabel) hourComboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);        //center aligning the combobox text, renderer is necessary for aligning the text in combobox
		frame.add(hourComboBox);
		
		minutesComboBox = new JComboBox<String>();				//combobox to choose minutes
		for(int i = 0; i < 60; i++) {							//filling values
			minutesComboBox.addItem(formatter.format(i));
		}
		minutesComboBox.setBounds(300,400,200,100);
		minutesComboBox.addActionListener(this);
		minutesComboBox.setFont(new Font ("Agency FB", Font.BOLD, 50));
		((JLabel) minutesComboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);      //center aligning the combobox text, renderer is necessary for aligning the text in combobox
		frame.add(minutesComboBox);
		
		
		secondsComboBox = new JComboBox<String>();				//combobox to choose seconds
		for(int i = 0; i < 60; i++) {							//filling values
			secondsComboBox.addItem(formatter.format(i));
		}
		secondsComboBox.setBounds(300,400,200,100);
		secondsComboBox.addActionListener(this);
		secondsComboBox.setFont(new Font ("Agency FB", Font.BOLD, 50));
		((JLabel) secondsComboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);			//center aligning the combobox text, renderer is necessary for aligning the text in combobox
		frame.add(secondsComboBox);
		
		h = new JLabel("h");
		h.setBounds(300,400,200,100);
		h.setFont(new Font ("Agency FB", Font.BOLD, 20));
		frame.add(h);
		
		min = new JLabel("min");
		min.setBounds(300,400,200,100);
		min.setFont(new Font ("Agency FB", Font.BOLD, 20));
		frame.add(min);
		
		sec = new JLabel("sec");
		sec.setBounds(300,400,200,100);
		sec.setFont(new Font ("Agency FB", Font.BOLD, 20));
		frame.add(sec);
		
		start.setBounds(100,300,100,50);
		start.setFont(new Font ("Agency FB", Font.PLAIN, 20));
		start.setFocusable(false);
		start.addActionListener(this);
		frame.add(start);
		
		reset.setBounds(200,300,100,50);
		reset.setFont(new Font ("Agency FB", Font.PLAIN, 20));
		reset.setFocusable(false);
		reset.addActionListener(this);
		frame.add(reset);
		
		pause.setBounds(200,300,100,50);
		pause.setFont(new Font ("Agency FB", Font.PLAIN, 20));
		pause.setFocusable(false);
		pause.addActionListener(this);
		frame.add(pause);
		
//		back.setBounds(200,300,100,50);
//		back.setFont(new Font ("Agency FB", Font.PLAIN, 20));
//		back.setFocusable(false);
//		back.addActionListener(this);
		
	}


	public long inputtime() {
		return (hours * 60 * 60 * 1000) + (minutes * 60 * 1000) + (seconds * 1000) + 1000;
	}
	
	public void update() {
		Duration duration = Duration.ofMillis(timeLeft);
		hours = duration.toHours();
		duration = duration.minusHours(hours);						
		minutes = duration.toMinutes();								
		duration = duration.minusMinutes(minutes);					
		seconds = duration.toMillis() / 1000;		
		
	}
	private void changeLabelTimer() {
		labeltime.setForeground(Color.BLACK);				
		labeltime.setText(formatter.format(hours) + " : " + formatter.format(minutes) + " : " + formatter.format(seconds));
	}
	
	public void reset() {
		try {
			Thread.sleep(1);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		hours = minutes = seconds = 0;
		changeLabelTimer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == hourComboBox) {
			hours = Integer.parseInt(hourComboBox.getItemAt(hourComboBox.getSelectedIndex()));       //Selected Number from ComboBox which is a string gets parsed as an integer
			changeLabelTimer();
		}
		
		if (e.getSource() == minutesComboBox) {
			minutes = Integer.parseInt(minutesComboBox.getItemAt(minutesComboBox.getSelectedIndex()));		//Selected Number from ComboBox which is a string gets parsed as an integer
			changeLabelTimer();
		}
		
		if(e.getSource() == secondsComboBox) {
			seconds = Integer.parseInt(secondsComboBox.getItemAt(secondsComboBox.getSelectedIndex()));		//Selected Number from ComboBox which is a string gets parsed as an integer
			changeLabelTimer();
		}
		if(e.getSource() == start) {
			reset.setEnabled(true);  pause.setEnabled(true);					//enabling the disabled buttons
			start.setEnabled(false);											//disabling as to prevent running two timers for the same task
			hourComboBox.setEnabled(false);  minutesComboBox.setEnabled(false);  secondsComboBox.setEnabled(false);          //disabling combobox to prevent resetting the numbers, mid countdown
			
			inputtime = inputtime();						//time selected from the comboboxes are converted into milliseconds
			lastticktime = System.currentTimeMillis();
			
			timer = new Timer(1000, new ActionListener() {                  //timer to countdown the set time, 1000 ms (1 second) delay
				
				@Override
				public void actionPerformed(ActionEvent e) {
					runningtime = System.currentTimeMillis() - lastticktime;		//Calculates the time elapsed since the start button was clicked
					timeLeft = inputtime - runningtime;	
					
					update();
					changeLabelTimer();
					
					if(hours <= 0 && seconds <= 0 && minutes <= 0) {
						Toolkit.getDefaultToolkit().beep();					//for the beep noise when time label gets to 00:00:00
						timer.stop();										//timer is stopped
						start.setEnabled(true);
						pause.setEnabled(false);  reset.setEnabled(false);
						hourComboBox.setSelectedIndex(0);  minutesComboBox.setSelectedIndex(0);  secondsComboBox.setSelectedIndex(0);			//resetting comboboxes to their initial values
						hourComboBox.setEnabled(true);  minutesComboBox.setEnabled(true);  secondsComboBox.setEnabled(true);					//enabling comboboxes after timer is completed
					}
				}
			});

			timer.start();						//starting timer
		}
		
		if(e.getSource() == pause) {
			timer.stop();						//stopping timer
			pause.setEnabled(false);
			start.setEnabled(true);
		}
		
		if(e.getSource() == reset) {
			timer.stop();					//stopping timer
			reset();
			reset.setEnabled(false);  pause.setEnabled(false); 
			start.setEnabled(true);
			hourComboBox.setSelectedIndex(0);  minutesComboBox.setSelectedIndex(0);  secondsComboBox.setSelectedIndex(0);				//resetting comboboxes to their initial values
			hourComboBox.setEnabled(true);  minutesComboBox.setEnabled(true);  secondsComboBox.setEnabled(true);						//enabling comboboxes after timer is completed
		}
		
	}

	
}
