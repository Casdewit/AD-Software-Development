package com.team3.canvas;

import java.util.ArrayList;

public class BiasCollection {

    private ArrayList<Bias> biasCollection;

    public BiasCollection(ArrayList<Bias> biasArray) {
        this.biasCollection = biasArray;
    }

    public void addBias(Bias bias) {
        this.biasCollection.add(bias);
    }

}
