package com.example.color.controller;

import com.example.color.service.GetColorName;
import com.example.color.service.GetHex;
import com.example.color.service.GetRgb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random-color/")
public class ColorController {
    @Autowired
    private GetColorName getColorName;
    @Autowired
    private GetHex getHex;
    @Autowired
    private GetRgb getRgb;

    @GetMapping("")
    public ResponseEntity<?> getRandomColor(@RequestParam("type") Integer type) {

        System.out.println(type);
        String randomColor = "";

        if (type > 3 || type < 1) {
            System.out.println("Loai mau khong hop le");
            return ResponseEntity.ok("");
        }

        try {
            switch (type) {
                case 1:
                    randomColor = getColorName.getColor();
                    System.out.println(randomColor);
                    break;
                case 2:
                    randomColor = getHex.getColor();
                    break;
                case 3:
                    randomColor = getRgb.getColor();
                    break;
            }
            return ResponseEntity.ok(randomColor);
        } catch (Exception e) {
            return ResponseEntity.ok("Error");
        }
    }
}


