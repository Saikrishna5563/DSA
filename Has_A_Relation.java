

public class Has_A_Relation {

    public static void main(String[] args) {
        // Step 1: Create an Address object.
        Address addr = new Address("Ameerpet", "hyd", "Telangana");

        // Step 2: Create an Employee object, passing the Address object as an argument.
        Employee e = new Employee(101, "Saikrishna", 25000, addr);

        // Step 3: Print the Employee object. The toString() method of Employee will be implicitly called.
        System.out.println(e); // This will print the employee and address details.
    }
}

class Employee {
    int num;
    String name;
    int salary;
    Address addr; // Has-A relationship: Employee has an Address.

    // Step 4: Constructor to initialize Employee object.
    Employee(int num, String name, int salary, Address addr) {
        this.num = num;
        this.name = name;
        this.salary = salary;
        this.addr = addr; // Assigning the Address object to the Employee's addr field.
    }

    // Step 5: Override toString() method to provide a custom string representation of the Employee object.
    public String toString() {
        return this.num + "," + this.name + "," + this.salary + "," + this.addr; // Returning employee details along with address details.
    }
}

class Address {
    String street;
    String city;
    String state;

    // Step 6: Constructor to initialize Address object.
    Address(String street, String city, String state) {
        this.city = city;
        this.state = state;
        this.street = street;
    }

    // Step 7: Override toString() method to provide a custom string representation of the Address object.
    public String toString() {
        return this.street + "," + this.city + "," + this.state; // Returning address details.
    }
}