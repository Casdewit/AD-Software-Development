import java.time.LocalDateTime;
import java.util.ArrayList;

public class ProfileList {

    private ArrayList<Profile> klantenBestand = new ArrayList<Profile>();

    // Constructor
    public ProfileList() {

    }

    // Maakt de profielen aan
    public void makeProfileList() {
        Profile piet   = new Profile("Piet", "de Waard", 43, 80, 1.76);
        Profile jan    = new Profile("Jan", "Tol", 55, 82, 1.88);
        Profile henk   = new Profile("Henk", "de Vries", 66, 70, 1.76);
        Profile gerard = new Profile("Gerard", "Joling", 58, 90, 1.80);

        ArrayList<Profile> dataBase = new ArrayList<Profile>();
        dataBase.add(piet);
        dataBase.add(jan);
        dataBase.add(henk);
        dataBase.add(gerard);

        klantenBestand = dataBase;

        // Toevoegen initiele gewichten aan de meetpunten
        GewichtMeetPunt gewichtPiet = new GewichtMeetPunt(LocalDateTime.now(), piet.getGewicht());
        GewichtMeetPunt gewichtJan = new GewichtMeetPunt(LocalDateTime.now(), jan.getGewicht());
        GewichtMeetPunt gewichtHenk = new GewichtMeetPunt(LocalDateTime.now(), henk.getGewicht());
        GewichtMeetPunt gewichtGerard = new GewichtMeetPunt(LocalDateTime.now(), gerard.getGewicht());

        piet.getGewichtMeetPunten().add(gewichtPiet);
        jan.getGewichtMeetPunten().add(gewichtJan);
        henk.getGewichtMeetPunten().add(gewichtHenk);
        gerard.getGewichtMeetPunten().add(gewichtGerard);
    }

/*/////////////////////////////////////

    ZOEKEN DOOR HET KLANTENBESTAND

*//////////////////////////////////////

    // Zoekt door het klantenbestand voor de namen
    public Profile whichProfile() {
        Scan eigenScan = new Scan();
        Profile leeg = new Profile("", "", 0, 0, 0);
        boolean isInList = false;
        int i = 0;
        int j = 2;

        while (!isInList && i < 3) {
            System.out.println(Talen.rb().getString("hoofdlettergevoelig"));
            String firstName = eigenScan.enterFirstName();
            String lastName = eigenScan.enterLastName();
            for (Profile a : klantenBestand) {
                if (firstName.equals(a.getVoornaam()) && lastName.equals(a.getAchternaam())) {
                    return a;
                }
            }
            if (!isInList) {
                System.out.println(Talen.rb().getString("persoonNietInSysteem"));
                if (j > 0) {
                    System.out.println(Talen.rb().getString("triesLeft") + j + Talen.rb().getString("triesLeft2"));
                }
                i++;
                j--;
                if (j == -1) {
                    System.out.println(Talen.rb().getString("exitProgram"));
                    System.exit(0);
                }
            }
        }
        return leeg;
    }
}
