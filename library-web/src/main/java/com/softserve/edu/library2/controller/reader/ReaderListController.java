package com.softserve.edu.library2.controller.reader;

import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.BookService;
import com.softserve.edu.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.softserve.edu.library2.dao.entities.Book;
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
        modelMap.addAttribute("readers", readers);
        modelMap.addAttribute("readerListMap", readerListMap);
        return "/reader/ReadersBookList";
    }


    @RequestMapping(value = {"/edit_reader"}, method = RequestMethod.GET)
    public String edit (ModelMap modelMap) {
        return "/reader/EditReader";
    }

    @RequestMapping(value = {"/new_reader"}, method = RequestMethod.GET)
    public String addReader(ModelMap modelMap) {
        Reader reader = new Reader();
        modelMap.addAttribute("reader", reader);
        modelMap.addAttribute("add", false);
        return "creatingreader";
    }
}
