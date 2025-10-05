package Nexus.HttpParser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpParser {
    public static HttpRequestData parse(BufferedReader httpInputReader) throws IOException, ParseException {
        HttpRequestData httpRequestData = null;
        //Extracting the method
        String methodAndVerion = httpInputReader.readLine();
        String host = httpInputReader.readLine();
        String userAgent = httpInputReader.readLine();
        String contentLength = httpInputReader.readLine();
        String accept = httpInputReader.readLine();
        String conTentType = httpInputReader.readLine();
        String connection = httpInputReader.readLine();
        String encoding = httpInputReader.readLine();
        //End of the buffer
        httpInputReader.readLine();
        String method = methodAndVerion.split(" ")[0];
        String Version = methodAndVerion.split(" ")[2];
        String path = methodAndVerion.split(" ")[1];
        httpRequestData = new HttpRequestData(method, path, Version);
        //Extracting the json
        if (method.equals("POST")) {
            int length = Integer.parseInt(contentLength.split(" ")[1]);
            char[] jsonChars = new char[length];
            httpInputReader.read(jsonChars, 0, length);
            String jsonString = new String(jsonChars);
            JSONParser jsonParser = new JSONParser();
            httpRequestData.setPayLoad((JSONObject) jsonParser.parse(jsonString));
        }
        return httpRequestData;
    }
}
