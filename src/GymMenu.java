import java.util.Locale;
import java.util.Scanner;

public class GymMenu {
   private Scanner scan;
   private GymManager manager;
   private Gym gym;

   //Receives the manager and gym from main
   public GymMenu(GymManager manager,Gym gym){
       this.manager=manager;
       this.scan = new Scanner(System.in);
       this.gym=gym;
   }

   public void start(){
       boolean running=true;

       while (running){
           System.out.println("\n====Gym Management System ====");
           System.out.println("1. Add a person");
           System.out.println("2. Show all people");
           System.out.println("3. Search for a person");
           System.out.println("4. Remove a person");
           System.out.println("5. Show gym branches");
           System.out.println("0. Exit");
           System.out.print("Choose an option between 0-5: ");
           String choice = scan.nextLine();
           switch (choice){

               case "2":
                   manager.showAllPeople();
                   break;
               case "3":
                   searchPerson();
                   break;
               case "4":
                   removerPerson();
                   break;
               case "5":
                   System.out.println("Branch info will be here");
                   break;
               case "0":
                   running =false;
                   System.out.println("Goodbye!");
                   break;
               default:
                   System.out.println("Invalid choice. Please try again.");
           }
       }
   }
   private void searchPerson(){
       System.out.print("Enter person's name: ");
       String name=scan.nextLine();

       Person person=manager.findPersonByName(name);

       if(person != null){
           person.printInfo();
       }else {
           System.out.println("Person not found.");
       }
   }
   private void removerPerson(){
       System.out.print("Enter the person's name to remove: ");
       String name= scan.nextLine();

       if (manager.removePerson(name)){
           System.out.println("Person removed successfully.");
       }else {
           System.out.println("Person not found.");
       }
   }

}
