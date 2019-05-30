package controller;

import entity.*;
import itype.ActionPassenger;
import itype.TicketState;

import java.util.ArrayList;
import java.util.List;

public class StationController {
	private List<Station> listStation;
	private List<Ticket> listTicket;
	private Station currentStation;

	public StationController() {
		// Fake station for ticket
		Station stationStart = new Station("b", "Madelenie", 3);
		Station stationEnd = new Station("g", "Cour Saint-Emilion", 19);

		// Fake list station
		this.listStation = new ArrayList<>(9);
		this.listStation.add(new Station("a", "Saint_Lazare", 0));
		this.listStation.add(stationStart);
		this.listStation.add(new Station("c", "Pyramides", 6.7));
		this.listStation.add(new Station("d", "Chatelet", 9));
		this.listStation.add(new Station("e", "Gare de Lyon", 12.4));
		this.listStation.add(new Station("f", "Bercy", 15.8));
		this.listStation.add(stationEnd);
		this.listStation.add(new Station("h", "Bibliotheque Francois Mitterrand", 25));
		this.listStation.add(new Station("i", "Olympiades", 5));

		// Fake list station
		this.listTicket = new ArrayList<>(3);
		this.listTicket.add(new OneWayTicket("12345677", TicketState.NEW_STATE, stationStart, stationStart ));
		this.listTicket.add(new TwentyFourHourTicket("12345678", TicketState.NEW_STATE ));
		this.listTicket.add(new PrepaidCard("12345679", TicketState.NEW_STATE, 20));
	}

	public boolean validateEnterTicket(Ticket ticket) {
		boolean isValid = ticket.isValidEnter(this.currentStation);
		if (isValid) {
			ticket.updateStartStation(this.currentStation);
		}
		// TODO: Set more information
		return false;
	}

	public boolean validateExitTicket(Ticket ticket) {
		boolean isValid = ticket.isValidExit(this.currentStation);
		if (isValid) {
			ticket.updateStartStation(null);
		}
		// TODO: Set more information
		return false;
	}

	public String getTicketInfo(String idTicket) {
		String ticketInfo = "";
		for(Ticket ticket: this.listTicket) {
			if (ticket.getId().equals(idTicket)) {
				ticketInfo = ticket.getTicketInfo();
				break;
			}
		}

		return ticketInfo;
	}

	public boolean checkIdTicket(String idTicket, ActionPassenger actionPassenger) {
		boolean isCorrect = false;
		for(Ticket ticket: this.listTicket) {
			if (ticket.getId().equals(idTicket)) {
				if (actionPassenger == ActionPassenger.ENTER_STATION) {
					isCorrect = validateEnterTicket(ticket);
				} else {
					isCorrect = validateExitTicket(ticket);
				}
				break;
			}
		}

		return isCorrect;
	}

	public boolean checkChooseStation(String idStation) {
		boolean isCorrect = false;
		for(Station station: this.listStation) {
			if (station.getId().equals(idStation)) {
				isCorrect = true;
				this.currentStation = station;
			}
		}

		return isCorrect;
	}

	public String getListStation() {
		String strStations = "";
		for(Station station : this.listStation) {
			strStations += station.getId() + ". " + station.getName() + "\n";
		}

		return strStations;
	}

	public String getListTicket() {
		String strTickets = "";
		for(Ticket ticket : this.listTicket) {
			strTickets += ticket.getId() + ". " + ticket.getClass().getSimpleName() + "\n";
		}

		return strTickets;
	}
}
