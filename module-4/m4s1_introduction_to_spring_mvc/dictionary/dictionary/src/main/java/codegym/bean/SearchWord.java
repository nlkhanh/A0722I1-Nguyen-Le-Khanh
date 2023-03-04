package codegym.bean;

public class SearchWord {
    private String word;
    private String result;

    public SearchWord() {
    }

    public SearchWord(String word, String result) {
        this.word = word;
        this.result = result;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
