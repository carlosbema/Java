package src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities;

public class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return name.equals(card.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
