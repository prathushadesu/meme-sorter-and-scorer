# Meme sorter and scorer

Meme sorter and scorer application sorts and scores a given list of memes. The data is read from a JSON file and the updated memes are written back to the same file. Each Meme has a 'name' and 'lulzScore' associated with it. Sorting of the Meme list is based on the 'name' and is done in ascending order. Scoring or associating lulzScore associates a Meme with a random lulzScore which ranges from 1-10.

Technology stack used
---------------------
- Java (jdk 7)
- Maven
- JSON.simple for JSON processing
- Apache log4j2 for logging
- JUnit for unit testing

Steps to execute
-----------------
An executable jar and a 'memes.json' file are placed in the 'executables.zip' folder. To execute the application,

1. Please left-click** on the executables.zip folder available at https://github.com/prathushadesu/meme-sorter-and-scorer
2. Please left-click** on the 'View Raw' options available on the screen at https://github.com/prathushadesu/meme-sorter-and-scorer/blob/master/executables.zip
3. After being prompted to save the zip folder, please save it to the disk.
4. Extract the zip file to a folder. After extraction, a "executables" folder is created, which contains meme-sorter-scorer.jar and memes.json.
5. Please open a command window and cd into the "executables" folder location, which contains the memes.json and the jar file.
6. Please verify the memes.json file by viewing in any text/json editor.
7. The memes.json will be updated with the sorted list of memes and the lulzScore updates.
8. Run the command given below to execute the application, at the end of which, the memes.json will be updated.

java -cp meme-sorter-scorer.jar com.comcast.application.MemeSorterScorer ./memes.json

**If the save-link-as option is used to save the folder or file from a Browser directly, the files become unusable. Please clone the Git Repository or follow Step#1, Step#2 to successfully execute the application.

Description of the command
---------------------------
java -cp \<jar file location\> \<Main class inside the jar\> \<JSON file location\>

1.  \<jar file location\> - If the command window is opened inside the executables folder, just the jar name is sufficient.
2.  \<Main class inside the jar\>  - com.comcast.application.MemeSorterScorer is the class that has the main method.
3.  \<JSON file location\> - Absolute file path of memes json file. If the command window is opened inside the executables folder, ./memes.json is sufficient.

Note
-----
1. Kindly note that the validation of the input json/file content has not been coded for, due to time crunch.
2. Application expects the JSON to be valid and has a JSONArray of Meme objects.
3. Each Meme element has a String parameter "name" and an Integer parameter "lulzScore".


Alternate ways to execute
--------------------------
1. Clone the Repository to Desktop.
2. Execute the com.comcast.application.MemeSorterScorer.java.
3. Initial run of the prorgam, picks the memes.json file on the classpath and places the output memes.json file under meme-sorter-scorer folder.
4. Subsequent executions will pick the file under meme-sorter-scorer/, unless the file under meme-sorter-scorer is removed or the file path is mentioned as the first argument.
