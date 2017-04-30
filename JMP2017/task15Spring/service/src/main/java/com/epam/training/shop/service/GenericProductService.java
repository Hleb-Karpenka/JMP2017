package com.epam.training.shop.service;

import com.epam.training.shop.model.Product;

public interface GenericProductService<T extends Product> extends BasicService<T, Long>{

}
