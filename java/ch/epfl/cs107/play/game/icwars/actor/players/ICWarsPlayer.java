package ch.epfl.cs107.play.game.icwars.actor.players;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icwars.actor.ICWarsActors;
import ch.epfl.cs107.play.game.icwars.actor.Unit;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ICWarsPlayer extends ICWarsActors {
    private List<Unit> units;

    public ICWarsPlayer(Area area, DiscreteCoordinates position, Faction faction, Unit... units){
        super(area, position, faction);
        this.units = new ArrayList<>(Arrays.asList(units));
        for(Unit unit : units){
            area.registerActor(unit);
        }
    }

    public void update(float deltaTime){
        super.update(deltaTime);

        if(isDisplacementOccurs()){

            for(Unit unit : units){
                if(unit.isDead()){
                    units.remove(unit);
                    getOwnerArea().unregisterActor(unit);
                }
            }
        }
    }

    @Override
    public void leaveArea(){

        for(Unit unit : units){
            getOwnerArea().unregisterActor(unit);
        }
        super.leaveArea();
    }

    public void centerCamera() {
        getOwnerArea().setViewCandidate(this);
    }

    @Override
    public boolean takeCellSpace() {
        return false;
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
    public void acceptInteraction(AreaInteractionVisitor v) {
        ////////
    }

    @Override
    public void draw(Canvas canvas) {
        for(Unit unit : units){
            unit.getSprite().draw(canvas);
        }
    }


}
