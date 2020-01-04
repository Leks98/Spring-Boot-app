package com.example.app.dao;

import com.example.app.exception.NumberRangeException;
import com.example.app.model.Numerator;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Service
public class PalindromesDao {

    public File getFileName() {
        return inFile;
    }

    public void setFileName(File fileName) {
        this.inFile = fileName;
    }

    private File inFile;

    public Set<Numerator> getDataFromFile() throws IOException {

        Set<Numerator> numbers = new HashSet<>();

        FileReader fr = null;
        try {
            fr = new FileReader(inFile);
            try (BufferedReader bfr = new BufferedReader(fr)) {
                String expression;
                while ((expression = bfr.readLine()) != null) {
                    try {
                        int nrValue = Integer.parseInt(expression);
                        numbers.add(new Numerator(nrValue, false));
                    } catch (NumberRangeException ex) {
                        ex.getMessage();
                    } catch (NumberFormatException ex) {
                        ex.getMessage();
                    }
                }
                bfr.close();
                return numbers;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void convertMultiPartToFile(MultipartFile file) throws IOException {
        inFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(inFile);
        fos.write(file.getBytes());
        fos.close();
    }
}