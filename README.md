# logVisibility
( 거북목 방지 프로젝트 )

#### 로그레벨
로그 레벨은 아래와 같이 정의하며 운영 상 2~5까지 운영합니다.  
( DEBUG - INFO - WARN - ERROR )

| 중요도 | 종류  | 상 황                                                                                         |
|--------|-------|-----------------------------------------------------------------------------------------------|
| 5      | ERROR | 비정상적인 상황 어플리케이션의 중요한 기능이 실패한 경우 자체 복구 불가능 바로 조치가 필요함. |
| 4      | WARN  | 비정상적인 상황 자체 복구 가능 빠른 시일 내에 오작동을 수정 필요                              |
| 3      | INFO  | 정상적인 상황 개발 / 운영에 도움이 되는 정보                                                  |
| 2      | DEBUG | 디버깅시 필요한 정보                                                                          |
| 1      | TRACE | 디버깅시 필요한 정보                                                                          |
  
---

#### 로그 패턴
로그패턴은 약속되어 있는 형태를 따른다.  
PL은 프로젝트(배달대행) 을 의미한다. (검증에서는 고정으로 사용)

- 로그 정의 : svc/main/resources/log/logback-spring.xml
- 로그 패턴 : 개발센터 공통 포멧을 기준으로 합니다.

```javascript
<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} PL %X{sessionId} %X{accountId} [%thread] %highlight(%-5level) %X{remoteIp} %logger{20} - %msg%n</pattern>
```
> MDC 로그는 filter 에서 설정      
> sessionId : 세션아이디  
> accountId : 아이디  
> remoteIp : 리모트 아이피

---
#### 실행 및 검증
```shell
## intelliJ 에서는 VisibilityApplication 클래스 실행
## command 로 실행할 경우
./gradlew bootRun
```
http://localhost:8080 접속 후 콘솔에서 로그 확인

#### 결과 확인 (color set 확인)
```logcatfilter
------------------  LOG CHECK START  ----------------
2023-02-08 09:21:46.289 PL OF30E51ABDFG17D yoonsm [http-nio-8080-exec-1] DEBUG 175.11.10.10 k.p.y.l.v.c.LogVisibilityController - [REDIS] Set redis,LOCATION:NG0000-LG0000-BB0000-BP0002-RR0000, RedisRiderInfo(loginId=jy_rider)
2023-02-08 09:21:46.289 PL OF30E51ABDFG17D yoonsm [http-nio-8080-exec-1] INFO  175.11.10.10 k.p.y.l.v.c.LogVisibilityController - ACTIVERIDER_STAT@ NG0000-LG0000-BB0000-BP0002-RR0000, 정연지점, 1
2023-02-08 09:21:46.289 PL OF30E51ABDFG17D yoonsm [http-nio-8080-exec-1] WARN  175.11.10.10 k.p.y.l.v.c.LogVisibilityController - Exception occurred, retry count 1
2023-02-08 09:21:46.289 PL OF30E51ABDFG17D yoonsm [http-nio-8080-exec-1] ERROR 175.11.10.10 k.p.y.l.v.c.LogVisibilityController - Rider unlock fail... action:RIDER_POINT_UNLOCK,orderNo:221128170030NG0001-BP0000-SS0019CMAuDu
------------------  LOG CHECK END  ------------------
```