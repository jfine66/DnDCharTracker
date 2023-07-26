package com.dndcharacter.service.models.requests;

import java.util.HashMap;
import java.util.Objects;

public class CreateCharacterRequest {
    private String userName;
    private String password;
    private String characterName;
    private String className;
    private String race;
    private int strStat;
    private int dexStat;
    private int conStat;
    private int intStat;
    private int wisStat;
    private int charStat;
    private int proficiencyBonus;
    private int maxHealth;
    private int AC;
    private int speed;
    private int hitDie;
    private HashMap<String, Boolean> savingThrows;
    private HashMap<String, Boolean> skills;

    public CreateCharacterRequest() {
    }

    public CreateCharacterRequest(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.characterName = builder.characterName;
        this.className = builder.className;
        this.race = builder.race;
        this.strStat = builder.strStat;
        this.dexStat = builder.dexStat;
        this.conStat = builder.conStat;
        this.intStat = builder.intStat;
        this.wisStat = builder.wisStat;
        this.charStat = builder.charStat;
        this.proficiencyBonus = builder.proficiencyBonus;
        this. maxHealth = builder.maxHealth;
        this.AC = builder.AC;
        this.speed = builder.speed;
        this.hitDie = builder.hitDie;
        this.savingThrows = builder.savingThrows;
        this.skills = builder.skills;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
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

    //******************** Override Methods *********************************
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        var that = (CreateCharacterRequest) obj;
        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(characterName, that.characterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, characterName);
    }

    // ********************** Builder ************************
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userName;
        private String password;
        private String characterName;
        private String className;
        private String race;
        private int strStat;
        private int dexStat;
        private int conStat;
        private int intStat;
        private int wisStat;
        private int charStat;
        private int proficiencyBonus;
        private int maxHealth;
        private int AC;
        private int speed;
        private int hitDie;
        private HashMap<String, Boolean> savingThrows;
        private HashMap<String, Boolean> skills;

        public Builder withUserName(String name){
            this.userName = name;
            return this;
        }

        public Builder withPassword(String pass) {
            this.password = pass;
            return this;
        }

        public Builder withCharacterName(String name) {
            this.characterName = name;
            return this;
        }

        public Builder withClassName(String name) {
            this.className = name;
            return this;
        }

        public Builder withRace(String race) {
            this.race = race;
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

        public Builder withProficiencyBonus(int proficiencyBonus) {
            this.proficiencyBonus = proficiencyBonus;
            return this;
        }

        public Builder withMaxHealth(int max) {
            this.maxHealth = max;
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

        public Builder withSavingThrows(HashMap<String, Boolean> map) {
            this.savingThrows = map;
            return this;
        }

        public Builder withSkill(HashMap<String, Boolean> map) {
            this.skills = map;
            return this;
        }

        public CreateCharacterRequest build() {
            return new CreateCharacterRequest(this);
        }
    }
}
