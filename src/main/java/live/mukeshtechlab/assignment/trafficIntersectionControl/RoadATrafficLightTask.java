package live.mukeshtechlab.assignment.trafficIntersectionControl;

public class RoadATrafficLightTask implements Runnable {
    private TrafficIntersection trafficIntersection;

    public RoadATrafficLightTask(TrafficIntersection trafficIntersection){
        this.trafficIntersection = trafficIntersection;
    }

    @Override
    public void run(){
        trafficIntersection.trafficOnRoadA();
    }

}
