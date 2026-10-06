import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Gym gym1=new Gym("Actic");
        GymBranch g1=new GymBranch("Lund",gym1);
        GymBranch g2=new GymBranch("Malmä",gym1);
        BasicMembership b1=new BasicMembership(g1);
        PremiumMembership p1=new PremiumMembership();
        Trainer t1=new Trainer("Ahmad",24,"Ahmad@gmail.com","0720337847",g1,"Mobility");
        Staff s1=new Staff("Ali jan",40,"Ali@gmail.com","0723337956",g1,"Reciptionist");
        List<Person> members=new ArrayList<>();
        members.add(t1);
        members.add(s1);
        for(Person p:members){
            p.printInfo();
        }
    }
}
