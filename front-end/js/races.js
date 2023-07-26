const dragonRace = document.getElementById('dragborn-btn')
const dwarfRace = document.getElementById('dwarf-btn')
const elfRace = document.getElementById('elf-btn')
const halfElfRace = document.getElementById('halfElf-btn')
const humanRace = document.getElementById('human-btn')
const gnomeRace = document.getElementById('gnome-btn')
const halfingRace = document.getElementById('halfing-btn')
const halfOrcRace = document.getElementById('halfOrc-btn')
const tielfingRace = document.getElementById('tielfing-btn')
const logOut = document.querySelector('.log-out')
const char = JSON.parse(sessionStorage.getItem("newCharacter"))
const charName = char[0]

dragonRace.addEventListener('click', () => {
    updateRace("Dragonborn")
})

dwarfRace.addEventListener('click', () => {
    updateRace("Dwarf")
})

elfRace.addEventListener('click', () => {
    updateRace("Elf")
})

halfElfRace.addEventListener('click', () => {
    updateRace("Half-Elf")
})

humanRace.addEventListener('click', () => {
    updateRace("Human")
})

gnomeRace.addEventListener('click', () => {
    updateRace("Gnome")
})

halfingRace.addEventListener('click', () => {
    updateRace("Halfing")
})

halfOrcRace.addEventListener('click', () => {
    updateRace("Half-Orc")
})

tielfingRace.addEventListener('click', () => {
    updateRace("Tielfing")
})

logOut.addEventListener('click', () => {
    sessionStorage.clear()
    window.location.href = "../html/index.html"
})

function updateRace(race) {
    sessionStorage.setItem("newCharacter", JSON.stringify([charName, race]))
    window.location.href = "../html/class.html"
}