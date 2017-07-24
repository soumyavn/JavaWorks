package soumyavn.java;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URLEncoder;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.http.HttpResponse;

public class AddressInfo extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Hello World";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String street=request.getParameter("street");
		// String city=request.getParameter("city");
		// String zip=request.getParameter("street");
		// String state=request.getParameter("pc");
		// String country=request.getParameter("country");

		// Actual logic goes here.

		try {

			String url = "https://us-street.api.smartystreets.com/street-address?"
					+ "&auth-id=012145f0-fdbb-9ae8-80a1-3f926da0bb3c" + "&auth-token=aeBINq4wIjb27DSsrm2c";
			String street = URLEncoder.encode((String) request.getParameter("street"), "UTF-8");
			String city = URLEncoder.encode((String) request.getParameter("city"), "UTF-8");
			String state = URLEncoder.encode((String) request.getParameter("state"), "UTF-8");
			url = url + "&street=" + street + "&city=" + city + "&state=" + state;
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet httpReq = new HttpGet(url);
			HttpResponse httpResponse = client.execute(httpReq);
			String retSrc = EntityUtils.toString(httpResponse.getEntity());
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = new JSONArray();
			try {
				jsonArray = (JSONArray) parser.parse(retSrc);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			JSONObject components = (JSONObject) jsonObject.get("components");
			String delivery_line_1 = (String) jsonObject.get("delivery_line_1");
			String city_name = (String) components.get("city_name");
			String zip = (String) components.get("zipcode");
			String plus4 = (String) components.get("plus4_code");
			HttpSession session = request.getSession();
			session.setAttribute("isVerified", true);
			String address = delivery_line_1 + "\n" + city_name + "\n" + zip + " - " + plus4;
			session.setAttribute("address", address);
			request.getRequestDispatcher("address.jsp").forward(request, response);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void destroy() {
		// do nothing.
	}
}