package com.pack1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack1.entity.Admin1;
import com.pack1.entity.Books;
import com.pack1.entity.User;
import com.pack1.services.AdminService;
import com.pack1.services.BookService;
import com.pack1.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController 
{
	@Autowired
	private UserService us;
	
	@Autowired
	private AdminService as;
	
	@Autowired
	private BookService bs;
	
	@GetMapping("/regpage")
	public String OpenRegPage(org.springframework.ui.Model model)
	{
		model.addAttribute("user", new User());
		return "register1"; 
	}
	
	@PostMapping("/regForm")
	public String SubmitRegistrationForm(@ModelAttribute("user") User user, Model model)
	{
		boolean status = us.RegisterUser(user);
		if (status) 
		{
			model.addAttribute("msg1","User Registered Successfully!");
		}
		else 
		{
			model.addAttribute("msg2","User Not Registered!");
		}
		return "confirmation";
	}
	
	@GetMapping("/loginPage")
	public String LoginPage(org.springframework.ui.Model model)
	{
		model.addAttribute("user", new User());
		return "register"; 
	}
	
	@GetMapping("/loginPage1")
	public String LoginPage1(org.springframework.ui.Model model)
	{
		model.addAttribute("user", new User());
		return "login"; 
	}
	
	@PostMapping("/loginForm")
	public String SubmitLoginForm(@ModelAttribute("user") User user, Model model)
	{
		User user1 = us.LoginUser(user.getMail(), user.getPassword()); 
		
		if (user1 != null)
		{
			model.addAttribute("msg1", user1.getName());
			return "profile";
		}
		else 
		{
			model.addAttribute("msg2","User Not Found!");
			return "login"; 
		}
	}
	
	@GetMapping("/profile1")
	public String userProfile(org.springframework.ui.Model model)
	{
		model.addAttribute("user", new User());
		return "profile"; 
	}
	
	@GetMapping("/logout")
	public String LogOutPage(HttpServletRequest req ,org.springframework.ui.Model model)
	{
		HttpSession hs =  req.getSession(false);
		if (hs != null) 
		{
			hs.invalidate();
		}
		return "redirect:/loginPage"; 
	}
	
	@GetMapping("/viewBooks")
	public String getBooksDetails(Model model) 
	{
	    List<Books> books = us.getAllBooks();
	    if (books.isEmpty()) 
	    {
	        System.out.println("No books found in the database.");
	    } 
	    else 
	    {
	        System.out.println("Books found: " + books.size());
	    }
	    model.addAttribute("books", books);
	    return "viewBooks"; 
	}
	
	@GetMapping("/buyBook/{id}")
	public String showBuyBookPage(@PathVariable("id") String bookId, Model model) 
	{
	    Books book = us.getBookById(bookId);
	    model.addAttribute("book", book);
	    return "buyBook";
	}
	
	@PostMapping("/submitBuy")
	public String submitBuy(@RequestParam("bookId") String bookId, @RequestParam("quantity") int quantity, Model model) 
	{
	    Books book = us.getBookById(bookId);
	    int price = Integer.parseInt(book.getPrice());
	    int totalPrice = price * quantity;
	    
	    int currentQty = Integer.parseInt(book.getQuantity());
	    int remainingQty = currentQty - quantity;

	    book.setQuantity(String.valueOf(remainingQty));
	    us.saveBook(book);
	    
	    model.addAttribute("book", book);
	    model.addAttribute("quantity", quantity);
	    model.addAttribute("totalPrice", totalPrice);

	    return "buyConfirmation"; 
	}
	
	@PostMapping("/AdminLoginForm")
	public String AdminLoginForm(@ModelAttribute("Admin1") Admin1 admin1, Model model)
	{
		Admin1 admin = as.LoginAdmin(admin1.getAemail(), admin1.getPassword()); 
		
		if (admin != null)
		{
			model.addAttribute("msg1", admin1.getAname());
			return "adminProfile";
		}
		else 
		{
			model.addAttribute("msg2","User Not Found!");
			return "adminLoginForm"; 
		}
	}
	
	@GetMapping("/AdminLogin")
	public String showAdminLoginForm(Model model) 
	{
	    model.addAttribute("Admin1", new Admin1());
	    return "adminLoginForm";
	}

	@GetMapping("/addBookForm")
    public String showAddBookForm(Model model) 
	{
        model.addAttribute("book", new Books());
        return "addBooks";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Books book, Model model) 
    { 
		boolean status = bs.AddBook(book);
		if (status) 
		{
			model.addAttribute("msg","Book Added Successfully!");
		}
		else 
		{
			model.addAttribute("msg","Somthing Wents Wrong!");
		}
		return "addBooks";
	}
	
    @GetMapping("/adminProfile")
	public String adhowAdminProfile(Model model) 
	{
	    model.addAttribute("Admin1", new Admin1());
	    return "adminProfile";
	}

    @GetMapping("/Logout1")
	public String LogOutPage1(HttpServletRequest req ,org.springframework.ui.Model model)
	{
		HttpSession hs =  req.getSession(false);
		if (hs != null) 
		{
			hs.invalidate();
		}
		return "redirect:/AdminLogin"; 
	}
    
    @GetMapping("/viewBooks1")
	public String getBooksDetailsforAdmin(Model model) 
	{
	    List<Books> books = us.getAllBooks();
	    if (books.isEmpty()) 
	    {
	        System.out.println("No books found in the database.");
	    } 
	    else 
	    {
	        System.out.println("Books found: " + books.size());
	    }
	    model.addAttribute("books", books);
	    return "adminViewBooks"; 
	}
    
    @GetMapping("/EditBook/{id}")
    public String editBook(@PathVariable("id") String bookId, Model model) 
    {
    	Books book = us.getBookById(bookId);
	    model.addAttribute("book", book);
	    return "editBookForm";
    }

    // Update book details
    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Books book) 
    {
        bs.saveBook(book);  // Save the updated book
        return "redirect:/viewBooks1";  // Redirect to the view books page after updating
    }

    @GetMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") String bookId) 
    {
        bs.deleteBookById(bookId);  // Delete the book by its ID
        return "redirect:/viewBooks1";  // Redirect to the view books page after deletion
    }

    
}