/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Calculator {
    
    private Reader reader;
    private int count = 0;

    public Calculator() {
        this.reader = new Reader();
    }
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }
    
    private int[] userInput() {
        int[] values = new int[2];
        System.out.print("value1: ");
        values[0] = reader.readInteger();
        System.out.print("value2: ");
        values[1] = reader.readInteger();
        return values;
    }
    
    private void sum() {
        count++;
        int[] numbers = userInput();
        int result = numbers[0] + numbers[1];
        System.out.println("sum of the values " + result);
    }
    
    private void difference () {
        count++;
        int[] numbers = userInput();
        int result = numbers[0] - numbers[1];
        System.out.println("difference of the values " + result);
    }
    
    private void product() {
        count++;
        int[] numbers = userInput();
        int result = numbers[0] * numbers[1];
        System.out.println("product of the values " + result);
    }
    
    private void statistics() {
        System.out.println("Calculations done " + count);
    }
        
}
