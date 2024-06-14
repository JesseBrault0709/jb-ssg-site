const addResourcesToCache = async () => {
    const cache = await caches.open('v1')
    cache.addAll(['/', '/compositions', '/videos', '/lessons', '/contact'])
    ;[
        'https://jessebrault.nyc3.cdn.digitaloceanspaces.com/images/portrait1.jpg',
        'https://jessebrault.nyc3.cdn.digitaloceanspaces.com/images/portrait2.jpg',
        'https://jessebrault.nyc3.cdn.digitaloceanspaces.com/images/portrait4.jpg',
        'https://jessebrault.nyc3.cdn.digitaloceanspaces.com/images/jesse-brault-bratislava.jpg'
    ].forEach(async url => {
        const request = new Request(url, { mode: 'no-cors' })
        const response = await fetch(request)
        cache.put(request, response)
    })
}

self.addEventListener('activate', event => {
    event.waitUntil(addResourcesToCache())
})
