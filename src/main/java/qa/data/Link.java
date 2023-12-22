package qa.data;

import lombok.Getter;

@Getter
public class Link {

    private final String data;
    private final String url;

    public Link(String data, String url) {

        this.data = data;
        this.url = url;
    }
}
