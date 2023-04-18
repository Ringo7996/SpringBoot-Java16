package vn.techmaster.demothymeleaf.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

import vn.techmaster.demothymeleaf.model.Country;
import vn.techmaster.demothymeleaf.model.Job;
import vn.techmaster.demothymeleaf.model.Person;
import vn.techmaster.demothymeleaf.model.Product;
import vn.techmaster.demothymeleaf.model.User;

@Repository
public class InMemoryRepository {
  private ArrayList<Product> products;
  private ArrayList<Country> countries;
  private ArrayList<Person> people;
  private ArrayList<User> users;

  private HashMap<String, List<Job>> jobs;

  public InMemoryRepository() {
    products = new ArrayList<>(List.of(new Product("Sony WX-MH1004", "Sony", 55000000),
        new Product("Nike Air", "Nike", 25000000),
        new Product("Dell M6800", "Dell", 105000000),
        new Product("Aris Pro", "VinSmart", 65000000),
        new Product("Logitech MX Master 2X", "Logitech", 32000000)));

    countries = new ArrayList<>(List.of(
        new Country("Vietnam", "VN"),
        new Country("China", "CN"),
        new Country("USA", "US"),
        new Country("France", "FR"),
        new Country("Singapore", "SG"),
        new Country("Japan", "JP")));

    people = new ArrayList<>(List.of(
        new Person("Cường", "Vietnam", "1975-11-27", "male"),
        new Person("John", "USA", "1979-10-27", "male"),
        new Person("Lara", "Italy", "1999-10-27", "female"),
        new Person("Anna", "Russia", "1998-02-01", "female"),
        new Person("Liên", "Vietnam", "1992-02-01", "female"),
        new Person("Ziang", "China", "2001-05-06", "female"),
        new Person("Persie", "Holland", "1978-11-20", "male")));

    users = new ArrayList<>(List.of(
        new User("Cường", "admin"),
        new User("Huy", "editor"),
        new User("Lan", "author"),
        new User("Long", "user"),
        new User("Joe", "user")));

jobs = new HashMap<>();
jobs.put("en", List.of(
    new Job("en", "doctor", "doctor"),
    new Job("en", "engineer", "engineer"),
    new Job("en", "staff", "staff"),
    new Job("en", "teacher", "teacher")));

jobs.put("vn", List.of(
    new Job("vn", "doctor", "bác sỹ"),
    new Job("vn", "engineer", "kỹ sư"),
    new Job("vn", "staff", "nhân viên"),
    new Job("vn", "teacher", "giáo viên")));

jobs.put("it", List.of(
    new Job("it", "doctor", "medico"),
    new Job("it", "engineer", "ingegnere"),
    new Job("it", "staff", "personale"),
    new Job("it", "teacher", "insegnante")));
  }

  public List<Product> getProducts() {
    return products;
  }

  public List<Country> getCountries() {
    return countries;
  }

  public List<Person> getPeople() {
    return people;
  }

  public List<User> getUsers() {
    return users;
  }

  public List<Job> getJobByLang(String lang) {
    return jobs.get(lang);
  }
}
