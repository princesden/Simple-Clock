import java.awt.Color;

import javax.swing.BorderFactory;

public class SetHours extends State {
	SimpleClock myclock;

	public SetHours(SimpleClock myclock) {
		super();
		this.myclock = myclock;

	}

	@Override
	public void SetUIFeatures() {
		// DO NOTHING
	}

	@Override
	public void increment() {
		if (Integer.parseInt(myclock.lblHour.getText()) < 23) {
			myclock.lblHour.setText(""
					+ (Integer.parseInt(myclock.lblHour.getText()) + 1));
		} else
			myclock.lblHour.setText("0");

	}

	@Override
	public void decrement() {
		if (Integer.parseInt(myclock.lblHour.getText()) > 0) {
			myclock.lblHour.setText(""
					+ (Integer.parseInt(myclock.lblHour.getText()) - 1));
		} else
			myclock.lblHour.setText("23");
	}

	@Override
	public void timeTicker() {
		// DO NOTHING

	}

	@Override
	public void changeMode() {
		myclock.setState(myclock.getSetMinutes());
		myclock.lblMinute
				.setBorder(BorderFactory.createLineBorder(Color.white));
		myclock.lblHour.setBorder(BorderFactory.createLineBorder(Color.black));

	}

	@Override
	public void cancel() {
		myclock.setState(myclock.getDisplayTime());
		myclock.lblHour.setBorder(BorderFactory.createLineBorder(Color.black));

		myclock.plusButton.setVisible(false);
		myclock.minusButton.setVisible(false);
		myclock.btnCancel.setVisible(false);

	}
}