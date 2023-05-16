package codegym.service.impl;

import codegym.entity.BorrowCard;
import codegym.repository.BorrowCardRepository;
import codegym.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BorrowCardServiceImpl implements BorrowCardService {
    @Autowired
    private BorrowCardRepository borrowCardRepository;

    @Override
    public BorrowCard save(BorrowCard borrowCard) {
        return borrowCardRepository.save(borrowCard);
    }

    @Override
    public boolean existsById(String id) {
        return borrowCardRepository.existsById(id);
    }

    @Override
    public List<BorrowCard> findAll(String bookName, String studentName) {
        return borrowCardRepository.findAllSearch(bookName, studentName);
    }

    @Override
    public BorrowCard findById(String id) {
        return borrowCardRepository.findById(id).orElse(null);
    }
}
