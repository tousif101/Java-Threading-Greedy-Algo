/**
 * Created by tousifchowdhury on 5/4/15.
 */

public class GremlinsBridge extends Object {
    /**
     *Create a GremlinsBridge with a given capacity.
     * The municipal authority creates a GremlinsBridge for each bridge that needs management.
     * @param max   the maximum capacity of the GremlinsBridge.
     */
    private int max;
    private int current = 0;


    public GremlinsBridge(int max){
        this.max = max;


        //Mogwai mog = new Mogwai();
    }



    /**
     *Request permission to go onto the gremlin's bridge. Mogwais call this method to ask the gremlin to put them
     *  on the queue of mogwais trying to get on the bridge.The Mogwai (thread) waits until
     *  it becomes the head of the queue and there is room on the gremlin's bridge.

     Note: Since this class is a monitor, this method needs to ensure mutual exclusive access by calling threads.
     That means synchronized methods are needed.

     The gremlin of a GremlinsBridge guards its bridge to make sure that mogwais get on
     the bridge in the order of their arrival.

     The gremlin of a GremlinsBridge prints the following message when the Mogwai
     shows up to get in line to cross the bridge:

     gremlin scowls "Get in line!" when mogwais_name_here shows up at the bridge.
     Precondition:

     The calling thread is the Mogwai instance itself.
     Postcondition:

     The mogwai got permission and has climbed onto the bridge.
     At some future time, the mogwai must call leave() to get off.
     * @param thisMogwai the Mogwai trying to get on the bridge (the same object as Thread calling this method).
     */
    public synchronized void enterBridgePlease(Mogwai thisMogwai){

        while (current <= max){
            try{
                wait();
            }catch (InterruptedException ie){

            }
        }

        current ++;

    }

    /**
     *Tell the gremlin of a GremlinsBridge that a mogwai has left the bridge so that the gremlin
     * can let other mogwais get on if there is room.

     A well-behaved Mogwai always informs the gremlin of a GremlinsBridge that it (the caller)
     is getting off the bridge.

     Note: Since this class is a monitor, this method needs to ensure mutual exclusive access by calling threads.
     That means synchronized methods are needed.

     Precondition:

     The calling thread is a Mogwai instance that has already called enterBridgePlease().
     Because of this precondition, a Mogwai argument is not needed.
     Postcondition:

     There is one less Mogwai on this GremlinsBridge.
     */
    public synchronized void leave(){

        if(current>0) {
            current--;
        }
        notify();


    }

}
