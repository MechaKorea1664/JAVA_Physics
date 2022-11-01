import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends SWorld
{

    /**
     * Constructor for objects of class Title.
     * 
     */
    /*Victory by Alexander Nakarada
    *Link: https://filmmusic.io/song/4924-victory
    *///License: https://filmmusic.io/standard-license
    public Title()
    {
        super (600, 580, 1, 600, 580);
        addObject(new StartButton(), 165, 500); 
        addObject(new TitleLetter(), 190, 325);
        addObject(new Cursor(), 300, 290);
        setBackground(bg0);
        Greenfoot.start();
        bgm0.play();
        bgm0.setVolume(25);
    }
    public void act()
    {
        
        //songEnd();
    }
    //public boolean songPlaying()

    /*public void songEnd()
    {
        StartButton button = new StartButton();
        if (StartButton.pressButton() == true)
        {
            bgm0.stop();
        }
    }*/
}
