import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test FireAnt class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class FireAntTest extends TestCase
{
    //~ Fields ................................................................
    
    private Colony colony;
    private FireAnt ant;
    private Bee bee1;
    private Bee bee2;
    private Bee bee3;
    private Bee bee4;
    private Bee bee5;
    private Bee bee6;
    private Bee bee7;
    private Bee bee8;
    private Bee bee9;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAntTest test object.
     */
    public FireAntTest()
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
        ant = new FireAnt();
        bee1 = new Bee();
        bee2 = new Bee();
        bee3 = new Bee();
        bee4 = new Bee();
        bee5 = new Bee();
        bee6 = new Bee();
        bee7 = new Bee();
        bee8 = new Bee();
        bee9 = new Bee();
        colony.add(ant, 2, 2);
    }


    // ----------------------------------------------------------
    
    /**
     * Test explode() method with bees
     * surrounding the FireAnt.
     */
    public void testExplode1()
    {
        colony.add(bee1, 2, 2);
        colony.add(bee2, 1, 1);
        colony.add(bee3, 2, 1);
        colony.add(bee4, 3, 1);
        colony.add(bee5, 3, 2);
        colony.add(bee6, 3, 3);
        colony.add(bee7, 2, 3);
        colony.add(bee8, 1, 3);
        colony.add(bee9, 1, 2);
        
        ant.explode();
        
        assertEquals(0, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test explode() method with bees
     * surrounding the FireAnt but no intersection.
     */
    public void testExplode2()
    {
        colony.add(bee2, 1, 1);
        colony.add(bee3, 2, 1);
        colony.add(bee4, 3, 1);
        colony.add(bee5, 3, 2);
        colony.add(bee6, 3, 3);
        colony.add(bee7, 2, 3);
        colony.add(bee8, 1, 3);
        colony.add(bee9, 1, 2);
        
        ant.explode();
        
        assertEquals(8, colony.getObjects(Bee.class).size());
    }
    /**
     * Test injure(int n) method.
     */
    public void testInjure()
    {
        colony.add(bee1, 2, 2);
        
        run(colony, 40);
        
        
        assertEquals(0, colony.getObjects(FireAnt.class).size());
        assertEquals(0, colony.getObjects(Bee.class).size());
    }

}
