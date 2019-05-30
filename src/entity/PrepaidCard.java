package entity;

import itype.TicketState;

public class PrepaidCard extends Ticket  {
	private double balance;

	public PrepaidCard(String id, TicketState status, double balance) {
		super(id, status);
		this.balance = balance;
	}

	public String getTicketInfo() {
		return null;
	}

	public void updateBalance(float newBalance) {
	}

	public boolean isValidEnter(Station currentStation) {
		return false;
	}

	public boolean isValidExit(Station currentStation) {
		return false;
	}

}
