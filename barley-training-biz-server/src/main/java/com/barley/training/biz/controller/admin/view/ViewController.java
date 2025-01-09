package com.barley.training.biz.controller.admin.view;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/project")
    public ModelAndView project() {
        return new ModelAndView("training/project");
    }

    @GetMapping("/course")
    public ModelAndView course() {
        return new ModelAndView("training/course");
    }

    @GetMapping("/course-detail")
    public ModelAndView courseDetail() {
        return new ModelAndView("training/course-detail");
    }
}
