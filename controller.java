import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;
/**
 * Write a description of class references here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class controller extends Actor
{
    GifImage standBy = new GifImage("baseModel_MainCharacter.gif"); //loads the base STANDBY animation for MainCharacter. 
    GifImage walkRight = new GifImage("baseModel_walkRight_MainCharacter.gif"); //loads the base WALK animation for Maincharacter.
    GifImage walkLeft = new GifImage("baseModel_walkLeft_MainCharacter.gif");
    GifImage titleAnim = new GifImage("titleAnim.gif");
    public int x = 0;
    public int y = 0;
    public int time = 0;
    public int lastTime = 0;    
    
    public void act()
    {
        
    }
}
