public abstract class State {

	public abstract void SetUIFeatures();

	public abstract void increment();

	public abstract void decrement();

	public abstract void timeTicker();

	public abstract void changeMode();

	public abstract void cancel();

}