package demo.domain;

public enum userPower {
    admin("admin", 1), master("master", 2), user("user", 3);
    private String name;
    private int rank;

    userPower(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }
}
