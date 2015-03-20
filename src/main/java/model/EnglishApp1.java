package model;

import javax.persistence.*;

@Entity
@Table(name="EnglishApp",
        uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class EnglishApp1 {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="English_Word", length=20, nullable=true)
    private String English_Word;

    @Column(name="Russian_Word", length=20, nullable=true)
    private String Russian_Word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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