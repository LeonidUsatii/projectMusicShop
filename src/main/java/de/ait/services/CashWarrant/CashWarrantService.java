package de.ait.services.CashWarrant;

import de.ait.models.Book;
import de.ait.models.CashWarrant;

import de.ait.models.Order;
import de.ait.services.EService;

import java.util.List;

public interface CashWarrantService  {

     List<CashWarrant> getOrder();

     double getSumOfPrice();

}
