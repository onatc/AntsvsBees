import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Bee class tries to reach to QueensChamber and attacks ants.
 *  
 *
 *  @author onatc6
 *  @version 2016.03.30
 */
public class Bee extends Actor
{
    //~ Fields ................................................................
    private int health;
    private int turn = 0;
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bee object.
     */
    public Bee()
    {
        health = 3;
        this.turn(180);
    }


    //~ Methods ...............................................................
    
    /**
     * getHealth() method returns health left.
     * @return health returns the health of bee.
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * injure(int n) method reduces bee's 
     * health by provided amount and removes
     * the bee if health is 0.
     * 
     * @param n amount the bee is injured.
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
     * Overrides getWorld method for Colony
     * to refer it directly from Bee class.
     * 
     * @return (Colony)super.getWorld()used
     * for easier access and more clear code.
     */
    public Colony getWorld()
    {
        return (Colony)super.getWorld();
    }
    
    /**
     * Main method that determines what the bee
     * does each turn.
     */
    public void act()
    {   
        if (this.getOneIntersectingObject(QueensChamber.class) == null)
        {
            Ant interAnt = this.getOneIntersectingObject(Ant.class);
            if (interAnt == null)
            {
                this.move(0.0125);
            }
            
            else
            {
                turn++;
                if (turn == 40)
                {
                    interAnt.injure(1);
                    turn = 0;
                }
            }
        }
        
        else
        {
            this.getWorld().lose();
        }
    }
}
