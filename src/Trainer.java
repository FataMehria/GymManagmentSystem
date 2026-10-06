public class Trainer extends Person{
    private String specialization;
    public Trainer(
            String name,
            int age,
            String email,
            String phone,
            GymBranch gymBranch,
            String specialization)
    {
        super(name,age,email,phone,gymBranch);

        if(specialization == null || specialization.isBlank()){
            throw new IllegalArgumentException("Specialization can not be empty.");
        }
        this.specialization=specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Specialization: Trainer("+specialization+")");
        System.out.println("===================");
    }

    @Override
    public String getRole() {
        return "Trainer";
    }

}
