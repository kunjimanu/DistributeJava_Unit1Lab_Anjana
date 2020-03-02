package edu.wctc.controller;

import edu.wctc.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String showHomePage(){
        return "index";
    }

    @RequestMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    //show the search page
    @RequestMapping("/searchBooks")
    public String showSearchResultsPage(){
        System.out.println("In the showSearchResultsPage method ");
        return "search_books";
    }

    //show the search results page
    @RequestMapping("/searchresults")
    public String showSearchPage(Model model){
        Book theBook = new Book();
        theBook.setBookid(2);
        theBook.setTitle("Alice in wonderland");
        theBook.setIsbn(11111);
        theBook.setCategory("Fantasy");
        model.addAttribute("book", theBook);
        return "searchResults";
    }

    //show the list of books page
    @RequestMapping("/listbooks")
    public String showBookListPage(Model model){
        Book theBook = new Book();
        theBook.setBookid(2);
        theBook.setTitle("Alice in wonderland");
        theBook.setIsbn(11111);
        theBook.setCategory("Fantasy");
        model.addAttribute("book", theBook);
        return "list2";
    }



}
