package codegym.library.service.impl;

import codegym.library.entity.BorrowCard;
import codegym.library.repository.BorrowCardRepository;
import codegym.library.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public BorrowCard findById(String id) {
        return borrowCardRepository.findById(id).orElse(null);
    }

    @Override
    public Page<BorrowCard> findAllBorrow(Pageable pageable) {
        return borrowCardRepository.findAllByBorrowingIsTrue(pageable);
    }

    @Override
    public Page<BorrowCard> findAllBorrowSearch(Pageable pageable, String bookName, String studentName) {
        return borrowCardRepository.findAllByBorrowingSearch(pageable, bookName, studentName);
    }

    @Override
    public boolean existsById(String id) {
        return borrowCardRepository.existsById(id);
    }
}
