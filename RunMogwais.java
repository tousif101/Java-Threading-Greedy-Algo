public class RunMogwais {

    /** SIDE_ONE is Andreenosn.  */
    public final static String SIDE_ONE = "Andreenos";

    /** SIDE_TWO is Bandi.  */
    public final static String SIDE_TWO = "Bandi";

    /** 
     * Command interface for collecting all the functions in this test suite.
     * Single method is Command.execute().
     */
    private interface Command {
        public void execute();
    }

    /** 
     * testSuite is the list of test cases.
     */
    private static Command[] testSuite = {
        new Command() { public void execute() { RunMogwais.test0(); }},
        new Command() { public void execute() { RunMogwais.test1(); }},
        new Command() { public void execute() { RunMogwais.test2(); }},
        new Command() { public void execute() { RunMogwais.test3(); }},
    };

    /** TEST_COUNT is number of test cases.  */
    public final static int TEST_COUNT = testSuite.length;

    /**
     * test0 is Test Scenario 0, an extremely simple, non-waiting test.
     * test0 provides an example template/pattern for writing a test case.
     */
    static void test0() {

        System.out.println( "Begin test0. ===============================\n" );

        Thread init = Thread.currentThread();      // init spawns the Mogwais

        // Create a GremlinsBridge of capacity 3.
        GremlinsBridge gremlinBridge = new GremlinsBridge( 3 );

        // Set an optional, test delay to stagger the start of each mogwai.
        int delay = 4000;

        // Create the Mogwais and store them in an array.
        Thread peds[] = {
            new Mogwai( "Al",    3, SIDE_ONE, gremlinBridge ),
            new Mogwai( "Bob",   4, SIDE_TWO, gremlinBridge ),
        };

        for ( int j = 0; j < peds.length; ++j ) {
            // Run them by calling their start() method.
            try {
                peds[j].start();
                init.sleep( delay );
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        // Now, the test must give the mogwai time to finish their crossings.
        for ( int j = 0; j < peds.length; ++j ) {
            try {
                peds[j].join();
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        System.out.println( "\n=============================== End test0." );
        return;
    }

    /**
     * test1 is Test Scenario 1, another fairly simple simulation run.
     * test1 provides another example for writing a test case.
     */
    static void test1() {

        System.out.println( "Begin test1. ===============================\n" );

        Thread init = Thread.currentThread();      // init spawns the Mogwais

        // Create a GremlinsBridge of capacity 3.
        GremlinsBridge gBridge = new GremlinsBridge( 3 );

        int delay = 1000;

        // Create the Mogwais and store them in an array.
        Thread peds[] = {
            new Mogwai( "Al",    3, SIDE_ONE, gBridge ),
            new Mogwai( "Bob",   2, SIDE_ONE, gBridge ),
            new Mogwai( "Cathy", 2, SIDE_TWO, gBridge ),
            new Mogwai( "Doris", 3, SIDE_TWO, gBridge ),
            new Mogwai( "Edith", 3, SIDE_ONE, gBridge ),
            new Mogwai( "Fred",  2, SIDE_TWO, gBridge ),
        };

        for ( int j = 0; j < peds.length; ++j ) {
            // Run them by calling their start() method.
            try {
                peds[j].start();
                init.sleep( delay );         // delay start of next mogwai
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
            }
        }
        // Now, the test must give the mogwai time to finish their crossings.
        for ( int j = 0; j < peds.length; ++j ) {
            try {
                peds[j].join();              // wait for next mogwai to finish
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
            }
        }

        System.out.println( "\n=============================== End test1." );
    }

    /**
     * TODO: write YOUR test case here.
     */
    static void test2() {

        System.out.println( "Begin test2. ===============================\n" );

        Thread init = Thread.currentThread();      // init spawns the Mogwais

        System.out.println( "TODO: write a more involved test here." );
        //
        // Create a GremlinsBridge of capacity 3.
        // Set an OPTIONAL, test delay to stagger the start of each mogwai.
        // Create the Mogwais and store them in an array.
            // Run them by calling their start() method.
        // Now, the test must give the mogwai time to finish their crossings.
        //
        System.out.println( "TODO: follow the pattern of the example tests." );
        System.out.println( "\n=============================== End test2." );
    }

    /**
     * TODO: write YOUR second test case here.
     */
    static void test3() {

        System.out.println( "Begin test3. ===============================\n" );

        Thread init = Thread.currentThread();      // init spawns the Mogwais

        System.out.println( "TODO: write another, more involved test here." );
        System.out.println( "\n=============================== End test3." );
    }

    /**
     * Run all the tests in this test suite.
     *
     * @param args not used
     */
    public static void main( String args[] ) {

        for ( int j = 0; j < TEST_COUNT; ++j ) {
            testSuite[j].execute();
        }
    }

}

/* 
 * Revisions:
 * $Log: RunMogwais.java,v $
 * Revision 1.1  2012/05/03 21:56:42  vcss243
 * Initial revision
 *
 */
