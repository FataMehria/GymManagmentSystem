import java.util.ArrayList;
import java.util.List;

public class GymManager {
    //List person can store all three subclasses, so
    //No need of a separate list for each
    private List<Person> people;

    public GymManager(){
        //creates an empty arraylist of people
        people = new ArrayList<>();
    }
    //add person to collection
    public void addPerson(Person person){
        if (person==null){
            throw new IllegalArgumentException("Person can not be null");
        }
        people.add(person);
    }
    //display all people and demonstrates polymorphism through printInfo()
    public void showAllPeople(){
        if(people.isEmpty()){
            System.out.println("No people found.");
        }
        for(Person person:people){
            person.printInfo();
        }
    }
    //searches for a person by name, ignoring uppercase and lowercase difference
    public Person findPersonByName(String name){
        if (name==null || name.isBlank()){
            return null;
        }
        for (Person person:people){
            if(person.getName().equalsIgnoreCase(name.trim())){
                return person;
            }
        }
        return null;
    }
    //removes a person if a matching name is found
    public boolean removePerson(String name){
        Person person = findPersonByName(name);
        if (person==null){
            return false;
        }
        people.remove(person);
        return true;
    }





}
