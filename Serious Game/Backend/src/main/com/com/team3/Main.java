package com.team3;

import com.team3.utils.Endpoints;
import com.team3.utils.DataHandler;

import java.io.FileNotFoundException;


public class Main {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) throws FileNotFoundException {
        getHerokuAssignedPort();

    //"http://localhost:4567/"
        DataHandler dataHandler = new DataHandler();
        Endpoints endpoints = new Endpoints(dataHandler);
        endpoints.startServer();
    }

}
