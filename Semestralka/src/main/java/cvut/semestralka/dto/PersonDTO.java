package cvut.semestralka.dto;

public abstract class PersonDTO extends AbstractDTO{
    
    protected String firstName, lastName;

    public PersonDTO(String firstName, String lastName, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  
}
