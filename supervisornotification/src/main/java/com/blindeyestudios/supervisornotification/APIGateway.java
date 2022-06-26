package com.blindeyestudios.supervisornotification;

import com.blindeyestudios.supervisornotification.model.NotificationRequest;
import com.blindeyestudios.supervisornotification.model.Supervisor;
import com.blindeyestudios.supervisornotification.service.RequestResult;
import com.blindeyestudios.supervisornotification.service.SupervisorService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * This class serves as the API Gateway on the back-end side
 * It is accessed at the base level via the mapping: "/api".
 * It provides microservice calls for supervisor-related services
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class APIGateway {

    private final SupervisorService supervisorService;

    /**
     * Constructor.
     * Sets a reference to the SupervisorService
     *
     * @param supervisorService
     */
    public APIGateway(SupervisorService supervisorService)
    {
        this.supervisorService = supervisorService;
    }

    /**
     * Utilizes a microservice to get all applicable supervisors and their data
     * from an endpoint
     *
     * @return
     * @throws IOException
     */
    @GetMapping("/supervisors")
    public ResponseEntity<List<Supervisor>> getSupervisors() throws IOException
    {
        // Gets all the Supervisors into a List
        List<Supervisor> supervisors = supervisorService.getSupervisors();
        // Returns that List in a ResponseEntity as well as with an "OK" status
        return new ResponseEntity<>(supervisors, HttpStatus.OK);
    }

    /**
     * This method takes in a NotificationRequest sent from the front-end.
     * It passes that NotificationRequest to a microservice that attempts to
     * handle the request.
     *
     * That microservice then returns a result Enum to indicate if the submission
     * was accepted or not
     *
     * @param notificationRequest
     * @return
     */
    @RequestMapping("/submit")
    public ResponseEntity<String> submitRequest(@RequestBody NotificationRequest notificationRequest)
    {
        // Utilizes the service to handle the NotificationRequest.  Will return an enum indicating
        // if the service was successful at submitting the request or not
        RequestResult result = supervisorService.handleNotificationRequest(notificationRequest);

        // Create a ResponseEntity variable to send back to the front-end
        ResponseEntity<String> response;

        // Create a new JSONObject to pass a message back to the front-end with the ResponseEntity
        JSONObject responseJSON = new JSONObject();

        // Switch on the value of the result enum
        switch (result)
        {
            // If the submission was accepted, indicate it through a message and return with an "OK" status
            case Accepted:
                responseJSON.put("responseMessage", "Submission successful!  Thanks!");
                response = new ResponseEntity<>(responseJSON.toString(), HttpStatus.OK);
                break;
            // If it was found to have missing fields, indicate it through a message and return an error as "EXPECTATION_FAILED"
            case Missing:
                responseJSON.put("responseMessage", "Submission unsuccessful.  Please fill all required fields.");
                response = new ResponseEntity<>("Submission unsuccessful.  Please fill all required fields.", HttpStatus.EXPECTATION_FAILED);
                break;
            // If it failed to accept the submission for any other reason, return a generic message to the user and an error
            default:
                responseJSON.put("responseMessage", "Something went wrong.  Please try again later.");
                response = new ResponseEntity<>(responseJSON.toString(), HttpStatus.BAD_REQUEST);
                break;
        }

        return response;
    }
}
