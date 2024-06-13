window.addEventListener('load', () => {
    const navBars = document.getElementById('nav-bars')
    const navItems = document.getElementById('nav-items')

    const toggleMenu = () => {
        if (window.matchMedia('screen and (max-width: 1023px)').matches) {
            if (navItems.style.display === 'flex') {
                navItems.style.display = 'none'
            } else {
                navItems.style.display = 'flex'
            }
        }
    }

    navBars.addEventListener('click', toggleMenu)

    const navLinks = document.querySelectorAll('.nav-link')
    navLinks.forEach(navLink => {
        navLink.addEventListener('click', toggleMenu)
    })
})
