package useful.popup;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class PopUp {
	
	public static void popUp(HttpServletResponse response, String popUpContent) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.println("<script>alert('" + popUpContent + "'); </script>");
			out.flush();
	}
	
	public static void popUpMove(HttpServletResponse response, String popUpContent, String viewName) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println("<script>alert('" + popUpContent + "'); "
				+ "location.href='" + viewName + "'"
				+ "</script>");
		out.flush();
	}
}
