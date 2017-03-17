import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleClock {

	private JFrame frame;
	private Timer timer;

	// Initial Clock Labels
	JLabel lblHour = new JLabel("23");
	JLabel lblMinute = new JLabel("59");
	JLabel lblSeconds = new JLabel("58");
	
	// Buttons
	JButton btnChangeMode = new JButton("Change Mode");
	JButton btnCancel = new JButton("Cancel");
	JButton plusButton = new JButton("+");
	JButton minusButton = new JButton("-");

	State DisplayTime;
	State SetHours;
	State SetMinutes;
	State SetSeconds;

	State state;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleClock window = new SimpleClock();
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
	public SimpleClock() {
		initialize();
		DisplayTime = new DisplayTime(this);
		SetHours = new SetHours(this);
		SetMinutes = new SetMinutes(this);
		SetSeconds = new SetSeconds(this);

		state = DisplayTime;

		timer = new Timer(1000, timerAction);
		timer.start();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Change Mode Button
		btnChangeMode.setBounds(148, 223, 139, 29);
		frame.getContentPane().add(btnChangeMode);
		ListenForButton lForButton = new ListenForButton();
		btnChangeMode.addActionListener(lForButton);

		// Hour Panel
		Panel hourPanel = new Panel();
		hourPanel.setBackground(Color.BLACK);
		hourPanel.setBounds(31, 57, 84, 74);
		frame.getContentPane().add(hourPanel);

		lblHour.setFont(new Font("Courier", Font.PLAIN, 63));
		lblHour.setForeground(Color.WHITE);
		hourPanel.add(lblHour);

		// Minute Panel
		Panel minutePanel = new Panel();
		minutePanel.setBackground(Color.BLACK);
		minutePanel.setBounds(179, 57, 84, 74);
		frame.getContentPane().add(minutePanel);

		lblMinute.setForeground(Color.WHITE);
		lblMinute.setFont(new Font("Courier", Font.PLAIN, 63));
		minutePanel.add(lblMinute);

		// Seconds Panel
		Panel secondsPanel = new Panel();
		secondsPanel.setBackground(Color.BLACK);
		secondsPanel.setBounds(326, 57, 84, 74);
		frame.getContentPane().add(secondsPanel);

		lblSeconds.setForeground(Color.WHITE);
		lblSeconds.setFont(new Font("Courier", Font.PLAIN, 63));
		secondsPanel.add(lblSeconds);

		// The dots that appear in between Digits 12 : 5 : 22
		JLabel labeldot = new JLabel(":");
		labeldot.setFont(new Font("Courier Prime", Font.PLAIN, 57));
		labeldot.setBounds(124, 39, 49, 109);
		frame.getContentPane().add(labeldot);

		JLabel labeldot1 = new JLabel(":");
		labeldot1.setFont(new Font("Courier Prime", Font.PLAIN, 57));
		labeldot1.setBounds(271, 39, 49, 109);
		frame.getContentPane().add(labeldot1);

		/**** Methods for Changing UI ****/

		// Cancel Button

		btnCancel.setBounds(310, 223, 117, 29);
		frame.getContentPane().add(btnCancel);
		ListenForCancelButton lForCancelButton = new ListenForCancelButton();
		btnCancel.addActionListener(lForCancelButton);

		// Increment Button

		plusButton.setBounds(19, 223, 49, 29);
		frame.getContentPane().add(plusButton);
		ListenforPlusButton lForPlusButton = new ListenforPlusButton();
		plusButton.addActionListener(lForPlusButton);

		// Decrement Button

		minusButton.setBounds(66, 223, 49, 29);
		frame.getContentPane().add(minusButton);
		ListenForMinusButton lForminusButton = new ListenForMinusButton();
		minusButton.addActionListener(lForminusButton);

	}

	public void setState(State clockState) {
		state = clockState;
	}

	/**** Methods for Incrementing Time ****/
	public void increment() {
		state.increment();
	}

	public void decrement() {
		state.decrement();
	}

	public void cancle() {
		state.cancel();
	}

	public void timeTicker() {
		state.timeTicker();
	}

	public State getDisplayTime() {
		return DisplayTime;
	}

	public State getSetHours() {
		return SetHours;
	}

	public State getSetMinutes() {
		return SetMinutes;
	}

	public State getSetSeconds() {
		return SetSeconds;
	}

	/*** ACTION LISTNERS ***/

	public ActionListener timerAction = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			if (state != SetSeconds) {
				if (Integer.parseInt(lblSeconds.getText()) > 58) {
					lblSeconds.setText("0");

					if (Integer.parseInt(lblMinute.getText()) > 58) {
						lblMinute.setText("0");

						if (Integer.parseInt(lblHour.getText()) > 22) {
							lblHour.setText("0");
						} else {
							lblHour.setText("" + (Integer.parseInt(lblHour.getText()) + 1));
						}

					} else {
						lblMinute.setText("" + (Integer.parseInt(lblMinute.getText()) + 1));

					}

				} else {
					lblSeconds.setText(""+ (Integer.parseInt(lblSeconds.getText()) + 1));
				}

			}
		}
	};


	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnChangeMode) {

				state.changeMode();

			}

		}

	}

	private class ListenforPlusButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == plusButton) {

				state.increment();

			}

		}

	}

	private class ListenForMinusButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == minusButton) {

				state.decrement();

			}

		}

	}

	private class ListenForCancelButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnCancel) {

				state.cancel();

			}

		}

	}

}
