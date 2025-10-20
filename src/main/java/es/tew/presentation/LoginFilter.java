package es.tew.presentation;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(
    dispatcherTypes = { DispatcherType.REQUEST },
    urlPatterns = { "/restricted/*" },
    initParams = {
        @WebInitParam(name = "LoginPath", value = "/login.xhtml")
    }
)
public class LoginFilter implements Filter {
    
    private FilterConfig config = null;
    
    public void init(FilterConfig fConfig) throws ServletException {
        config = fConfig;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }
        
        HttpSession session = ((HttpServletRequest) request).getSession();
        
        if (session.getAttribute("LOGGEDIN_USER") == null) {
            String loginForm = config.getInitParameter("LoginPath");
            ((HttpServletResponse) response).sendRedirect(
                ((HttpServletRequest) request).getContextPath() + loginForm
            );
            return;
        }
        
        chain.doFilter(request, response);
    }
    
    public void destroy() {
        // Cleanup si fuera necesario
    }
}