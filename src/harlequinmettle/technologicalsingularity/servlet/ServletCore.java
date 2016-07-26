package harlequinmettle.technologicalsingularity.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCore extends HttpServlet {

	private static final long serialVersionUID = -2534176868859773101L;

	public static final String SERVLET_TYPE_PARAMETER_KEY = "servlettype";

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String servletType = "none";
		servletType = tryGetParameter(req, SERVLET_TYPE_PARAMETER_KEY, servletType);

	}

	protected void closeHtml(StringBuilder pageResponse) {
		pageResponse.append("</body>");
		pageResponse.append("</html>");
	}

	protected void addHtmlConventions(String title, StringBuilder pageResponse) {
		pageResponse.append("<!DOCTYPE html>");
		pageResponse.append("<html>");
		pageResponse.append("<head>");
		pageResponse.append("<meta charset=\"UTF-8\">");
		pageResponse.append("<link rel=\"stylesheet\" href=\"/css/appstyle.css\">");
		pageResponse.append("<title>" + title + "</title>");
		pageResponse.append("</head>");
		pageResponse.append("<body>");
	}

	protected String tryGetParameter(HttpServletRequest req, String param, String defaultValue) {
		Enumeration e = req.getParameterNames();
		while (e.hasMoreElements()) {
			String element = e.nextElement().toString();
			if (element.equals(param))
				return req.getParameter(element);
		}
		return defaultValue;
	}

}
