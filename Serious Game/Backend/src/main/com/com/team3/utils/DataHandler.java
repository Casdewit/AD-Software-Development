package com.team3.utils;

import com.team3.canvas.Bias;
import com.team3.gamehandler.Round;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class DataHandler {

    private static ArrayList<Round> setupRoundaData() throws FileNotFoundException {
        try {
            Gson gson = new Gson();

            Reader reader1 = new FileReader("Backend/src/main/resources/data/Round1.json");
            Reader reader2 = new FileReader("Backend/src/main/resources/data/Round2.json");
            Reader reader3 = new FileReader("Backend/src/main/resources/data/Round3.json");
            Reader reader4 = new FileReader("Backend/src/main/resources/data/Round4.json");
            Reader reader5 = new FileReader("Backend/src/main/resources/data/Round5.json");
            Reader reader6 = new FileReader("Backend/src/main/resources/data/Round6.json");

            Round round1 = gson.fromJson(reader1, Round.class);
            Round round2 = gson.fromJson(reader2, Round.class);
            Round round3 = gson.fromJson(reader3, Round.class);
            Round round4 = gson.fromJson(reader4, Round.class);
            Round round5 = gson.fromJson(reader5, Round.class);
            Round round6 = gson.fromJson(reader6, Round.class);


            reader1.close();
            reader2.close();
            reader3.close();
            reader4.close();
            reader5.close();
            reader6.close();



            ArrayList<Round> rounds = new ArrayList<Round>();
            rounds.add(round1);
            rounds.add(round2);
            rounds.add(round3);
            rounds.add(round4);
            rounds.add(round5);
            rounds.add(round6);


            return rounds;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Bias> setupBiasListData() {
        try {
            Gson gson = new Gson();
            Reader biasListReader = new FileReader("Backend/src/main/resources/data/BiasList.json");

            ArrayList<Bias> biasList = gson.fromJson(biasListReader, ArrayList.class);

            biasListReader.close();

            return biasList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Bias> getBiaslistData() throws FileNotFoundException {
        return setupBiasListData();
    }


    public ArrayList<Round> getRoundsData() throws FileNotFoundException {
        return setupRoundaData();
    }



}


//    public ArrayList<Bias> getBiasCollection() {
//        return biasCollection;
//    }


//    public void load(File file) throws FileNotFoundException {
//        JSONParser parser = new JSONParser();
//        try (FileReader reader = new FileReader(file)) {
//            Object object = parser.parse(reader);
//            JSONArray list = (JSONArray) object;
//            list.forEach(emp -> parseBiasObject((JSONObject) emp));
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    [20:27] Amanda Schoonhoven
//            File gameJSON = new File("data/game.json");
//            ArrayList<JSONObject> bRound = new ArrayList<JSONObject>();
//        ​[20:29] Amanda Schoonhoven
//private void parseBiasObject(JSONObject biasO) {​
//        JSONObject biasObject = (JSONObject) biasO.get("bias");
//        String Char = (String) biasObject.get("biasChar");
//        String biasName = (String) biasObject.get("biasName");
//        String biasDescription = (String) biasObject.get("biasDescription");
//        String biasExample = (String) biasObject.get("biasExample");
//        String points = (String) (biasObject.get("biasPoints"));
//        eBiasQuestion bias = new eBiasQuestion(Char, biasName, biasDescription, biasExample, points);
//        biasen.add(bias);
//        }​

