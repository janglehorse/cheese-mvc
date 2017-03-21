package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adminbackup on 3/7/17.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {
//Modify the static cheeses list to be a HashMap

   static ArrayList<Cheese> cheeses = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName,
                                       @RequestParam String description) {

            Cheese newCheese = new Cheese();
            Cheese cheese = newCheese;
            newCheese.setName(cheeseName);
            newCheese.setDescription(description);
            cheeses.add(cheese);
            return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Delete Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(@RequestParam ArrayList<String> cheese){
        for(String s : cheese){
            cheeses.remove(s);
        }
        return "redirect:";
    }

}
