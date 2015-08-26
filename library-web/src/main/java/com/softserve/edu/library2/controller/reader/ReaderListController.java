package com.softserve.edu.library2.controller.reader;

import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Dmytro Brylyuk.
 */
@Controller
@RequestMapping("/")
public class ReaderListController {

    @Autowired
    ReaderService readerService;

    @RequestMapping(value = {"/list_readers"}, method = RequestMethod.GET)
    public String  listAuthor(ModelMap modelMap) {
        List<Reader> readers = readerService.findAll();
        modelMap.addAttribute("readers", readers);
        return "/reader/ReaderList";
    }

    @RequestMapping(value = {"/edit_reader"}, method = RequestMethod.GET)
    public String edit (ModelMap modelMap) {
        return "edit";
    }

    @RequestMapping(value = {"/new_reader"}, method = RequestMethod.GET)
    public String addReader(ModelMap modelMap) {
        Reader reader = new Reader();
        modelMap.addAttribute("reader", reader);
        modelMap.addAttribute("add", false);
        return "creatingreader";
    }
}
