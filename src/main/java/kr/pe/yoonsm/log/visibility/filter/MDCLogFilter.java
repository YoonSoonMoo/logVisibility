package kr.pe.yoonsm.log.visibility.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yoonsm@daou.co.kr on 2023-02-06
 */
@Component
public class MDCLogFilter extends OncePerRequestFilter {

    final String REMOTE_IP = "175.11.10.10";
    final String SESSION = "OF30E51ABDFG17D";
    final String ACCOUNT_ID ="yoonsm";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        try {
            MDC.put("remoteIp", REMOTE_IP);
            MDC.put("sessionId", SESSION);
            MDC.put("accountId",ACCOUNT_ID);

            filterChain.doFilter(request,response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } finally {
            MDC.clear();
        }

    }
}
