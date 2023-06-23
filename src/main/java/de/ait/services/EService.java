package de.ait.services;

import java.util.List;

public interface EService <T>{
    List<T> getProducts();
    List <T> sortByPrice();
    List<T> filterByValue(String value);

}
