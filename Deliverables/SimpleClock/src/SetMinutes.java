import java.awt.Color;

import javax.swing.BorderFactory;

public class SetMinutes extends State {
	SimpleClock myclock;

	public SetMinutes(SimpleClock myclock) {
		super();
		this.myclock = myclock;

	}

	@Override
	public void SetUIFeatures() {
		// DO NOTHING
	}

	@Override
	public void increment() {
		if (Integer.parseInt(myclock.lblMinute.getText()) < 59) {
			myclock.lblMinute.setText(""
					+ (Integer.parseInt(myclock.lblMinute.getText()) + 1));
		} else {
			myclock.lblMinute.setText("0");
			if (Integer.parseInt(myclock.lblHour.getText()) < 23) {
				myclock.lblHour.setText(""
						+ (Integer.parseInt(myclock.lblHour.getText()) + 1));
			} else
				myclock.lblHour.setText("0");
		}
	}

	@Override
	public void decrement() {
		if (Integer.parseInt(myclock.lblMinute.getText()) > 0) {
			myclock.lblMinute.setText(""
					+ (Integer.parseInt(myclock.lblMinute.getText()) - 1));
		} else {
			myclock.lblMinute.setText("59");
			if (Integer.parseInt(myclock.lblHour.getText()) > 0) {
				myclock.lblHour.setText(""
						+ (Integer.parseInt(myclock.lblHour.getText()) - 1));
			} else
				myclock.lblHour.setText("23");
		}
	}

	@Override
	public void timeTicker() {
		// DO NOTHING

	}

	@Override
	public void changeMode() {
		myclock.setState(myclock.getSetSeconds());
		myclock.lblSeconds.setBorder(BorderFactory
				.createLineBorder(Color.white));
		myclock.lblMinute
				.setBorder(BorderFactory.createLineBorder(Color.black));

		

	}

	@Override
	public void cancel() {
		myclock.setState(myclock.getSetHours());
		myclock.lblMinute
				.setBorder(BorderFactory.createLineBorder(Color.black));
		myclock.lblHour.setBorder(BorderFactory.createLineBorder(Color.white));


	}
}