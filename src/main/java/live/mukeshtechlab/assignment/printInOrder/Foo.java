package live.mukeshtechlab.assignment.printInOrder;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore firstSema;
    private Semaphore secondSema;
    private Semaphore thirdSema;

    public Foo(Semaphore firstSema, Semaphore secondSema, Semaphore thirdSema){
        this.firstSema = firstSema;
        this.secondSema = secondSema;
        this.thirdSema = thirdSema;
    }

    public void first(){
        while (true){
            try{
                firstSema.acquire();
                Thread.sleep(1000); // Method is taking time to print
            }
            catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
            System.out.println("First");
            secondSema.release();
        }
    }
    public void second(){

        while(true){
            try{
                secondSema.acquire();
                Thread.sleep(1000); // Method is taking time to print
            }
            catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }
            System.out.println("Second");
            thirdSema.release();
        }

    }
    public void third(){

        while(true){
            try{
                thirdSema.acquire();
                Thread.sleep(1000); // Method is taking time to print
            }
            catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }
            System.out.println("Third");
            firstSema.release();
        }

    }
}
