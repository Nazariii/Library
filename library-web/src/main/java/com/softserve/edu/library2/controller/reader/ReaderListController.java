package com.softserve.edu.library2.controller.reader;

import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.BookService;
import com.softserve.edu.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.softserve.edu.library2.dao.entities.Book;

import javax.validation.Valid;

/**
 * @author Dmytro Brylyuk.
 */
@Controller
@RequestMapping("/readers")
public class ReaderListController {

    @Autowired
    ReaderService readerService;
    @Autowired
    BookService bookService;

    @RequestMapping(value = {"/list_readers"}, method = RequestMethod.GET)
    public String  listReader(ModelMap modelMap) {
        List<Reader> readers = readerService.findAll();
        modelMap.addAttribute("readers", readers);
        return "/reader/ReaderList";
    }

    @RequestMapping(value = {"/list_readers_books"}, method = RequestMethod.GET)
    public String  listReaderBooks(ModelMap modelMap) {
        List<Reader> readers = readerService.findAll();
        Map<Reader, List<Book>> readerListMap = new HashMap<Reader, List<Book>>();
        for (Reader reader : readers) {
            try {
                readerListMap.put(reader, bookService.getBooksByReader(
                        reader.getFirstName(),
                        reader.getLastName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelMap.addAttribute("readerListMap", readerListMap);
        return "/reader/ReadersBookList";
    }

    @RequestMapping(value = {"/new_reader"}, method = RequestMethod.GET)
    public String newReader(ModelMap modelMap) {
        Reader reader = new Reader();
        modelMap.addAttribute("reader", reader);
        modelMap.addAttribute("edit", false);
        return "/reader/EditReader";
    }

    @RequestMapping(value = {"/new_reader"}, method = RequestMethod.POST)
    public String saveReader(@Valid Reader reader, BindingResult result, ModelMap modelMap) {


        readerService.save(reader);
        modelMap.addAttribute("success", "User" + reader.getFirstName() + " " + reader.getLastName() + " "
        + reader.getMiddleName() + " " + reader.getTelephone() + " " + reader.getBirthDate() + " registered successfully");
        return "redirect:/readers/list_readers";
    }

    @RequestMapping(value = {"/edit-reader-{id}"}, method = RequestMethod.GET)
    public String editReader (@PathVariable String id, ModelMap modelMap) {
        Reader reader = readerService.findById(Integer.valueOf(id));
        modelMap.addAttribute("reader", reader);
        modelMap.addAttribute("edit", true);
        return "/reader/EditReader";
    }

    @RequestMapping(value = {"/edit-reader-{id}"}, method = RequestMethod.POST)
    public String updateReader (@Valid Reader reader, BindingResult result, ModelMap modelMap, @PathVariable String id) {        readerService.update(reader);
        modelMap.addAttribute("success", "User" + reader.getFirstName() + " " + reader.getLastName() + " "
                + reader.getMiddleName() + " " + reader.getTelephone() + " " + reader.getBirthDate() + " update successfully");
        return "redirect:/readers/list_readers";
    }

    @RequestMapping(value = {"/delete-reader-{id}"}, method = RequestMethod.GET)
    public String deleteReader(@PathVariable String id){
        readerService.deleteById(Integer.valueOf(id));
        return "redirect:/readers/list_readers";
    }
}
