package entity;

import itype.TicketState;

public class TwentyFourHourTicket extends Ticket  {
	private long firstUsage;

	public TwentyFourHourTicket(String id, TicketState status) {
		super(id, status);
		this.firstUsage = -1;
	}

	public String getTicketInfo() {
		return this.id + " Status: " + this.status;
	}

	public boolean isValidExit(Station currentStation) {
		if (this.status == TicketState.IN_STATION_STATE) {
			return true;
		}
		return false;
	}

	public boolean isValidEnter(Station currentStation) {
		if (this.firstUsage == -1 || firstUsage + 24 * 60 * 60 * 1000 < System.currentTimeMillis()) {
			return true;
		}
		return false;
	}

	public void updateInfoAfterEnter(Station currentStation) {
		super.updateInfoAfterEnter(currentStation);
		if (this.firstUsage == -1) {
			this.firstUsage = System.currentTimeMillis();
		}
	}

	public void updateInfoAfterExit(Station currentStation) {
		super.updateInfoAfterExit(currentStation);
		if (firstUsage + 24 * 60 * 60 * 1000 < System.currentTimeMillis()) {
			this.status = TicketState.NEW_STATE;
		} else {
			this.status = TicketState.DESTROY_STATE;
		}
	}
}
