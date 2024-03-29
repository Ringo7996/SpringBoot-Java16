package vn.techmaster.demoupload.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalController {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxUploadSizeException(MaxUploadSizeExceededException e, Model model){
        model.addAttribute("errorMessage","File is too large. Detail: "  +e.getMessage());

        return "failure";
    }

}
