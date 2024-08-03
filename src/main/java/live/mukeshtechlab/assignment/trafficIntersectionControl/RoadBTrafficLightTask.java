package live.mukeshtechlab.assignment.trafficIntersectionControl;

public class RoadBTrafficLightTask implements Runnable {
    private TrafficIntersection trafficIntersection;

    public RoadBTrafficLightTask(TrafficIntersection trafficIntersection){
        this.trafficIntersection = trafficIntersection;
    }

    @Override
    public void run(){
        trafficIntersection.trafficOnRoadB();
    }

}
