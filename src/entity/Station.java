package entity;

public class Station {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private double position;
	private String id;

	public Station(String id, String name, double position) {
		this.name = name;
		this.position = position;
		this.id = id;
	}

	public String getStationInfo() {
		return null;
	}

}
