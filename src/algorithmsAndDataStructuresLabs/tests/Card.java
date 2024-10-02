package algorithmsAndDataStructuresLabs.tests;

public class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Métodos equals e hashCode para comparar cartas pelo nome
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    // Método toString
    @Override
    public String toString() {
        return name;
    }
}
