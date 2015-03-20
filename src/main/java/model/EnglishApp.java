package model;

import java.lang.String; /**
 * Created by almex on 20.03.15.
 */
public class EnglishApp {

    private int ID;
    private String English_Word;
    private String Russian_Word;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEnglish_Word() {
        return English_Word;
    }

    public void setEnglish_Word(String english_Word) {
        English_Word = english_Word;
    }

    public String getRussian_Word() {
        return Russian_Word;
    }

    public void setRussian_Word(String russian_Word) {
        Russian_Word = russian_Word;
    }
}
