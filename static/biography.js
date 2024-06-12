window.addEventListener('load', () => {
    const readMoreButton = document.getElementById('biography-read-more-button')
    const biographyArticle = document.getElementById('biography-article')
    readMoreButton.addEventListener('click', () => {
        biographyArticle.scrollIntoView({ behavior: 'smooth' })
    })
})
