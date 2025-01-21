package ch.epfl.cs107.play.game.icwars.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Interactable;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Path;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icwars.area.ICWarsArea;
import ch.epfl.cs107.play.game.icwars.area.ICWarsRange;
import ch.epfl.cs107.play.game.icwars.handler.ICWarsInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

import java.util.List;
import java.util.Queue;


public abstract class Unit extends ICWarsActors {

    private String name;
    private int damage;
    private int hp;
    private Sprite sprite;
    private int maxHp;
    private int radius;

    private boolean usableUnit;

    private ICWarsRange range;

    public Unit(Area area, DiscreteCoordinates position, Faction faction, int damage, int maxHp, int radius) {
        super(area, position, faction);
        sprite = new Sprite(name, 1.5f, 1.5f, this, null, new Vector(-0.25f, -0.25f));
        this.damage = damage;
        this.maxHp = maxHp;
        hp = maxHp;
        this.radius = radius;

        this.range = createRange(position, radius);
        this.usableUnit = true;
    }

    @Override
    public boolean changePosition(DiscreteCoordinates newPosition) {
        if (!isDisplacementOccurs() || !range.nodeExists(newPosition)) {
            return false;
        } else {
            range.nodeExists(newPosition);
            return true;
        }
    }

    public boolean isUsableUnit() {
        return usableUnit;
    }

    public void setUsableUnit(boolean usableUnit) {
        this.usableUnit = usableUnit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSprite() {
        sprite = new Sprite(this.name, 1.5f, 1.5f, this, null, new Vector(-0.25f, -0.25f));
    }

    public Sprite getSprite() {
        return sprite;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public void draw(Canvas canvas) {
        sprite.draw(canvas);
    }

    public void damage(int damage) {
        hp = Math.max(hp - damage, 0);
    }

    public void recover(int recover) {
        hp = Math.min(hp + recover, maxHp);
    }

    public boolean isDead() {
        return (hp == 0);
    }


    /**
     * Draw the unit's range and a path from the unit position to
     * destination
     *
     * @param destination path destination
     * @param canvas      canvas
     */
    public void drawRangeAndPathTo(DiscreteCoordinates destination, Canvas canvas) {
        range.draw(canvas);
        Queue<Orientation> path =
                range.shortestPath(getCurrentMainCellCoordinates(), destination);

//Draw path only if it exists (destination inside the range)
        if (path != null) {
            new Path(getCurrentMainCellCoordinates().toVector(), path).draw(canvas);
        }
    }

    public ICWarsRange createRange(DiscreteCoordinates position, int radius) {

        ICWarsRange range = new ICWarsRange();

        int fromX = position.x;
        int fromY = position.y;

        int height = this.getOwnerArea().getHeight();
        int width = this.getOwnerArea().getWidth();

        for (int x = -radius; x <= radius; ++x) {
            for (int y = -radius; y <= radius; ++y) {

                boolean hasLeftEdge = ((x > -radius) && (x + fromX > 0));

                boolean hasRightEdge = ((x < radius) && (x + fromX < width));

                boolean hasUpEdge = ((y < radius) && (y + fromY < height));

                boolean hasDownEdge = ((y > -radius) && (y + fromY > 0));

                if ((fromX + x >= 0) && (fromX + x < width) && (fromY + y >= 0) && (fromY + y < height)) {
                    DiscreteCoordinates coords = new DiscreteCoordinates(fromX + x, fromY + y);
                    range.addNode(coords, hasLeftEdge, hasUpEdge, hasRightEdge, hasDownEdge);
                }
            }
        }
        return range;
    }

    @Override
    public boolean isCellInteractable() {
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
        ((ICWarsInteractionVisitor)v).interactWith(this);
    }
}

