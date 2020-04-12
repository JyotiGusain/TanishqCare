package com.tanishq.care.util;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import com.tanishq.care.model.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String FILE_NAME = "STUDENT.csv";
    private static final String COMMA = ",";

    private static String [] columnNames = {"id","FirstName","LastName","Email", "Branch","PhoneNumber"};
    public static void write(List<Student> students) throws IOException {

        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(FILE_NAME));
            //Create record

            writer.writeNext(columnNames);

            CSVWriter finalWriter = writer;
            students.forEach(s->{
               String data = new StringBuilder().append(s.getId())
                       .append(COMMA).append(s.getFirstName())
                       .append(COMMA).append(s.getLastName())
                       .append(COMMA).append(s.getEmail())
                       .append(COMMA).append(s.getBranch())
                       .append(COMMA).append(s.getPhoneNumber())
                       .toString();
               finalWriter.writeNext(data.split(COMMA));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }
    public static List<Student> read() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(FILE_NAME), ',', '"', 1);
        List<String[]> allRows = reader.readAll();
        List<Student> students= new ArrayList<>();
        for(String[] row : allRows) {
            Student s = new Student();
            s.setId(Integer.parseInt(row[0]));
            s.setFirstName(row[1]);
            s.setLastName(row[2]);
            s.setEmail(row[3]);
            s.setBranch(row[4]);
            s.setPhoneNumber(Long.parseLong(row[5]));
            students.add(s);
        }

        return students;
    }
}
