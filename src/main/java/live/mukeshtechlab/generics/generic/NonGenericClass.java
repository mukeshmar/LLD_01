package live.mukeshtechlab.generics.generic;


// Generic methods in non-generic class
public class NonGenericClass {
    public <T> void printArray(T[] arr){
        System.out.print("{ ");
        for(T element : arr){
            System.out.print(element + ", ");
        }
        System.out.println("}");
    }
    public <T> void swapElement(T[] arr, int indexA, int indexB){
        T temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
