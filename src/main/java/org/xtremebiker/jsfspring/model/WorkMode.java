package org.xtremebiker.jsfspring.model;

import com.google.common.base.Objects;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "work_mode")
public class WorkMode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkMode)) return false;
        WorkMode workMode = (WorkMode) o;
        return Objects.equal(id, workMode.id) &&
                Objects.equal(name, workMode.name) &&
                Objects.equal(description, workMode.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, description);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public void update(WorkMode new_game)
    {
        this.description = new_game.description;
        this.name = new_game.name;

    }
}
