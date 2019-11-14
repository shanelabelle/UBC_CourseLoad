package network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FetchCourseDescription {

    public String getCourseTitle(String courseName) throws IOException {
        String courseData = getCourseData(courseName);

        JsonObject jsonObject = new JsonParser().parse(courseData).getAsJsonObject();

        String title = jsonObject.get("course_title").getAsString();
        System.out.println(title);
        return title;
    }


    public String getCourseData(String courseName) throws IOException {

        String jsonString;
        BufferedReader br = null;

        try {
            URL url = new URL(createCourseUrl(courseName));
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            jsonString = sb.toString();

        }  finally {

            if (br != null) {
                br.close();
            }
        }
        return jsonString;
    }

    public String createCourseUrl(String coursename) {
        String[] split = coursename.split(" ");
        String courseType = split[0];
        String courseNumber = split[1];

        String url = "https://ubc-courses-api.herokuapp.com/2019W/" + courseType + "/" + courseNumber + "/";
        return url;
    }



}
