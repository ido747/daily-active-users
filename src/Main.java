import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("input.txt");
        HashMap<String, HashSet<String>> activeUsers =  createActiveUsersMap(file);
        System.out.println(getDailyUsersCount(activeUsers,"01/01/2020"));

    }


    private static HashMap<String, HashSet<String>> createActiveUsersMap(File file){
        HashMap<String,HashSet<String>> map = new HashMap<>();
        //read the file
        try { Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] row = data.split(","); //first split, extract the userid
                String key = row[1].split(" ")[0];//second split, extract the date
                String value = row[0];

                if(map.containsKey(key)){ //check if the date is new.

                    if(!map.get(key).contains(value)){ //check if the userid is not in the specific date's hashset.
                        map.get(key).add(value);
                    }
                }
                else{
                    HashSet<String> listOfId = new HashSet<>();
                    listOfId.add(value);
                    map.put(key,listOfId);
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("The file not found, please make sure the name of the file is correct");
        }

        return map;

    }


    private static int getDailyUsersCount(HashMap<String,HashSet<String>> map, String date){
        if(map==null||date ==null){
            return 0;
        }

        if(map.containsKey(date)){
            return map.get(date).size();
        }
        else { // the date is not in the map.
            return 0;
        }

    }
}
