import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test leaf class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class LeafTest extends TestCase
{
    //~ Fields ................................................................
    private Bee bee;
    private Leaf leaf;
    private Colony colony;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new LeafTest test object.
     */
    public LeafTest()
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
        leaf = new Leaf();
        bee = new Bee();
        colony = new Colony();
    }


    // ----------------------------------------------------------
    
    /**
     * Test act() method when intersecting a bee.
     */
    public void testAct1()
    {
        colony.add(leaf, 2, 2);
        colony.add(bee, 5, 2);
        
        run(colony, 80);
        assertEquals(2, bee.getHealth());
        assertEquals(0, colony.getObjects(Leaf.class).size());
        
    }
    
    /**
     * Test act() method when there's no intersection.
     */
    public void testAct2()
    {
        colony.add(leaf, 2, 2);
        
        run(colony, 270);
        
        assertEquals(0, colony.getObjects(Leaf.class).size());
        
    }

}
