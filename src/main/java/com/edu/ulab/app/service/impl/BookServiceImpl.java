package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.facade.UserDataFacade;
import com.edu.ulab.app.service.BookService;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import com.edu.ulab.app.web.response.UserBookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl implements BookService {



    @Override
    public BookDto createBook(BookDto bookDto) {
        long id = System.currentTimeMillis();
        bookDto.setId(id);
        Storage storage = new Storage();
        User user =new User(
                bookDto.getUserId()

        );
        Book book = new Book(
                user,
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPageCount()
        );
        storage.addBookToUser(bookDto.getUserId(), book);
      //  storage.printBook();

        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        bookDto.getUserId();


        return bookDto;
    }

    @Override
    public BookDto getBookById(Long id) {
        return null;
    }

    @Override
    public void deleteBookById(Long id) {

    }
}
