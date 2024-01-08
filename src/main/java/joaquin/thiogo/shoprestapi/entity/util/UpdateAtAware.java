package joaquin.thiogo.shoprestapi.entity.util;

import java.time.LocalDateTime;

public interface UpdateAtAware {

    void setUpdatedAt(LocalDateTime updatedAt);

    void setCreatedAt(LocalDateTime createdAt);

}
