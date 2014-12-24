import java.io.*;
 
public class CompareDataInFiles {
 
        public static void main(String[] args) throws IOException {
                // File names to Read & Write.
                String actualFile   = "/Users/nmahesh/Desktop/try.rtf";
                String expectedFile = "/Users/nmahesh/Desktop/try1.rtf";
                String descptnFile  = "/Users/nmahesh/Desktop/sample.rtf";
                try{
                // Create FileReader & Writer Objects.
                FileReader actualFileReader  = new FileReader(actualFile);
                FileReader expctdFileReader  = new FileReader(expectedFile);
                FileWriter resultDesc = new FileWriter(descptnFile);
               
                // Create Buffered Object.
                BufferedReader actlFileBufRdr = new BufferedReader(actualFileReader);
                BufferedReader expcFileBufRdr = new BufferedReader(expctdFileReader);
                BufferedWriter resultFileBufWrtr = new BufferedWriter(resultDesc);
               
                // Get the file contents into String Variables.
                String actlFileContent = actlFileBufRdr.readLine();
                String expctdFileContent = expcFileBufRdr.readLine();
               
                // Compare the Contents of the files.
                String startOfComparision = "---------START----------";
                resultFileBufWrtr.write(startOfComparision);
                resultFileBufWrtr.newLine();
                System.out.println(startOfComparision);
               
                boolean isDifferent = false;
                int lineNumber = 1;
               
                if (actlFileContent != null || expctdFileContent != null) {
                       
                        // Check whether Actual file contains data or not
                        while((actlFileContent!=null)  ){
                               
                                // Check whether Expected file contains data or not
                                if (((expctdFileContent )!=null)) {
                                       
                                        // Check whether both the files have same data in the lines
                                        if (!actlFileContent.equals(expctdFileContent)) {
                                                resultFileBufWrtr.write("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains : "+expctdFileContent);
                                                resultFileBufWrtr.newLine();
                                                System.out.println("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains : "+expctdFileContent);
                                                isDifferent = true;
                                        }
                                        lineNumber = lineNumber+1;
                                        expctdFileContent= expcFileBufRdr.readLine();
                                }
                                else{
                                        resultFileBufWrtr.write("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains - "+expctdFileContent);
                                        resultFileBufWrtr.newLine();
                                        System.out.println("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains - "+expctdFileContent);
                                        isDifferent = true;
                                        lineNumber = lineNumber+1;
                                }
                                actlFileContent=actlFileBufRdr.readLine();
                        }
                       
                        // Check for the condition : if Actual File has Data & Expected File doesn't contain data.
                        while ((expctdFileContent!=null)&&(actlFileContent==null)) {
                                resultFileBufWrtr.write("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains - "+expctdFileContent);
                                resultFileBufWrtr.newLine();
                                System.out.println("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains - "+expctdFileContent);
                                isDifferent = true;
                                lineNumber = lineNumber+1;
                                expctdFileContent= expcFileBufRdr.readLine();
                        }
                }
                else{
                        // Mention that both the files don't have Data.
                        resultFileBufWrtr.write("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains - "+expctdFileContent);
                        resultFileBufWrtr.newLine();
                        System.out.println("Difference in Line "+lineNumber+" :- Actual File contains :"+actlFileContent+", Expected File Contains - "+expctdFileContent);
                        isDifferent = true;
                }
               
                // Check is there any difference or not.
                String endOfComparision = "-----------END----------";
                if (isDifferent) {
                        resultFileBufWrtr.append(endOfComparision);
                        System.out.println(endOfComparision);
                }
                else{
                        resultFileBufWrtr.append("No difference Found");
                        resultFileBufWrtr.newLine();
                        resultFileBufWrtr.append(endOfComparision);
                       
                        System.out.println("No difference Found");
                        System.out.println(endOfComparision);
                }
               
                //Close the streams.
                actualFileReader.close();
                expctdFileReader.close();
                resultFileBufWrtr.close();
                actlFileBufRdr.close();
                expcFileBufRdr.close();
          }
          catch( FileNotFoundException e )
        {
                        e.printStackTrace();
        }              
        }
 
}
 