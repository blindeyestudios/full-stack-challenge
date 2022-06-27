# full-stack-challenge
This repo contains the Dockerized full-stack Angular/Spring challenge



This application uses the following stack:

-Angular

-Spring (with Maven build)



PREREQUISITES

Download and install Node.js - https://nodejs.org/en/download/

Download and install Docker - https://docs.docker.com/desktop/windows/install/

Download and install Angular CLI - run the command line: "npm install -g @angular/cli



SETUP

1. On Github (https://github.com/blindeyestudios/full-stack-challenge), download the .zip file of the code and unzip it into a folder of the same name

2. Create a new folder to house both the front and back end of the application

  Front-end
  
  3. Inside that folder, run the command line 
   
      "ng new supervisor-notification-front-end"

      3a. For the Angular options, choose N for routing, and CSS for the stylesheet
      
  -Now you have a folder called "supervisor-notification-front-end
  
  4. From the UNZIPPED github folder, copy the contents of the supervisor-notification-front-end folder, and paste it into the newly created angular folder of the same name.  When asked, choose to REPLACE the files of the same name

  5. Open a Powershell (or terminal of your choice) at the "supervisor-notification-front-end" folder and run the command : "ng build".  This will create our "dist" folder



  Back-end
  
  6. Copy and paste the "supervisornotification" folder from the UNZIPPED folder into the folder     created in step #2
  
  7. Open "supervisornotification" in a Java IDE.  For this example, I will walk through the steps   with Eclipse. 
  
      7a. Upon opening the folder in Eclipse, it will automatically sync and pull the External Maven libraries needed to run the application.  You may test at this point by running the application through Eclipse to confirm that it is working
      
  8. We need to first build the jar that will run in Docker.  In Eclipse, on the "supervisornotification" folder, right-click > Run As > Maven install.  (For other IDEs, please see the respective documentation for how to build the .jar file).
  
  9. You will now find that a "target" folder has been populated, in which you will find the "spring-boot-docker.jar" file that has been generated.
  
  10. ***Before building for Docker, ensure that you have the Docker command terminal running (or Docker Desktop open, which is what I'm personally using)



BACK-END BUILD

To build for Docker, run the following command on the "supervisornotification" folder (Shift+click > Open PowerShell window here) :

    "docker build -t spring-boot-docker.jar ."


To then run the application in a Docker container, run the following command:

    "docker run -p 9090:8080 spring-boot-docker.jar"



FRONT-END BUILD

To build the Angular front-end, open a new Powershell terminal at the "supervisor-notification-front-end" folder and run the following command:

    "docker build -t supervisor-notification-front-end ."


To then run the application in a Docker container, run the following command:

    "docker run -p 80:80 supervisor-notification-front-end"

(If you are using Docker Desktop, you will now see 2 containers running)



LAUNCH APPLICATION

At this point, open a web browser and navigate to this url: "http://localhost"

(You may need to try : http://localhost:80)
