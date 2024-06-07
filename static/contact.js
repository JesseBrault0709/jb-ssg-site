window.addEventListener('load', function () {
    const contactForm = document.querySelector('form.contact')
    contactForm.addEventListener('submit', function (submitEvent) {
        submitEvent.preventDefault()
        const formData = new FormData(contactForm)
        const toSend = {
            name: formData.get('name'),
            email: formData.get('email'),
            institution: formData.get('institution'),
            message: formData.get('message')
        }
        fetch('https://api.jessebrault.com/contact/jessebrault', {
            body: JSON.stringify(toSend),
            headers: {
                'Content-type': 'application/json'
            },
            method: 'POST' // TODO: signal
        })
            .then(function (response) {
                if (response.status === 400) {
                    response.json().then(function (body) {
                        body.errors.forEach(function ({ field, message }) {
                            const element = document.getElementById(`${field}-message`)
                            element.innerText = message
                        })
                    })
                } else if (response.status === 500) {
                    const submitMessageElement = document.getElementById('submit-message')
                    submitMessageElement.innerText = 'There was internal server error. Please try again later.'
                } else {
                    const submitMessageElement = document.getElementById('submit-message')
                    submitMessageElement.innerText = 'Your message was successfully sent!'
                }
            })
            .catch(function (error) {})
    })
})
