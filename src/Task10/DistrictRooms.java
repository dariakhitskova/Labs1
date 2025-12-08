package Task10;

public class DistrictRooms {
    String district;
    int numRooms;
    int totalPrice;
    double totalSquare;

    public DistrictRooms(String district, int numRooms) {
        this.district = district;
        this.numRooms = numRooms;
        totalPrice = 0;
        totalSquare = 0;
    }

    public void addFlat(Flat f) {
        totalPrice += f.price;
        totalSquare += f.square;
    }

    public double avg() {
        return totalPrice / totalSquare;
    }

    @Override
    public String toString() {
        return "Район: " + district +
                "\nкомнат: " + numRooms +
                "\nобщая площадь: " + totalSquare +
                "\nобщая цена: " + totalPrice;
    }
}
