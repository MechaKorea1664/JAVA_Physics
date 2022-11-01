import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Main character, animations, movement, more keystroke detection/signals. Attach hitbox, sound.
 * 
 * Kevin 
 * version: 11022021
 */
public class MainCharacter extends controller
{
    public double minVX = 0.0; //sets min value for both vx values. recommended to keep it at 0. Default = 0
    public double maxVX = 3.0; //sets max value for both vx values. Default = 5
    public double vx1 = 0.0; //x velocity 1 (right). Default = 0
    public double vx2 = 0.0; //x velocity 2 (left). Default = 0
    public double ax1 = 1.4; //Acceleration/deceleration rate for vx1. Default = 1. AX1 TEND TO BE SLOWER THAN AX2.
    public double ax2 = 1.3; //Acceleration/deceleration rate for vx2. Default = 1. AX1 TEND TO BE SLOWER THAN AX2.
    public double g = 0.4; //gravity strengh. Default = 0.4
    public double vy = 0; //variable for y velocity. Default = 0
    public double j = 10; //Variable for jump force. Default = 8
    public int height = 38; //"Height" of the MainCharacter. Actual height is twice this value. (NOT USED FOR NOW)
    public int width = 18; //"Width" of the MainCharacter. Actual width is twice this value.
    public int ground = 0; //NOT the ACTUAL y value of the ground...just a placeholder.
    public int groundLevel = 0; //ACTUAL y value of the ground
    public int y = 0; //placeholder for y value of MainCharacter
    public int x = 0; //placeholder for x valuie of MainCharacter
    public int mapNum;
    
    public void act()
    {
        groundCollisionCheck();
        movementUpdate();
        animationUpdate();
    }
    protected void addedToWorld (World Field1)
    {
        if (getWorld() instanceof Field1)
        {
            groundLevel = 480;
            mapNum = 1;
        }
        else if (getWorld() instanceof Field2)
        {
            groundLevel = 400; 
            mapNum = 2;
        }
    }
    public void vTest() //use this when there are issues with velocities
    {
        if ((vy < 0) || (vy > 0))
        {
            setRotation(90);
        } else {
            setRotation(0);
        }
    }
    public void animationUpdate()
    {
        if ((vx1 == 0) && (vx2 == 0) && (vy == 0) && (y == groundLevel))
        {
            standBy();
        } else if ((vx1 > 0) && !(Greenfoot.isKeyDown("right")) && !(Greenfoot.isKeyDown("left") && (vy == 0)) && (groundLevel == y) || (vx2 > 0) && !(Greenfoot.isKeyDown("right")) && !(Greenfoot.isKeyDown("left") && (vy == 0)) && (groundLevel == y))
        {
            standBy();
        }
        if ((vx1 > minVX) && (Greenfoot.isKeyDown("right"))&&(vy == 0))
        {
            walkRight();
        }
        if ((vx2 > minVX) && (Greenfoot.isKeyDown("left"))&&(vy == 0))
        {
            walkLeft();
        }
        if ((vy > 0) && (vx2 > 0))
        {
            setImage("baseModel_jumpLeft_MainCharacter.png");
        }
        if ((vy > 0) && (vx1 > 0))
        {
            setImage("baseModel_jumpRight_MainCharacter.png");
        }
        if ((vy > 0) && (vx1 == 0) && (vx2 == 0))
        {
            setImage("baseModel_jumpRight_MainCharacter.png");
        }
    }
    public void walkLeft()
    {
        setImage(walkLeft.getCurrentImage());
    }
    public void walkRight()
    {
        setImage(walkRight.getCurrentImage());
    }
    public void standBy()
    {
        setImage(standBy.getCurrentImage());
    }
    public void getXYAxis() //gets the x and y value and updates x and y
    {
        x = getX();
        y = getY();
    }
    public void calcVX() //calculates velocity
    {
        //this adds and subtracts velocity
        if ((Greenfoot.isKeyDown("right")))
        {
            vx1 += 0.1;
        }
        else 
        {
            if (!Greenfoot.isKeyDown("right"))
            {
                if (vx1 > minVX) 
                {
                    vx1 -= 0.1;
                }
            }
        }
        if ((Greenfoot.isKeyDown("left")))
        {
            vx2 += 0.1;
        }
        else 
        {
            if (!Greenfoot.isKeyDown("left"))
            {
                if (vx2 > minVX) 
                {
                    vx2 -= 0.1;
                }
            }
        }
        /*Conserves momentum (DOES NOTHING BUT BREAK MY CODE LOL) 
         *just turned it into a comment to remind myself to not write this again
         *Note to self: dont write this again
        if ((vx1 > 0.1)&&(vx2 > 0.1))
        {
            vx2 -= vx1;
        }
        else if ((vx2 < 0.1)&&(vx1 > 0.1))
        {
            vx1 -= vx2;
        }
        */
        if (vx1 > maxVX) //Limits both vx1 and vx2 to double values between 0 and 5, essentially limiting movement speed.
        {
            vx1 = maxVX;
        } else if (vx1 < minVX) 
        {
            vx1 = minVX;
        }
        if (vx2 > maxVX)
        {
            vx2 = maxVX;
        } else if (vx2 < minVX) 
        {
            vx2 = minVX;
        }
    }
    public void movement() //right and left movement, converts velocities xv1 and xv2 to horizontal momentum
    {
        //uses velocity to control speed and direction.
        getXYAxis();
        calcVX();
        wallCollisionCheck();
        if (Greenfoot.isKeyDown("right"))
        {
            x += ax1 * vx1;
        } else if (vx1 > minVX)
        {
            x += ax1 * vx1;   
        } 
        if (Greenfoot.isKeyDown("left"))
        {
            x -= ax2 * vx2;
        } else if (vx2 > minVX)
        {
            x -= ax2 * vx2;
        }
    }
    /*public void gravity() //constant gravitatinoal force 
     * (I don't think i need this) <--- yep
     * (I don't need this, but I'm still keeping it here for future reference / and so that I dont write the same code again.)
    {
        getXYAxis();
        vy += g;
        y += vy;
    }
    */
    public void jump() //jump controller
    {
        calcVY();
        groundCollisionCheck();
        y -= vy;
    }
    public void calcVY() //vy value calculator, with gravity
    {
        if (Greenfoot.isKeyDown("up") && (vy == 0))
        {
            vy += j;
        }
        else if (y == (groundLevel))
        {
            vy = 0;
        }
        else if (y < groundLevel)
        {
            vy -= g;
        } 
    }
    public void groundCollisionCheck() //checks for ground collision. prevents clipping outside of boundary.
    {
        if (y > groundLevel)
        {
            y = groundLevel;
            vy = 0;
        }
    }
    public void wallCollisionCheck()
    {
        if (x >= (getWorld().getWidth() - width))
        {
            vx1 = 0;
            x = getWorld().getWidth() - width;
        }
        if (x <= width)
        {
            vx2 = 0;
            x = width;
        }
    }
    public void movementUpdate() //updates every movement
    {
        groundCollisionCheck();
        wallCollisionCheck();
        movement();
        jump();
        setLocation(x, y);
    }
    

}

