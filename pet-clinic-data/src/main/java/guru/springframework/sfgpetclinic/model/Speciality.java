package guru.springframework.sfgpetclinic.model;

/**
 * Created by Ledio Papa on 7/15/19
 */
public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
