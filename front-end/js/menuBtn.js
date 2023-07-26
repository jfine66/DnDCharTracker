//buttons
const menubtn = document.getElementById('menu-btn')
const menu = document.getElementById('menubar')

menubtn.addEventListener('click', () => {
    if (menubtn.classList.contains('active')) {
        menu.style.left = "-300px"
        menubtn.style.left = "0px"
        menubtn.innerHTML = '<i class="fa-solid fa-bars fa-2xl"></i>'
        menubtn.classList.remove('active')
    } else {
        menubtn.innerText = "X"
        menu.style.left = "0px"
        menubtn.style.left = "150px"
        menubtn.innerHTML = '<i class="fa-solid fa-xmark fa-2xl"></i>'
        menubtn.classList.add('active')
    }
})