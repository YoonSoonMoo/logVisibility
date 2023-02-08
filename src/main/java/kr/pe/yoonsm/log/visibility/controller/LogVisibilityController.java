package kr.pe.yoonsm.log.visibility.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yoonsm@daou.co.kr on 2023-02-06
 */
@RestController
public class LogVisibilityController {

    private static final Logger logger
            = LoggerFactory.getLogger(LogVisibilityController.class);

    @RequestMapping("/")
    public String printLog() {
        System.out.println("------------------  LOG CHECK START  ----------------" );
        logger.debug("[REDIS] Set redis,LOCATION:NG0000-LG0000-BB0000-BP0002-RR0000, RedisRiderInfo(loginId=jy_rider)");
        logger.info("ACTIVERIDER_STAT@ NG0000-LG0000-BB0000-BP0002-RR0000, 정연지점, 1");
        logger.warn("Exception occurred, retry count 1");
        logger.error("Rider unlock fail... action:RIDER_POINT_UNLOCK,orderNo:221128170030NG0001-BP0000-SS0019CMAuDu");
        System.out.println("------------------  LOG CHECK END  ------------------" );

        return "콘솔에서 로그를 확인해 보세요.";
    }
}
