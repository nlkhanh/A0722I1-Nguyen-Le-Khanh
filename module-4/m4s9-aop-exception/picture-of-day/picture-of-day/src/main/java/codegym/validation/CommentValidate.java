package codegym.validation;


import codegym.model.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentValidate {
    private static final List<String> BAD_WORDS = new ArrayList<>();
    private String badWord;


    static {
        BAD_WORDS.add("fuck");
        BAD_WORDS.add("bitch");
        BAD_WORDS.add("penis");
        BAD_WORDS.add("bullshit");
        BAD_WORDS.add("cum");
        BAD_WORDS.add("pussy");
        BAD_WORDS.add("ass");
    }

    public String getBadWord() {
        return badWord;
    }

    public boolean haveBadWords(Comment comment) {
        for (String w : BAD_WORDS) {
            if (comment.getFeedBack().contains(w)) {
                this.badWord = comment.toString();
                return true;
            }
        }
        return false;
    }
}
