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

/**
 * Comment:<br>
 * <pre>
 * <u> Name         Type       Size  DBName       DBType     Description </u> *  ActorId(PK)  Integer    5   actor_id     SMALLINT     *  FirstName    String     45  first_name   VARCHAR      *  LastName     String     45  last_name    VARCHAR      *  LastUpdate   Timestamp  19  last_update  TIMESTAMP    * </pre>
*/
	Actor tabActor= new Actor();
/**
 * Comment:<br>
 * <pre>
 * <u> Name           Type       Size   DBName       DBType     Description </u> *  Address        String     50     address      VARCHAR      *  Address2       String     50     address2     VARCHAR      *  AddressId(PK)  Integer    5      address_id   SMALLINT     *  CityId         Integer    5      city_id      SMALLINT     *  District       String     20     district     VARCHAR      *  LastUpdate     Timestamp  19     last_update  TIMESTAMP    *  Location       byte[]     65535  location     BINARY       *  Phone          String     20     phone        VARCHAR      *  PostalCode     String     10     postal_code  VARCHAR      * </pre>
*/
	Address tabAddress= new Address();
/**
 * Comment:<br>
 * <pre>
 * <u> Name             Type       Size  DBName       DBType     Description </u> *  CategoryId(PK)   Integer    3   category_id  TINYINT      *  LastUpdate       Timestamp  19  last_update  TIMESTAMP    *  NameTypeString1  String     25  name         VARCHAR      * </pre>
*/
	Category tabCategory= new Category();
/**
 * Comment:<br>
 * <pre>
 * <u> Name        Type       Size  DBName       DBType     Description </u> *  City        String     50  city         VARCHAR      *  CityId(PK)  Integer    5   city_id      SMALLINT     *  CountryId   Integer    5   country_id   SMALLINT     *  LastUpdate  Timestamp  19  last_update  TIMESTAMP    * </pre>
*/
	City tabCity= new City();
/**
 * Comment:<br>
 * <pre>
 * <u> Name           Type       Size  DBName       DBType     Description </u> *  Country        String     50  country      VARCHAR      *  CountryId(PK)  Integer    5   country_id   SMALLINT     *  LastUpdate     Timestamp  19  last_update  TIMESTAMP    * </pre>
*/
	Country tabCountry= new Country();
/**
 * Comment:<br>
 * <pre>
 * <u> Name            Type       Size  DBName       DBType     Description </u> *  Active          Boolean    1   active       BIT          *  AddressId       Integer    5   address_id   SMALLINT     *  CreateDate      Timestamp  19  create_date  TIMESTAMP    *  CustomerId(PK)  Integer    5   customer_id  SMALLINT     *  Email           String     50  email        VARCHAR      *  FirstName       String     45  first_name   VARCHAR      *  LastName        String     45  last_name    VARCHAR      *  LastUpdate      Timestamp  19  last_update  TIMESTAMP    *  StoreId         Integer    3   store_id     TINYINT      * </pre>
*/
	Customer tabCustomer= new Customer();
/**
 * Comment:<br>
 * <pre>
 * <u> Name                Type        Size   DBName                DBType       Description </u> *  Description         String      65535  description           LONGVARCHAR    *  FilmId(PK)          Integer     5      film_id               SMALLINT       *  LanguageId          Integer     3      language_id           TINYINT        *  LastUpdate          Timestamp   19     last_update           TIMESTAMP      *  Length              Integer     5      length                SMALLINT       *  OriginalLanguageId  Integer     3      original_language_id  TINYINT        *  Rating              String      5      rating                CHAR           *  ReleaseYear         Date        4      release_year          DATE           *  RentalDuration      Integer     3      rental_duration       TINYINT        *  RentalRate          BigDecimal  4      rental_rate           DECIMAL        *  ReplacementCost     BigDecimal  5      replacement_cost      DECIMAL        *  SpecialFeatures     String      54     special_features      CHAR           *  Title               String      255    title                 VARCHAR        * </pre>
*/
	Film tabFilm= new Film();
