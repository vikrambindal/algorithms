package vik.demo.sort;

public class StatisticsDTO {
	private int iterations;
	private int swaps;
	private long timeInSeconds;
	
	public StatisticsDTO(int iterations, int swaps, long timeInSeconds) {
		super();
		this.iterations = iterations;
		this.swaps = swaps;
		this.timeInSeconds = timeInSeconds;
	}

	@Override
	public String toString() {
		return "StatisticsDTO [iterations=" + iterations + ", swaps=" + swaps
				+ ", time(ns)=" + timeInSeconds + "]";
	}
}
