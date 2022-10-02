package com.sinnotech.hotel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.util.Constants;
import com.sinnotech.hotel.util.Message;

@Controller
@RequestMapping("admin/book")
public class AdminBookDetailManagementController {

	@Autowired
	BookService bookService;
	private BookingsDTO bookDto;

	@RequestMapping(value = "detail/{room}", method = RequestMethod.GET)
	public String detail(Model model, @PathVariable("room") Integer roomID) {
		BookingsDTO bookDto = bookService.getBookInfo(roomID);
		this.bookDto = bookDto;
		model.addAttribute("book", bookDto);
		return BaseController.ADMIN_DETAIL_PATH;
	}

	@RequestMapping(value = "update/{bookID}")
	public String getUpdate(HttpServletRequest rq,BookingsDTO bookingsDTO, Model model) {
		if (rq.getMethod().equalsIgnoreCase("GET")) {
			model.addAttribute("form", Constants.UPDATE_FORM);
		} else if (rq.getMethod().equalsIgnoreCase("POST")) {
			bookingsDTO = bookService.updateBookInfo(bookingsDTO);
			if (bookingsDTO != null) {
//				BookingsOutput bookingsOutput = bookingsHelper(bookingsDTO);
				model.addAttribute("message", Message.UPDATE_SUCCEED);
				bookDto = bookingsDTO;
			} else {
				model.addAttribute("message", Message.DELETE_FAIL);
			}
		} else {
			model.addAttribute("message", Message.HTTPMethodError);
		}
		model.addAttribute("book", bookDto);
		return BaseController.ADMIN_DETAIL_PATH;
	}

	@RequestMapping(value = "delete/{room}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable("roomID") Integer roomID) {
		boolean result = bookService.deleteBookInfo(roomID);
		model.addAttribute("form", Constants.DELETE_FORM);
		model.addAttribute("message", result == true ? Message.DELETE_SUCCEED : Message.DELETE_FAIL);
		return result == true ? BaseController.ADMIN_LIST_PATH : BaseController.ADMIN_DETAIL_PATH;
	}
}
