package com.epam.training.shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.epam.training.shop.model.Product;
import com.epam.training.shop.repository.GenericProductRepository;
import com.epam.training.shop.service.GenericProductService;

@Service
@Transactional
public class GenericProductServiceImpl<T extends Product> extends BasicServiceImpl<T, GenericProductRepository<T>, Long>
		implements GenericProductService<T> {
}
