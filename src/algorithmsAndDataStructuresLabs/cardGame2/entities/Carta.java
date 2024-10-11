package algorithmsAndDataStructuresLabs.cardGame2.entities;

public class Carta {

    private String nome;

    public Carta(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Carta) {
            Carta outra = (Carta) obj;
            return this.nome.equals(outra.nome);
        }
        return false;
    }

    @Override
    public String toString() {
        return nome;
    }
}

