package cvut.semestralka.bo;

import java.io.Serializable;

public class FilmId implements Serializable{
    private Integer release_year;
    private String title;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.release_year != null ? this.release_year.hashCode() : 0);
        return hash;
    }
    
    public FilmId(){}
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FilmId other = (FilmId) obj;
        if (this.release_year != other.release_year && (this.release_year == null || !this.release_year.equals(other.release_year))) {
            return false;
        }
        if (this.title != other.title && (this.title == null || !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }
}
