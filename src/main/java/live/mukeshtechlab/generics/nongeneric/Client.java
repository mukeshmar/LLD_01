package live.mukeshtechlab.generics.nongeneric;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        /*
        Issues: There is no compile-time type safety.
        We may get an error at runtime while retrieving and typecasting the data.
        Adding elements will not give errors, but retrieving and typecasting them may cause errors if the types do not match.
         */

        // Creating a List without specifying a type.
        // This allows adding objects of any type to the list.
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        list.add(1);  // Adding an integer, which will cause issues later during retrieval and casting.

        // Iterating and casting elements to String
        for (Object listObj : list) {
            System.out.println((String) listObj);  // This may cause a ClassCastException if the element is not a String.
        }
    }
}
