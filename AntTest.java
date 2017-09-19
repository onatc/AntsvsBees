import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test for Ant class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class AntTest extends TestCase
{
    //~ Fields ................................................................
    private Colony colony;
    private WallAnt ant;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AntTest test object.
     */
    public AntTest()
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
        ant = new WallAnt();
    }


    // ----------------------------------------------------------
    
     /**
     * Test getHealth() method.
     */
    public void testGetHealth()
    {
        colony.add(ant, 2, 2);
        
        ant.getHealth();
        
        assertEquals(4, ant.getHealth());
    }
    
    /**
     * Test injure(int n) method when health > 0.
     */
    public void testInjure1()
    {
        colony.add(ant, 2, 2);
        
        ant.injure(2);
        
        assertEquals(2, ant.getHealth());
    }
    
    /**
     * Test injure(int n) method when health equals 0.
     */
    public void testInjure2()
    {
        colony.add(ant, 2, 2);
        
        ant.injure(4);
        
        assertEquals(0, colony.getObjects(WallAnt.class).size());
    }
    
    /**
     * Test foodCost() method.
     */
    public void testFoodCost()
    {
        colony.add(ant, 2, 2);
        
        assertEquals(4, ant.getFoodCost());
    }
}
