/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package moviegenre;
import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author Ana
 */
public class MovieGenre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        int rowCount =9742;
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
         File file1 = new File("output2.txt");
        PrintWriter writer1 = new PrintWriter(file1);
        String [] movield = new String [9742];
        String [] title = new String [9742];
        String [] genre = new String [9742];
        for(int i=0; i<rowCount;i++){
            String row = sc.nextLine();
            String [] data = row.split(",");
            movield[i] = data[0];
            title[i] =data[1];
           genre[i]=data[2];
           
        }
     
Map<String, Long> freq = Stream.of(genre).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<String, Long> entry : freq.entrySet()) {
             writer1.println(entry.getKey() + " ----  " + entry.getValue() + " times ");
        }

    
}
}