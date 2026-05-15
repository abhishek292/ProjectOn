package api.endpoints;

public class Routes {

	

	public static String baseUrl = "https://petstore.swagger.io/v2";
	public static String baseUrlInstrument = "http://localhost:8080";
	

	public static String auth = baseUrlInstrument+ "/api/auth/login";
	public static String addInstrument =baseUrlInstrument+ "/api/instruments";
	public static String getInstrument = baseUrlInstrument+"/api/instruments/{id}";
	public static String getUrl = baseUrl + "/user/{username}";
	public static String postUrl = baseUrl + "/user";
	public static String updateUrl = baseUrl + "/user/{username}";
	public static String deleteUrl = baseUrl + "/user/{username}";
	public static String postImage = baseUrl + "/pet/{petId}/uploadImage";
	public static String addPetPost = baseUrl + "/pet";
	public static String addedPetPost = baseUrl + "/pet/set";
}
