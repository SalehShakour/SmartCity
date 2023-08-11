package vehicles.concrete;

public class Plaque {
    private Character letter;
    private Integer number;

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String res = new String();
        res = res.concat(String.valueOf(number / 100000)).concat(letter.toString()).
                concat(String.valueOf((number % 100000) / 100)).concat(String.valueOf(number % 100));
        return res;
    }
}
