package vn.techmaster.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {
    @RequestMapping(value = "/random-color/")
    public ResponseEntity<?> getRandomColor(@RequestParam("type") Integer type ) {
        String randomColor = "";


        if ( type > 3 || type < 1 ){
            System.out.println("Loai mau khong hop le");
            return  ResponseEntity.ok("");
        }

        try {
            switch (type){
                case 1:
                    randomColor = getRandomColorName();
                    break;
                case 2:
                    randomColor = getRandomHex();
                    break;
                case 3:
                    randomColor = getRandomRGB();
                    break;
            }
            return ResponseEntity.ok(randomColor);
        } catch (Exception e){
           return  ResponseEntity.ok("Error");
        }

    }

    public String getRandomColorName(){
        String[] color = {"red","blue","green","yellow","black","white"};
        int index = (int) (Math.random() * color.length);

        return color[index];
    }

    public String getRandomHex(){
        String[] letters = "0123456789ABCDEF".split("");
        String color = "#";
        for (int i = 0; i < 6; i++) {
            color += letters[(int) (Math.random() * 16)];
        }
        return color;
    }

    public String getRandomRGB(){
        int RGBColor1 = (int) (Math.random() * 225);
        int RGBColor2 = (int) (Math.random() * 225);
        int RGBColor3 = (int) (Math.random() * 225);

        String color = "rgb(" + RGBColor1 + ","+ RGBColor2 +"," + RGBColor3 +")";
        return color;
    }

}
