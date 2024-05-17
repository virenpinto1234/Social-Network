import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;




public class Analysis {

  public static void main(String[] args) {
    if (args.length == 0) {
        System.out.println("No file path provided. Please provide the path to the social network file as a command-line argument.");
        return;
      }
    try {
      // System.out.println(args[0]);
      //File socNet = new File("/home/pintov/h-drive/Social-Network/social-network1.txt" );
      // File socNet = new File("C:\\Users\\Viren Pinto\\OneDrive\\Desktop\\Social-Network\\social-network1.txt" );
      File socNet = new File(args[0]);
      Scanner Read = new Scanner(socNet);
      int nodecount = 0;
      int totalEdgeCount = 0;
      int followers = 0;
      String name = " ";
      ArrayList<String> names = new ArrayList<>();
      ArrayList<Integer> arrayMedian = new ArrayList<>();
      HashMap<String, Integer> followerCount = new HashMap<>();
     
     
    

      // loop checks if there is a next line
      while (Read.hasNextLine()) 
      {
        nodecount = nodecount+1;
        String line = Read.nextLine();
        
        Scanner lineScan = new Scanner(line);
        int edgecount = 0;
        
        name = lineScan.next();
        while(lineScan.hasNext())
        {
          String following = lineScan.next();
          int currentFollowers = followerCount.getOrDefault(following, 0);
          followerCount.put(following, currentFollowers + 1);
          edgecount = edgecount + 1;
          
          
        }
    
        lineScan.close();
        
        if(edgecount > followers)
        {
          followers = edgecount;
          names.clear();
          names.add(name);
        }
        else if(edgecount == followers)
        {
          names.add(name);
        }
  
        totalEdgeCount = totalEdgeCount + edgecount;

      }

      for (Integer count : followerCount.values()) 
      {
        arrayMedian.add(count);
       
      }

      float median = 0;
      int size = arrayMedian.size();

      //odd/even number Check 
      if(size % 2 == 1) median = arrayMedian.get(size/2);
      
      else median = (arrayMedian.get(size/2 - 1) + arrayMedian.get(size/2)) / 2;

      Read.close();


      Collections.sort(names);
      Collections.sort(arrayMedian);
      float answer = (float) totalEdgeCount/(nodecount*(nodecount-1));

      // System.out.println("\nTotal number of nodes: " + nodecount);
      // System.out.println("\nTotal number of edges: " + totalEdgeCount);
      System.out.println("\nTask 1: " + answer);
      System.out.println("\nTask 3: " + names);
      System.out.println("\nTask 5: " + median);
      //System.out.println("\nTask 6: " + );

      // for (int i = 0; i<arrayMedian.size(); i++) {
      // int curr = arrayMedian.get(i);

//       System.out.println(curr);
// }

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

