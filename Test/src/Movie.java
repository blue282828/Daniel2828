class Movie {
    String title, genre;
    int duration;

    Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return title + " | Genre: " + genre + " | Duration: " + duration + " mins";
    }
}