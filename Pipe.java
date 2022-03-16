import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pipe extends Actor
{
   /** The speed of the pipes to move backward. */
    public static final int WIDTH = 55;
    
    /**
     * Creates a new pipe.
     * 
     * 
     */
    public Pipe(int height) {
        GreenfootImage image = new GreenfootImage(WIDTH, height);
        image.setColor(Color.BLUE);
        image.fill();
        setImage(image);
    }
    
    /**
     * Things to do for each turn.
     * 
     */
    public void act() {
        // Moves the pipe backward.
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
