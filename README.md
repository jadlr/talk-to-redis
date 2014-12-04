#  talk-to-redis - in its language

trying out the new 1.0-M1 release of akk http / stream

* start redis
* sbt "run localhost 6379"
* talk to redis in its protocol (blank spaces will be replaced with CRLF)

```
PING // +PONG
```

```
*3 $3 SET $3 key $5 value // +OK
```

```
*2 $3 GET $3 key // $5\r\nvalue
```