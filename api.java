package api;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
  
class api {
	  private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	  
	  public static void main(String[] args) throws IOException, JSONException {
		Scanner scanner = new Scanner(System.in); 
	    System.out.println("Please Choose (1,2,3,4) "+"\n"+"1. /Search"+"\n"+"2. /Search with more than 1 key "+"\n"+"3. Get Albums 1 and more "+"\n"+"4. Get Artist 1 and more");
	    int caseKey = scanner.nextInt(); 
	    scanner.nextLine();
	    switch(caseKey) {
	    case 1:
	    	 System.out.println("iTunes Search: ");
	    	 String searchKey = scanner.nextLine(); 
	    	 String encodedQuery = URLEncoder.encode(searchKey,"UTF-8");
	    	 String completeUrl = "https://itunes.apple.com/search?term=" + encodedQuery;
	    	 JSONObject result = readJsonFromUrl(completeUrl);
	    	 System.out.println(result);
	      break;
	    case 2:
	    	 System.out.println("iTunes Search: ");
	    	 String searchKeyLimited  = scanner.nextLine(); 
	    	 System.out.println("Limit result to: ");
	    	 String limitKey = scanner.nextLine(); 
	    	 String encodedQueryLimited = URLEncoder.encode(searchKeyLimited,"UTF-8");
	    	 String completeUrlLimited  = "https://itunes.apple.com/search?term=" + encodedQueryLimited + "&limit=" + limitKey;
	    	 JSONObject resultLimited  = readJsonFromUrl(completeUrlLimited );
	    	 System.out.println(resultLimited);
	      break;
	    case 3:
	    	 System.out.println("iTunes Albums Search: ");
	    	 String albumsKey  = scanner.nextLine(); 
	    	 String encodedQueryAlbums = URLEncoder.encode(albumsKey,"UTF-8");
	    	 String completeUrlAlbums  = "https://itunes.apple.com/search?term=" + encodedQueryAlbums + "&entity=album";
	    	 JSONObject resultAlbums  = readJsonFromUrl(completeUrlAlbums );
	    	 System.out.println(resultAlbums);
	      break;
	    case 4:
	    	 System.out.println("iTunes Artists Search: ");
	    	 String artistsKey  = scanner.nextLine(); 
	    	 String encodedQueryArtist = URLEncoder.encode(artistsKey,"UTF-8");
	    	 String completeUrlArtist  = "https://itunes.apple.com/search?term=" + encodedQueryArtist+ "&entity=musicArtist";
	    	 JSONObject resultArtist  = readJsonFromUrl(completeUrlArtist );
	    	 System.out.println(resultArtist);
		      break;
	    default:
	      break;
	    }
	  }
}