package com.dndcharacter.service.models;

import java.util.Map;
import java.util.Objects;

public class CharacterModel {
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
    private Map<String, Boolean> savingThrows;
    private Map<String, Boolean> skills;

    public CharacterModel() {
    }

    public CharacterModel(Builder builder) {
        this.name = builder.name;
        this.className = builder.className;
        this.race = builder.race;
        this.level = builder.level;
        this.expPoints = builder.expPoints;
        this.strStat = builder.strStat;
        this.dexStat = builder.dexStat;
        this.conStat = builder.conStat;
        this.intStat = builder.intStat;
        this.wisStat = builder.wisStat;
        this.charStat = builder.charStat;
        this.proficiencyBonus = builder.proficiencyBonus;
        this.maxHealth = builder.maxHealth;
        this.currentHealth = builder.currentHealth;
        this.AC = builder.AC;
        this.speed = builder.speed;
        this.hitDie = builder.hitDie;
        this.savingThrows = builder.savingThrows;
        this.skills = builder.skills;
    }

    //*************  Getter and Setters *************************************

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Map<String, Boolean> getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(Map<String, Boolean> savingThrows) {
        this.savingThrows = savingThrows;
    }

    public Map<String, Boolean> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Boolean> skills) {
        this.skills = skills;
    }

    // ********************* Override Methods ***********************

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CharacterModel that = (CharacterModel) obj;

        return Objects.equals(name, that.name) && Objects.equals(className, that.className);
    }

    public int hashCode() {
        return Objects.hash(name, className);
    }


    // *********************** Builder ******************************

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
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
        private Map<String, Boolean> savingThrows;
        private Map<String, Boolean> skills;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withClassName(String className) {
            this.className = className;
            return this;
        }

        public Builder withRace(String raceName) {
            this.race = raceName;
            return this;
        }

        public Builder withLevel(int level) {
            this.level = level;
            return this;
        }

        public Builder withExpPoints(long expPoints) {
            this.expPoints = expPoints;
            return this;
        }

        public Builder withStrStat(int stat) {
            this.strStat = stat;
            return this;
        }

        public Builder withDexStat(int stat) {
            this.dexStat = stat;
            return this;
        }

        public Builder withConStat(int stat) {
            this.conStat = stat;
            return this;
        }

        public Builder withIntStat(int stat) {
            this.intStat = stat;
            return this;
        }

        public Builder withWisStat(int stat) {
            this.wisStat = stat;
            return this;
        }

        public Builder withCharStat(int stat) {
            this.charStat = stat;
            return this;
        }

        public Builder withProficiencyBonus(int bonus) {
            this.proficiencyBonus = bonus;
            return this;
        }

        public Builder withSavingThrows(Map<String, Boolean> saves) {
            this.savingThrows = saves;
            return this;
        }

        public Builder withSkills(Map<String, Boolean> skills) {
            this.skills = skills;
            return this;
        }

        public Builder withMaxHealth(int health) {
            this.maxHealth = health;
            return this;
        }

        public Builder withCurrentHealth(int health) {
            this.currentHealth = health;
            return this;
        }

        public Builder withAC(int ac) {
            this.AC = ac;
            return this;
        }

        public Builder withSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder withHitDie(int die) {
            this.hitDie = die;
            return this;
        }

        public CharacterModel build() {
            return new CharacterModel(this);
        }
    }
}