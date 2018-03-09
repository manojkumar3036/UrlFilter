package com.mks;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doStuff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Inside get");
		out.println("Following are the Headers from the Client");
		out.println("<br>");
		out.println("-----------------------");
		out.println("<br>");
		Enumeration<?> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			out.println(name + " : " + value);
			out.println("<br>");
		}

		request.getReader();

		// checking whether the request url contains any parameter or not

		Map<?, ?> urlParams = request.getParameterMap();
		if (urlParams.isEmpty()) {
			out.println("No Params");
		} else {
			Set<?> s = urlParams.entrySet();
			Iterator<?> i = s.iterator();

			while (i.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) i.next();
				String key = entry.getKey();
				String[] value = entry.getValue();

				out.println("Params are: <br>");
				out.println("Key: " + key + "<br>");
				if (value.length > 1) {
					for (int j = 0; j < value.length; j++) {
						out.println("<li>" + value[j].toString() + "</li><br>");
					} // end of for
				} else {
					out.println("Value is " + value[0].toString() + "<br>");

					out.println("-------------------<br>");
				} // end of else

			} // end of while
		} // end of else

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doStuff(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doStuff(request, response);
	}

}
