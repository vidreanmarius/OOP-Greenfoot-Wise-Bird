import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Sky extends World {
    
    /** The spacing between the pipe pair.*/
    public static final int PIPES_SPACING = 150;
    
    /** The minimal height of a pipe. */
    public static final int PIPE_MIN_HEIGHT = 25;
    
    /** The interval between two pipe pairs. */
    private final int PIPE_INTERVAL = 30;
    
    /** The timer to the next pipe pair. */
    private int pipeTimer = 0;
    
    /** The scoreBoard. */
    private ScoreBoard scoreBoard = null;
    
    public static boolean gameHasEnded = false;
    
    
    public static class data
    {
      
     public static String[] intrebari =
     {
      "In ce procente sa gaseste oxigenul in aer?", 
      "Prima persoana care a facut inconjurul lumii e:", 
      "Inaltimea varfului Everest este de:",
      "Autorul Romanului Maitreyi este:",
      "Capitala Belgiei este?",
      "Care a fost primul model de masina Dacia?",
      "Care varianta este corecta?",
      "Care nu este o ramura a biologiei?",
      "Care tara are frontiera cu Polonia?",
      "Care tara nu are fontiera cu Slovacia?",
      "Care tara nu este vecina cu Ungaria?",
      "Care este tara de provenienta a vikingilor?",
      "Care este capitala Bulgariei?",
      "Care este capitala Egiptului?",
      "Care este simbolul chimic al mercurului?",
      "Care este cea mai simpla alchena?",
      "Cel mai lung fluviu din Europa este:",
      "Ce semnificatie are martisorul?",
      "Cele mai mici oase ale corpului se gasesc in:",
      "Care este cel mai adanc loc de pe Pamant?",
      "Cum se numea sabia regelui Arthur?",
      "Care este cea mai mare planeta din Sistemul Solar?",
      "Icrele cui este caviarul?",
      "In ce an a intrat Romania in UE?",
      "Prin cate capitale trece Dunarea?",
      "Odata la cati ani sunt jocurile olimpice de vara?",
      "Care este cea mai mare artera a corpului?",
      "Pe ce continent se afla Desertul Kalahari?",
      "In ce oras a fost inventat hamburgerul?",
      "In ce tara se afla orasul Cape Town?",
    
    };
        
     
     public static String[] raspunsuriGresite =
     {
      "15%", 
      "75%", 
      "Phileas Fogg.", 
      "Amerigo Vespuci.",
      "5.700", 
      "8.048", 
      "Ion Creanga.",
      "Mihai Eminescu.",
      "Bratislava.",
      "Amsterdam.",
      "Dacia 1310",
      "Dacia 1001",
      "amindorura",
      "amindurura",
      "Virusologia",
      "Zoologia",
      "Norvegia",
      "Suedia",
      "Austria",
      "Polonia",
      "Austria",
      "Croatia",
      "Irlanda",
      "Suedia",
      "Budapesta",
      "Bratislava",
      "Alexandria",
      "Bagdad",
      "M",
      "Mg",
      "metanul",
      "acetilena",
      "Rin",
      "Dunarea",
      "Cerere in casatorie",
      "Anunta echinoptiul de primavara",
      "In gura",
      "In nas",
      "Triunghiul Bermudelor",
      "Delta Dunarii",
      "Nimue",
      "Camelot",
      "Uranus",
      "Neptun",
      "Somonului",
      "Bibanului",
      "2009",
      "2008",
      "7",
      "5",
      "1",
      "2",
      "Brahiocefalica",
      "Pulmonara",
      "Asia",
      "Australia",
      "New York",
      "San Francisco",
      "Filipine",
      "Noua Zeelanda",
     
      
      
      
     };
     
    
     public static String[] raspunsuriCorecte =
     {
      "21%", 
      "Ferdinand Magellan.", 
      "8848.", 
      "Mircea Eliade.",
      "Bruxelles.",
      "Dacia 1100",
      "amindurora",
      "Biochimia",
      "Ucraina",
      "Germania",
      "Germania",
      "Danemarca",
      "Sofia",
      "Cairo",
      "Hg",
      "etena",
      "Volga",
      "Simbolizeaza venirea primaverii",
      "In ureche",
      "Groapa Marianelor",
      "Excalibur",
      "Jupiter",
      "Sturionului",
      "2007",
      "4",
      "4",
      "Aorta",
      "Africa",
      "Hamburg",
      "Africa de Sud",
      
     };
     
    
    }
    
    /**
     * Constructor for objects of class Sky.
     * 
     */
    public Sky() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Bird(), getWidth() / 2, getHeight() / 2);
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 70, 50);
        pipeTimer = PIPE_INTERVAL * 2;
        setPaintOrder(GameOver.class, ScoreBoard.class, Bird.class, Pipe.class);
    }
    
    /**
     * Things to do for each turn.
     * 
     */
    public void act() {
        // Adds a pipe pair periodically.
        if(!gameHasEnded)addPipePairPeriodically();
    }
    
    /**
     * Sets the score.
     * 
     * 
     */
    public void setScore(int score) {
        if(!gameHasEnded) scoreBoard.setScore(score);
    }
    
    /**
     * Game over.
     * 
     * 
     */
    public void gameOver(int score) {
        addObject(new GameOver(score), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
    
    /**
     * Adds a pipe pair periodically.
     * 
     */
    private void addPipePairPeriodically() {
        pipeTimer--;
        if (pipeTimer == 0) {
            addPipePair();
            pipeTimer = PIPE_INTERVAL;
        }
    }
    
    /**
     * Adds a pipe pair.
     * 
     */
    private void addPipePair() {
        int pipeMaxHeight = getHeight() - PIPES_SPACING - PIPE_MIN_HEIGHT;
        int height1 = PIPE_MIN_HEIGHT + Greenfoot.getRandomNumber(pipeMaxHeight - PIPE_MIN_HEIGHT);
        int y1 = height1 / 2 - 1;
        int height2 = getHeight() - height1 - PIPES_SPACING;
        int y2 = getHeight() - height2 / 2 - 1;
        int y3 = height1 + PIPES_SPACING / 2 - 1;
        addObject(new Pipe(height1), getWidth() - 1, y1);
        addObject(new Pipe(height2), getWidth() - 1, y2);
        addObject(new ScoreLine(), getWidth() - Pipe.WIDTH / 2, y3);
    }
}