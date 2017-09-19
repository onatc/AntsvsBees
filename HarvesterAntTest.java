import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test HarvesterAnt class.
 *
 *  @author onatc6
 *  @version 2016.03.380
 */
public class HarvesterAntTest extends TestCase
{
    //~ Fields ................................................................
    
    private Colony colony;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HarvesterAntTest test object.
     */
    public HarvesterAntTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        colony = new Colony();
        HarvesterAnt ant = new HarvesterAnt();
        colony.add(ant, 2, 2);
    }


    // ----------------------------------------------------------
    
    /**
     * Test act() method.
     */
    public void testAct()
    {
        run(colony, 40);
        
        assertEquals(11, colony.getFood());
    }

}
