public class Player {
    private String name;
    private int number;
    public Player() {
        name = "Default";
        number = -1;
    }
    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public String playerInfo() {
        return "Player: " + name + ", #" + number;
    }
}