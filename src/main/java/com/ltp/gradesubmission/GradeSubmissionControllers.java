package com.ltp.gradesubmission;

import Models.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeSubmissionControllers {

    List<Grade> studentGrades =  new ArrayList<>();


    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades",studentGrades);

        return "grades";
    }
    public Integer getGradeIndex(String id){
        for (int i = 0;i<studentGrades.size();i++){
            if(studentGrades.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1000;
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false
    ) String id){
        Grade grade;
        if(getGradeIndex(id) == -1000){
            grade =new Grade();
        }else{
            grade =studentGrades.get(getGradeIndex(id));
        }
        model.addAttribute("grade",grade);

        return "form";
    }
@PostMapping("/handlesubmit")
    public String submitForm(Grade grade){
        int index =getGradeIndex(grade.getName());
        if(index==-1000){
            studentGrades.add(grade);
        }
        else{
            studentGrades.set(index,grade);
        }




        return "redirect:/grades";
}
}
