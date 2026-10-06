public class PremiumMembership implements Membership{

    @Override
    public boolean canTrainAt(GymBranch gymBranch) {
        return gymBranch !=null;
    }

    @Override
    public boolean canBookPT() {
        return false;
    }
}
