import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Gym gym1=new Gym("Actic");
        GymBranch g1=new GymBranch("Lund",gym1);
        GymBranch g2=new GymBranch("Malmä",gym1);
        BasicMembership b1=new BasicMembership(g1);
        PremiumMembership p1=new PremiumMembership(g1);
        Member m1= new Member("Sara",25,"Sara@gmail.com", "0773482843",g1,b1);
        Trainer t1=new Trainer("Ahmad",24,"Ahmad@gmail.com","0720337847",g1,"Mobility");
        Staff s1=new Staff("Ali jan",40,"Ali@gmail.com","0723337956",g1,"Reciptionist");
        GymManager manager=new GymManager();
        manager.addPerson(m1);
        manager.addPerson(s1);
        manager.addPerson(t1);
        System.out.println("=== All People ===");
        manager.showAllPeople();
        System.out.println("=== Search for Sara ===");
        Person found= manager.findPersonByName("Sara");
        if(found != null){
            found.printInfo();
        }else {
            System.out.println("Person not found");
        }
        System.out.println("=== Remove People Test ===");
        if (manager.removePerson("Ali")){
            System.out.println("Ali was removed");
        }else {
            System.out.println("Person not found");
        }
        System.out.println("=== People after removal ===");
        manager.showAllPeople();
        //new branch test
    }
}
