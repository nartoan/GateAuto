package entity;

import itype.TicketState;
import utils.IUtil;

public class OneWayTicket extends Ticket  {
	private Station embarkation;
	private Station disembarkation;

	public OneWayTicket(String id, TicketState status, Station embarkation, Station disembarkation) {
		super(id, status);

		this.embarkation = embarkation;
		this.disembarkation = disembarkation;
	}

	public String getTicketInfo() {
		return null;
	}

	public boolean isValidExit(Station currentStation) {
		IUtil.calculateActualFare(this.getStartStation(), currentStation);
		return false;
	}

	public boolean isValidEnter(Station currentStation) {
		return false;
	}
}
