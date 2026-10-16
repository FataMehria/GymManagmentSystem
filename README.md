# Gym Management System

## Project Idea

My project is a gym management system for managing people and gym branches. The program allows users to add, display, search for and remove members, staff and trainers, as well as display the gym's branches. Members can have different membership types that determine where they can train and wether they can book personal training(PT).

## Superclass

* Name: Person
* Common fields: name, age, email, phone and gymBranch
* Common methods: printInfo() displays the person's information and getRole() returns the person's role. The class also contains getter methods to access the person's information.

The superclass contains the common fields and methods shared by all types of people in the system.

## Subclasses
* Member: Represents a gym member and contains the field membership, which defines the member's membership type. It overrides printInfo() to display membership information and training permissions. It also overrides getRole() to return "Member".
* Staff: Represents a gym employee and contains the field position, which describes the employee's job position. It overrides printInfo() to display the position and getRole() to return "Staff".
* Trainer: Represents a gym trainer and contains the field specialization, which describes the trainer's area of expertise. It overrides printInfo() to display the specialization and getRole() to return "Trainer".

All three subclasses inherit common fields and methods from Person while adding their own specific information and behavior.

## Interface
* Name: Membership
* Methods: 
   1. canBookPTAt(GymBranch gymBranch) - checks whether personal training can be booked at home branch.
   2. canTrainAtAllBranches() - checks whether the member can train at all gym branches.
* Implemented by: BasicMembership and PremiumMembership.

BasicMembership does not allow training at all branches or booking personal training according to the current implementation. PremiumMembership allows training at all branches but only allows personal training bookings at the member's home branch.

## Menu
* Add a person: Allows the user to register a member, staff member or trainer. For members, the user also selects a membership type.
* Show all people: Displays information about all registered people, including information specific to their roles.
* Search for a person: Searches for a person by name. The search is case-insensitive.
* Remove a person: Removes a registered person by name.
* Show gym branches: Displays the address of the gym's branches.
* Exit: Close the program.

## Error Scenarios
* Invalid personal information: If the user enters an age outside the range of 18-90, an invalid email address, an invalid swedish phone number or leaves a required field empty, registration is rejected and an error message is displayed.
* Gym branch not found: If the user enters an address that does not match any registered gym branch, the person can not be registered, and the program displays an error message.
* Invalid age input: If the user enters text instead of a number for the age, the program displays an error message and cancels the registration.
* Person not found: If the user searches for or tries to remove a person who is not registered, the program displays a message indicating that the person was not found.

## Motivation

I chose Person as the superclass because members, staff and trainers share common information, such as name, age, email, phone and gymbranch. Inheritance allows to reuse these fields and methods instead of implementing them separately in each subclass.

I use polymorphism by storing all people in a shared List<Person> in GymManager. When printInfo() is called, the implementation belonging to the object's actual class is executed. This allows different types of people to display their information through the same method call.

I use the membership interface to define common methods for different membership types. BasicMembership and PremiumMembership implements the same interface but have different rules for training access and personal training bookings. This makes it easier to introduce additional membership types in the future.

I also separated person management in GymManager from the user interface in GymMenu. This separation makes the code easier to organize, maintain and develop further.

