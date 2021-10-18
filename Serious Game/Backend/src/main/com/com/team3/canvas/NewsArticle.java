package com.team3.canvas;

public class NewsArticle {

    private String newsArticleTitle;
    private String newsArticleMessage;
    private String newsArticleSource;
    private boolean newsArticlePopup;

    public NewsArticle(String newsArticleTitle, String newsArticleMessage, String newsArticleSource, boolean newsArticlePopup){
        this.newsArticleTitle = newsArticleTitle;
        this.newsArticleMessage = newsArticleMessage;
        this.newsArticleSource = newsArticleSource;
        this.newsArticlePopup = newsArticlePopup;
    }

    public String getNewsArticleTitle() {
        return newsArticleTitle;
    }

    public void setNewsArticleTitle(String newsArticleTitle) {
        this.newsArticleTitle = newsArticleTitle;
    }

    public String getNewsArticleMessage() {
        return newsArticleMessage;
    }

    public void setNewsArticleMessage(String newsArticleMessage) {
        this.newsArticleMessage = newsArticleMessage;
    }

    public String getNewsArticleSource() {
        return newsArticleSource;
    }

    public void setNewsArticleSource(String newsArticleSource) {
        this.newsArticleSource = newsArticleSource;
    }

    public boolean isNewsArticlePopup() {
        return newsArticlePopup;
    }

    public void setNewsArticlePopup(boolean newsArticlePopup) {
        this.newsArticlePopup = newsArticlePopup;
    }
}
