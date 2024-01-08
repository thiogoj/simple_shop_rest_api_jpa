package joaquin.thiogo.shoprestapi.entity.util;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class UpdateAtListener {

    @PrePersist
    public void setLastCreatedAt(UpdateAtAware object) {
        object.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void setLastUpdatedAt(UpdateAtAware object) {
        object.setUpdatedAt(LocalDateTime.now());
    }

}
