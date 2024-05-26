package io.eleutherius.lemonhc.resourceserver.filter;

import io.eleutherius.lemonhc.resourceserver.service.JwtService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomHeaderValidationFilter implements Filter {

  private final JwtService jwtService;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;

    final String kidiToken = request.getHeader("x-kidi-auth");
    if (kidiToken == null || kidiToken.trim().isEmpty()) {
      throw new RuntimeException("401"); // 401
    }

    Boolean valid = jwtService.validate(kidiToken);
    if (!valid) {
      throw new RuntimeException("403"); // 403
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
