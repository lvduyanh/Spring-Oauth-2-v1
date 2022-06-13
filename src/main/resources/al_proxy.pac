function FindProxyForURL(url, host) {
  if (dnsDomainIs(host, ".unpkg.com")) {
    return "PROXY 10.10.10.10:8080; DIRECT";
  }
  return "DIRECT";
}