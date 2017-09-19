import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Colony class is the world for this program.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class Colony extends HomeBase
{
    //~ Fields ................................................................
    private int food;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Colony object.
     */
    public Colony()
    {
        super();
        
        Hive hive = new Hive();
        QueensChamber queensChamber = new QueensChamber();
        this.add(hive, 9 , 3);
        this.add(queensChamber, 0, 3);
        food = 10;
        

        setActorChoices(HarvesterAnt.class, ThrowerAnt.class,
            WallAnt.class, FireAnt.class, HungryAnt.class);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Add an ant to the screen when a specific location is clicked.
     * This method is automatically called while the simulation is
     * running, whenever the user clicks on (or taps on) a location
     * in the colony (one that isn't covered by an actor already).
     * 
     * @param x The x-coordinate of the click
     * @param y The y-coordinate of the click
     */
    public void onTouchDown(int x, int y)
    {
        // Complete this method yourself.
        Ant selectedAnt = ((Ant) newActorOfSelectedType());
        if (this.getFood() >= selectedAnt.getFoodCost() && x >= 1 
            && x <= 8 && y >= 1 && y <= 5 )
        {
            this.add(selectedAnt, x, y);
            this.consumeFood(selectedAnt.getFoodCost());
        }
    }
        
    
    /**
     * Returns the amount of food.
     * 
     * @return food returns remaining food.
     */
    public int getFood()
    {
        return food;
    }
    
    /**
     * addFood(int n) adds provided amount of
     * food.
     * @param n amount of food to be added.
     */
    public void addFood(int n)
    {
        food = food + n;
    }
    
    /**
     * consumeFood(int n) consumes provided amount
     * of food.
     * @param n amount of food to be consumed.
     */
    public void consumeFood(int n)
    {
        food = food - n;
        
    }
    
    
}
