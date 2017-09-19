import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  WallAnt class stops the bee because it has a health of 4.
 *  Adding a WallAnt costs 4 food units.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class WallAnt extends Ant
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WallAnt object.
     */
    public WallAnt()
    {
        health = 4;
        foodCost = 4;
    }


    //~ Methods ...............................................................


}
