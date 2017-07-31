/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Orlin
 */
public abstract class BaseObject {
    protected int x;
    protected int y;
    private boolean alive;
    
    public BaseObject(int x, int y){
        this.x = x;
        this.y = y;
        this.alive = true;
    }
    
    public boolean isAlive(){
        return this.alive;
    }
    
    public void setAlive (boolean alive){
        this.alive = alive;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void die(){
        this.alive = false;
    }
    
    public boolean isIntersec(BaseObject object){
        if (this.x == object.x && this.y == object.y){    //AKO IMA PROBLEM zamesti this.x s this.getX() i ostanalite
            return true;
        }else {
            return false;
        }
    }
    
    public abstract void draw (PlayField playfield);
    
}
