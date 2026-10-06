public class Staff extends Person{
    private String position;
    public Staff(
            String name,
            int age,
            String email,
            String phone,
            GymBranch gymBranch,
            String position
    ){
        super(name,age,email,phone,gymBranch);

        if(position ==null || position.isBlank()){
            throw new IllegalArgumentException("Position can not be empty.")
        }
        this.position=position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Position: "+position);
    }

    @Override
    public String getRole() {
        return "Staff";
    }

}
