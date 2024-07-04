import java.time.LocalDateTime;

public class Alien {

    private int id;
    private String name;
    private Species species;
    private int levelOfDanger;
    private boolean quarantine;
    private LocalDateTime entryDate;

    public Alien(int id, String name, Species species, int levelOfDanger, boolean quarantine, LocalDateTime entryDate) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.levelOfDanger = levelOfDanger;
        this.quarantine = quarantine;
        this.entryDate = entryDate;
    }

    public Alien() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getLevelOfDanger() {
        return levelOfDanger;
    }

    public void setLevelOfDanger(int levelOfDanger) {
        this.levelOfDanger = levelOfDanger;
    }

    public boolean issQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public int evaluateDangerLevel(int alienLevelOfDanger) {
        int levelOfDanger = species.getBaseDangerLevel() + alienLevelOfDanger;

        switch (species.getPlanetOfOrigin()) {
            case "Marte" -> levelOfDanger += 1;
            case "Vênus" -> levelOfDanger += 2;
            case "Jupiter" -> levelOfDanger += 3;
            case "Saturno" -> levelOfDanger += 4;
            case "Urano" -> levelOfDanger += 5;
            case "Netuno" -> levelOfDanger += 6;
            default -> levelOfDanger += 7;
        }

        return levelOfDanger;

    }

    public String typeOfDanger() {
        int levelOfDanger = evaluateDangerLevel(this.levelOfDanger);
        if (levelOfDanger <= 3) {
            return "Baixo nível ";
        } else if (levelOfDanger <= 8) {
            return "Nível Humano";
        } else if (levelOfDanger <= 11) {
            return "Nível Alto";
        } else if (levelOfDanger <= 15) {
            return "Nível Crítico";
        } else {
            return "Elimine o Alien";
        }
    }

    public String isQuarentine() {
        if (typeOfDanger().equals("Nível Crítico") || typeOfDanger().equals("Elimine o Alien")) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public String showAlien() {
        System.out.println("====================");
        System.out.println("Nome: " + getName());
        System.out.println("Espécie: " + getSpecies().getName());
        System.out.println("Planeta de Origem: " + getSpecies().getPlanetOfOrigin());
        System.out.println("Nível de Periculosidade: " + typeOfDanger());
        System.out.println("Está em Quarentena: " + isQuarentine());
        System.out.println("Data de entrada: " + getEntryDate());
        return "====================";
    }


}
