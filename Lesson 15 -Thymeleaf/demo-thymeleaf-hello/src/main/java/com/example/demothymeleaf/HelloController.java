package com.example.demothymeleaf;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HelloController {
    @GetMapping("/home")
    public String hello(){
        return "hello";
    }

    @GetMapping(value = "/hi", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String hi() {
        return "<h1>Hello World</h1><h3>Cool</h3>";
    }


    public static void main(String[] args) {
        Locale[] locales = new Locale[] {
                Locale.JAPAN,
                Locale.CHINA,
                Locale.KOREA,
                Locale.TAIWAN,
                Locale.ITALY,
                Locale.FRANCE,
                Locale.GERMAN,
                new Locale("vi", "VN")
        };

// Get an instance of current date time
        Date today = new Date();
        for (Locale locale : locales) {
            System.out.printf("Date format in %s = %s%n",
                    locale.getDisplayName(), SimpleDateFormat.getDateInstance(
                            SimpleDateFormat.LONG, locale).format(today));
        }

    }

}
