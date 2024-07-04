import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Alien> aliens = new ArrayList<>();
        List<Species> speciesList = new ArrayList<>();

        speciesList.add(new Species(1, "Marciano", "Marte", 1));
        speciesList.add(new Species(2, "Venusiano", "Venus", 2));
        speciesList.add(new Species(3, "Jupiteriano", "Jupiter", 3));
        speciesList.add(new Species(4, "Saturniano", "Saturno", 4));
        speciesList.add(new Species(5, "Plutoniano", "Plutão", 5));

        aliens.add(new Alien(1, "Marciano", speciesList.get(0), 2, true, LocalDateTime.of(2021, 10, 10, 10, 10)));
        aliens.add(new Alien(2, "Venos", speciesList.get(1), 2, true, LocalDateTime.of(2024, 7, 10, 10, 10)));
        aliens.add(new Alien(3, "Gargamel", speciesList.get(3), 2, true, LocalDateTime.now()));

        AlienSystemControl alienSystemControl = new AlienSystemControl(aliens, speciesList);
        Scanner sc = new Scanner(System.in);

        int choose = 0;
        do {
            ShowMenu();
            try {
                choose = sc.nextInt();
                sc.nextLine();

                switch (choose) {
                    case 1:

                        System.out.print("Digite o nome da espécie: ");
                        String specieName = sc.nextLine();
                        System.out.print("Digite o planeta de origem: ");
                        String planetOfOrigin = sc.nextLine();
                        System.out.print("Digite o nível de periculosidade base: ");
                        int levelOfDanger = sc.nextInt();
                        sc.nextLine(); // Limpar o buffer do scanner

                        Species specie = new Species(speciesList.size() + 1, specieName, planetOfOrigin, levelOfDanger);
                        alienSystemControl.registerSpecies(specie);
                        System.out.println("Espécie registrada com sucesso!");
                        break;
                    case 2:

                        if (speciesList.isEmpty()) {
                            System.out.println("Não há espécies registradas. Registre uma espécie antes de adicionar um alienígena.");
                            System.out.print("Digite o nome da espécie: ");
                            specieName = sc.nextLine();
                            System.out.print("Digite o planeta de origem: ");
                            planetOfOrigin = sc.nextLine();
                            System.out.print("Digite o nível de periculosidade base: ");
                            levelOfDanger = sc.nextInt();


                            specie = new Species(speciesList.size() + 1, specieName, planetOfOrigin, levelOfDanger);
                            alienSystemControl.registerSpecies(specie);
                            System.out.println("Espécie registrada com sucesso!");
                        } else {
                            System.out.print("Digite o nome do alienígena: ");
                            String alienName = sc.nextLine();

                            System.out.println("Espécies disponíveis:");
                            for (Species species : speciesList) {
                                System.out.println(species.getId() + ". " + species.getName());
                            }
                            System.out.print("Escolha o número da espécie do alienígena: ");
                            int specieId = sc.nextInt();


                            if (specieId < 1 || specieId > speciesList.size()) {
                                System.out.println("Opção inválida. Escolha um número válido da espécie.");
                                break;
                            }

                            Species especieSelecionada = speciesList.get(specieId - 1);

                            System.out.print("Digite o nível de periculosidade do alienígena: ");
                            int nivelPericulosidadeAlien = sc.nextInt();

                            LocalDateTime entrieDate = LocalDateTime.parse(LocalDateTime.now().toString());
                            System.out.print("Data de entranda : " + entrieDate);

                            Alien alien = new Alien();
                            alien.setName(alienName);
                            alien.setSpecies(especieSelecionada);
                            alien.setLevelOfDanger(nivelPericulosidadeAlien);
                            alien.setEntryDate(entrieDate);
                            alien.isQuarentine();
                            alienSystemControl.registerAlien(alien);
                            System.out.println("\nAlienígena registrado com sucesso!");
                        }
                        break;
                    case 3:
                        System.out.println("Relatório de Entradas:");
                        alienSystemControl.entriesAliens();
                        break;
                    case 4:
                        System.out.println("Ranking de Periculosidade:");
                        alienSystemControl.rankinfOfDanger();
                        break;
                    case 5:
                        System.out.println("Alienígenas em quarentena:");
                        alienSystemControl.showAliensInQuarentine();
                        break;
                    case 6:

                        System.out.print("Digite o nome da espécie para buscar os alienígenas: ");
                        String SpeciesName = sc.nextLine();
                        alienSystemControl.showAliensOfSpecies(SpeciesName);
                        break;
                    case 7:

                        alienSystemControl.lastSixMonthsAliensEntreies();
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao processar sua escolha: " + e.getMessage());
                sc.nextLine();
            }

        } while (choose != 0);

        sc.close();
    }

    public static void ShowMenu() {
        System.out.println("\n### Sistema de Controle de Entrada de Alienígenas ###");
        System.out.println("1. Registrar Espécie");
        System.out.println("2. Registrar Alienígena");
        System.out.println("3. Mostrar Relatório de Entradas");
        System.out.println("4. Ranking de Periculosidade");
        System.out.println("5. Verificar alienígenas em quarentena");
        System.out.println("6. Mostrar todos os alienígenas de uma espécie específica");
        System.out.println("7. Mostrar todos os alienígenas que entraram no planeta nos últimos 6 meses");
        System.out.println("0. Encerrar o Programa");
        System.out.print("Escolha uma opção: ");
    }
}

