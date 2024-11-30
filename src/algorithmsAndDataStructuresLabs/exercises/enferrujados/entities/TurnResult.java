package src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities;

public class TurnResult {
    public boolean collected;
    public boolean collectedFromLeft; // true se coletou da esquerda
    public boolean placedCard;
    public boolean placedOnLeft;      // true se colocou na esquerda

    public TurnResult() {
        collected = false;
        collectedFromLeft = false;
        placedCard = false;
        placedOnLeft = false;
    }
}
