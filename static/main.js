window.addEventListener('load', function () {
    const navBars = document.getElementById('nav-bars')
    const navItems = document.getElementById('nav-items')
    navBars.addEventListener('click', function () {
        if (window.matchMedia('screen and (max-width: 1023px)').matches) {
            if (navItems.style.display === 'flex') {
                navItems.style.display = 'none'
            } else {
                navItems.style.display = 'flex'
            }
        }
    })
})
