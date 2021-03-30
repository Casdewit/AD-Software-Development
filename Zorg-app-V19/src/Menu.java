public class Menu {

    private boolean isZorgverlener = false;
    private boolean wiltUitloggen  = false;
    private boolean menuTerug      = false;
    private boolean anderePatient  = false;

    // Constructor
    public Menu() {

    }

/*/////////////////////////////////////

    ALGEMENE MENU'S

*//////////////////////////////////////

    // Start programma. Kijkt of je zorgverlener of patiënt bent en vraagt evt om een wachtwoord
    public void startProgram() {
        Scan eigenScan = new Scan();
        ProfileList klantenBestand = new ProfileList();
        klantenBestand.makeProfileList();
        while (!wiltUitloggen) {
            Talen.setTaal(eigenScan.taalKeuze());
            printWelkomMenu();
            int choice = eigenScan.getFirstChoice();
            if (choice == 3) {
                exitProgram();
            } else if (choice == 1) {
                checkPassword();
                isZorgverlener = true;
                do {
                    wiltUitloggen = false;
                    System.out.print(Talen.rb().getString("enterNames"));
                    runHoofdMenu(klantenBestand.whichProfile());
                } while (anderePatient);
            } else if (choice == 2) {
                isZorgverlener = false;
                System.out.print(Talen.rb().getString("enterNames"));
                runHoofdMenu(klantenBestand.whichProfile());
            }
            wiltUitloggen = false;
        }
    }

    // Runt het menu of je wilt weergeven / bewerken / afsluiten / uitloggen
    public void runHoofdMenu(Profile patient) {
        Scan eigenScan = new Scan();
        while (!wiltUitloggen) {
            printMenu();
            int choice = eigenScan.getChoice();
            if (choice == 9) {
                exitProgram();
            } else if (choice == 1) {
                patient.printProfile();
            } else if (choice == 2) {
                bewerkMenu(patient);
            } else if (choice == 3) {
                runMedicijnMenu(patient);
            } else if (choice == 4) {
                runGewichtMeetpuntMenu(patient);
            } else if (choice == 5) {
                runUitloggen();
            } else if (choice == 6){
                runAnderePatient();
            } else if (choice == 7) {
                Talen.setTaal(eigenScan.taalKeuze());
            }
        }
    }

    // Runt het menu voor gewichtmeetpunten als zorgverlener zijnde
    public void runGewichtMeetpuntMenu(Profile patient) {
        Scan eigenScan = new Scan();
        GewichtMeetPuntList gewichtList = new GewichtMeetPuntList();
        if (!isZorgverlener){
            patient.printGewichtMeetpunten();
            gewichtList.printStaafdiagram(patient);
            return;
        }
        while (!menuTerug) {
            printGewichtMeetPuntMenu();
            int choice = eigenScan.getChoice3();
            if (choice == 1) {
                patient.printGewichtMeetpunten();
                gewichtList.printStaafdiagram(patient);
            } else if (choice == 2) {
                gewichtList.bewerkGewichtMeetpunten(patient);
            } else if (choice == 3) {
                gewichtList.addGewichtMeetpunten(patient);
            } else if (choice == 4) {
                gewichtList.deleteGewichtMeetpunt(patient);
            } else if (choice == 9) {
                menuTerug = true;
            }
        }
        menuTerug = false;
    }

    // Runt het medicijn keuze menu als zorgverlener zijnde
    public void runMedicijnMenu(Profile patient) {
        if (!isZorgverlener){
            patient.printMedicijnenPatient();
            return;
        }
        Scan eigenScan = new Scan();
        MedicijnList medicijnList = new MedicijnList();
        while (!menuTerug) {
            printMedicijnMenu();
            int choice = eigenScan.getChoice3();
            if (choice == 1) {
                patient.printMedicijnenPatient();
            } else if (choice == 2) {
                medicijnList.addMedicijnen(patient);
            } else if (choice == 3) {
                medicijnList.deleteMedicijnen(patient);
            } else if (choice == 4) {
                medicijnList.printCompleteMedicijnLijst();
            } else if (choice == 9) {
                menuTerug = true;
            }
        }
        menuTerug = false;
    }

    // Runt het menu of je namen / leeftijd / gewicht wilt bewerken
    public void bewerkMenu(Profile patient) {
        Scan eigenScan = new Scan();
        while (!menuTerug) {
            printBewerkMenu();
            int choice = eigenScan.getChoice2();
            if (choice == 1) {
                patient.setNames();
            } else if (choice == 2) {
                patient.setAge();
            } else if (choice == 3) {
                if (isZorgverlener) {
                    patient.setWeight();
                } else {
                    System.out.println(Talen.rb().getString("onlyZorgverlener"));
                }
            } else if (choice == 9) {
                menuTerug = true;
            }
        }
        menuTerug = false;
    }

    // Andere patient bewerken. Kan alleen als zorgverlener.
    public void runAnderePatient(){
        if (isZorgverlener){
            anderePatient = true;
            wiltUitloggen = true;
        } else {
            System.out.println(Talen.rb().getString("onlyZorgverlener"));
        }
    }

    // Logt uit en verandert booleans
    public void runUitloggen(){
        wiltUitloggen = true;
        anderePatient = false;
    }

    // Checkt het wachtwoord van de zorgverlener
    public void checkPassword(){
        Scan eigenScan = new Scan();
        if (!eigenScan.checkPassword()){
            exitProgram();
        } else {
            System.out.println(Talen.rb().getString("groet"));
        }
    }

/*/////////////////////////////////////

    PRINT MENU'S

*//////////////////////////////////////

    // Print het welkom menu
    public void printWelkomMenu() {
        System.out.println(Talen.rb().getString("welkomMenu"));
    }

    // Print het algemene menu uit
    public void printMenu() {
        System.out.println(Talen.rb().getString("hoofdMenu"));
    }

    // Print het bewerkmenu uit
    public void printBewerkMenu() {
        System.out.println(Talen.rb().getString("bewerkMenu"));
    }

    // Print het medicijn menu als zorgverlener zijnde uit
    public void printMedicijnMenu() {
        System.out.println(Talen.rb().getString("medicijnMenu"));
    }

    // Print het menu voor gewichtmeetpunten voor de zorgverlener
    public void printGewichtMeetPuntMenu() {
        System.out.println(Talen.rb().getString("gewichtMeetpuntMenu"));
    }

    // Sluit het programma af
    public void exitProgram() {
        System.out.println(Talen.rb().getString("exitProgram"));
        System.exit(0);
    }
}
