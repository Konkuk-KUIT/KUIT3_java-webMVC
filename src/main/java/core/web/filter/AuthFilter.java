package core.web.filter;


import core.db.MemoryUserUserRepository;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static core.constant.Uri.*;
import static core.constant.UserField.USER_ID;

@WebFilter("/*")
@Order(1)
public class AuthFilter implements Filter {

  private static final List<String> permitAll = new ArrayList<>();

  static {
    permitAll.add(HOME.getUri());
    permitAll.add(USER_REGISTER.getUri());
    permitAll.add(LOGIN.getUri());
    permitAll.add(LOGIN_FAIL.getUri());
  }

  private RequestDispatcher defaultRequestDispatcher;
  private MemoryUserUserRepository userRepository;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.defaultRequestDispatcher = filterConfig.getServletContext().getNamedDispatcher("default");
    this.userRepository = MemoryUserUserRepository.getInstance();
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
  }

  private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    String path = request.getRequestURI().substring(request.getContextPath().length());
    if (!isPermitAll(path)) {
      String userId = (String) request.getSession(true).getAttribute(USER_ID.getKey());

      if (userId == null || !userRepository.existsUserById(userId)) {
        response.sendRedirect(LOGIN.getUri());
        return;
      }
    }
    chain.doFilter(request, response);
  }

  private boolean isPermitAll(String url) {
    for (String uri : permitAll) {
      if (url.equals(uri)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void destroy() {
  }
}
