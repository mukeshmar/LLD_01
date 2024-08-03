package live.mukeshtechlab.assignment.trafficIntersectionControl;

import java.util.concurrent.Semaphore;

public class TrafficIntersection {
    private Semaphore roadASema; // Manage green light for road A
    private Semaphore roadBSema; // Manage green light for road B

    public TrafficIntersection(Semaphore roadASema, Semaphore roadBSema){
        this.roadASema = roadASema;
        this.roadBSema = roadBSema;
    }

    private void sleep(int second){
        try{
            Thread.sleep(1000* second);
        }
        catch(InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }

    public void trafficOnRoadA(){
        while(true){
            // if green light is on the road A
            try{
                // Wait if road B has green light
                roadASema.acquire();
            }
            catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
            System.out.println("Road A : Green");
            sleep(5);

            System.out.println("Road A : Yellow");
            sleep(1);

            roadBSema.release(); // Notify road to Green


            System.out.println("Road A : Red");
            sleep(5);
        }
    }
    public void trafficOnRoadB(){
        while(true){

            System.out.println("Road B : Red");
            sleep(5);

            // if green light is on the road A
            try{
                // Wait if road B has green light
                roadBSema.acquire();
            }
            catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
            System.out.println("Road B : Green");
            sleep(5);

            System.out.println("Road B : Yellow");
            sleep(1);
            roadASema.release(); // Notify road to Green

        }
    }
}
