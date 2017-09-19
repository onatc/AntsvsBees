import sofia.micro.*;
import sofia.util.Random;
//-------------------------------------------------------------------------
/**
 *  Hive is where bees start spawning.
 *  it represents, and how to use it.
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class Hive extends Actor
{
    //~ Fields ................................................................
    private int turn = 0;
    private int addedBees;
    private int rDelay = 450;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Hive object.
     */
    public Hive()
    {
        addedBees = 30;
    }


    //~ Methods ...............................................................
    /**
     * Gets the number of bees remaining in the hive.
     * 
     * @return addedBees returns remaining bees in hive.
     */
    public int getBees()
    {
        return addedBees;
    }
    
    /**
     * Sets the amount of bees to be released.
     * 
     * @param n the amount of bees to be set.
     */
    public void setBees(int n)
    {
        addedBees -= 30;
        addedBees += n;
    }

    /**
     * Overrides getWorld method for Colony
     * to refer it directly from Hive class.
     * 
     * @return (Colony)super.getWorld() used
     * for easier access and more clear code.
     */
    public Colony getWorld()
    {
        return (Colony)super.getWorld();
    }
    
    /**
     * Main method that determines what hive does
     * every round. 
     * If there are no bees left ants win.
     */
    public void act()
    {
        int allBees = this.getBees() 
            + this.getWorld().getObjects(Bee.class).size();
        if (allBees > 0)
        {
            turn++;
            if (turn == 400)
            {
                this.addBees();
                rDelay = Random.generator().nextInt(320);
                turn = 0;
            }
            
            if ((rDelay + 80) == turn)
            {
                this.addBees();
                rDelay = Random.generator().nextInt(320);
                turn = 0;
            }
        }
        
        else
        {
            this.getWorld().win();
        }
        
    }
    
    /**
     * Adds bees into the world.
     */
    public void addBees()
    {
        if (this.getBees() != 0)
        {
            int valuey = Random.generator().nextInt(5);
            Bee bee = new Bee();
            this.getWorld().add(bee, 9, valuey + 1);
            addedBees -= 1;
        }
    }
    
    
}
