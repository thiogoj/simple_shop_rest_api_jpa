package joaquin.thiogo.shoprestapi.entity.util;

import java.time.LocalDateTime;
import java.util.Date;

public interface UpdateAtAware {

    void setUpdatedAt(Date updatedAt);

    void setCreatedAt(Date createdAt);

}
