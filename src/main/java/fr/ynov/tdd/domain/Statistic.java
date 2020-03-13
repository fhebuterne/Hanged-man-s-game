package fr.ynov.tdd.domain;

import java.util.Date;

public class Statistic {
    private String wordToFind;
    private boolean foundWord;
    private int tryCount;
    private Date date;

    public Statistic(String wordToFind, int tryCount, Date date) {
        this.wordToFind = wordToFind;
        this.tryCount = tryCount;
        this.date = date;
    }

    public Statistic(String wordToFind, boolean foundWord, int tryCount, Date date) {
        this.wordToFind = wordToFind;
        this.tryCount = tryCount;
        this.foundWord = foundWord;
        this.date = date;
    }

    public String getWordToFind() {
        return wordToFind;
    }

    public void setWordToFind(String wordToFind) {
        this.wordToFind = wordToFind;
    }

    public boolean haveFoundWord() {
        return tryCount != 6;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
