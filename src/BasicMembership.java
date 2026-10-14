public class BasicMembership implements Membership{

    private GymBranch homeBranch;
    public BasicMembership(GymBranch homeBranch){
        if(homeBranch==null){
            throw new IllegalArgumentException("Home branch can not be null.");
        }
        this.homeBranch=homeBranch;
    }

    @Override
    public boolean canBookPTAt(GymBranch gymBranch) {
        return false;
    }

    @Override
    public boolean canTrainAtAllBranches() {
        return false;
    }

    public GymBranch getHomeBranch() {
        return homeBranch;
    }
}
