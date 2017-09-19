import sofia.micro.*;



// -------------------------------------------------------------------------
/**
 * Test Hive class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class HiveTest extends TestCase
{
    //~ Fields ................................................................
    private Colony colony;
    private Hive hive;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HiveTest test object.
     */
    public HiveTest()
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
        hive = new Hive();
        
    }


    // ----------------------------------------------------------
    
    /**
     * Test method getBees().
     */
    public void testGetBees()
    {
        colony.add(hive, 9, 3);
        
        assertEquals(30, hive.getBees());
    }
    
    /**
     * Test method addBees() when
     * int addedBees doesn't equal to 0.
     */
    public void testAddBees1()
    {
        colony.add(hive, 9, 3);
        
        hive.addBees();
        
        assertEquals(29, hive.getBees());
        assertEquals(1, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test method addBees() when
     * int addedBees equal 0.
     */
    public void testAddBees2()
    {
        colony.add(hive, 9, 3);
        
        hive.setBees(0);
        hive.addBees();
        
        assertEquals(0, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test act() method when turn == 400.
     */
    public void testAct1()
    {
        run(colony, 400);
        
        assertEquals(1, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test act() method when there are no bees left.
     */
    public void testAct2()
    {
        colony.add(hive, 9, 3);
        
        hive.setBees(0);
        
        hive.act();
        
        assertTrue(colony.isGameWon());
    }
    /**
     * Test setBees() method.
     */
    public void testSetBees()
    {
        colony.add(hive, 9, 3);
        
        hive.setBees(20);
        
        assertEquals(20, hive.getBees());
    }
    
}
