import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class raspunsCorect extends Actor
{
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    
    private static final Color transparent = new Color(0,0,0,0);

    
    /**
     * Create a new label, initialise it with the int value to be shown and the font size 
     */
    public raspunsCorect(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
    }
    
    /**
     * Create a new label, initialise it with the needed text and the font size 
     */
    public raspunsCorect(String value, int fontSize)
    {
        this.value = value;
        this.fontSize = fontSize;
        updateImage();
    }

    /**
     * Sets the value  as text
     * 
     * 
     */
    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }
    
    /**
     * Sets the value as integer
     * 
     * 
     */
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }
    
    /**
     * Sets the line color of the text
     * 
     * 
     */
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }
    
    /**
     * Sets the fill color of the text
     * 
     * 
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }
    

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
    public void act()
    {
     if(Greenfoot.mouseClicked(this))
     {
      Actor buton1 = getWorld().getObjects(raspunsGresit.class).get(0);
      Actor buton2 = getWorld().getObjects(raspunsGresit.class).get(1);
      Actor intrebareee = getWorld().getObjects(Intrebare.class).get(0);
      getWorld().removeObject(buton1);
      getWorld().removeObject(buton2);
      getWorld().removeObject(intrebareee);
      Sky.gameHasEnded = false;   
      getWorld().removeObject(this);
     }
    }
}
