package com.team3.utils;

import com.team3.canvas.*;
import com.google.gson.Gson;

import com.team3.gamehandler.MeasureQuestion;
import com.team3.gamehandler.Timer;
import com.team3.gamehandler.Round;


import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public class RoundCreator {

    public static void createRoundJSON() {
        String roundNumber = "Ronde 1: ";
        String roundTitle = "De start";
        Timer timer = new Timer(7);
        Scenario scenario = new Scenario("Hamsterwoede!", "Met oplopende Olifantengriepcijfers op de horizon zijn inwoners van Engelse Eiland massaal begonnen met het inslaan van tampons. Deze zouden helpen de Olifantengriep uit de neus te houden en daarmee een infectie te voorkomen. De regering van Engelse Eiland verzoekt haar burgers dringend om te stoppen met hamsteren, en verzekert hen ervan dat de voorraden groot genoeg zijn om iedereen te kunnen bedienen. Over de effectiviteit van het tampongebruik als preventie van de Olifantengriep zijn door experts nog geen uitspraken gedaan. In Digitanzanië beginnen de eerste geluiden al op te gaan om spullen in te slaan. Wat moet de overheid doen?");

        Bias bias1 = new Bias('a', "Decoy effect", "In de keuze tussen twee producten zal er een voorkeur optreden voor een van de twee zodra je een er een optie tussen plaatst die (asymmetrisch) dichter bij een van de opties ligt.", "In de bioscoop verkoopt men kleine, medium en grote popcorn voor €2.50, €3,50 en €4,00 respectievelijk.", 0);
        Bias bias2 = new Bias('b', "Decoy effect", "In de keuze tussen twee producten zal er een voorkeur optreden voor een van de twee zodra je een er een optie tussen plaatst die (asymmetrisch) dichter bij een van de opties ligt.", "In de bioscoop verkoopt men kleine, medium en grote popcorn voor €2.50, €3,50 en €4,00 respectievelijk.", 5);
        Bias bias3 = new Bias('c', "Decoy effect", "In de keuze tussen twee producten zal er een voorkeur optreden voor een van de twee zodra je een er een optie tussen plaatst die (asymmetrisch) dichter bij een van de opties ligt.", "In de bioscoop verkoopt men kleine, medium en grote popcorn voor €2.50, €3,50 en €4,00 respectievelijk.", 2);

        ArrayList<Bias> biasCollection = new ArrayList<Bias>();
        biasCollection.add(bias1);
        biasCollection.add(bias2);
        biasCollection.add(bias3);

        MeasureQuestion measureQuestion1 = new MeasureQuestion('a', "We plaatsen een overzicht van de informatie over het virus en omschrijven welke soorten middelen infectie kunnen afremmen of tegenhouden.", 5);
        MeasureQuestion measureQuestion2 = new MeasureQuestion('b', "We plaatsen een overzicht van de informatie over het virus en omschrijven welke soorten middelen infectie kunnen afremmen of tegenhouden.", 0);
        MeasureQuestion measureQuestion3 = new MeasureQuestion('c', "We plaatsen een overzicht van de informatie over het virus en omschrijven welke soorten middelen infectie kunnen afremmen of tegenhouden.", 2);

        ArrayList<MeasureQuestion> measureQuestionCollection = new ArrayList<MeasureQuestion>();
        measureQuestionCollection.add(measureQuestion1);
        measureQuestionCollection.add(measureQuestion2);
        measureQuestionCollection.add(measureQuestion3);


        ArrayList<Canvas> canvasCollection = new ArrayList<Canvas>();
        // array van 5 canvassen
        Canvas canvas1 = new Canvas();
        canvas1.getNewsArticleCollection().add((new NewsArticle("", "", "", false)));
        canvas1.getNewsArticleCollection().add((new NewsArticle("", "", "", false)));
        canvas1.getNewsArticleCollection().add((new NewsArticle("", "", "", true)));
        canvas1.setInfections(new Infections(999, 999, 999));
        canvasCollection.add(canvas1);


        Canvas canvas2 = new Canvas();
        canvas2.getNewsArticleCollection().add((new NewsArticle("", "", "", false)));
        canvas2.getNewsArticleCollection().add((new NewsArticle("", "", "", false)));
        canvas2.getNewsArticleCollection().add((new NewsArticle("", "", "", true)));
        canvas2.setInfections(new Infections(999, 999, 999));
        canvasCollection.add(canvas2);

        Canvas canvas3 = new Canvas();
        canvas3.getNewsArticleCollection().add((new NewsArticle("Experts maken zich zorgen over stijgende aantal besmettingen Olifantengriep", "Veel blijft nog onbekend over de onlangs ontdekte Olifantengriep. Vooralsnog lijkt Noord-Kropslavië het enige land dat getroffen is. Inzichten in de verspreiding en werking van het virus blijven nog uit. Authoriteiten in Degressia zijn begonnen met de eerste maatregelen om het land voor te bereiden op een uitbraak.", "~ Degressia Dagblad ~", false)));
        canvas3.getNewsArticleCollection().add((new NewsArticle("Een nieuw en potentieel levensbedreigend virus is gevonden in Noord-Kropslavië", "De afgelopen dagen zijn er steeds meer gevallen bekend geworden van een nieuw en mogelijk levensbedreigend virus in Noord-Kropslavië. Genaamd de olifantengriep vanwege de gezichtsmutatie die het laatste stadium van besmetting met dit virus met zich mee brengt: een permanente verandering van de neus in een slurf. Epidemiologen en virologen zijn druk bezig met een onderzoek om het virus tegen te gaan.", "~ Daily Digitanzanië ~", true)));
        canvas3.getNewsArticleCollection().add((new NewsArticle("", "", "", true)));
        canvas3.setInfections(new Infections(999, 999, 999));
        canvasCollection.add(canvas3);

        Canvas canvas4 = new Canvas();
        canvas4.getNewsArticleCollection().add((new NewsArticle("", "", "", false)));
        canvas4.getNewsArticleCollection().add((new NewsArticle("", "", "", false)));
        canvas4.getNewsArticleCollection().add((new NewsArticle("", "", "", false)));
        canvas4.setInfections(new Infections(999, 999, 999));
        canvasCollection.add(canvas4);

        Canvas canvas5 = new Canvas();
        canvas5.getNewsArticleCollection().add((new NewsArticle("", "", "", true)));
        canvas5.getNewsArticleCollection().add((new NewsArticle("", "", "", true)));
        canvas5.getNewsArticleCollection().add((new NewsArticle("", "", "", true)));
        canvas5.setInfections(new Infections(999, 999, 999));
        canvasCollection.add(canvas5);


        Round round = new Round(roundNumber, roundTitle, timer, scenario, biasCollection, measureQuestionCollection, canvasCollection);

        try {
            Writer writer = new FileWriter("/home/yawgmoth/Dropbox/HU-ADSD/S2/Periode 3/bias-brothers-serious-game/Backend/src/main/test/test.json");
            Gson gson = new Gson();
            // 1. Java object to JSON file
            gson.toJson(round, writer);
            writer.flush(); //flush data to file

            System.out.println("profile list has exported to json");//   <---
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
