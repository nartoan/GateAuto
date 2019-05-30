package entity;

import itype.TicketState;

public abstract class Ticket  {
	private String id;
	private TicketState status;
	private Station startStation;

	public abstract String getTicketInfo();
	public abstract boolean isValidExit(Station currentStation);
	public abstract boolean isValidEnter(Station currentStation);

	public Ticket(String id,TicketState status) {
		this.id = id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Station getStartStation() {
		return startStation;
	}

	public void updateStateTicket(TicketState newState) {
	}
	public void updateStartStation(Station station) {
		this.startStation = station;
	}
}
