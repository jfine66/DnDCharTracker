const api_url = "https://hof2lxdd4k.execute-api.us-west-2.amazonaws.com/prod/users"
const character_api = "https://hof2lxdd4k.execute-api.us-west-2.amazonaws.com/prod/characters"
const userCreds = JSON.parse(sessionStorage.getItem("userCreds"))
const charcter = JSON.parse(sessionStorage.getItem("charDetails"))
// Core character info
const charName = document.getElementById('character-name')
const charClass = document.getElementById('character-class')
const charRace = document.getElementById('character-race')
const charLevel = document.getElementById('character-level')
const charExp = document.getElementById('character-exp')
// Core Stats
const strStat = document.getElementById('str-stat')
const dexStat = document.getElementById('dex-stat')
const conStat = document.getElementById('con-stat')
const intStat = document.getElementById('int-stat')
const wisStat = document.getElementById('wis-stat')
const charStat = document.getElementById('char-stat')
// Saving throws
const proficiency = document.getElementById('proficiency')
const strSave = document.getElementById('Str-save')
const dexSave = document.getElementById('Dex-save')
const conSave = document.getElementById('Con-save')
const intSave = document.getElementById('Int-save')
const wisSave = document.getElementById('Wis-save')
const charSave = document.getElementById('Char-save')
// Mods
const strModDB = document.getElementById('str-mod')
const dexModDB = document.getElementById('dex-mod')
const conModDB = document.getElementById('con-mod')
const intModDB = document.getElementById('int-mod')
const wisModDB = document.getElementById('wis-mod')
const charModDB = document.getElementById('char-mod')
// Skills
const skills = document.querySelectorAll('.skill')
const arcoSkill = document.getElementById('arco-skill')
const animalSkill = document.getElementById('animal-skill')
const arcanaSkill = document.getElementById('arcana-skill')
const athleticsSkill = document.getElementById('athletics')
const deceptionSkill = document.getElementById('Deception')
const historySkill = document.getElementById('History')
const insightSkill = document.getElementById('Insight')
const intimidationSkill = document.getElementById('Intimidation')
const investiogationSkill = document.getElementById('Investiogation')
const medicineSkill = document.getElementById('Medicine')
const natureSkill = document.getElementById('Nature')
const perceptionSkill = document.getElementById('Perception')
const performanceSkill = document.getElementById('Performance')
const persuasionSkill = document.getElementById('Persuasion')
const religionSkill = document.getElementById('Religion')
const sleightSkill = document.getElementById('Sleight of Hand')
const stealthSkill = document.getElementById('Stealth')
const survivalSkill = document.getElementById('Survival')
// HP-AC
const maxHP = document.querySelector('.max-hp')
const currentHP = document.querySelector('.current-hp')
const speed = document.querySelector('.speed')
const ac = document.querySelector('.ac')
const hitdie = document.querySelector('.hitdie')
const saveBtnDB = document.querySelector('.save-btn')
const backBtn = document.querySelector('.back-btn')
const loadingDiv = document.querySelector('.wave')

getCharacter()

function getCharacter() {
    const response = fetch(api_url, {
        method: "POST",

        body: JSON.stringify({
            userName: userCreds[0],
            password: userCreds[1]
        }),

        headers: {
            "Content-type": "application/json"
        }
    })
    .then(resp => resp.json())
    .then(json => json.user.characters.forEach(ele => {
        if (ele.name == charcter[0] && ele.className == charcter[1]) {
            setCharInfo(ele)
            return;
        }
    }));
}

