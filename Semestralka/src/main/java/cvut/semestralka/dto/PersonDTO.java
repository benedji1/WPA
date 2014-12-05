package cvut.semestralka.dto;

public abstract class PersonDTO extends AbstractDTO{
    
    protected String first_name, last_name;

    public PersonDTO(String first_name, String last_name, Long id) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public PersonDTO(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }
    
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }  
}
