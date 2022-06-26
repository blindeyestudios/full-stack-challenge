# full-stack-challenge
This repo contains the Dockerized full-stack Angular/Spring challenge

BACK-END BUILD
To build for Docker, run the following command at the root-level folder:
"docker build -t spring-boot-docker.jar ."

To then run the application in a Docker container, run the following command:
"docker run -p 9090:8080 spring-boot-docker.jar"

FRONT-END BUILD
To build the Angular front-end, run the following command at the root-level folder:
"docker build -t supervisor-notification-front-end ."

To then run the application in a Docker container, run the following command:
"docker run -p 80:80 supervisor-notification-front-end"
