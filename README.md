# blocked-connection-pool
Showcase providing an example of a blocked connection pool in Spring Boot, when using a StreamingResponseBody, a opened transaction and enabled SSL.

# Usage
Start the development Server, and navigate to https://localhost:8080/ping
Your browser might tell you that this connection is not secure, as I'm using a self signed certificate to enable SSL.

The screen should be empty as the response is empty.

After 30 seconds Hikari should log the current connection pool.
```
HikariPool-1 - Pool stats (total=10, active=1, idle=9, waiting=0)
```
The active Connection will never be released. After requesting the same url 9 times more, the connection pool is full and every subsequent request will run into timeout.
