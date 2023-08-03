package ru.davydenko.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        var name = request.getParameter("name");
//        var surname = request.getParameter("surname");
//        System.out.println("Hello " + name + " " + surname);
//        return "first/hello";
//    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);
        double rezult;
        switch (action) {
            case "multiplication":
                rezult = a * b;
                break;
            case "division":
                rezult = a / (double) b;
                break;
            case "subtraction":
                rezult = a - b;
                break;
            case "addition":
                rezult = a + b;
                break;
            default:
                rezult = 0;
        }
        model.addAttribute("rezult", rezult);
        return "first/calculator";
    }
}
