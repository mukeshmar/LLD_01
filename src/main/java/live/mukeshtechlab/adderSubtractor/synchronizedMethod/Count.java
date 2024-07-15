package live.mukeshtechlab.adderSubtractor.synchronizedMethod;

public class Count {
    int value = 0; // Assign default value as well

    public synchronized void addValue(int value){
        this.value += value;
    }
    public synchronized void subtractValue(int value){
        this.value -= value;
    }
    public int getValue(){
        return value;
    }
}
