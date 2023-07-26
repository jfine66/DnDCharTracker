// Class buttons
const barbBtn = document.getElementById('barb-class')
const bardBtn = document.getElementById('bard-class')
const clericBtn = document.getElementById('cleric-class')
const druidBtn = document.getElementById('druid-class')
const fighterBtn = document.getElementById('fighter-class')
const monkBtn = document.getElementById('monk-class')
const paladinBtn = document.getElementById('paladin-class')
const rangerBtn = document.getElementById('ranger-class')
const rogueBtn = document.getElementById('rogue-class')
const sorcBtn = document.getElementById('sorcerer-class')
const warlockBtn = document.getElementById('warlock-class')
const wizardBtn = document.getElementById('wizard-class')
const logOut = document.querySelector('.log-out')
const loadDiv = document.querySelector('.wave')
const character_api = "https://hof2lxdd4k.execute-api.us-west-2.amazonaws.com/prod/characters"

const userCreds = JSON.parse(sessionStorage.getItem("userCreds"))
const char = JSON.parse(sessionStorage.getItem("newCharacter"))
const charName = char[0]
const charRace = char[1]

// stats
let strStat;
let dexStat;
let conStat;
let intStat;
let wisStat;
let charStat;

const savingThrows = {"STR": false, "DEX": false, "CON": false, "INT": false, "WIS": false, "CHAR": false}
const skills = {"Arcobatics": false, "Animal Handling": false, "Arcana": false, "Athletics": false, "Deception": false, "History": false, "Insight": false, "Intimidation": false, "Investiogation": false, "Medicine": false, "Nature": false, "Perception": false, "Persuasion": false, "Religion": false, "Sleight of Hand": false, "Stealth": false, "Survival": false}

barbBtn.addEventListener('click', () => {
    changeClass("Barbarian")
})

bardBtn.addEventListener('click', () => {
    changeClass("Bard")
})

clericBtn.addEventListener('click', () => {
    changeClass("Cleric")
})

druidBtn.addEventListener('click', () => {
    changeClass("Druid")
})

fighterBtn.addEventListener('click', () => {
    changeClass("Fighter")
})

monkBtn.addEventListener('click', () => {
    changeClass("Monk")
})

paladinBtn.addEventListener('click', () => {
    changeClass("Paladin")
})

rangerBtn.addEventListener('click', () => {
    changeClass("Ranger")
})

rogueBtn.addEventListener('click', () => {
    changeClass("Rogue")
})

sorcBtn.addEventListener('click', () => {
    changeClass("Sorcerer")
})

warlockBtn.addEventListener('click', () => {
    changeClass("Warlock")
})

wizardBtn.addEventListener('click', () => {
    changeClass("Wizard")
})


function changeClass(className) {
    loadDiv.style.visibility = "visible"
    generateStats();
    setSavingThrows(className);

    const response = fetch(character_api, {
        method: "POST",

        body: JSON.stringify({
            userName: userCreds[0],
            password: userCreds[1],
            characterName: charName,
            className: className,
            race: charRace,
            strStat: strStat,
            dexStat: dexStat,
            conStat: conStat,
            intStat: intStat,
            wisStat: wisStat,
            charStat: charStat,
            proficiencyBonus: 2,
            maxHealth: (getMaxHp(className) + getConMod(conStat)),
            AC: 10,
            speed: getSpeed(charRace),
            hitDie: 1,
            savingThrows: savingThrows,
            skills: skills
        }),

        headers: {
            "Content-type": "application/json"
        }
    })
    .then(resp => resp.json())
    .then(json => {
        loadDiv.style.visibility = "hidden"
        window.location.href = "../html/home.html"
    });
}

function generateStats() {
    const max = 18
    const min = 7
    strStat = Math.floor(Math.random() * (max - min + 1) + min)
    dexStat = Math.floor(Math.random() * (max - min + 1) + min)
    conStat = Math.floor(Math.random() * (max - min + 1) + min)
    intStat = Math.floor(Math.random() * (max - min + 1) + min)
    wisStat = Math.floor(Math.random() * (max - min + 1) + min)
    charStat = Math.floor(Math.random() * (max - min + 1) + min)
}

function getSpeed(race) {
    switch(race) {
        case "Dwarf":
        case "Halfing":
        case "Gnome":
            return 25;
        case "Dragonborn":
        case "Elf":
        case "Half-Elf":
        case "Human":
        case "Half-Orc":
        case "Tiefling":
            return 30;
    }
}

function getMaxHp(className) {
    switch(className) {
        case "Barbarian":
            return 12;
        case "Fighter":
        case "Paladin":
        case "Ranger":
            return 10;
        case "Wizard":
        case "Sorcerer":
            return 6
    }

    return 8;
}

function getConMod(mod) {
    if (mod < 10) {
        return 0;
    }

    switch(mod) {
        case 10:
        case 11:
            return 0;
        case 12:
        case 13:
            return 1;
        case 14:
        case 15:
            return 2;
        case 16:
        case 17:
            return 3;
        case 18:
        case 19:
            return 4;
        case 20:
            return 5;
    }
}

function setSavingThrows(className) {
    switch(className) {
        case "Barbarian":
            savingThrows["STR"] = true
            savingThrows["CON"] = true
            break;
        case "Bard":
            savingThrows["DEX"] = true
            savingThrows["CHAR"] = true
            break;
        case "Cleric":
            savingThrows["WIS"] = true
            savingThrows["CHAR"] = true
            break;
        case "Druid":
            savingThrows["INT"] = true
            savingThrows["WIS"] = true
            break;
        case "Fighter":
            savingThrows["STR"] = true
            savingThrows["CON"] = true
            break;
        case "Monk":
            savingThrows["STR"] = true
            savingThrows["DEX"] = true
            break;
        case "Paladin":
            savingThrows["WIS"] = true
            savingThrows["CHAR"] = true
            break;
        case "Ranger":
            savingThrows["STR"] = true
            savingThrows["DEX"] = true
            break;
        case "Rogue":
            savingThrows["DEX"] = true
            savingThrows["INT"] = true
            break;
        case "Sorcerer":
            savingThrows["CON"] = true
            savingThrows["CHAR"] = true
            break;
        case "Warlock":
            savingThrows["WIS"] = true
            savingThrows["CHAR"] = true
            break;
        case "Wizard":
            savingThrows["INT"] = true
            savingThrows["WIS"] = true
            break;
    }
}

logOut.addEventListener('click', () => {
    sessionStorage.clear()
    window.location.href = "../html/index.html"
})