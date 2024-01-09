package joaquin.thiogo.shoprestapi.entity.util;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
import java.util.Date;

public class UpdateAtListener {

    @PrePersist
    public void setLastCreatedAt(UpdateAtAware object) {
        object.setCreatedAt(new Date());
    }

    @PreUpdate
    public void setLastUpdatedAt(UpdateAtAware object) {
        object.setUpdatedAt(new Date());
    }

}
