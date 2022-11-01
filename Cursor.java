import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cursor extends controller
{
    /**
     * Act - do whatever the Cursor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        followMouse();
    }
    public void followMouse()
    {
        if(Greenfoot.mouseMoved(null))
        {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                setLocation(mouse.getX() + 10,mouse.getY()+11);
        }
    }
}
