import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Main class for ants that provides the basic methods.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class Ant extends Actor
{
    //~ Fields ................................................................
    /**
     * Ants health.
     */
    public int health;
    
    /**
     * Food units needed to add a
     * specific ant.
     */
    public int foodCost;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ant object.
     */
    public Ant()
    {
        // Doesn't need to do anything subclasses
        // handle it.
    }


    //~ Methods ...............................................................
    
    /**
     * getHealth() method returns remaining health
     * of the ant.
     * 
     * @return health returns the health of the ant.
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * injure(int n) method reduces ant's
     * health by provided amount and removes
     * the bee if health is 0.
     * 
     * @param n amount the ant is injured.
     */
    public void injure(int n)
    {
        health = health - n;
        if (health == 0)
        {
            this.remove();
        }
    }
    
    /**
     * getFoodCost() method returns the foodCost
     * for the selected ant.
     * 
     * @return foodCost returns the food units needed.
     */
    public int getFoodCost()
    {
        return foodCost;
    }
    
    /**
     * Overrides getWorld method for Colony
     * to refer it directly from Ant class.
     * 
     * @return (Colony)super.getWorld() used
     * for easier access and more clear code.
     */
    public Colony getWorld()
    {
        return (Colony)super.getWorld();
    }
}
