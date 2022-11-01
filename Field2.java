import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Field2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Field2 extends SWorld
{

    public int width = 0;
    public int height = 0;
    public int gHeight = 100;
    
    public Field2()
    {
        super(600, 580, 1, 1500, 600); 
        setMainActor(new MainCharacter(), 100, 580);
        GreenfootImage bg = new GreenfootImage("background.png");
        setScrollingBackground(bg);
        getWH();
        sceneLoad();
    }
    public void portal()
    {
        portal portal = new portal();
        addObject(portal, (width + 350), height - gHeight);
    }
    public void getWH()
    {
        width = getWidth();
        height = getHeight();
    }
    public MainCharacter getMainCharacter()
    {
        return mainCharacter;
    }
    public int getGHeight() 
    {
        return gHeight;
    }
    public void sceneLoad()
    {
        portal();
    }
}

