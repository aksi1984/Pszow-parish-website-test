package qa.data;

import lombok.Getter;

@Getter
public class LinkData {

    private final String data;
    private final String linkName;
    private final String url;

    public LinkData(String data, String linkName, String url) {

        this.data = data;
        this.linkName = linkName;
        this.url = url;
    }
}
