package entity;

import itype.TicketState;

public class TwentyFourHourTicket extends Ticket  {
	private int firstUsage;

	public TwentyFourHourTicket(String id, TicketState status) {
		super(id, status);
	}

	public String getTicketInfo() {
		return null;
	}

	public void updateFirstUseTime() {

	}

	public boolean isValidExit(Station currentStation) {
		return false;
	}

	public boolean isValidEnter(Station currentStation) {
		return false;
	}

}
