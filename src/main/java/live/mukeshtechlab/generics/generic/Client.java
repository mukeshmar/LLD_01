package live.mukeshtechlab.generics.generic;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Generic Class
        Box<Integer> box = new Box<>();
        box.addContent(1);
        box.addContent(2);
        box.addContent(3);
        // box.addContent("Adding string"); // Uncommenting this line will cause a compile-time error

        System.out.println(box.getContent()); // Output: 3


        // Generic Method in non-generic class
        NonGenericClass nonGenericClass  = new NonGenericClass();

        Integer[] arr = {1, 2, 3, 4, 5};

        nonGenericClass.swapElement(arr, 2, 4);
        nonGenericClass.printArray(arr);

        String[] stringArr = {"Apple", "Mango"};
        nonGenericClass.printArray(stringArr);

        // PairImp ->
        PairImp<Integer, String> pairImp = new PairImp<>();
        pairImp.setKeyValue(1, "Mukesh");
        System.out.println("< Key: " + pairImp.getKey() + ", value: " + pairImp.getValue() + " >");

    }

    public static void printListUnbounded(List<?> list){
        // Unbounded WildCard in Generics
        // This method will accept a list of all type
    }

    public static void printListUpperBound(List<? extends Number> list){
        // Upper-Bounded WildCard in Generics
        // This method will only accept List of a Number type and its subclasses
    }

    public static void printListLowerBound(List<? super Number> list){
        // Lower-Bounded WildCard in Generics
        // This method will only accept List of a Number type and its super/parent class only
    }


}
