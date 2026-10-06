import java.util.ArrayList;
import java.util.List;

public class Gym {
    private String name;
    private List<GymBranch> branches;

    public Gym(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Gym name cannot be empty.");
        }

        this.name=name;
        //Initialize an empty list of gym branches
        this.branches= new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void addBranch(GymBranch branch){
        if (branch == null){
            throw new IllegalArgumentException("Branch cn not be null.");
        }
        branches.add(branch);
    }
    public void showBranches(){
        for(GymBranch branch:branches){
            System.out.println(branch.getAddress());
        }
    }
}
