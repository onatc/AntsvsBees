import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test ThrowerAnt class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class ThrowerAntTest extends TestCase
{
    //~ Fields ................................................................
    private Colony colony;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ThrowerAntTest test object.
     */
    public ThrowerAntTest()
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
        ThrowerAnt ant = new ThrowerAnt();
        colony.add(ant, 2, 2);
    }


    // ----------------------------------------------------------
    
    /**
     * Test act() method.
     */
    public void testAct1()
    {
        run(colony, 120);
        
        assertEquals(1, colony.getObjects(Leaf.class).size());
    }

}
