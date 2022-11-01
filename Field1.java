import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Field1 extends SWorld
{
    public int width = 0;
    public int height = 0;
    public int gHeight = 100;
    
    public Field1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 580, 1, 1500, 600); 
        setMainActor(new MainCharacter(), 100, 580);
        setScrollingBackground(bg1);
        getWH();
        portal();
    }
    public void act()
    {
        //stopSong();
    }
    public void portal()
    {
        addObject(new portal(), (width + 350), height - gHeight);
        
    }
    public void getWH()
    {
        width = getWidth();
        height = getHeight();
    }
    public int ground() 
    {
        return 500;
    }
    /*public void stopSong()
    {
        if (title.songPlaying() == true)
        {
            //bgm0.stop();
        }
    }*/
}

