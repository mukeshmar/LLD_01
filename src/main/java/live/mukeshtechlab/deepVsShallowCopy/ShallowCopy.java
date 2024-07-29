package live.mukeshtechlab.deepVsShallowCopy;

public class ShallowCopy {
    public static void main(String[] args) {
        Person p1 = new Person("Mukesh", new Address("Jaipur"));

        // Creating shallow copy
        Person p2 = new Person(p1.name, p1.address);

        // Change in copy Entity
        p2.name = "Mukesh Mar";
        p2.address.street = "Bikaner";

        // Print P1 object
        System.out.println("Name : " + p1.name + " & Address: " + p1.address.street);

        // Print p2 object
        System.out.println("Name : " + p2.name + " & Address: " + p2.address.street);
    }
}
