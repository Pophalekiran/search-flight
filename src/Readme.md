This is spring boot application. It is restful service application used spring rest to define the controller.
I have used below component. 
   1) @RestController : To define the controller.
   2) @RequestMapping : To define rest point end point.
   3) Defined service layer : It has business logic and calls the repository
   4) Repository : It has logic to collect the flight details from different providers
   5) @ControllerAdvice : It handles the exceptions in the applications and retuen the error messages to client/consumer
   6) ReadFileUtil class : Reads the data from the provider files
   7) CSVReader class : It is in opencsv jar. It is allowing to parse the csv files.
   8) Flight : It model class and hold the flight details.
   9) Junit : added 2 test cases to test the FlightServiceHandlerImpl service class
   9) Build tool : Maven 
   10) IDE : Intellij 