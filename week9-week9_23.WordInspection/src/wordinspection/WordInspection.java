/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dmitry
 */
public class WordInspection {
    private File file;

    public WordInspection(File file) {
        this.file = file;
    }
    
    public int wordCount() throws FileNotFoundException {
        Scanner reader = new Scanner(file, "UTF-8");
        int count = 0;
        while(reader.hasNextLine()) {
            reader.nextLine();
            count++;
        }
        System.out.println(count);
        return count;
    }
    
    public List<String> wordsContainingZ() throws FileNotFoundException {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> wordsWithZ = new ArrayList<String>();
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            if(word.contains("z"))
                wordsWithZ.add(word);
        }
        return wordsWithZ;
    }
    
    public List<String> wordsEndingInL() throws FileNotFoundException {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> wordsWithL = new ArrayList<String>();
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            if(word.charAt(word.length() - 1) == 'l')
                wordsWithL.add(word);
        }
        return wordsWithL;
    }
    
    public List<String> palindromes() throws FileNotFoundException {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> palindrom = new ArrayList<String>();
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            StringBuilder builder = new StringBuilder();
            builder.append(word);
            builder = builder.reverse();
            String reverse = new String(builder);
            if(word.equals(reverse))
                palindrom.add(word);
        }
        return palindrom;
    }
    
    public List<String> wordsWhichContainAllVowels() throws FileNotFoundException {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> vowels = new ArrayList<String>();
        char[] array = {'a', 'e', 'i', 'o', 'u', 'y', 'ä', 'ö'};
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            int count = 0;
            for(int i = 0; i < array.length; i++){
                if(word.indexOf(array[i]) != -1) {
                    count++;
                }
            }
            if(count == 8)
                vowels.add(word);
        }
        return vowels;
    }
}
