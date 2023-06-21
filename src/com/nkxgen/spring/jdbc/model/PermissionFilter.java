package com.nkxgen.spring.jdbc.model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic, if needed
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();

		// Check if the user ID is already stored in the session
		if (session.getAttribute("userId") != null) {
			// User ID already exists, proceed with the request
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		// Perform login logic here
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);

		if ("3".equals(username) && "a".equals(password)) {
			// Login successful, store the user ID in the session
			session.setAttribute("userId", "3"); // Replace "123" with the actual user ID

			// Forward the request to the next page
			request.getRequestDispatcher("Test.html").forward(servletRequest, servletResponse);
		} else {
			// Invalid credentials, show an error message or redirect to the login page
			// For simplicity, we'll show an error message using an alert
			servletResponse.getWriter().println("<script>alert('Invalid credentials. Please try again.');</script>");
		}
	}

	@Override
	public void destroy() {
		// Cleanup logic, if needed
	}
}
