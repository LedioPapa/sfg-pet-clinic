package guru.springframework.sfgpetclinic.model;

/**
 * Created by ledio on 5/7/19
 */
public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
