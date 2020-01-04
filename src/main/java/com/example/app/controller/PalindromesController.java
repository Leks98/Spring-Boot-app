package com.example.app.controller;

import com.example.app.dao.PalindromesDao;
import com.example.app.model.Numerator;
import com.example.app.service.PalindromesService;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Controller
public class PalindromesController {
    @Autowired
    private PalindromesService palindromesService;
    @Autowired
    private PalindromesDao palindromesDao; //czy dodac interfejs i @Component?


    @GetMapping("/menu")
    public String createNumber(Model model) {
        model.addAttribute("numerator", new Numerator());
        return "menu";
    }
    @PostMapping("/menu")
    public String checkNumberIsPalindrome(@ModelAttribute Numerator number, Model model) {
        palindromesService.checkNumberCorrectness(number.getValue());
        boolean isPalindrome=palindromesService.checkNumberIsPalindrome(number.getValue());
        number.setIsPalindrome(isPalindrome);
        number.setAdditionDate(new Date());
        model.addAttribute("numerator", number);
        return "menu";
    }

//    @RequestMapping(value = "/menu")
//    public String processInputData(@RequestParam("file") MultipartFile fileName, Model model) throws IOException {
//        palindromesDao.convertMultiPartToFile(fileName);
//        return "menu";
//    }
//    @GetMapping("/numbers")
//    public Set<Numerator> list(Model model)
//    {
//        Set<Numerator>  numbers = null;
//        try {
//            numbers = palindromesDao.getDataFromFile();
//            for (Numerator nr : numbers) {
//                checkNumberIsPalindrome(nr, model); //czy tak sie da?
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return numbers;
//    }
//    @PostMapping("/menu")
//    public String generatePalindromes(@ModelAttribute int[] interval, Model model) {
//        Set<Numerator>numbers=palindromesService.generatePalindromesFromSpecificInterval(interval);
//        for(Numerator nr:numbers) {
//            nr.setIsPalindrome(true);
//            nr.setAdditionDate(new Date());
//        }
//        model.addAttribute("numerator", numbers);
//        return "menu";
//    }

}