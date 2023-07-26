const leftBtns = document.querySelectorAll('.down-arrow')
const rightBtns = document.querySelectorAll('.up-arrow')
const savingThrows = document.querySelectorAll('.save')
const skillThrows = document.querySelectorAll('.skill')
const proBonus = document.getElementById('proficiency')
const saveBtn = document.querySelector('.save-btn')
const hpUpArrows = document.querySelectorAll('.hp-up-arrow')
const hpDownArrows = document.querySelectorAll('.hp-down-arrow')
const loadDiv = document.querySelector('.wave')
// Mods
const strMod = document.getElementById('str-mod')
const dexMod = document.getElementById('dex-mod')
const conMod = document.getElementById('con-mod')
const intMod = document.getElementById('int-mod')
const wisMod = document.getElementById('wis-mod')
const charMod = document.getElementById('char-mod')

leftBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        changeSaveButton()

        const prev = btn.nextElementSibling.textContent
        if (Number(prev) <= 0) {
            return;
        }

        btn.nextElementSibling.textContent = prev - 1

        btn.nextElementSibling.nextElementSibling.nextElementSibling.textContent = adjuctMod(btn.nextElementSibling.textContent)
    })
})

rightBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        changeSaveButton()
        const prev = btn.previousElementSibling.textContent
         if (Number(prev) >= 20) {
            return;
        }
        btn.previousElementSibling.textContent = (1 + Number(prev))

        btn.nextElementSibling.textContent = adjuctMod(btn.previousElementSibling.textContent)
    })
})


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

savingThrows.forEach(save => {
    save.addEventListener('change', () => {
        changeSaveButton()
        if (save.checked) {
            save.nextElementSibling.nextElementSibling.textContent = '+' + (Number(proBonus.textContent) + Number(getMod(save).textContent))
        } else {
            save.nextElementSibling.nextElementSibling.textContent = "+0"
        }
    })
})

skillThrows.forEach(skill => {
    skill.addEventListener('change', () => {
        changeSaveButton()
        if(skill.checked) {
            skill.nextElementSibling.nextElementSibling.textContent = '+' + (Number(proBonus.textContent) + Number(getMod(skill).textContent))
        } else {
            skill.nextElementSibling.nextElementSibling.textContent = "+0"
        }
    })
})

function getMod(save) {
    const stat = save.nextElementSibling.nextElementSibling

    if (stat.classList.contains("str")) {
        return strMod;
    } else if (stat.classList.contains("dex")) {
        return dexMod;
    } else if (stat.classList.contains("con")) {
        return conMod;
    } else if (stat.classList.contains("wis")) {
        return wisMod;
    } else if (stat.classList.contains("int")) {
        return intMod;
    } else if (stat.classList.contains("char")) {
        return charMod;
    }
}

function changeSaveButton() {
    saveBtn.style.width = "200px"
    saveBtn.style.height = "100px"
    saveBtn.style.backgroundColor = "red"
}

hpUpArrows.forEach(btn => {
    btn.addEventListener('click', () => {
        btn.previousElementSibling.textContent = Number(btn.previousElementSibling.textContent) + 1
    })
})

hpDownArrows.forEach(btn => {
    btn.addEventListener('click', () => {
        btn.nextElementSibling.textContent = Number(btn.nextElementSibling.textContent) - 1
    })
})