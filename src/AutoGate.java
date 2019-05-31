import controller.StationController;
import ui.StationUI;

public class AutoGate {
    public static void main(String[] args) {
        StationUI stationUI = new StationUI(new StationController());

       while (true) {
           stationUI.showListStation();
           stationUI.showListTicket();
       }
    }
}
