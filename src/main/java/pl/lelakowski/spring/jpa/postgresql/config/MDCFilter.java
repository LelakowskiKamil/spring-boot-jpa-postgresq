package pl.lelakowski.spring.jpa.postgresql.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class MDCFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            MDC.put("txID", getCorrelationId());
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("txID");
        }
    }

    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}