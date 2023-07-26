package com.dndcharacter.service.dynamodb.models;

import java.util.HashMap;
import java.util.Objects;

public class DnDCharacter {
    private String name;
    private String className;
    private String race;
    private int level;
    private long expPoints;
    private int strStat;
    private int dexStat;
    private int conStat;
    private int intStat;
    private int wisStat;
    private int charStat;
    private int proficiencyBonus;
    private int maxHealth;
    private int currentHealth;
    private int AC;
    private int speed;
    private int hitDie;
    private HashMap<String, Boolean> savingThrows;
    private HashMap<String, Boolean> skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(long expPoints) {
        this.expPoints = expPoints;
    }

    public int getStrStat() {
        return strStat;
    }

    public void setStrStat(int strStat) {
        this.strStat = strStat;
    }

    public int getDexStat() {
        return dexStat;
    }

    public void setDexStat(int dexStat) {
        this.dexStat = dexStat;
    }

    public int getConStat() {
        return conStat;
    }

    public void setConStat(int conStat) {
        this.conStat = conStat;
    }

    public int getIntStat() {
        return intStat;
    }

    public void setIntStat(int intStat) {
        this.intStat = intStat;
    }

    public int getWisStat() {
        return wisStat;
    }

    public void setWisStat(int wisStat) {
        this.wisStat = wisStat;
    }

    public int getCharStat() {
        return charStat;
    }

    public void setCharStat(int charStat) {
        this.charStat = charStat;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public HashMap<String, Boolean> getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(HashMap<String, Boolean> savingThrows) {
        this.savingThrows = savingThrows;
    }

    public HashMap<String, Boolean> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, Boolean> skills) {
        this.skills = skills;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHitDie() {
        return hitDie;
    }

    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, className);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        DnDCharacter that = (DnDCharacter) obj;

        return Objects.equals(name, that.name) && Objects.equals(className, that.className);
    }
}