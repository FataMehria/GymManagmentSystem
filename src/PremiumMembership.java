public class PremiumMembership implements Membership{

    private GymBranch homeBranch;
    public PremiumMembership(GymBranch homeBranch){
        if (homeBranch==null){
            throw new IllegalArgumentException("Home Branch can not be null");
        }
        this.homeBranch=homeBranch;
    }


    @Override
    public boolean canBookPTAt(GymBranch gymBranch){
        //Checks if booking pt is at home branch or not
        return homeBranch.equals(gymBranch);
    }

    @Override
    public boolean canTrainAtAllBranches() {
        return true;
    }

    public GymBranch getHomeBranch() {
        return homeBranch;
    }
}
