import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test HungryAnt class.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class HungryAntTest extends TestCase
{
    //~ Fields ................................................................
    
    private HungryAnt ant;
    private Colony colony;
    private Bee bee;
    private Bee bumble;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAntTest test object.
     */
    public HungryAntTest()
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
        ant = new HungryAnt();
        bee = new Bee();
        bumble = new Bee();
        colony.add(ant, 2, 2);
    }


    // ----------------------------------------------------------
    
    /**
     * Test eat() method on intersection and 
     * stomach equaling 0.
     */
    public void testEat1()
    {
        colony.add(bee, 2, 2);
        
        ant.eat();
        
        assertEquals(0, colony.getObjects(Bee.class).size());
    }
    
    
    
    /**
     * Test eat() method no intersection.
     */
    public void testEat2()
    {
        colony.add(bee, 3, 2);
        
        ant.eat();
        
        assertEquals(1, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test eat() method on intersection
     * but stomach equaling 1.
     */
    public void testEat3()
    {
        colony.add(bee, 2, 2);
        colony.add(bumble, 2, 2);
        
        ant.eat();
        ant.eat();
        
        assertEquals(1, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test eat() method no intersection
     * and stomach equaling 1.
     */
    public void testEat4()
    {
        colony.add(bee, 3, 2);
        colony.add(bumble, 2, 2);
        
        ant.eat();
        ant.eat();
        
        assertEquals(1, colony.getObjects(Bee.class).size());
    }
    
    /**
     * Test act() method.
     */
    public void testAct()
    {
        colony.add(bee, 2, 2);
        
        ant.act();
        run(colony, 240);
        colony.add(bumble, 2, 2);
        ant.act();
        
        assertEquals(0, colony.getObjects(Bee.class).size());
    }
}
