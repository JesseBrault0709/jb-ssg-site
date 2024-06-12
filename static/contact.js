window.addEventListener('load', () => {
    const contactForm = document.getElementById('contact-form')

    const nameMessage = document.getElementById('name-message')
    const emailMessage = document.getElementById('email-message')
    const messageMessage = document.getElementById('message-message')
    const submitMessage = document.getElementById('submit-message')

    const nameInput = document.getElementById('name-input')
    const emailInput = document.getElementById('email-input')
    const messageInput = document.getElementById('message-input')
    const submitInput = document.getElementById('submit-input')

    const validateName = () => {
        if (nameInput.validity.valid) {
            nameMessage.innerHTML = '&nbsp;'
            nameInput.classList.remove('invalid')
        } else {
            nameMessage.innerText = 'Name is required.'
            nameInput.classList.add('invalid')
        }
        submitMessage.innerHTML = '&nbsp;'
    }

    nameInput.addEventListener('focusout', validateName)
    nameInput.addEventListener('input', validateName)

    const validateEmail = () => {
        if (emailInput.validity.valid) {
            emailMessage.innerHTML = '&nbsp;'
            emailInput.classList.remove('invalid')
        } else if (emailInput.validity.valueMissing) {
            emailMessage.innerText = 'Email is required.'
            emailInput.classList.add('invalid')
        } else if (emailInput.validity.typeMismatch) {
            emailMessage.innerText = 'Email must be a valid email.'
            emailInput.classList.add('invalid')
        }
        submitMessage.innerHTML = '&nbsp;'
    }

    emailInput.addEventListener('focusout', validateEmail)
    emailInput.addEventListener('input', validateEmail)

    const validateMessage = () => {
        if (messageInput.validity.valid) {
            messageMessage.innerHTML = '&nbsp;'
            messageInput.classList.remove('invalid')
        } else {
            messageMessage.innerText = 'Message is required.'
            messageInput.classList.add('invalid')
        }
        submitMessage.innerHTML = '&nbsp;'
    }

    messageInput.addEventListener('focusout', validateMessage)
    messageInput.addEventListener('input', validateMessage)

    contactForm.addEventListener('submit', submitEvent => {
        submitEvent.preventDefault()
        validateName()
        validateEmail()
        validateMessage()
        if (nameInput.validity.valid && emailInput.validity.valid && messageInput.validity.valid) {
            const formData = new FormData(contactForm)
            const toSend = {
                name: formData.get('name'),
                email: formData.get('email'),
                institution: formData.get('institution'),
                message: formData.get('message')
            }
            submitInput.disabled = true
            submitMessage.innerText = 'Sending...'
            fetch('https://api.jessebrault.com/contact/jessebrault', {
                body: JSON.stringify(toSend),
                headers: {
                    'Content-type': 'application/json'
                },
                method: 'POST'
            })
                .then(response => {
                    if (response.status === 400) {
                        response.json().then(body => {
                            body.errors.forEach(({ field, message }) => {
                                const element = document.getElementById(`${field}-message`)
                                element.innerText = message
                            })
                        })
                    } else if (response.status === 500) {
                        submitMessage.classList.add('error')
                        submitMessage.innerText = 'There was internal server error. Please try again later.'
                    } else {
                        submitMessage.classList.remove('error')
                        submitMessage.innerText = 'Your message was successfully sent!'
                        setTimeout(() => {
                            submitMessage.innerHTML = '&nbsp;'
                        }, 5000)
                    }
                    submitInput.disabled = false
                })
                .catch(error => {})
        }
    })
})
