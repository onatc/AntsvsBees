import sofia.micro.*;
import java.util.List;

//-------------------------------------------------------------------------
/**
 *  A subclass of Ant class that destroys the bees around it.
 *  If FireAnt and a bee intersects, FireAnt blows itself up
 *  while removing the bees around it.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class FireAnt extends Ant
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAnt object.
     */
    public FireAnt()
    {
        health = 1;
        foodCost = 4;
    }


    //~ Methods ...............................................................
    
    /**
     * explode() method removes all bees around
     * while removing itself upon intersecting a bee.
     */
    public void explode()
    {
        if (this.getOneIntersectingObject(Bee.class) != null)
        {
            this.getOneIntersectingObject(Bee.class).injure(3);
            List explodingBee = this.getNeighbors(1, true, Bee.class);
            for (int i = 0; i < explodingBee.size(); i++)
            {
                this.getOneNeighbor(1, true, Bee.class).remove();
            }
        }
    }
    
    /**
     * injure(int n) overrides injure(int n) method
     * in Ant class.
     * 
     * @param n amount the FireAnt injured.
     */
    public void injure(int n)
    {
        health = health - n;
        this.explode();
        this.remove();
    }
}

