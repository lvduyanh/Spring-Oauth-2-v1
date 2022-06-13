function FindProxyForURL(url, host) {
  if (useProxy(host)) {
    return "PROXY 10.10.10.10:8080; DIRECT";
  }
  return "DIRECT";
}

function useProxy(host) {
  return dnsDomainIs(host, "grammarly.com") || dnsDomainIs(host, "unpkg.com")
    || dnsDomainIs(host, "wikipedia.org") || dnsDomainIs(host, "googleusercontent.com")
    || dnsDomainIs(host, "cloudflare.com") || dnsDomainIs(host, "quora.com");
}
