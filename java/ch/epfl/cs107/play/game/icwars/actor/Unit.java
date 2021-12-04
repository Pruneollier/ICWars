package ch.epfl.cs107.play.game.icwars.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Interactable;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

import java.util.List;


public abstract class Unit extends ICWarsActors{

    private String name;
    private int damage;
    private int hp;
    private Sprite sprite;
    private int maxHp;
    private int ray;

    public Unit(Area area, DiscreteCoordinates position, Faction faction, int damage, int maxHp, int ray){
        super(area,position, faction);
        sprite = new Sprite(name, 1.5f, 1.5f, this , null , new Vector(-0.25f, -0.25f));
        this.damage = damage;
        this.maxHp = maxHp;
        hp = maxHp;
        this.ray = ray;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSprite() {
        sprite = new Sprite(this.name , 1.5f, 1.5f, this , null , new Vector(-0.25f, -0.25f));
    }

    public Sprite getSprite(){
        return sprite;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public int getHp(){
        return hp;
    }

    public void draw(Canvas canvas) {
        sprite.draw(canvas);
    }

    public void damage(int damage){
        hp = Math.max(hp - damage, 0);
    }

    public void recover(int recover){
        hp = Math.min(hp + recover , maxHp);
    }

    public boolean isDead(){
        return (hp == 0);
    }

    @Override
    public boolean isCellInteractable(){
        return true;
    }

    @Override
    public boolean isViewInteractable() {
        return false;
    }

    @Override
    public boolean takeCellSpace() {
        return false;
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v) {

    }
}