package harlequinmettle.technologicalsingularity.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletSorter extends ServletCore {

	public static final String TICKER_PARAMETER_KEY = "servlettickerquery";
	public static final String ADITIONAL_INFO_PARAMETER_KEY = "additionalinfo";

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		super.doGet(req, resp);
		StringBuilder modifiablePageResponse = new StringBuilder();
		String servletType = "none";
		servletType = tryGetParameter(req, SERVLET_TYPE_PARAMETER_KEY, servletType);

		addHtmlConventions(servletType, modifiablePageResponse);

		String ticker = "";
		String additionalinfo = "";
		PrintWriter pageResponse = resp.getWriter();

		ticker = tryGetParameter(req, TICKER_PARAMETER_KEY, ticker);
		additionalinfo = tryGetParameter(req, ADITIONAL_INFO_PARAMETER_KEY, additionalinfo);

		String exceptionInfo = "";
		try {

			respond();
		} catch (Exception e) {

			exceptionInfo = e.toString();
			// exceptionInfo += " <br>" +
			// SystemTool.getStackTraceForException(e, true);

		}

		pageResponse.append(exceptionInfo);

		closeHtml(modifiablePageResponse);

		pageResponse.append(modifiablePageResponse);
	}

	private void respond() {
	}

}
