package algorithmsAndDataStructuresLabs.cardGame7.entities;

public class Move {
    private Card card;
    private boolean isCollecting;
    private boolean isRight;

    public Move(Card card, boolean isCollecting, boolean isRight) {
        this.card = card;
        this.isCollecting = isCollecting;
        this.isRight = isRight;
    }

    public Card getCard() {
        return card;
    }

    public boolean isCollecting() {
        return isCollecting;
    }

    public boolean isRight() {
        return isRight;
    }
}