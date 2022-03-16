import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bird extends Actor {
    /** The gravity to the ground. */
    public static final int GRAVITY = 1;
    
    /** The horizontal speed that the bird flies (the pipes move backwards). */
    public static final int SPEED = 10;
    
    /** The vertical speed when the bird flaps. */
    public static final int FLAP_SPEED = -10;
    
    /** The current virtical speed. */
    private int speed = 0;
    
    /** The score. */
    public static int score = 0;
    
    public int nrIntrebari = 30;
   
    
    
    public int livesLeft = 100;
    
    public boolean gameHasStarted = false;
    
    /**
     * Creates a new bird.
     * 
     */
    public Bird() {
    speed = 0;
    score = 0;
        // Add your action code here.
    }   
    
    public void intrebare()
    {    
     Sky.gameHasEnded = true;
     int i = Greenfoot.getRandomNumber(nrIntrebari);
     String question = Sky.data.intrebari[i];
     String raspunsG1 = Sky.data.raspunsuriGresite[i*2];
     String raspunsG2 = Sky.data.raspunsuriGresite[i*2+1];
     String raspunsC = Sky.data.raspunsuriCorecte[i];
     
     livesLeft--;
     this.setLocation(getWorld().getWidth()/2,getWorld().getHeight()/2-100);
     getWorld().addObject(new Intrebare(question,32), getWorld().getWidth()/2, getWorld().getHeight()/2-50);
     int randomNumber = Greenfoot.getRandomNumber(3);
     if(randomNumber == 0)
     {
      getWorld().addObject(new raspunsGresit(raspunsG1,32), getWorld().getWidth()/2, getWorld().getHeight()/2);
      getWorld().addObject(new raspunsGresit(raspunsG2,32), getWorld().getWidth()/2, getWorld().getHeight()/2+50);   
      getWorld().addObject(new raspunsCorect(raspunsC,32), getWorld().getWidth()/2, getWorld().getHeight()/2+100);   
     }
     else if(randomNumber==1)
     {
      getWorld().addObject(new raspunsGresit(raspunsG1,32), getWorld().getWidth()/2, getWorld().getHeight()/2);
      getWorld().addObject(new raspunsCorect(raspunsC,32), getWorld().getWidth()/2, getWorld().getHeight()/2+50);   
      getWorld().addObject(new raspunsGresit(raspunsG2,32), getWorld().getWidth()/2, getWorld().getHeight()/2+100);
     }
     else
     {
      getWorld().addObject(new raspunsCorect(raspunsC,32), getWorld().getWidth()/2, getWorld().getHeight()/2);
      getWorld().addObject(new raspunsGresit(raspunsG1,32), getWorld().getWidth()/2, getWorld().getHeight()/2+50);   
      getWorld().addObject(new raspunsGresit(raspunsG2,32), getWorld().getWidth()/2, getWorld().getHeight()/2+100);
     }   
    
    }
    
 /**
     * Things to do for each turn.
     * 
     */
    public void act() {
        if(!gameHasStarted) {gameHasStarted = true; Sky.gameHasEnded = false;}
        // Checks if the bird flaps.
        if(!Sky.gameHasEnded) checkFlap();
        // Moves the bird.
        if(!Sky.gameHasEnded) move();
        // Checks if the bird hits the obstacles.
        if(!Sky.gameHasEnded)
        {
        if (checkHit()) {
            if(livesLeft>0) intrebare();
            else
            {
             Sky sky = (Sky) getWorld(); 
             sky.gameOver(Bird.score);   
            }
        } else {
            // Checks if the bird gets ths score.
            checkScore();
        }
        }
    }
    /**
     * Checks if the bird flaps.
     * 
     */
    private void checkFlap() {
        if (Greenfoot.mouseClicked(null)) {
            speed = FLAP_SPEED;
        }
    }
    /**
     * Moves the bird.
     * 
     */
    private void move() {
        speed = speed + GRAVITY;
        setLocation(getX(), getY() + speed);
    }
    /**
     * Checks if the bird hits the obstacles.
     * 
     * @return true if hit, false otherwise
     */
    private boolean checkHit() {
        if (isTouching(Pipe.class)) {
            return true;
        }
        if (getY() == getWorld().getHeight() - 1) {
            return true;
        }
        return false;
    }
    /**
     * Checks if the bird gets ths score.
     * 
     */
    private void checkScore() {
        if (isTouching(ScoreLine.class)) {
            removeTouching(ScoreLine.class);
            score++;
            Sky sky = (Sky) getWorld();
            sky.setScore(score);
        
        }
    }
}