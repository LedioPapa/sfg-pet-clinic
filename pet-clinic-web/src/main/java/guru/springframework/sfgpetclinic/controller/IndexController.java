package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ledio on 5/23/19
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }
}
