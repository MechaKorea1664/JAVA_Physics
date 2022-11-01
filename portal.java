import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class portal extends controller
{
    //background bg = new background();
    GifImage portalGif = new GifImage("portal.gif");
    //String currentImage = "";
    public void act()
    {
        setImage(portalGif.getCurrentImage());
    }
    public void bgImageCheck()
    {
        //bg.getImage() = currentImage;
    }

}
