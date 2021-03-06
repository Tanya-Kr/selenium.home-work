package petclinic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Type {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(id, type.id) &&
                Objects.equals(name, type.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
}
