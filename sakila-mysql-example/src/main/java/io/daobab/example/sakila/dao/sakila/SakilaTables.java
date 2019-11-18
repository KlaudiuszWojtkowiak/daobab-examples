package io.daobab.example.sakila.dao.sakila;

import io.daobab.parser.ParserGeneral;import io.daobab.example.sakila.dao.sakila.table.Actor;
import io.daobab.example.sakila.dao.sakila.table.Address;
import io.daobab.example.sakila.dao.sakila.table.Category;
import io.daobab.example.sakila.dao.sakila.table.City;
import io.daobab.example.sakila.dao.sakila.table.Country;
import io.daobab.example.sakila.dao.sakila.table.Customer;
import io.daobab.example.sakila.dao.sakila.table.Film;
import io.daobab.example.sakila.dao.sakila.table.FilmActor;
import io.daobab.example.sakila.dao.sakila.table.FilmCategory;
import io.daobab.example.sakila.dao.sakila.table.FilmText;
import io.daobab.example.sakila.dao.sakila.table.Inventory;
import io.daobab.example.sakila.dao.sakila.table.Language;
import io.daobab.example.sakila.dao.sakila.table.Payment;
import io.daobab.example.sakila.dao.sakila.table.Rental;
import io.daobab.example.sakila.dao.sakila.table.Staff;
import io.daobab.example.sakila.dao.sakila.table.Store;
import io.daobab.example.sakila.dao.sakila.view.ActorInfo;
import io.daobab.example.sakila.dao.sakila.view.CustomerList;
import io.daobab.example.sakila.dao.sakila.view.FilmList;
import io.daobab.example.sakila.dao.sakila.view.NicerButSlowerFilmList;
import io.daobab.example.sakila.dao.sakila.view.SalesByFilmCategory;
import io.daobab.example.sakila.dao.sakila.view.SalesByStore;
import io.daobab.example.sakila.dao.sakila.view.StaffList;


public interface SakilaTables extends ParserGeneral{






	Actor tabActor= new Actor();





	Address tabAddress= new Address();





	Category tabCategory= new Category();





	City tabCity= new City();





	Country tabCountry= new Country();





	Customer tabCustomer= new Customer();





	Film tabFilm= new Film();





	FilmActor tabFilmActor= new FilmActor();





	FilmCategory tabFilmCategory= new FilmCategory();





	FilmText tabFilmText= new FilmText();





	Inventory tabInventory= new Inventory();





	Language tabLanguage= new Language();





	Payment tabPayment= new Payment();





	Rental tabRental= new Rental();





	Staff tabStaff= new Staff();





	Store tabStore= new Store();





	ActorInfo viewActorInfo= new ActorInfo();





	CustomerList viewCustomerList= new CustomerList();





	FilmList viewFilmList= new FilmList();





	NicerButSlowerFilmList viewNicerButSlowerFilmList= new NicerButSlowerFilmList();





	SalesByFilmCategory viewSalesByFilmCategory= new SalesByFilmCategory();





	SalesByStore viewSalesByStore= new SalesByStore();





	StaffList viewStaffList= new StaffList();


}