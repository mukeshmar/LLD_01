package live.mukeshtechlab.deepVsShallowCopy;

public class DeepCopy {
    public static void main(String[] args) {
        Person p1 = new Person("Mukesh", new Address("Jaipur"));

        // Creating deep copy
        Person p2 = new Person(p1.name, new Address(p1.address.street));

        // Change in copy Entity
        p2.name = "Mukesh Mar";
        p2.address.street = "Bikaner";

        // Print P1 object
        System.out.println("Name : " + p1.name + " & Address: " + p1.address.street);

        // Print p2 object
        System.out.println("Name : " + p2.name + " & Address: " + p2.address.street);
    }
}
