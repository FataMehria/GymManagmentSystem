import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        //Create gym and its branches
       Gym gym = new Gym("Actic");
       gym.addBranch("Lund");
       gym.addBranch("Malmö");

       //Create the manager for people
       GymManager manager= new GymManager();

       //Start the menu with the gym and manager
       GymMenu menu= new GymMenu(manager,gym);
       menu.start();
    }
}
