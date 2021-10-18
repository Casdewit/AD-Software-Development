package com.team3.utils;

import com.google.gson.Gson;
import com.team3.canvas.Bias;
import com.team3.gamehandler.Round;
import spark.Spark;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static spark.Spark.*;

public class Endpoints {

    private DataHandler dataHandler;

    public Endpoints(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public void startServer() throws FileNotFoundException {

        // Allow CORS//////////////////////////////////////////////////////////////////////////////
        Spark.options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";

        });
        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });
        ////////////////////////////////////////////////////////////////////////////////////////////


        final Gson gson = new Gson();
        Round round1 = dataHandler.getRoundsData().get(0);
        Round round2 = dataHandler.getRoundsData().get(1);
        Round round3 = dataHandler.getRoundsData().get(2);
        Round round4 = dataHandler.getRoundsData().get(3);
        Round round5 = dataHandler.getRoundsData().get(4);
        Round round6 = dataHandler.getRoundsData().get(5);

        System.out.println("Rounds have been loaded");

        ArrayList<Bias> biasList = dataHandler.getBiaslistData();

        System.out.println("Bias list has been loaded");



        get("/round1", (req, res) -> {
            return gson.toJson(round1);
        });

        get("/round2", (req, res) -> {
            return gson.toJson(round2);
        });

        get("/round3", (req, res) -> {
            return gson.toJson(round3);
        });

        get("/round4", (req, res) -> {
            return gson.toJson(round4);
        });

        get("/round5", (req, res) -> {
            return gson.toJson(round5);
        });

        get("/round6", (req, res) -> {
            return gson.toJson(round6);
        });

        get("/biases", (req, res) -> {
            return gson.toJson(biasList);
        });

        after((req, res) -> {
            res.status(200);
            res.type("application/json");
        });

        notFound((req, res) -> {
            res.type("application/json");
            res.status(404);
            return "{\"message\":\"404 Not Found\"}";
        });
    }
}
