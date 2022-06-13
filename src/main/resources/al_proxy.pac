function FindProxyForURL(url, host) {
  if (useProxy(host)) {
    return "PROXY 10.10.10.10:8080; DIRECT";
  }
  return "DIRECT";
}

function useProxy(host) {
  return dnsDomainIs(host, "unpkg.com") || dnsDomainIs(host, "grammarly.com")
    || dnsDomainIs(host, "wikipedia.org") || dnsDomainIs(host, "googleusercontent.com");
}
