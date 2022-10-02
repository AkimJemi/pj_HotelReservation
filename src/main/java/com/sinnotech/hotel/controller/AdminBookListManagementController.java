package com.sinnotech.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.service.OptionsService;

@Controller
public class AdminBookListManagementController {

	@Autowired
	BookService bookService;
	@Autowired
	OptionsService optionsService;

	private List<OptionsDTO> options;

	@RequestMapping(value = "/admin/book/list", method = RequestMethod.GET)
	public String init(Model model, Paging page) {

		BookInfo bookInput = new BookInfo();
		bookInput = bookService.getAllBookList();
		options = bookInput.getOptions();
		model.addAttribute("options", bookInput.getOptions());
		model.addAttribute("paging", bookInput.getPaging());
		model.addAttribute("bookList", bookInput.getBookDTOList());
		return BaseController.ADMIN_LIST_PATH;
	}

	@RequestMapping(value = "/admin/book/list", method = RequestMethod.POST)
	public String search(Model model, Paging page, OptionsDTO options) {
		BookInfo bookInput = bookService.searchBookList(page);
		System.out.println("test : " + options.getBookingCode());
		model.addAttribute("selectedOption", options.getBookingCode());
		model.addAttribute("options",
				this.options == null ? options == null ? optionsService.getBookingOptions() : options : this.options);
		model.addAttribute("paging", bookInput.getPaging());
		model.addAttribute("bookList", bookInput.getBookDTOList());
		return BaseController.ADMIN_LIST_PATH;
	}

}
