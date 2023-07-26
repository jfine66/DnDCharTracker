const loginBtn = document.getElementById('login-btn')
const loginBackBtn = document.getElementById('back-btn')
const createBtn = document.getElementById('create-btn')
const createBackBtn = document.getElementById('create-back-btn')
const loginAccount = document.getElementById('login-account')
const createAccount = document.getElementById('create-account')
//divs
const introDiv = document.getElementById('intro')
const loginCard = document.getElementById('login-card')
const createCard = document.getElementById('create-card')
const loaderDiv = document.querySelector('.loading')
const createLoaderDiv = document.querySelector('.loading-create')
// Strings
const transition = "all 0.5s ease-out"
const zeroPx = "0px"
const fourThouPx = "4000px"
// Login form
const userNameField = document.getElementById('username')
const passwordField = document.getElementById('login-password')
const api_url = " https://hof2lxdd4k.execute-api.us-west-2.amazonaws.com/prod/users"
// Create User form
const api_create = " https://hof2lxdd4k.execute-api.us-west-2.amazonaws.com/prod/create"
const newUserField = document.getElementById('create-username')
const newPassField = document.getElementById('create-password')

loginBtn.addEventListener('click', () => {
    introDiv.style.transition = transition
    introDiv.style.marginLeft = "-" + fourThouPx

    loginCard.style.transition = transition
    loginCard.style.marginLeft = zeroPx
})

loginBackBtn.addEventListener('click', () => {
    introDiv.style.transition = transition
    introDiv.style.marginLeft = zeroPx

    loginCard.style.transition = transition
    loginCard.style.marginLeft = fourThouPx
})

createBtn.addEventListener('click', () => {
    introDiv.style.transition = transition
    introDiv.style.marginRight = "-" + fourThouPx

    createCard.style.transition = transition
    createCard.style.marginRight = zeroPx
})

createBackBtn.addEventListener('click', () => {
    introDiv.style.transition = transition
    introDiv.style.marginRight = zeroPx

    createCard.style.transition = transition
    createCard.style.marginRight = fourThouPx
})

loginAccount.addEventListener('click', () => {
   getUser()
})

createAccount.addEventListener('click', () => {
    createUser()
})

function getUser() {
    displayLoading()
    hideLoginBtn()
 // get name and password from fields
    const name = userNameField.value
    const password = passwordField.value
    // Call data base
    const response = fetch(api_url, {
        method: "POST",

        body: JSON.stringify({
            userName: name,
            password: password
        }),

        headers: {
            "Content-type": "application/json"
        }
    })
    .then(response => response.json())
    .then(json => {
        if (json.errorMessage != null) {
            hideLoading()
            alert(json.errorMessage)
            loginAccount.style.visibility = 'visible'
        } else {
            hideLoading()
            sessionStorage.setItem("userCreds", JSON.stringify([name, password]))
            window.location.href = "../html/home.html"
        }
    })
}

function createUser() {
    hideCreateBtn()
    displayCreateLoader()
    const userName = newUserField.value
    const password = newPassField.value

    const response = fetch(api_create, {
        method: "POST",

        body: JSON.stringify({
            name: userName,
            password: password
        }),

        headers: {
            "Content-type": "application/json"
        }
    }).then(response => response.json()).then(json => {
        if (json.errorMessage != null) {
            createAccount.style.visibility = 'visible'
            alert(json.errorMessage)
        } else {
            hideCreateLoader()
            sessionStorage.setItem("userCreds", JSON.stringify([userName, password]))
            window.location.href = "../html/home.html"
        }
    })
}

function hideLoginBtn() {
    loginAccount.style.visibility = 'hidden'
}

function hideCreateBtn() {
    createAccount.style.visibility = 'hidden'
}

function displayLoading() {
    loaderDiv.classList.add('display');
}

function hideLoading() {
    loaderDiv.classList.remove('display')
}

function displayCreateLoader() {
    createLoaderDiv.classList.add('display')
}

function hideCreateLoader() {
    createLoaderDiv.classList.remove('display')
}