// Kudos to Nic: https://codepen.io/nicm42/pen/ExbZmPy
let iteration = 0
let intervalId = -1
const fadeLeeway = 3
const iterationLimit = 30

function random(min, max) {
    return min + Math.random() * (max + 1 - min)
}

const createFirework = () => {
    const xPos = random(0, 100)
    const yPos = random(0, 100)
    const colour = '#' + Math.random().toString(16).substring(2, 6)

    // Create 50 divs, start them on top of each other
    // so they can radiate out from the centre
    if (iteration <= iterationLimit) {
        for (let i = 1; i <= 50; i++) {
            const firework = document.createElement('div')
            firework.className = 'firework'
            firework.classList.add(`firework${i}`)
            firework.classList.add(`set${iteration}`)
            firework.style.backgroundColor = colour
            firework.style.left = xPos + '%'
            firework.style.top = yPos + '%'
            document.body.appendChild(firework)
        }
        // console.log('added ' + iteration)
    }

    iteration += 1

    const setToDelete = iteration - fadeLeeway
    if (setToDelete >= 0) {
        const oldFireworks = document.querySelectorAll(`.set${setToDelete}`)

        oldFireworks.forEach(firework => {
            firework.remove()
        })
        // console.log('removed ' + setToDelete)
    }
    if (setToDelete >= iterationLimit) {
        clearInterval(intervalId)
        intervalId = -1
    }
}

const launchFireworks = function () {
    if (intervalId !== -1) {
        clearInterval(intervalId)
    }
    iteration = 0
    createFirework()

    const fireworkTime = 1000
    intervalId = setInterval(createFirework, fireworkTime)
    // console.log('intervalId = ' + intervalId)
}
