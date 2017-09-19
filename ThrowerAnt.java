import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  ThrowerAnt class throws a leaf every 120 turns and
 *  injures the bee by 1 upon intersecting.
 *  Adding a ThrowerAnt costs 4 food units.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class ThrowerAnt extends Ant
{
    //~ Fields ................................................................
    private int turn = 0;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ThrowerAnt object.
     */
    public ThrowerAnt()
    {
        health = 1;
        foodCost = 4;
    }


    //~ Methods ...............................................................
    /**
     * This method determines what ThrowerAnt class
     * does each turn.
     */
    public void act()
    {
        turn++;
        if (turn == 120)
        {
            Leaf leaf = new Leaf();
            int valuex = this.getGridX();
            int valuey = this.getGridY();
            this.getWorld().add(leaf, valuex, valuey);
            turn -= 120;
        }
    }
}
