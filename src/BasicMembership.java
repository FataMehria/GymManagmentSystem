public class BasicMembership implements Membership{

    private GymBranch homeBranch;
    public BasicMembership(GymBranch homeBranch){
        if(homeBranch==null){
            throw new IllegalArgumentException("Home branch can not be null.");
        }
        this.homeBranch=homeBranch;
    }
    @Override
    public boolean canTrainAt(GymBranch gymBranch) {

        return homeBranch.equals(gymBranch);
    }

    @Override
    public boolean canBookPT() {
        return true;
    }

    public GymBranch getHomeBranch() {
        return homeBranch;
    }

}
