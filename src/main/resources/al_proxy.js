function FindProxyForURL(url, host) {
    return useProxy(host) ? 'PROXY 10.10.10.10:8080; DIRECT' : 'DIRECT';
}

function useProxy(host) {
    return (
        dnsDomainIs(host, 'googlevideo.com') ||
        dnsDomainIs(host, 'grammarly.com') ||
        dnsDomainIs(host, 'translate.google.com') ||
        dnsDomainIs(host, 'cdn.sstatic.net') ||
        dnsDomainIs(host, 'stackoverflow.com') ||
        dnsDomainIs(host, 'bootstrapcdn.com') ||
        dnsDomainIs(host, 'ampproject.org') ||
        dnsDomainIs(host, 'netaos.us') ||
        dnsDomainIs(host, 'wikipedia.org') ||
        dnsDomainIs(host, 'googleusercontent.com') ||
        dnsDomainIs(host, 'cloudflare.com') ||
        dnsDomainIs(host, 'cloudfront.net') ||
        dnsDomainIs(host, 'quora.com') ||
        dnsDomainIs(host, 'quoracdn.net') ||
        dnsDomainIs(host, 'jetbrains.com') ||
        dnsDomainIs(host, 'unpkg.com') ||
        dnsDomainIs(host, 'optimizely.com') ||
        dnsDomainIs(host, 'cdn.jsdelivr.net')
    );
}
