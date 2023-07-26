// buttons
let deleteBtns = document.querySelectorAll('.delete')
const addChar = document.querySelector('.add-character')
const createBackBtn = document.querySelector('.create-back')
const createNext = document.querySelector('.next-btn')
const logOut = document.querySelector('.log-out')
// divs
const body = document.getElementById('body')
const mainContent = document.querySelector('.content')
const createDiv = document.querySelector('.create-char')
const loaderDiv = document.querySelector('.wave')
// input fields
const charName = document.getElementById('char-name')
// fetch api
const api_url = "https://hof2lxdd4k.execute-api.us-west-2.amazonaws.com/prod/users"
const character_api = "https://hof2lxdd4k.execute-api.us-west-2.amazonaws.com/prod/characters"
const userCreds = JSON.parse(sessionStorage.getItem("userCreds"))

getCharacters()
// Delete Characters
function confirmDelete(btn, name, className) {
   const div = createConfirmDiv()
   const yesBtn = div.childNodes[1]
   const noBtn = div.childNodes[2]

    yesBtn.addEventListener('click', () => {
        btn.parentNode.parentNode.remove()
        deleteFromDB(name, className)
        deleteConfirmDiv()
    })

    noBtn.addEventListener('click', ()=> {
        deleteConfirmDiv()
    })

    body.appendChild(div)
}

function deleteConfirmDiv() {
    document.querySelector('.delete-confirm').remove()
}

function deleteFromDB(name, className) {
    loaderDiv.style.visibility = "visible"
    const response = fetch(character_api, {
        method: "DELETE",

        body: JSON.stringify({
            userName: userCreds[0],
            password: userCreds[1],
            character: {"name": name, "className": className}
        }),

        headers: {
            "Content-type": "application/json"
        }
    })
    .then(resp => resp.json())
    .then(json => {
        loaderDiv.style.visibility = "hidden"
    })
}

function createConfirmDiv() {
    // Create div and buttons
    const newDiv = document.createElement("div")
    const yesBtn = document.createElement("button")
    const noBtn = document.createElement("button")
    // Text to add
    const newContent = document.createTextNode("Are you sure?")
    const yesText = document.createTextNode("YES")
    const noText = document.createTextNode("NO")

    yesBtn.appendChild(yesText)
    noBtn.appendChild(noText)

    newDiv.appendChild(newContent)
    newDiv.appendChild(yesBtn)
    newDiv.appendChild(noBtn)

    yesBtn.classList.add('delete-btn')
    noBtn.classList.add('no-btn')
    newDiv.classList.add('delete-confirm')

    return newDiv
}
// Add event listeners to buttons
addChar.addEventListener('click', () => {
    mainContent.style.marginLeft = "5000px"
    mainContent.style.transition = "all 0.5s ease-in"

    createDiv.style.marginLeft = "0px"
    createDiv.style.transition = "all 0.2s ease-in"
})

createBackBtn.addEventListener('click', () => {
    mainContent.style.margin = "0px auto"
    mainContent.style.transition = "all 0.5s ease-in"

    createDiv.style.marginLeft = "4000px"
    createDiv.style.transition = "all 0.2s ease-in"
})

createNext.addEventListener('click', () => {
    const name = charName.value;

    if (name == "") {
        alert("Character name cannot be blank")
    } else {
        sessionStorage.setItem("newCharacter", JSON.stringify([name]))
        window.location.href = "../html/Races.html"
    }
})

logOut.addEventListener('click', () => {
    sessionStorage.clear()
    window.location.href = "../html/index.html"
})

// Characters and their elements
function getCharacters() {
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
    .then(json => {
        if (json.user.characters.length >= 5) {
            addChar.style.visibility = "hidden"
        } else {
            addChar.style.visibility = "visible"
        }

        json.user.characters.forEach(ele => {
        displayCharacters(ele)
    })
});
}

function displayCharacters(ele) {
    const characterDiv = document.createElement('div')
    const infoDiv = document.createElement('div')
    const descripDiv = document.createElement('div')
    const delBtn = document.createElement('button')
    const detailBtn = document.createElement('button')
    const charPara = document.createElement('p')
    const charText = document.createTextNode(`Name: ${ele.name}\n`)
    const charClass = document.createTextNode(`Class: ${ele.className}`)
    const detailText = document.createTextNode('Details')
    const delText = document.createTextNode('Delete')

    charPara.appendChild(charText)
    charPara.appendChild(charClass)

    delBtn.classList.add('character-details')
    delBtn.classList.add('delete')
    delBtn.appendChild(delText)
    delBtn.addEventListener('click', () => {
        confirmDelete(delBtn, ele.name, ele.className)
    })

    detailBtn.classList.add('character-details')
    detailBtn.appendChild(detailText)
    detailBtn.addEventListener('click', () => {
        sessionStorage.setItem("charDetails", JSON.stringify([ele.name, ele.className]))
        window.location.href = "../html/characterSheet.html"
    })

    infoDiv.style.backgroundColor = "#fff"
    infoDiv.classList.add('info')
    infoDiv.appendChild(charPara)
    infoDiv.appendChild(delBtn)
    infoDiv.appendChild(detailBtn)

    characterDiv.classList.add('character')
    characterDiv.appendChild(infoDiv)
    characterDiv.appendChild(descripDiv)

    mainContent.insertBefore(characterDiv, addChar)
}