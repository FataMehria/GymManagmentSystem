public class Member extends Person{
private Membership membership;
public Member(String name,
              int age,
              String email,
              String phone,
              GymBranch gymBranch,
              Membership membership){
    super(name,age,email,phone,gymBranch);
    if (membership==null){
        throw new IllegalArgumentException("Membership can not be null");
    }
    this.membership=membership;
}

    public Membership getMembership() {
        return membership;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Membership: "+membership);
    }

    @Override
    public String getRole() {
        return "Member";
    }
}
