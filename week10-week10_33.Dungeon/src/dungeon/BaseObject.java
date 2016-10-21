/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Dmitry
 */
public abstract class BaseObject {
    protected int x;
    protected int y;
    private boolean alive;
    
    public BaseObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        this.alive = false;
    }
    
    public boolean isIntersec(BaseObject o)
    {
        if(this.getX() == o.getX() && this.getY() == o.getY()) {
            return true;
        }
        return false;
    }
       
    public abstract void draw(Canvas canvas);
    
}
