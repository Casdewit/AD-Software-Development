import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GewichtMeetPunt {
    private LocalDateTime           dateTimeMeetpunt;
    private double                  gewicht;
    private int                     meetpuntNummer;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // Constructor
    public GewichtMeetPunt(LocalDateTime datumTijd, double weight) {
        dateTimeMeetpunt = datumTijd;
        gewicht = weight;
    }

/*/////////////////////////////////////

    PRINT METHODS

*//////////////////////////////////////

    // Print het meetpunt met nummer, tijd en gewicht
    public void printMeetpunt() {
        System.out.println(Talen.rb().getString("meetpunt") + meetpuntNummer);
        System.out.println(Talen.rb().getString("datumTijdMeetpunt") + dateTimeMeetpunt.format(formatter));
        System.out.println(Talen.rb().getString("gewichtMeetpunt") + gewicht + "kg\n");
    }

    // Print streepjes en spaties uit per gewichtmeetpunt. Voegt kleur toe afhankelijk van streefgewicht
    public void printStaven(double streefgewicht) {
        if (gewicht - streefgewicht > 2 || streefgewicht - gewicht > 2){
            String kleurGeel = "\u001B[33m";
            System.out.print(kleurGeel);
        }
        if (gewicht - streefgewicht > 5 || streefgewicht - gewicht > 5){
            String kleurRood = "\u001B[31m";
            System.out.print(kleurRood);
        }
        int x = (int) Math.round(gewicht) / 2;
        for (int i = 0; i <= x; i++) {
            System.out.print("|");
        }
        int j = 70 - x;
        for (int z = 0; z < j; z++) {
            System.out.print(" ");
        }
        String kleurReset = "\u001B[0m";
        System.out.println(gewicht + " kg" + kleurReset);
    }

/*/////////////////////////////////////

    GETTERS EN SETTERS

*//////////////////////////////////////

    // Voegt een nummer aan het meetpunt toe
    public void setMeetpuntNummer(int nummer) {
        meetpuntNummer = nummer;
    }

    // Haalt nummer van meetpunt op
    public int getMeetpuntNummer() {
        return meetpuntNummer;
    }

    // Haalt de datum en tijd van het meetpunt op
    public String getMeetpuntDatumTijd() {
        return dateTimeMeetpunt.format(formatter);
    }

    // Bewerkt het gewicht van het meetpunt
    public void setMeetpuntGewicht(double weight) {
        gewicht = weight;
    }

}
