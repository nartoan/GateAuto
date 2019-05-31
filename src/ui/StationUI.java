package ui;

import controller.StationController;
import itype.ActionPassenger;

import java.util.Scanner;

public class StationUI {
	private StationController stationController;

	public StationUI(StationController stationController) {
		this.stationController = stationController;
	}

	public void displayStateGate(boolean isValid) {
		if (isValid) {
			System.out.println("GATE OPEN!");
		} else {
			System.out.println("GATE CLOSE!");
		}
	}

	public void displayTicketInfo(String ticketInfo) {
		System.out.println(ticketInfo);
	}

	public void showListTicket() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to staion. Please choose: ");
		System.out.println("1: Enter Station");
		System.out.println("2: Exit Station");
		int action = 0;
		while (action != 1 && action != 2) {
			System.out.print("Your choose: ");
			action = scanner.nextInt();
		}

		ActionPassenger actionPassenger = ActionPassenger.EXIT_STATION;
		if (action == 1) {
			actionPassenger = ActionPassenger.ENTER_STATION;
		}

		scanner.nextLine();
		System.out.println("List ticket: ");
		String strTickets = this.stationController.getListTicket();
		System.out.println(strTickets);

		boolean isInValidIdTicket = true;
		while (isInValidIdTicket) {
			System.out.print("Please choose ticket: ");
			String idTicket = scanner.nextLine();
			isInValidIdTicket = !this.stationController.checkIdTicket(idTicket, actionPassenger);

			displayStateGate(!isInValidIdTicket);
			String ticketInfo = this.stationController.getTicketInfo(idTicket);
			displayTicketInfo(ticketInfo);
		}
	}

	public void showListStation() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("These are station in the line M14 Paris: ");
		String strStation = this.stationController.getListStation();
		System.out.println(strStation);

		boolean isInValidStaion = true;
		while (isInValidStaion) {
			System.out.print("Please provide a letter for choosing a station: ");
			String idStation = scanner.nextLine();
			isInValidStaion = !this.stationController.checkChooseStation(idStation);
		}
	}
}
