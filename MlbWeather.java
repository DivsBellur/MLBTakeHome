import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MlbWeather{

	public static void main(String[] args) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String errorMessage = "This program needs to be run with these specific arguments. See example below \n " +
				"java MlbWeather --venue 117 \n" +
				"or \n" +
				"java MlbWeather --team 112 --date 2022-04-07";

		if(args.length == 2 && args[0].substring(2).equals("venue")){
			String venue = args[1];
			int venueId = Integer.parseInt(venue);
			getVenueWeatherDetails(venueId);
		} else  if(args.length == 4 && args[0].substring(2).equals("team") && args[2].substring(2).equals("date")) {
			String teamId = args[1];
			String date = args[3];
			getTeamScheduleWeatherDetails(teamId, date);
		} else {
			System.out.println("here1");
			System.out.println(errorMessage);
		}
	}

	public static void getVenueWeatherDetails(int venueId) throws Exception{
		URL url = new URL( "http://localhost:8080/mlbWeather/venue/" + Integer.toString(venueId));
		executeGetCall(url);
	}

	public static void getTeamScheduleWeatherDetails(String teamId,String startDate ) throws Exception{
		URL url = new URL("http://localhost:8080/teamSchedule/team/" + teamId +"/date/"+ startDate);
		executeGetCall(url);
	}

	public static void executeGetCall(URL url) throws Exception{
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("Response code: " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response.toString());
	}


}

