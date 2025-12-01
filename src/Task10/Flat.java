package Task10;

public class Flat {
    String district;
    int numRooms;
    double square;
    double squareKitchen;
    int price;

    public Flat(String district, int numRooms,
                double square, double squareKitchen, int price) {
        this.district = district;
        this.numRooms = numRooms;
        this.square = square;
        this.squareKitchen = squareKitchen;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Район: " + district +
                "\nКол-во комнат: " + numRooms +
                "\nОбщая площадь: " + square +
                "\nПлощадь кухни: " + squareKitchen +
                "\nЦена: " + price;
    }
}
