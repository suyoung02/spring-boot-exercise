package com.example.exercise1.Enum.Rating;

public enum Rating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private String code;

    private Rating(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Rating fromCode(String code) {
        switch (code) {
            case "G":
                return Rating.G;
            case "PG":
                return Rating.PG;
            case "PG-13":
                return Rating.PG_13;
            case "R":
                return Rating.R;
            case "NC-17":
                return Rating.NC_17;
            default:
                throw new IllegalArgumentException();
        }
    }
}