function updateCharacter() {
        loadingDiv.style.visibility = "visible"
        const response = fetch(character_api, {
        method: "PUT",

        body: JSON.stringify({
            userName: userCreds[0],
            password: userCreds[1],
            character: {"name": charName.textContent, "className": charClass.textContent},
            characterName: charName.textContent,
            className: charClass.textContent,
            race: charRace.textContent,
            level: Number(charLevel.textContent),
            expPoints: Number(charExp.textContent),
            strStat: Number(strStat.textContent),
            dexStat: Number(dexStat.textContent),
            conStat: Number(conStat.textContent),
            intStat: Number(intStat.textContent),
            wisStat: Number(wisStat.textContent),
            charStat: Number(charStat.textContent),
            proficiencyBonus: Number(proficiency.textContent),
            maxHealth: Number(maxHP.textContent),
            currentHealth: Number(currentHP.textContent),
            AC: Number(ac.textContent),
            speed: Number(speed.textContent),
            hitDie: Number(hitdie.textContent),
            savingThrows: {"STR": strSave.checked, "DEX": dexSave.checked, "CON": conSave.checked, "INT": intSave.checked, "WIS": wisSave.checked, "CHAR": charSave.checked},
            skills: {"Arcobatics": arcoSkill.checked, "Animal Handling": animalSkill.checked, "Arcana": arcanaSkill.checked, "Athletics": athleticsSkill.checked, "Deception": deceptionSkill.checked, "History": historySkill.checked, "Insight": insightSkill.checked, "Intimidation": intimidationSkill.checked, "Investiogation": investiogationSkill.checked, "Medicine": medicineSkill.checked, "Nature": natureSkill.checked, "Perception": perceptionSkill.checked, "Perforamnce": performanceSkill.checked, "Persuasion": persuasionSkill.checked, "Religion": religionSkill.checked, "Sleight of Hand": sleightSkill.checked, "Stealth": stealthSkill.checked, "Survival": survivalSkill.checked}
        }),

        headers: {
            "Content-type": "application/json"
        }
    })
    .then(resp => resp.json())
    .then(json => {
        loadingDiv.style.visibility = "hidden"
    });
}

function setCharInfo(char) {
    charName.textContent = char.name
    charClass.textContent = char.className
    charRace.textContent = char.race
    charLevel.textContent = char.level
    charExp.value = char.expPoints
    strStat.textContent = char.strStat
    dexStat.textContent = char.dexStat
    conStat.textContent = char.conStat
    intStat.textContent = char.intStat
    wisStat.textContent = char.wisStat
    charStat.textContent = char.charStat
    proficiency.textContent = '+' + char.proficiencyBonus
    setMods(char)
    getSavingThrows(char)
    getSkills(char)
    setHPAC(char)
}

function setMods(char) {
    strStat.nextElementSibling.nextElementSibling.textContent = adjuctMod(char.strStat)
    dexStat.nextElementSibling.nextElementSibling.textContent = adjuctMod(char.dexStat)
    conStat.nextElementSibling.nextElementSibling.textContent = adjuctMod(char.conStat)
    intStat.nextElementSibling.nextElementSibling.textContent = adjuctMod(char.intStat)
    wisStat.nextElementSibling.nextElementSibling.textContent = adjuctMod(char.wisStat)
    charStat.nextElementSibling.nextElementSibling.textContent = adjuctMod(char.charStat)
}

function getSavingThrows(char) {
    for (let i in char.savingThrows) {
        if (i == "STR" && char.savingThrows[i]) {
            strSave.checked = true;
            strSave.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(strModDB.textContent))
        } else if (i == "DEX" && char.savingThrows[i]) {
            dexSave.checked = true;
            dexSave.nextElementSibling.nextElementSibling.textContent = '+' +  (char.proficiencyBonus + Number(dexModDB.textContent))
        } else if (i == "CON" && char.savingThrows[i]) {
            conSave.checked = true;
            conSave.nextElementSibling.nextElementSibling.textContent = '+' +  (char.proficiencyBonus + Number(conModDB.textContent))
        } else if (i == "INT" && char.savingThrows[i]) {
            intSave.checked = true;
            intSave.nextElementSibling.nextElementSibling.textContent = '+' +  (char.proficiencyBonus + Number(intModDB.textContent))
        } else if (i == "WIS" && char.savingThrows[i]) {
            wisSave.checked = true;
            wisSave.nextElementSibling.nextElementSibling.textContent = '+' +  (char.proficiencyBonus + Number(wisModDB.textContent))
        } else if (i == "CHAR" && char.savingThrows[i]) {
            charSave.checked = true;
            charSave.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(charModDB.textContent))
        }
    }
}

