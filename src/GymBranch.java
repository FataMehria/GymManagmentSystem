public class GymBranch{
    private String address;
    public GymBranch(String address){
        if( address==null || address.isBlank()){
            throw new IllegalArgumentException("Gym address cannot be empty");
        }
        this.address=address;
    }
    public String getAddress() {
        return address;
    }

}
