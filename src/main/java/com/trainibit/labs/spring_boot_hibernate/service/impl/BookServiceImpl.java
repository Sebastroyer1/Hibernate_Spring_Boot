package com.trainibit.labs.spring_boot_hibernate.service.impl;

import com.trainibit.labs.spring_boot_hibernate.model.Book;
import com.trainibit.labs.spring_boot_hibernate.service.BookService;
import com.trainibit.labs.spring_boot_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  //Marca la clase como un componente de servicio Spring.
public class BookServiceImpl implements BookService {

    // Save book
    @Override
    public Book saveBook(Book book) {  // Abre una sesión Hibernate y guarda la entidad libro.
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(book);

        transaction.commit();
        return book;
    }

    // Get book by id
    @Override
    public Optional getBookById(Long id) {  // Recupera un libro por su clave principal.
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class, id);

        transaction.commit();

        return Optional.of(id);
    }

    // Get all books
    @Override
    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Book> books = session.createQuery("FROM Book", Book.class).getResultList();
        transaction.commit();
        return books;
    }

    // Update book
    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class, id);

        book.setTitle(bookDetails.getTitle());
        book.setPrice(bookDetails.getPrice());
        session.update(book);
        transaction.commit();
        return bookDetails;
    }

    // Delete book
    @Override
    public void deleteBook(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book != null) {
            session.delete(book);
        }
        transaction.commit();
    }
}