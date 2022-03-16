import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreLine extends Actor
{
    /**
     * Things to do for each turn.
     * 
     */
    public void act() {
        // Moves the score line backward.
        move();
    }
    
    /**
     * Moves the pipe backward.
     * 
     */
    private void move()
    {
        setLocation(getX() - Bird.SPEED, getY());
        if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }
}