/**
 * Comment:<br>
 * <pre>
 * <u> Name        Type       Size  DBName       DBType     Description </u> *  ActorId     Integer    5   actor_id     SMALLINT     *  FilmId(PK)  Integer    5   film_id      SMALLINT     *  LastUpdate  Timestamp  19  last_update  TIMESTAMP    * </pre>
*/
	FilmActor tabFilmActor= new FilmActor();
/**
 * Comment:<br>
 * <pre>
 * <u> Name            Type       Size  DBName       DBType     Description </u> *  CategoryId(PK)  Integer    3   category_id  TINYINT      *  FilmId          Integer    5   film_id      SMALLINT     *  LastUpdate      Timestamp  19  last_update  TIMESTAMP    * </pre>
*/
	FilmCategory tabFilmCategory= new FilmCategory();
/**
 * Comment:<br>
 * <pre>
 * <u> Name         Type     Size   DBName       DBType       Description </u> *  Description  String   65535  description  LONGVARCHAR    *  FilmId(PK)   Integer  5      film_id      SMALLINT       *  Title        String   255    title        VARCHAR        * </pre>
*/
	FilmText tabFilmText= new FilmText();
/**
 * Comment:<br>
 * <pre>
 * <u> Name             Type        Size  DBName        DBType     Description </u> *  FilmId           Integer     5   film_id       SMALLINT     *  InventoryId(PK)  BigDecimal  8   inventory_id  INTEGER      *  LastUpdate       Timestamp   19  last_update   TIMESTAMP    *  StoreId          Integer     3   store_id      TINYINT      * </pre>
*/
	Inventory tabInventory= new Inventory();
/**
 * Comment:<br>
 * <pre>
 * <u> Name             Type       Size  DBName       DBType     Description </u> *  LanguageId(PK)   Integer    3   language_id  TINYINT      *  LastUpdate       Timestamp  19  last_update  TIMESTAMP    *  NameTypeString2  String     20  name         CHAR         * </pre>
*/
	Language tabLanguage= new Language();
/**
 * Comment:<br>
 * <pre>
 * <u> Name           Type        Size  DBName        DBType     Description </u> *  Amount         BigDecimal  5   amount        DECIMAL      *  CustomerId     Integer     5   customer_id   SMALLINT     *  LastUpdate     Timestamp   19  last_update   TIMESTAMP    *  PaymentDate    Timestamp   19  payment_date  TIMESTAMP    *  PaymentId(PK)  Integer     5   payment_id    SMALLINT     *  RentalId       BigDecimal  10  rental_id     INTEGER      *  StaffId        Integer     3   staff_id      TINYINT      * </pre>
*/
	Payment tabPayment= new Payment();
/**
 * Comment:<br>
 * <pre>
 * <u> Name          Type        Size  DBName        DBType     Description </u> *  CustomerId    Integer     5   customer_id   SMALLINT     *  InventoryId   BigDecimal  8   inventory_id  INTEGER      *  LastUpdate    Timestamp   19  last_update   TIMESTAMP    *  RentalDate    Timestamp   19  rental_date   TIMESTAMP    *  RentalId(PK)  BigDecimal  10  rental_id     INTEGER      *  ReturnDate    Timestamp   19  return_date   TIMESTAMP    *  StaffId       Integer     3   staff_id      TINYINT      * </pre>
*/
	Rental tabRental= new Rental();
/**
 * Comment:<br>
 * <pre>
 * <u> Name         Type       Size   DBName       DBType         Description </u> *  Active       Boolean    1      active       BIT              *  AddressId    Integer    5      address_id   SMALLINT         *  Email        String     50     email        VARCHAR          *  FirstName    String     45     first_name   VARCHAR          *  LastName     String     45     last_name    VARCHAR          *  LastUpdate   Timestamp  19     last_update  TIMESTAMP        *  Password     String     40     password     VARCHAR          *  Picture      byte[]     65535  picture      LONGVARBINARY    *  StaffId(PK)  Integer    3      staff_id     TINYINT          *  StoreId      Integer    3      store_id     TINYINT          *  Username     String     16     username     VARCHAR          * </pre>
*/
	Staff tabStaff= new Staff();
