package qa.enums;

public enum URLs {

    HOME_PAGE("https://bazylika-pszow.pl/");

    private final String name;

    URLs(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
