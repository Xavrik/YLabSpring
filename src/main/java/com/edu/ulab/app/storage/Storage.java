package com.edu.ulab.app.storage;

import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;
import org.hibernate.annotations.Cache;
import org.mapstruct.control.MappingControl;

import java.util.*;
import java.util.stream.Stream;

public class Storage {
    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции

    final  List<User> users = new LinkedList<>();
    Map<Long , List<Book>> books = new HashMap<>();


    public void addUser (User user ){
        users.add(user);

    }
    public void addBookToUser (Long id, Book book){
        books.put(id, Arrays.asList(book));
    }



    public Optional<User> getUsersName (String fullname, String title){
        printUser();
       return  users.stream()

               .filter(n -> n.getFullName().equals(fullname) && n.getTitle().equals(title))

                .findAny()
                ;

    }


//    public User getById(int id){
//        return users.stream()
//                .anyMatch(k -> k.getId()==id);
//
//        return User;
//
//    }
    public void deliteUserById (Long id){

        Collection<User> collection = Arrays.asList();
        collection.removeIf(user -> id == user.getId());
    }



    public void printUser(){
        for (User us: users ) {
            System.out.println("User - " + us);
        }
    }
    public void printBook(){
        for(Map.Entry<Long, List<Book>> e : books.entrySet()){
            for(Book e1 : e.getValue())
                System.out.println("Book Map: " + ", ID User: " + e.getKey() +
                        ",  Book ID" + + e1.getId() +
                        ", Author: " + e1.getAuthor() +
                         ", Title: " + e1.getTitle() +
                        ", Page Count: " + e1.getPageCount() +
                        ", User: " + e1.getUser()
                );
        }
    }



}
