package de.ait.services;

import de.ait.models.Product;

import java.util.List;

public interface EService <T>{
    List<T> getProducts();
    void sortByPrice();
}
