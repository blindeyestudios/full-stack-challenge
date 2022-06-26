package com.blindeyestudios.supervisornotification.service;

import com.blindeyestudios.supervisornotification.model.NotificationRequest;
import com.blindeyestudios.supervisornotification.model.Supervisor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SupervisorService {

    private final String ID = "id";
    private final String PHONE = "phone";
    private final String JURISDICTION = "jurisdiction";
    private final String IDENTIFICATION_NUMBER = "identificationNumber";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";

    private final String url = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";

    /**
     * Default constructor
     */
    public SupervisorService() {}


    public List<Supervisor> getSupervisors() throws IOException, JSONException
    {
        // Initialize the list for Supervisors
        List<Supervisor> supervisors = new ArrayList<>();

        // Open up a stream to read from the url endpoint
        InputStream input = new URL(url).openStream();
        try
        {
            // Create a reader for the stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            // Initialize a StringBuilder to build the JSON string
            StringBuilder builder = new StringBuilder();

            // Read in the characters as long as there is something to read
            int temp;
            do
            {
                temp = bufferedReader.read();
                builder.append((char) temp);
            }
            while (temp != -1);

            // Use the StringBuilder to instantiate a JSONArray
            JSONArray jsonArray = new JSONArray(builder.toString());

            // Iterate through the JSONArray to extract all Supervisors
            for (int i = 0; i < jsonArray.length(); i++)
            {
                // Get the current JSONObject
                JSONObject ob = jsonArray.getJSONObject(i);

                // Check to see if the jurisdiction is numerical
                String jurisdiction = ob.getString(JURISDICTION);
                // If it IS numerical, we don't want it
                if (isNotNumeric(jurisdiction))
                {
                    // Create a new Supervisor and add it to the list
                    supervisors.add(new Supervisor(
                            ob.getInt(ID),
                            ob.getString(PHONE),
                            jurisdiction,
                            ob.getString(IDENTIFICATION_NUMBER),
                            ob.getString(FIRST_NAME),
                            ob.getString(LAST_NAME)));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally
        {
            // Make sure that whether we catch an exception or not, we close the input stream
            input.close();
        }

        // Sort the Supervisors as specified in the Supervisor class
        Collections.sort(supervisors);

        return supervisors;
    }

    /**
     * A method to check if a String is NOT a numerical value
     *
     * @param str
     * @return
     */
    private boolean isNotNumeric(String str)
    {
        if (str == null)
        {
            return true;
        }
        try
        {
            // Try to parse the String to a double
            double number = Double.parseDouble(str);
        }catch (NumberFormatException nfe)
        {
            // If we catch the exception, that means it's NOT a number
            return true;
        }
        return false;
    }

    public RequestResult handleNotificationRequest(NotificationRequest request)
    {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String supervisor = request.getSupervisor();

        if (firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                    supervisor == null || supervisor.isEmpty())
        {
            System.out.println(request.toString());
            return RequestResult.Missing;
        }
        else
        {
            System.out.println(request.toString());
            return RequestResult.Accepted;
        }
    }


}
