import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class StartMenu extends World
{

    /**
     * Constructor for objects of class StartMenu.
     * 
     */
    public StartMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    
    
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        Greenfoot.setWorld(new Sky());
        
    }
}
