public class GymBranch{
    private String address;
    private Gym gym;
    public GymBranch(String address,Gym gym){
        if( address==null || address.isBlank()){
            throw new IllegalArgumentException("Gym address cannot be empty");
        }
        if (gym==null){
            throw new IllegalArgumentException("Gym cannot be null");
        }
        this.address=address;
        this.gym=gym;
    }
    public String getAddress() {
        return address;
    }

    public Gym getGym() {
        return gym;
    }
}
