function FindProxyForURL(url, host) {
  if (dnsDomainIs(host, ".unpkg.com")) {
    return "PROXY 10.10.10.10:8080; DIRECT";
  }
  return "DIRECT";
}

function useProxy() {
  if (dnsDomainIs(host, ".unpkg.com") || dnsDomainIs(host, ".grammarly.com") || dnsDomainIs(host, ".wikipedia.org")) {
    return true;
  }
  return false;
}
