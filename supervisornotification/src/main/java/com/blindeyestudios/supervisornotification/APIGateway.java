package com.blindeyestudios.supervisornotification;

import com.blindeyestudios.supervisornotification.model.NotificationRequest;
import com.blindeyestudios.supervisornotification.model.Supervisor;
import com.blindeyestudios.supervisornotification.service.RequestResult;
import com.blindeyestudios.supervisornotification.service.SupervisorService;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Notification;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class APIGateway {

    private final SupervisorService supervisorService;



    public APIGateway(SupervisorService supervisorService)
    {
        this.supervisorService = supervisorService;
    }

    @GetMapping("/supervisors")
    public ResponseEntity<List<Supervisor>> getSupervisors() throws IOException
    {
        List<Supervisor> supervisors = supervisorService.getSupervisors();
        return new ResponseEntity<>(supervisors, HttpStatus.OK);
    }

    @RequestMapping("/submit")
    public ResponseEntity<String> submitRequest(@RequestBody NotificationRequest notificationRequest)
    {

        RequestResult result = supervisorService.handleNotificationRequest(notificationRequest);

        ResponseEntity<String> response;

        JSONObject responseJSON = new JSONObject();


        switch (result)
        {
            case Accepted:
                responseJSON.put("responseMessage", "Submission successful!  Thanks!");
                response = new ResponseEntity<>(responseJSON.toString(), HttpStatus.OK);
                break;
            case Missing:
                responseJSON.put("responseMessage", "Submission unsuccessful.  Please fill all required fields.");
                response = new ResponseEntity<>("Submission unsuccessful.  Please fill all required fields.", HttpStatus.EXPECTATION_FAILED);
                break;
            default:
                responseJSON.put("responseMessage", "Something went wrong.  Please try again later.");
                response = new ResponseEntity<>(responseJSON.toString(), HttpStatus.BAD_REQUEST);
                break;
        }

        return response;
    }
}
