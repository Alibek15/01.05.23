package model;

//здесь должна была быть аннотация @Data (((
public class Songs {
    private String name;
    private String artist;
    private Integer year;
    
    public Songs(final String name, final String artist, final Integer year) {
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }
     @Override
    public int hashCode(){
        int hash=1;
        for (int i = 0; i <name.toCharArray().length ; i++) {
            hash= i+31*hash;
        }
        for (int i = 0; i <artist.toCharArray().length ; i++) {
            hash= i+31*hash;
        }
        hash+=year;

        return hash;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                '}';
    }
}