function getSkills(char) {
    for (let i in char.skills) {
        if (i == "Arcobatics" && char.skills[i]) {
            arcoSkill.checked = true;
            arcoSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(dexModDB.textContent))
        } else if (i == "Animal Handling" && char.skills[i]) {
            animalSkill.checked = true;
            animalSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(wisModDB.textContent))
        } else if (i == "Arcana" && char.skills[i]) {
            arcanaSkill.checked = true;
            arcanaSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(intModDB.textContent))
        } else if (i == "Athletics" && char.skills[i]) {
            athleticsSkill.checked = true;
            athleticsSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(strModDB.textContent))
        } else if (i == "Deception" && char.skills[i]) {
            deceptionSkill.checked = true;
            deceptionSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(charModDB.textContent))
        } else if (i == "History" && char.skills[i]) {
            historySkill.checked = true;
            historySkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(intModDB.textContent))
        } else if (i == "Insight" && char.skills[i]) {
            insightSkill.checked = true;
            insightSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(wisModDB.textContent))
        } else if (i == "Intimidation" && char.skills[i]) {
            intimidationSkill.checked = true;
            intimidationSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(charModDB.textContent))
        } else if (i == "Investiogation" && char.skills[i]) {
            investiogationSkill.checked = true;
            investiogationSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(intModDB.textContent))
        } else if (i == "Medicine" && char.skills[i]) {
            medicineSkill.checked = true;
            medicineSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(wisModDB.textContent))
        } else if (i == "Nature" && char.skills[i]) {
            natureSkill.checked = true;
            natureSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(intModDB.textContent))
        } else if (i == "Perception" && char.skills[i]) {
            perceptionSkill.checked = true;
            perceptionSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(intModDB.textContent))
        } else if (i == "Performance" && char.skills[i]) {
            performanceSkill.checked = true;
            performanceSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(charModDB.textContent))
        } else if (i == "Persuasion" && char.skills[i]) {
            persuasionSkill.checked = true;
            persuasionSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(charModDB.textContent))
        } else if (i == "Religion" && char.skills[i]) {
            religionSkill.checked = true;
            religionSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(intModDB.textContent))
        } else if (i == "Sleight of Hand" && char.skills[i]) {
            sleightSkill.checked = true;
            sleightSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(dexModDB.textContent))
        } else if (i == "Stealth" && char.skills[i]) {
            stealthSkill.checked = true;
            stealthSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(dexModDB.textContent))
        } else if (i == "Survival" && char.skills[i]) {
            survivalSkill.checked = true;
            survivalSkill.nextElementSibling.nextElementSibling.textContent = '+' + (char.proficiencyBonus + Number(wisModDB.textContent))
        }
    }
}

function setHPAC(char) {
    maxHP.textContent = char.maxHealth
    currentHP.textContent = char.currentHealth
    ac.textContent = char.AC
    speed.textContent = char.speed
    hitdie.textContent = char.hitDie
}

function adjuctMod(stat) {
    let mod = Number(stat)

    switch(mod) {
        case 0:
        case 1:
            mod = '-5'
            break;
        case 2:
        case 3:
            mod = '-4'
            break;
        case 4:
        case 5:
            mod = '-3'
            break;
        case 6:
        case 7:
            mod = '-2'
            break;
        case 8:
        case 9:
            mod = '-1'
            break;
        case 10:
        case 11:
            mod = '+0'
            break;
        case 12:
        case 13:
            mod = '+1'
            break;
        case 14:
        case 15:
            mod = '+2'
            break;
        case 16:
        case 17:
            mod = '+3'
            break;
        case 18:
        case 19:
            mod = '+4'
            break;
        case 20:
            mod = '+5'
            break;
        default:
            return;
    }

    return mod;
}

function setSavingThrows(ele) {
    if(strSave.checked) {
        ele.savingThrows["STR"] = true;
    } else {
        ele.savingThrows["STR"] = false;
    }

    if (dexSave.checked) {
        ele.savingThrows["DEX"] = true;
    } else {
        ele.savingThrows["DEX"] = false;
    }

    if (conSave.checked) {
        ele.savingThrows["CON"] = true;
    } else {
        ele.savingThrows["CON"] = false;
    }

    if (intSave.checked) {
        ele.savingThrows["INT"] = true;
    } else {
        ele.savingThrows["INT"] = false;
    }

    if (wisSave.checked) {
        ele.savingThrows["WIS"] = true;
    } else {
        ele.savingThrows["WIS"] = false;
    }

    if (charSave.checked) {
        ele.savingThrows["CHAR"] = true;
    } else {
        ele.savingThrows["CHAR"] = false;
    }
}

function setSkills(ele) {
    skills.forEach(skill => {
        if (skill.checked) {
            ele.skills[skill.nextElementSibling.textContent] = true;
        } else {
            ele.skills[skill.nextElementSibling.textContent] = false;
        }
    })
}

saveBtnDB.addEventListener('click', () => {
    updateCharacter()
    saveBtnDB.style.backgroundColor = "green"
    saveBtnDB.style.color = "white"
    saveBtnDB.style.width = "100px"
    saveBtnDB.style.height = "50px"
})

backBtn.addEventListener('click', () => {
    window.location.href = "../html/home.html"
})