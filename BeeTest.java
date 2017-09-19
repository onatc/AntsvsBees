import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 * Test Bee class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class BeeTest extends TestCase
{
    //~ Fields ................................................................
    private Bee bee;
    private Colony colony;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BeeTest test object.
     */
    public BeeTest()
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
        bee = new Bee();
        colony = new Colony();
    }


    // ----------------------------------------------------------
    
    /**
     * Test getHealth() method.
     */
    public void testGetHealth()
    {
        colony.add(bee, 2, 2);
        
        bee.getHealth();
        
        assertEquals(3, bee.getHealth());
    }
    
    /**
     * Test injure(int n) method when health > 0.
     */
    public void testInjure1()
    {
        colony.add(bee, 2, 2);
        
        bee.injure(2);
        
        assertEquals(1, bee.getHealth());
    }
    
    /**
     * Test injure(int n) method when health equals 0.
     */
    public void testInjure2()
    {
        colony.add(bee, 2, 2);
        
        bee.injure(3);
        
        assertEquals(0, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test act() method when bee isn't on
     * QueensChamber and no intersecting objects.
     */
    public void testAct1()
    {
        colony.add(bee, 2, 2);
        
        run(colony, 80);

        assertEquals(1, bee.getGridX());
    }
    
    
    /**
     * Test act() method when bee isn't on
     * QueensChamber and bee intersects ant
     * and turn equals 40.
     * 
     */
    public void testAct2()
    {
        Ant ant = new WallAnt();
        colony.add(bee, 2, 2);
        colony.add(ant, 2, 2);
        
        run(colony, 40);
        
        assertEquals(3, ant.getHealth());
    }
    
    /**
     * Test act() method when bee isn't on
     * QueensChamber and bee intersects ant
     * and turn is less than 40.
     * 
     */
    public void testAct3()
    {
        Ant ant = new WallAnt();
        colony.add(bee, 2, 2);
        colony.add(ant, 2, 2);
        
        run(colony, 39);
        
        assertEquals(2, bee.getGridX());
        assertEquals(4, ant.getHealth());
    }
    
    /**
     * Test act() method when bee is on 
     * QueensChamber.
     */
    public void testAct4()
    {
        colony.add(bee, 0, 3);
        
        bee.act();
        
        assertTrue(colony.isGameOver());
    }
}
