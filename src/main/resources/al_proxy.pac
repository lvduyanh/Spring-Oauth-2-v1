function FindProxyForURL(url, host) {
  if (useProxy(host)) {
    return "PROXY 10.10.10.10:8080; DIRECT";
  }
  return "DIRECT";
}

function useProxy(host) {
  if (dnsDomainIs(host, "unpkg.com") || dnsDomainIs(host, "grammarly.com") || dnsDomainIs(host, "wikipedia.org")) {
    return true;
  }
  return false;
}
