# MavProject

Instructions to Run Test with in the Project.

Prerequsites : Maven Installed in the host machine of execution. 

1) Open the LUI ( line user interface ) in your respective Operating system.
2) In your LUI (terminal/cmd prompt)Change Directory to the location you have downloaded the project to (Ex: cd ~/documents/workspace/mavProject).
3) Run the below Maven commands on the LUI , .
     mvn clean
     mvn install
4) As a result of the above command , the dependecies will be downloaded, the project will be built and the tests will run.
5) In order to re run the tests , you can use the below mavn command,
     mvn test
    
