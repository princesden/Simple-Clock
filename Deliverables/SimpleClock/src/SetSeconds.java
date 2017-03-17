import java.awt.Color;

import javax.swing.BorderFactory;

public class SetSeconds extends State {
	SimpleClock myclock;

	public SetSeconds(SimpleClock myclock) {
		super();
		this.myclock = myclock;
		timeTicker();

	}

	@Override
	public void SetUIFeatures() {
		// DO NOTHING
	}

	@Override
	public void increment() {
		if (Integer.parseInt(myclock.lblSeconds.getText()) < 59) {
			myclock.lblSeconds.setText(""
					+ (Integer.parseInt(myclock.lblSeconds.getText()) + 1));
		} else {
			myclock.lblSeconds.setText("0");
			if (Integer.parseInt(myclock.lblMinute.getText()) < 59) {
				myclock.lblMinute.setText(""
						+ (Integer.parseInt(myclock.lblMinute.getText()) + 1));
			} else
				myclock.lblMinute.setText("0");
		}
	}

	@Override
	public void decrement() {
		if (Integer.parseInt(myclock.lblSeconds.getText()) > 0) {
			myclock.lblSeconds.setText(""
					+ (Integer.parseInt(myclock.lblSeconds.getText()) - 1));
		} else {
			myclock.lblSeconds.setText("59");
			if (Integer.parseInt(myclock.lblMinute.getText()) > 0) {
				myclock.lblMinute.setText(""
						+ (Integer.parseInt(myclock.lblMinute.getText()) - 1));
			} else
				myclock.lblMinute.setText("59");
		}
	}

	@Override
	public void timeTicker() {
	}

	@Override
	public void changeMode() {
		myclock.setState(myclock.getDisplayTime());
		myclock.lblSeconds.setBorder(BorderFactory
				.createLineBorder(Color.black));

		myclock.plusButton.setVisible(false);
		myclock.minusButton.setVisible(false);
		myclock.btnCancel.setVisible(false);

	}

	@Override
	public void cancel() {
		myclock.setState(myclock.getSetMinutes());
		myclock.lblSeconds.setBorder(BorderFactory
				.createLineBorder(Color.black));
		myclock.lblMinute
				.setBorder(BorderFactory.createLineBorder(Color.white));

	}

}