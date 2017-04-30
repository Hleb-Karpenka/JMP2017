package com.epam.training.shop.storefront.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.training.shop.model.Category;
import com.epam.training.shop.model.Customer;
import com.epam.training.shop.service.CustomerService;
import com.epam.training.shop.storefront.controllers.dto.ContactGrid;
import com.epam.training.shop.storefront.controllers.dto.Message;
import com.google.common.collect.Lists;

@PreAuthorize("isAuthenticated()")
@RequestMapping("/customerpanel")
@Controller
public class CustomerController {
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("Listing customers");
		List<Customer> customers = customerService.findAll();
		uiModel.addAttribute("customers", customers);
		logger.info("No. of customers: " + customers.size());

		return "customerpanel/list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model uiModel) {
		Customer customer = customerService.findOne(id);
		uiModel.addAttribute("customer", customer);
		return "customerpanel/show";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
	public String update(@ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale,
			@RequestParam(value = "file", required = false) Part file) {
		logger.info("Updating customer account");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("message",
					new Message("error", messageSource.getMessage("contact_save_fail", new Object[] {}, locale)));
			uiModel.addAttribute("customer", customer);
			return "customerpanel/update";
		}
		uiModel.asMap().clear();
		// Process upload file
		processUploadFile(customer, file);
		/*
		 * redirectAttributes.addFlashAttribute("message", new
		 * Message("success", messageSource.getMessage("contact_save_success",
		 * new Object[]{}, locale)));
		 */
		customerService.save(customer);
		return "redirect:/customerpanel/"
				+ UrlUtil.encodeUrlPathSegment(customer.getId().toString(), httpServletRequest);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		uiModel.addAttribute("customer", customerService.findOne(id));
		return "customerpanel/update";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		customerService.delete(id);
		return "customerpanel/list";
	}

	private void processUploadFile(@ModelAttribute("customer") Customer customer,
			@RequestParam(value = "file", required = false) Part file) {
		if (file != null) {
			logger.info("File name: " + file.getName());
			logger.info("File size: " + file.getSize());
			logger.info("File content type: " + file.getContentType());
			byte[] fileContent = null;
			try {
				InputStream inputStream = file.getInputStream();
				if (inputStream == null)
					logger.info("File inputstream is null");
				fileContent = IOUtils.toByteArray(inputStream);
				customer.setPhoto(fileContent);
			} catch (IOException ex) {
				logger.error("Error saving uploaded file");
			}
			customer.setPhoto(fileContent);
		}
	}

	@RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("id") Long id) {
		Customer customer = customerService.findOne(id);

		if (customer.getPhoto() != null) {
			logger.info("Downloading photo for id: {} with size: {}", customer.getId(), customer.getPhoto().length);
		}

		return customer.getPhoto();
	}

	// @PreAuthorize("isAuthenticated()")
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(Model uiModel) {
		Customer customer = new Customer();
		uiModel.addAttribute("customer", customer);

		return "customerpanel/create";
	}

	@ResponseBody
	@RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces = "application/json")
	public ContactGrid listGrid(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sidx", required = false) String sortBy,
			@RequestParam(value = "sord", required = false) String order) {

		logger.info("Listing contacts for grid with page: {}, rows: {}", page, rows);
		logger.info("Listing contacts for grid with sort: {}, order: {}", sortBy, order);

		// Process order by
		Sort sort = null;
		String orderBy = sortBy;
		if (orderBy != null && orderBy.equals("birthDate"))
			orderBy = "birthDate";

		if (orderBy != null && order != null) {
			if (order.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, orderBy);
			} else
				sort = new Sort(Sort.Direction.ASC, orderBy);
		}

		// Constructs page request for current page
		// Note: page number for Spring Data JPA starts with 0, while jqGrid
		// starts with 1
		PageRequest pageRequest = null;

		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}

		Page<Customer> contactPage = customerService.findAll(pageRequest);

		// Construct the grid data that will return as JSON data
		ContactGrid contactGrid = new ContactGrid();

		contactGrid.setCurrentPage(contactPage.getNumber() + 1);
		contactGrid.setTotalPages(contactPage.getTotalPages());
		contactGrid.setTotalRecords(contactPage.getTotalElements());

		contactGrid.setContactData(Lists.newArrayList(contactPage.iterator()));

		return contactGrid;
	}

}
