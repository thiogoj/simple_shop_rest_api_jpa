package joaquin.thiogo.shoprestapi.entity.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public class AuditableEntity<T extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    @Column(name = "created_at")
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at")
    @JsonIgnore
    private Date updatedAt;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
