import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import javax.management.RuntimeErrorException;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter data: surname_name_middlename_phone number_gender  ");

        String input = scanner.nextLine();


        try {
            String [] data = input.split("");
            if (data.length !=6 ) {
                throw new Exception("please, enter each argument");
            }
        

        String surname = data[0];
        String name = data[1];
        String middlename = data [2];
        int phoneNumber;
        String gender = data [5]; 

        SimpleDateFormat format = new SimpleDateFormat ("dd.mm.yyyy");
        Date birthDate;

        try {
            birthDate = format.parse(data[3]);

        } catch (NumberFormatException e) {
            throw new NumberFormatException("wrong date format"); 
        }

        try {
            phoneNumber = Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("wrong phone format"); 
        }

        if (!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")) {
            throw new RuntimeException("please, enter lower case f or m");
        }



        // String fileName = "data.txt";
        File info = new File("data.txt");
        try (FileWriter fileWriter = new FileWriter(info,true)){
            if (info.length() > 0){
                fileWriter.write("\n");
            }
            fileWriter.write(String.format(surname, name, middlename, format.format(birthDate),phoneNumber, gender));
        } catch (IOException y) {
            throw new FileSystemException("file processing error");
        }

    }
    


    }

}

    



          
        

    


  




       



