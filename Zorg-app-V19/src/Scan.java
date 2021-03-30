import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Scan {

    public Scan() {

    }

/*/////////////////////////////////////

    ALGEMENE KEUZEMENU'S

*//////////////////////////////////////

    // Taalkeuze
    public String taalKeuze(){
        System.out.println("Kies uw taal / Choose your language.");
        System.out.println("1. Nederlands / Dutch.");
        System.out.println("2. Engels / English.");
        int choice;
        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                choice = s.nextInt();
                while (choice != 1 && choice != 2) {
                    System.out.println("Dit is geen optie / This is no option.");
                    choice = s.nextInt();
                }
                if (choice == 1) {
                    return "nl";
                } else if (choice == 2) {
                    return "en";
                }
            } catch (InputMismatchException ime){
                System.out.println("Dit is geen optie / This is no option.");
            }
        }
    }

    // Returned de eerste keuze (Zorgverlener of patiënt)
    public int getFirstChoice() {
        boolean isNumber = false;
        int choice = 0;

        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                choice = s.nextInt();
                while (choice != 1 && choice != 2 && choice != 3) {
                    System.out.println(Talen.rb().getString("geenOptie"));
                    choice = s.nextInt();
                }
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenOptie"));
            }
        }
        return choice;
    }

    // Haalt eerste keuze op (voor weergeven / bewerken / afsluiten / uitloggen
    public int getChoice() {
        boolean isNumber = false;
        int choice = 0;
        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                choice = s.nextInt();
                while (choice <= 0 || choice > 9 || choice == 8) {
                    System.out.println(Talen.rb().getString("geenOptie"));
                    choice = s.nextInt();
                }
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenOptie"));
            }
        }
        return choice;
    }

    // Haalt op of je naam /leeftijd / gewicht wilt bewerken
    public int getChoice2() {
        boolean isNumber = false;
        int choice = 0;
        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                choice = s.nextInt();
                while (choice != 1 && choice != 2 && choice != 3 && choice != 9) {
                    System.out.println(Talen.rb().getString("geenOptie"));
                    choice = s.nextInt();
                }
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenOptie"));
            }
        }
        return choice;
    }

    // Haalt op wat de zorgverlener qua medicatie of gewicht wilt
    public int getChoice3() {
        boolean isNumber = false;
        int choice = 0;
        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                choice = s.nextInt();
                while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 9) {
                    System.out.println(Talen.rb().getString("geenOptie"));
                    choice = s.nextInt();
                }
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenOptie"));
            }
        }
        return choice;
    }

    // Checkt het wachtwoord van de zorgverlener
    public boolean checkPassword(){
        Scanner s = new Scanner(System.in);
        int i = 0;
        int pogingen = 2;
        while (i < 3) {
            System.out.println(Talen.rb().getString("enterPassword"));
            String invoer = s.nextLine();
            if (invoer.equals("asdf")) {
                return true;
            } else {
                System.out.println(Talen.rb().getString("onjuistWachtwoord"));
            }
            i++;
            if (pogingen > 0) {
                System.out.println(Talen.rb().getString("triesLeft") + pogingen + Talen.rb().getString("triesLeft2"));
            }
            pogingen--;
        }
        return false;
    }

/*/////////////////////////////////////

    MEDICIJN SCANNERS

*//////////////////////////////////////

    // Toevoegen of verwijderen van medicijnen
    public String scanForAddOrDelete(int x) {
        Scanner s = new Scanner(System.in);
        if (x == 1) {
            System.out.println(Talen.rb().getString("enterMedNameForAdd"));
        } else if (x == 2) {
            System.out.println(Talen.rb().getString("enterMedNameForDelete"));
        }
        System.out.println(Talen.rb().getString("toets9"));
        String invoer = s.nextLine();
        return invoer;
    }

/*/////////////////////////////////////

    LEEFTIJD / GEWICHT / NAAM

*//////////////////////////////////////

    // Scanner voor nieuwe leeftijd
    public int nieuweLeeftijd() {
        System.out.println(Talen.rb().getString("vulNieuweLeeftijdIn"));
        int newLeeftijd = 0;
        boolean isNumber = false;
        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                newLeeftijd = s.nextInt();
                while (newLeeftijd <= 0) {
                    System.out.println(Talen.rb().getString("vulNieuweLeeftijdIn"));
                    newLeeftijd = s.nextInt();
                }
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenGetal") + Talen.rb().getString("vulNieuweLeeftijdIn"));
            }
        }
        return newLeeftijd;
    }

    // Scanner voor nieuwe gewicht
    public double nieuwGewicht() {
        double newGewicht = 0;
        boolean isNumber = false;
        System.out.println(Talen.rb().getString("enterNewWeight"));
        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                newGewicht = s.nextDouble();
                while (newGewicht <= 0) {
                    System.out.println(Talen.rb().getString("enterNewWeight"));
                    newGewicht = s.nextDouble();
                }
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenGetal"));
                System.out.println(Talen.rb().getString("enterNewWeight"));
            }
        }
        return newGewicht;
    }

    // Haalt op welk meetpuntnummer de zorgverlener wilt bewerken
    public int getChoiceGewichtMeetpunt() {
        boolean isNumber = false;
        int choice = 0;
        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                choice = s.nextInt();
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenOptie"));
            }
        }
        return choice;
    }

    // Returned een gewichtmeetpunt om handmatig toe te voegen
    public GewichtMeetPunt addGewichtMeetpunt(){
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println(Talen.rb().getString("enterDate"));
            String datum = s.nextLine();
            System.out.println(Talen.rb().getString("enterTime"));
            String tijd = s.nextLine();
            String datumTijd = datum + " " + tijd;
            double gewicht = nieuwGewicht();
            try {
                return new GewichtMeetPunt(LocalDateTime.parse(datumTijd, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), gewicht);
            } catch (DateTimeParseException ex) {
                System.out.println(Talen.rb().getString("dateTimeIncorrect"));
            }
        }
    }

    // Voornaam voor het zoeken in de database
    public String enterFirstName() {
        Scanner s = new Scanner(System.in);
        System.out.println(Talen.rb().getString("voornaam"));
        String firstName = s.nextLine();
        return firstName;
    }

    // Achternaam voor het zoeken in de database
    public String enterLastName() {
        Scanner s = new Scanner(System.in);
        System.out.println(Talen.rb().getString("achternaam"));
        String lastName = s.nextLine();
        return lastName;
    }

    // Scanner voor nieuwe namen
    public String nieuweNaam() {
        Scanner s = new Scanner(System.in);
        String newName = s.nextLine();
        return newName;
    }

    // Scanner voor streefgewicht
    public double streefGewicht() {
        double streefGewicht = 0;
        boolean isNumber = false;
        System.out.println(Talen.rb().getString("voerStreefgewichtIn"));
        while (!isNumber) {
            try {
                Scanner s = new Scanner(System.in);
                streefGewicht = s.nextDouble();
                while (streefGewicht <= 0) {
                    System.out.println(Talen.rb().getString("voerStreefgewichtIn"));
                    streefGewicht = s.nextDouble();
                }
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println(Talen.rb().getString("geenGetal"));
                System.out.println(Talen.rb().getString("voerStreefgewichtIn"));
            }
        }
        System.out.println();
        return streefGewicht;
    }
}