/**
 * Comment:<br>
 * <pre>
 * <u> Name            Type       Size  DBName            DBType     Description </u> *  AddressId       Integer    5   address_id        SMALLINT     *  LastUpdate      Timestamp  19  last_update       TIMESTAMP    *  ManagerStaffId  Integer    3   manager_staff_id  TINYINT      *  StoreId(PK)     Integer    3   store_id          TINYINT      * </pre>
*/
	Store tabStore= new Store();
/**
 * Comment:VIEW<br>
 * <pre>
 * <u> Name       Type     Size   DBName      DBType       Description </u> *  ActorId    Integer  5      actor_id    SMALLINT       *  FilmInfo   String   65535  film_info   LONGVARCHAR    *  FirstName  String   45     first_name  VARCHAR        *  LastName   String   45     last_name   VARCHAR        * </pre>
*/
	ActorInfo viewActorInfo= new ActorInfo();
/**
 * Comment:VIEW<br>
 * <pre>
 * <u> Name             Type     Size  DBName    DBType    Description </u> *  Address          String   50  address   VARCHAR     *  City             String   50  city      VARCHAR     *  Country          String   50  country   VARCHAR     *  IdTypeInteger1   Integer  5   ID        SMALLINT    *  NameTypeString1  String   91  name      VARCHAR     *  Notes            String   6   notes     VARCHAR     *  Phone            String   20  phone     VARCHAR     *  Sid              Integer  3   SID       TINYINT     *  Zipcode          String   10  zip code  VARCHAR     * </pre>
*/
	CustomerList viewCustomerList= new CustomerList();
/**
 * Comment:VIEW<br>
 * <pre>
 * <u> Name         Type        Size   DBName       DBType       Description </u> *  Actors       String      65535  actors       LONGVARCHAR    *  Category     String      25     category     VARCHAR        *  Description  String      65535  description  LONGVARCHAR    *  Fid          Integer     5      FID          SMALLINT       *  Length       Integer     5      length       SMALLINT       *  Price        BigDecimal  4      price        DECIMAL        *  Rating       String      5      rating       CHAR           *  Title        String      255    title        VARCHAR        * </pre>
*/
	FilmList viewFilmList= new FilmList();
/**
 * Comment:VIEW<br>
 * <pre>
 * <u> Name         Type        Size   DBName       DBType       Description </u> *  Actors       String      65535  actors       LONGVARCHAR    *  Category     String      25     category     VARCHAR        *  Description  String      65535  description  LONGVARCHAR    *  Fid          Integer     5      FID          SMALLINT       *  Length       Integer     5      length       SMALLINT       *  Price        BigDecimal  4      price        DECIMAL        *  Rating       String      5      rating       CHAR           *  Title        String      255    title        VARCHAR        * </pre>
*/
	NicerButSlowerFilmList viewNicerButSlowerFilmList= new NicerButSlowerFilmList();
/**
 * Comment:VIEW<br>
 * <pre>
 * <u> Name        Type        Size  DBName       DBType   Description </u> *  Category    String      25  category     VARCHAR    *  TotalSales  BigDecimal  27  total_sales  DECIMAL    * </pre>
*/
	SalesByFilmCategory viewSalesByFilmCategory= new SalesByFilmCategory();
/**
 * Comment:VIEW<br>
 * <pre>
 * <u> Name        Type        Size  DBName       DBType   Description </u> *  Manager     String      91   manager      VARCHAR    *  Store       String      101  store        VARCHAR    *  TotalSales  BigDecimal  27   total_sales  DECIMAL    * </pre>
*/
	SalesByStore viewSalesByStore= new SalesByStore();
/**
 * Comment:VIEW<br>
 * <pre>
 * <u> Name             Type     Size  DBName    DBType   Description </u> *  Address          String   50  address   VARCHAR    *  City             String   50  city      VARCHAR    *  Country          String   50  country   VARCHAR    *  IdTypeInteger2   Integer  3   ID        TINYINT    *  NameTypeString1  String   91  name      VARCHAR    *  Phone            String   20  phone     VARCHAR    *  Sid              Integer  3   SID       TINYINT    *  Zipcode          String   10  zip code  VARCHAR    * </pre>
*/
	StaffList viewStaffList= new StaffList();


}