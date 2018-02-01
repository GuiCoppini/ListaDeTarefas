package EstudandoJS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public String asqwhe() {
        System.out.println("AAAAAAAAawewa");
        return "test";
    }

    @RequestMapping(value = "/bbb", method = RequestMethod.GET)
    public ModelAndView asd() {
        ModelAndView mv = new ModelAndView("test.html");
        return mv;
    }
}
