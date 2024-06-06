window.addEventListener('load', function () {
    const contactForm = document.querySelector('form.contact')
    contactForm.addEventListener('submit', function (submitEvent) {
        submitEvent.preventDefault()
        const formData = new FormData(contactForm)

        const message = `
From: ${formData.get('name')}
Email: ${formData.get('email')}
Institution: ${formData.get('institution')}
Message:
${formData.get('message')}
        `.trim()

        const toSend = { message }
        console.log(toSend)
        // fetch('https://api.jessebrault.com/contact/jessebrault', {
        //     body: JSON.stringify(toSend),
        //     headers: 'Content-Type: Application/JSON',
        //     method: 'POST' // TODO: signal
        // })
    })
})
