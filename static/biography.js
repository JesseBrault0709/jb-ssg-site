window.addEventListener('load', function () {
    const readMoreButton = document.getElementById('biography-read-more-button')
    const biographyArticle = document.getElementById('biography-article')
    readMoreButton.addEventListener('click', function () {
        biographyArticle.scrollIntoView({ behavior: 'smooth' })
    })
})
