import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  ThrowerAnts throw leaves that harm bees if intersects.
 *  
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class Leaf extends Actor
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Leaf object.
     */
    public Leaf()
    {
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    /**
     * Main method that determines what
     * a leaf does every turn.
     */
    public void act()
    {
        Bee interBee = this.getOneIntersectingObject(Bee.class);
        this.move(0.025);
        if (interBee != null)
        {
            interBee.injure(1);
            this.remove();
        }
        
        else if (this.getGridX() == 9)
        {
            this.remove();
        }
    }
}
