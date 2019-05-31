package entity;

import itype.TicketState;
import utils.IUtil;

public class PrepaidCard extends Ticket  {
	private double balance;

	public PrepaidCard(String id, TicketState status, double balance) {
		super(id, status);
		this.balance = balance;
	}

	public String getTicketInfo() {
		return this.id + " Status: " + this.status + " - Balance: " + this.balance;
	}

	public boolean isValidEnter(Station currentStation) {
		if (this.balance > 1.9) {
			return true;
		}
		return false;
	}

	public boolean isValidExit(Station currentStation) {
		double fare = IUtil.calculateActualFare(this.getStartStation(), currentStation);
		if (fare <= balance) {
			return true;
		}
		return false;
	}

	public void updateInfoAfterEnter(Station currentStation) {
		super.updateInfoAfterEnter(currentStation);
	}

	public void updateInfoAfterExit(Station currentStation) {
		super.updateInfoAfterExit(currentStation);

		double fare = IUtil.calculateActualFare(this.getStartStation(), currentStation);
		this.balance = this.balance - fare;
	}
}
