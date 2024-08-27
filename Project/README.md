## Project Structure

Project
│
├── Tests
│   ├── src
│   │   └── test_all.py
│
├── final-project
│   ├── src
│   │   ├── main
│   │   │   └── java/final_project
│   │   │       ├── (Java source files)
│   │   ├── resources
│   │   ├── test
│   │   └── target
│   ├── Dockerfile #for CICD server
│   ├── HELP.md
│   ├── mvnw
│   ├── mvnw.cmd
│   └── pom.xml
│
├── play-with-docker
│   ├── Dockerfile  #for Python tests
│   ├── docker-compose.yml
│   ├── requirements.txt



**GUIDE**

1. Clone the repository to your local machine
2. Navigate to the play-with-docker directory
3. Build and start the services by running docker-compose up --build


Now you can access the CI CD server via browser http://localhost:8080
and make sure that everything is up and running

