public class Gym {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAdress() {
        return address;
    }
    public Gym(String name,String address){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Gym name cannot be empty.");
        }
        if( address==null || address.isBlank()){
            throw new IllegalArgumentException("Gym address cannot be empty");
        }
        this.name=name;
        this.address=address;
    }
}
