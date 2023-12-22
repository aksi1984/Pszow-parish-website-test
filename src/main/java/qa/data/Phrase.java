package qa.data;

import lombok.Getter;

@Getter
public class Phrase {

    private final String phrase;
    private final String message;

    public Phrase(String phrase, String message) {

        this.phrase = phrase;
        this.message = message;
    }
}
