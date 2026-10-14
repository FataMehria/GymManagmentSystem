public class PremiumMembership implements Membership{

    private GymBranch homeBranch;
    public PremiumMembership(GymBranch homeBranch){
        if (homeBranch==null){
            throw new IllegalArgumentException("Home Branch can not be null");
        }
        this.homeBranch=homeBranch;
    }

    @Override
    public boolean canTrainAt(GymBranch gymBranch) {
        return gymBranch !=null;
    }

    @Override
    public boolean canBookPT() {
        return true;
    }
    public boolean canBookPTAt(GymBranch gymBranch){
        //Checks if booking pt is at home branch or not
        return homeBranch.equals(gymBranch);
    }
}
