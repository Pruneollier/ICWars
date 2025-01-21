package ch.epfl.cs107.play.game.icwars.actor.unit;

import ch.epfl.cs107.play.game.actor.Graphics;
import ch.epfl.cs107.play.game.icwars.actor.Unit;
import ch.epfl.cs107.play.game.icwars.actor.players.ICWarsPlayer;
import ch.epfl.cs107.play.game.icwars.area.ICWarsArea;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;

public abstract class Action implements Graphics {
    protected Unit unit;
    protected ICWarsArea area;

    private String name;
    private int key;

    public Action(Unit unit, ICWarsArea area){
        this.unit = unit;
        this.area = area;
    }

    public abstract void doAction(float dt, ICWarsPlayer player , Keyboard keyboard);

    protected void setName(String name){
        this.name = name;
    }

    protected void setKey(int key){
        this.key = key;
    }

}
