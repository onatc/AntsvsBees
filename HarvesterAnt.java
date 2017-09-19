import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  HarvesterAnt produces 1 unit of food every 40 turns.
 *  Adding a HarvesterAnt costs 2 food units.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class HarvesterAnt extends Ant
{
    //~ Fields ................................................................
    private int turn = 0;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HarversterAnt object.
     */
    public HarvesterAnt()
    {
        health = 1;
        foodCost = 2;
    }


    //~ Methods ...............................................................
   
    /**
     * This method determines what this class
     * does each turn.
     */
    public void act()
    {
        turn++;
        if (turn == 40)
        {
            this.getWorld().addFood(1);
            turn -= 40;
        }
    }
}
