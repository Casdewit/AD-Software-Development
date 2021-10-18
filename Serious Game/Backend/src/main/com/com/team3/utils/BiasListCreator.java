package com.team3.utils;

import com.team3.canvas.Bias;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public class BiasListCreator {

    public static void createBiasJSONList() {
        Bias bias = new Bias('z', "","", "", 0);

        ArrayList<Bias> biasList = new ArrayList<Bias>();
        biasList.add(bias);

        try {
            Writer writer = new FileWriter("Backend/src/main/resources/data/BiasList.json");
            Gson gson = new Gson();
            // 1. Java object to JSON file
            gson.toJson(biasList, writer);
            writer.flush(); //flush data to file

            System.out.println("Bias list has exported to json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
