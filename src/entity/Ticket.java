package entity;

import itype.TicketState;

public abstract class Ticket  {
	protected String id;
	protected TicketState status;
	protected Station startStation;

	public Ticket(String id,TicketState status) {
		this.id = id;
		this.status = status;
	}
	public abstract String getTicketInfo();
	public abstract boolean isValidExit(Station currentStation);
	public abstract boolean isValidEnter(Station currentStation);

	public void updateInfoAfterEnter(Station currentStation) {
		this.startStation = currentStation;
		this.status = TicketState.IN_STATION_STATE;
	}

	public void updateInfoAfterExit(Station currentStation) {
		this.startStation = null;
		this.status = TicketState.NEW_STATE;
	}

	public String getId() {
		return id;
	}

	public Station getStartStation() {
		return startStation;
	}
}
