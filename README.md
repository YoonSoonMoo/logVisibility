# logVisibility
로그 시인성 검증

- log의 가장 좋은 color light를 검증한다.
- log pattern

```javascript
<pattern>%green(%d{yyyy-MM-dd HH:mm:ss.SSS}) %magenta(PL) %highlight(%X{sessionId}) %highlight(%X{accountId}) %highlight(%thread) %highlight(%-5level) %yellow(%X{remoteIp}) %cyan(%logger{20}) : %msg%n</pattern>
```
