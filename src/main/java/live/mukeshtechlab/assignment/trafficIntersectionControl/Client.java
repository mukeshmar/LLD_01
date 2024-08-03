package live.mukeshtechlab.assignment.trafficIntersectionControl;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args){
        TrafficIntersection trafficIntersection = new TrafficIntersection(new Semaphore(1), new Semaphore(0));

        // Create 2 Threads for Road A and Road B
        Thread roadA = new Thread(new RoadATrafficLightTask(trafficIntersection));
        Thread roadB = new Thread(new RoadBTrafficLightTask(trafficIntersection));

        roadA.start();
        roadB.start();

        try {
            roadA.join();
            roadB.join();
        }
        catch(InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }
}
