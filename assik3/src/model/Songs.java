package model;

//здесь должна была быть аннотация @Data (((
public class Songs {
    private String name;
    private String artist;
    private Integer year;

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
        return hash;
    }
}
