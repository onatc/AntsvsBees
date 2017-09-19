import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  HungryAnt class eats the intersecting bee every 240 turns.
 *  Adding a HungryAnt costs 5 food units.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class HungryAnt extends Ant
{
    //~ Fields ................................................................
    private int turn = 0;
    private int stomach = 0;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAnt object.
     */
    public HungryAnt()
    {
        health = 1;
        foodCost = 5;
    }


    //~ Methods ...............................................................
    
    /**
     * This method determines what HungryAnt class
     * does each turn.
     */
    public void act()
    {
        this.eat();
        if (stomach == 1)
        {
            turn++;
            if (turn == 240)
            {
                stomach = 0;
            }
        }
    }
    
    /**
     * eat() method removes the intersecting bee.
     */
    public void eat()
    {
        Bee interBee = this.getOneIntersectingObject(Bee.class);
        if (interBee != null && stomach == 0)
        {
            interBee.remove();
            stomach = 1;
        }
    }
}
