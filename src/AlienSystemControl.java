import java.time.LocalDateTime;
import java.util.List;

public class AlienSystemControl {
    private List<Alien> aliens;
    private List<Species> spices;

    public AlienSystemControl(List<Alien> aliens, List<Species> spices) {
        this.aliens = aliens;
        this.spices = spices;
    }

    public AlienSystemControl() {

    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public List<Species> getSpices() {
        return spices;
    }

    public void setSpices(List<Species> spices) {
        this.spices = spices;
    }

    public void registerSpecies(Species species) {
        spices.add(species);
    }

    public void registerAlien(Alien alien) {
        aliens.add(alien);
    }

    public void entriesAliens() {
        for (Alien alien : aliens) {
            System.out.println(alien.showAlien());
        }
    }

    public void rankinfOfDanger() {
        aliens.sort((a1, a2) -> Integer.compare(a2.evaluateDangerLevel(a2.getLevelOfDanger()), a1.evaluateDangerLevel(a1.getLevelOfDanger())));
        for (Alien alien : aliens) {
            System.out.println("Nome: " + alien.getName() + ", Avaliação de Periculosidade: " + alien.typeOfDanger());
        }

    }

    public void showAliensOfSpecies(String SpeciesName) {
        for (Alien alien : aliens) {
            if (alien.getSpecies().getName().equals(SpeciesName)) {
                System.out.println(alien.showAlien());
            } else {
                System.out.println("Espécie não encontrada ou Não há aliens dessa espécie.");
            }
        }
    }

    public void lastSixMonthsAliensEntreies() {
        for (Alien alien : aliens) {
            if (alien.getEntryDate().isAfter(LocalDateTime.now().minusMonths(6))) {
                System.out.println(alien.showAlien());
            }
        }
    }

    public void showAliensInQuarentine() {
        for (Alien alien : aliens) {
            if (alien.isQuarentine().equals("Sim")) {
                System.out.println(alien.showAlien());
            }else{
                System.out.println("Não há aliens em quarentena.");
            }
        }
    }
}
