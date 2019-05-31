package entity;

import itype.TicketState;
import utils.IUtil;

public class OneWayTicket extends Ticket  {
	private Station embarkation;
	private Station disembarkation;
	private double balance;

	public OneWayTicket(String id, TicketState status, Station embarkation, Station disembarkation, double balance) {
		super(id, status);

		this.embarkation = embarkation;
		this.disembarkation = disembarkation;
		this.balance = balance;
	}

	public String getTicketInfo() {
		return this.id + " from " + this.embarkation.getName() + " to " + this.disembarkation.getName() + " Status: " + this.status + " - Balance:" + this.balance;
	}

	public boolean isValidExit(Station currentStation) {
		double fare = IUtil.calculateActualFare(this.getStartStation(), currentStation);
		if (fare <= balance) {
			return true;
		}
		return false;
	}

	public boolean isValidEnter(Station currentStation) {
		if (this.status != TicketState.NEW_STATE) {
			return false;
		}

		if ((embarkation.getPosition() > currentStation.getPosition() && disembarkation.getPosition() > currentStation.getPosition()) ||
				(embarkation.getPosition() < currentStation.getPosition() && disembarkation.getPosition() < currentStation.getPosition())) {
			return false;
		}

		return true;
	}

	public void updateInfoAfterExit(Station currentStation) {
		double fare = IUtil.calculateActualFare(this.getStartStation(), currentStation);
		this.balance = this.balance - fare;

		super.updateInfoAfterExit(currentStation);
		this.status = TicketState.DESTROY_STATE;
	}
}
