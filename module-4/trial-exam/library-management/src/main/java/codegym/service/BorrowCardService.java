package codegym.service;

import codegym.entity.BorrowCard;

import java.util.List;

public interface BorrowCardService {
    BorrowCard save(BorrowCard borrowCard);
    boolean existsById(String id);
    List<BorrowCard> findAll(String bookName, String studentName);
    BorrowCard findById(String id);
}
