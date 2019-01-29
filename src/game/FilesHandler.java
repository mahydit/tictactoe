/*
File Handler class is responislbe for aff methods and details
concerning saving and reading from files
 */
package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mahy
 */
public class FilesHandler {

    private File gameFile; //current file 
    private final File SAVED_GAMES = new File(System.getProperty("user.home") + File.separator + "tictactoe/savedgames"); //directory to save into
    private PrintWriter pw;
    private BufferedReader br;

    //constructor to use when writing 
    public FilesHandler(FileMode mode) throws FileNotFoundException {
        if (!SAVED_GAMES.exists()) {
            SAVED_GAMES.mkdirs();
        }
        createFile(mode);
    }
    
    //constructor to use when reading
    public FilesHandler(File file, FileMode mode) throws FileNotFoundException {
        gameFile = file;
        if (mode == FileMode.READ) {
            FileReader fr = new FileReader(gameFile.getAbsoluteFile());
            br = new BufferedReader(fr);

        }
    }
    
    public File getFile(){
        return gameFile;
    }
    
    //creating file for thr first time
    private void createFile(FileMode mode) throws FileNotFoundException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
        gameFile = new File(SAVED_GAMES + "/" + timeStamp + ".txt");
        if (mode == FileMode.WRITE) {
            pw = new PrintWriter(gameFile);
        }
    }

    //saving integer value to the file
    public void saveIntegerElementInFile(int element) {
        pw.println(element);
    }
    //closing printwriter
    public void closeWriterBuffer() {
        pw.close();
    }
    //closing bufferedreader
    public void closeReaderBuffer() throws IOException {
            br.close();
    }

    //reading the file and saving its content into an arraylist
    public ArrayList readElementsFromFile() throws IOException {
        ArrayList<Integer> gameMoves = new ArrayList<>(); //change it to arraylist
        String line;
        while ((line = br.readLine()) != null) {
            gameMoves.add(Integer.parseInt(line));
        }

        return gameMoves;

    }
    
    //count number of lines in the file
    public int countFileItems(){
        FileReader fr =null;
        int count =0;
        try {
            fr = new FileReader(gameFile.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                count++;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            return 0;
        }catch (IOException ex) {
            return 0;
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                return 0;
            }
        }
        return count;
    }

}
