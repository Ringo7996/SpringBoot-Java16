package vn.techmaster.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BMIController {
    @GetMapping(value = "/bmi/")
    public ResponseEntity<?> getBMI(@RequestParam("height") Double heightValue, @RequestParam("weight") Double weightValue  ){
        if ( heightValue <= 0 || weightValue <=0 ){
            System.out.println("Chieu cao can nang phai lon hon khong");
            return  ResponseEntity.ok("");
        }
        double BMI = weightValue / (heightValue*heightValue);

        System.out.println(weightValue);
        return  ResponseEntity.ok(BMI);
    }

    @PostMapping(value = "/bmi/")
    public ResponseEntity<?> postBMI(@RequestBody BMIRequest bmiRequest){

        double height = Double.parseDouble(bmiRequest.getHeight());
        double weight = Double.parseDouble(bmiRequest.getWeight());

        double BMI = weight / (height*height);

        return ResponseEntity.ok(bmiRequest);
    }
}
