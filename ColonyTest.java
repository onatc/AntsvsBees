import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Tests Colony class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class ColonyTest extends TestCase
{
    //~ Fields ................................................................
    private Colony colony;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ColonyTest test object.
     */
    public ColonyTest()
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
    }


    // ----------------------------------------------------------
    /**
     * Test onTouchDown() when there's enough food
     * and x and y are valid.
     */
    public void testOnTouchDown1()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        
        colony.onTouchDown(2, 2);
        
        assertEquals(1, colony.getObjects(HarvesterAnt.class).size());
    }
    
     /**
     * Test onTouchDown() when there isn't enough food
     * but x and y are valid.
     */
    public void testOnTouchDown2()
    {
        colony.setSelectedActor(WallAnt.class);
        
        colony.onTouchDown(2, 2);
        colony.onTouchDown(3, 2);
        colony.onTouchDown(4, 2);
        
        assertEquals(2, colony.getObjects(WallAnt.class).size());
    }
    
    /**
     * Test onTouchDown() when there is enough food
     * but x is 0.
     */
    public void testOnTouchDown3()
    {
        colony.setSelectedActor(WallAnt.class);
        
        colony.onTouchDown(0, 2);
        
        assertEquals(0, colony.getObjects(WallAnt.class).size());
    }
    
    /**
     * Test onTouchDown() when there is enough food
     * but x is 9.
     */
    public void testOnTouchDown4()
    {
        colony.setSelectedActor(WallAnt.class);
        
        colony.onTouchDown(9, 2);
        
        assertEquals(0, colony.getObjects(WallAnt.class).size());
    }
    
    /**
     * Test onTouchDown() when there is enough food
     * but y is 0.
     */
    public void testOnTouchDown5()
    {
        colony.setSelectedActor(WallAnt.class);
        
        colony.onTouchDown(2, 0);
        
        assertEquals(0, colony.getObjects(WallAnt.class).size());
    }
    
    /**
     * Test onTouchDown() when there is enough food
     * but y is 6.
     */
    public void testOnTouchDown6()
    {
        colony.setSelectedActor(WallAnt.class);
        
        colony.onTouchDown(2, 6);
        
        assertEquals(0, colony.getObjects(WallAnt.class).size());
    }
    
    /**
     * Test getFood() method.
     */
    public void testGetFood()
    {
        assertEquals(10, colony.getFood());
    }
    
    /**
     * Test addFood() method.
     */
    public void testAddFood()
    {
        colony.addFood(1);
        
        assertEquals(11, colony.getFood());
    }
    
    /**
     * Test consumeFood() method.
     */
    public void testConsumeFood()
    {
        colony.consumeFood(1);
        
        assertEquals(9, colony.getFood());
    }

}
