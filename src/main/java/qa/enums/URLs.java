package qa.enums;

public enum URLs {

    HOME_PAGE("https://bazylika-pszow.pl/"),
    PHOTO_GALLERY("https://bazylika-pszow.pl/galeria-zdjec/");

    private final String name;

    URLs(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
