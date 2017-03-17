import java.awt.Color;

import javax.swing.BorderFactory;

public class DisplayTime extends State {
	SimpleClock myclock;

	public DisplayTime(SimpleClock myclock) {
		super();
		this.myclock = myclock;
		SetUIFeatures();
		
	}

	@Override
	public void SetUIFeatures() {
		myclock.plusButton.setVisible(false);
		myclock.minusButton.setVisible(false);
		myclock.btnCancel.setVisible(false);
	}

	@Override
	public void increment() {
		// DO NOTHING

	}

	@Override
	public void decrement() {
		// DO NOTHING

	}

	@Override
	public void timeTicker() {
		
	}

	@Override
	public void changeMode() {
		myclock.setState(myclock.getSetHours());
		myclock.lblHour.setBorder(BorderFactory.createLineBorder(Color.white));

		myclock.plusButton.setVisible(true);
		myclock.minusButton.setVisible(true);
		myclock.btnCancel.setVisible(true);

	}

	@Override
	public void cancel() {
		// DO NOTHING

	}
}