public class Person {
    private String name;
    private int age;
    private String email;
    private String phone;
    private GymBranch gymBranch;

    public Person(String name,int age,String email,String phone,GymBranch gymBranch){
        if( name==null || name.isBlank() ){
            throw new IllegalArgumentException("Name can not be empty");
        }
        if(age<18 || age>90){
            throw new IllegalArgumentException("Age limit is between 18-90");
        }
        if (!isValidEmail(email)){
            throw new IllegalArgumentException("Email format is not correct.");
        }
        if(gymBranch==null){
            throw new IllegalArgumentException("Gym branch can not be null");
        }

        this.name=name;
        this.age=age;
        this.email=email;
        this.phone=normalizeAndValidatePhone(phone);
        this.gymBranch=gymBranch;
    }
    public String getName() {
        return name;
    }
    public GymBranch getGymBranch() {
        return gymBranch;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    /*
    //.matches is a method of String class. it checks wether the
    //Entire String matches a given regular expression(regex)
    // and returns a boolean
    //regex = regular expression= which means a pattern that describes
    //what text should look like. instead of checking manually
    //we can describe the whole pattern and that is why i used .matches
    //^ means start of the text
    //[A-Za-z0-9._%+-] is a character class and means at least
    //one character from this collection
    //Contains uppercase,lowercase,digit,dot,%,plus,hyphen
    //+ after first collection means that at least one or more of the
    //previous thing.
    //@ email must contain @
    //then second part and then\\. which means dot
    // if it is just . it means any charachter not dot
    // we use \\. if we use one it is escape character in java
    // regex actually recieve this \\. like this \. which means dot
    //final part means that it should has at least 2 character at the end
    //$ sign means end of text*/

    private boolean isValidEmail(String email){
        return email !=null && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    private String normalizeAndValidatePhone(String phone){
        if(phone==null || phone.isBlank()){
            throw new IllegalArgumentException("Phone number can not be empty.");
        }
        phone = phone.replace(" ","").replace("-","");

        if(!phone.matches("^(07[0-9]{8}|\\+467[0-9]{8})$")){
            throw new IllegalArgumentException("Phone number must be a valid Swedish number.");
        }
        return phone;
    }
    public void printInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Email: "+email);
        System.out.println("Phone: "+phone);
        System.out.println("Gym branch: "+gymBranch.getGym().getName());
        System.out.println("Gym location: "+gymBranch.getAddress());
    }
    public String getRole(){
        return "Person";
    }
}
