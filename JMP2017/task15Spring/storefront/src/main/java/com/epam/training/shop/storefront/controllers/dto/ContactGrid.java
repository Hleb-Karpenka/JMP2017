package com.epam.training.shop.storefront.controllers.dto;

import java.util.List;

import com.epam.training.shop.model.Customer;


public class ContactGrid {
    private int totalPages;
    private int currentPage;
    private long totalRecords;
    private List<Customer> contactData;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Customer> getContactData() {
        return contactData;
    }

    public void setContactData(List<Customer> contactData) {
        this.contactData = contactData;
    }
}
