/**
 * Created by tousifchowdhury on 5/4/15.
 */

public class Mogwai extends Thread {
    private String name;
    private int crossTime;
    private String destination;
    private GremlinsBridge bridgeGuard;
    /**
     *
     * @param name
     * @param crossTime
     * @param destination
     * @param bridgeGuard
     */
    public Mogwai(String name, int crossTime, String destination, GremlinsBridge bridgeGuard){



        this.name = name;
        this.crossTime = crossTime;
        this.destination = destination;
        this.bridgeGuard = bridgeGuard;

    }

    /**
     *
     */
    public void run(){

        bridgeGuard.enterBridgePlease(this);

        for(int i = 0; i <crossTime; i++){
            if (i == 0) {
                System.out.println(name + "is starting to cross");
            }
            else {

                System.out.println(name + i + "second");
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        bridgeGuard.leave();
        System.out.println(name +"Leaves at" + destination+".");


    }
}
