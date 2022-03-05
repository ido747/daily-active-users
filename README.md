# daily-active-users



I made 2 functions – 
The first function HashMap<String, HashSet <String>> createActiveUsersMap(File file) -creates a hash map that contains date as a key, and hashset of userID's as a value. 
I read a file and in each line I using 2 splits. The first, split the row by the separator ",". The value(userID) is the  before separator part.
The second split, split the after comma part, and extract the date from the rest of the string.

In each line I check if the map contains the date:
If it does - I add the user id into the hashset of the daily active users only if the user id not in the hashset yet. If it does, I not change a thing.
If the map doesn't contains the date , so I put the date as a new key and create new hashset with the user id in it.


The second function int getDailyUsersCount (HashMap<String, HashSet <String>> map, String date) - it get the hashmap that I created and a specific date, and return the number of unique daily active users in this day.

  
 -------Insuructions for running the code------------
  First, you need to create the daily active users map and to do it you need to run createActiveUsersMap function.
  once you do it, you can run the second function with map you created and the specific date.
  
  
