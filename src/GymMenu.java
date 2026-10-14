import java.util.Locale;
import java.util.Scanner;

public class GymMenu {
    private Scanner scan;
    private GymManager manager;
    private Gym gym;

    //Receives the manager and gym from main
    public GymMenu(GymManager manager, Gym gym) {
        this.manager = manager;
        this.scan = new Scanner(System.in);
        this.gym = gym;
    }

    public void start() {
        boolean running = true;

        //keeps the menu running until the user chooses to exit
        while (running) {
            System.out.println("\n====Gym Management System ====");
            System.out.println("1. Add a person");
            System.out.println("2. Show all people");
            System.out.println("3. Search for a person");
            System.out.println("4. Remove a person");
            System.out.println("5. Show gym branches");
            System.out.println("0. Exit");
            System.out.print("Choose an option between 0-5: ");
            String choice = scan.nextLine();

            //handles the user choice
            switch (choice) {

                case "1":
                    addPerson();
                    break;
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
                    gym.showBranches();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //add a new member, staff or trainer
    private void addPerson(){
        System.out.println("Choose person type: ");
        System.out.println("1. Member");
        System.out.println("2. Staff");
        System.out.println("3. Trainer");
        System.out.println("0. Back to menu");
        System.out.print("Choose an option between 0-3: ");

        String choice=scan.nextLine();

        if(choice.equals("0")){
            return;
        }

        System.out.print("Enter name: ");
        String name=scan.nextLine();

        //read the person information and validate the input
        try {
            System.out.print("Enter age: ");
            int age= Integer.parseInt(scan.nextLine());

            System.out.print("Enter email: ");
            String email=scan.nextLine();

            System.out.print("Enter phone: ");
            String phone=scan.nextLine();

            System.out.println("Choose gym branch: ");
            gym.showBranches();
            System.out.print("Enter branch address: ");
            String address=scan.nextLine();

            GymBranch branch=null;
            //find the branch selected by the user
            for (GymBranch gymBranch: gym.getBranches()){
                if(gymBranch.getAddress().equalsIgnoreCase(address.trim())){
                    branch=gymBranch;
                    break;
                }
            }
            if (branch == null){
                System.out.println("Branch not found.");
                return;
            }
            Person person=null;
            switch (choice){
                case "1":
                    //slect the membership type for a new member
                    System.out.println("Choose membership: ");
                    System.out.println("1. Basic");
                    System.out.println("2. Premium");
                    System.out.println("Choose an option between 1-2: ");
                    String memberChoice=scan.nextLine();
                    Membership membership=null;

                    if(memberChoice.equals("1")){
                        membership=new BasicMembership(branch);
                    } else if (memberChoice.equals("2")) {
                        membership= new PremiumMembership(branch);
                    }else {
                        System.out.println("Invalid membership choice.");
                    }

                    //Create the selected person using the appropriate constructor
                    person= new Member(name,age,email,phone,branch,membership);
                    break;
                case "2":
                    System.out.print("Enter position: ");
                    String position=scan.nextLine();
                    //Create the selected person using the appropriate constructor
                    person=new Staff(name,age,email,phone,branch,position);
                    break;
                case "3":
                    System.out.println("Enter specialization: ");
                    String specialization=scan.nextLine();

                    //  //Create the selected person using the appropriate constructor
                    person=new Trainer(name,age,email,phone,branch,specialization);
                    break;
                default:
                    System.out.println("Invalid person type.");
                    break;

            }
            //add the person to the gym's people collection
            manager.addPerson(person);
            System.out.println("Person add successfully");
        }//handle invalid number input and invalid person information
        catch (NumberFormatException e){
            System.out.println("Age must be a number.");
        } catch (IllegalArgumentException e){
            System.out.println("Invalid information: "+e.getMessage());
        }
        System.out.println("Press enter to return to the menu.");
        scan.nextLine();

    }
    //searches for a person name
    private void searchPerson() {
        System.out.print("Enter person's name: ");
        String name = scan.nextLine();

        Person person = manager.findPersonByName(name);

        if (person != null) {
            person.printInfo();
        } else {
            System.out.println("Person not found.");
        }
    }

    //removes a person by name
    private void removerPerson() {
        System.out.print("Enter the person's name to remove: ");
        String name = scan.nextLine();

        if (manager.removePerson(name)) {
            System.out.println("Person removed successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }

}
