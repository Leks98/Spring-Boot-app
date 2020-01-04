package com.example.app.service;

import com.example.app.exception.NumberRangeException;
import com.example.app.model.Numerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class PalindromesService {

    public Set<Numerator> generatePalindromesFromSpecificInterval(int interval[]) {
        //generate all possibly combinations from specify interval, because interval is integer type it can't throw NumberFormatException
        Set<Numerator> nrs = new HashSet<>();
        for (int number = interval[0]; number <= interval[1]; number++) {
            //it doesn't use checkNumberCorrectness method from Number because, it's not present information about each value from interval =>
            //if it's palindrome or not but the result has to be the whole set of the numeric palindromes
            if (checkNumberIsPalindrome(number)) {
                Numerator n = new Numerator(number, true);
                nrs.add(n);
            }
        }
        return nrs;
    }

    public void checkNumberCorrectness(int value) throws NumberRangeException {
        if (value < 0) {
            throw new NumberRangeException("The given number is incorrect because it's negative.");
        }
    }

    public boolean checkNumberIsPalindrome(int nr) {
        int reverseNumber = 0;
        int tmp = nr;
        while (tmp != 0) {
            reverseNumber = reverseNumber * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return nr == reverseNumber;
    }
}
