# CMPT 276 Project: Escape From Corona #

## Project running instructions ##


### Running Using Maven ###
If a .jar file hasn't been created, you can run the project directly using Maven and the command `mvn javafx:run` in the `C:\...\Project` path.

### Building and JAR File Creation ###
In the directory of where the project was cloned to (should be path `C:\...\Project`), run `mvn package` in a terminal/command line window to create the JAR file.

### JAR File Location and How to Run ###
The JAR file should have been created in the `...\Project\target` folder as `Escape-From-Corona.jar`.
To run the JAR file:
* Double-click on the file; or
* Right click on the file and click `Open`; or
* Open a terminal/command-line window in the directory and run the following command: `java -jar Escape-From-Corona.jar`

### Javadocs Creation and Where to Find ###
Javadocs can be created by running `mvn javadoc:javadoc` in the `C:\...\Project` path.  

To view the created Javadocs, go to `...\Project\target\site\apidocs` where there should be mulitple `.html` files. Open `index.html` in a browser, and all documented classes and functions using Javadocs should be viewable.

### Testing ###
In the `C:\...\Project` path, run `mvn test` to run all tests.

## Video Tutorial ##
A video tutorial showcasing the project can be found at INSERT LINK HERE https://www.youtube.com/


## Credits ##
Created by:
* Stephen Dao
* Danyaal Patel
* Peter Salnikov
* Brendan Saw