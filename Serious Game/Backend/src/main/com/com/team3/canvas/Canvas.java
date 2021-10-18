package com.team3.canvas;

import java.util.ArrayList;

public class Canvas {

    private int points;
    private ArrayList<NewsArticle> newsArticleCollection = new ArrayList<NewsArticle>();
    private Infections infections;

    public Canvas() {

    }

    public Canvas(int points, ArrayList<NewsArticle> newsArticleCollection, Infections infections) {
        this.points = points;
        this.newsArticleCollection = newsArticleCollection;
        this.infections = infections;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ArrayList<NewsArticle> getNewsArticleCollection() {
        return newsArticleCollection;
    }

    public void setNewsArticleCollection(ArrayList<NewsArticle> newsArticleCollection) {
        this.newsArticleCollection = newsArticleCollection;
    }

    public Infections getInfections() {
        return infections;
    }

    public void setInfections(Infections infections) {
        this.infections = infections;
    }
}
