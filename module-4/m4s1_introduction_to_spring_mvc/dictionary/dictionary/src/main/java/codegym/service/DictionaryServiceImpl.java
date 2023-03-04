package codegym.service;

import codegym.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public String findWord(String word) {
        return dictionaryRepository.findWord(word);
    }
}
