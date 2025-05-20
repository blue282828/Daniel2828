class Studio {
    int number;
    boolean isBooked;

    Studio(int number) {
        this.number = number;
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "Studio " + number + " - " + (isBooked ? "Booked" : "Available");
    }
}