package joaquin.thiogo.shoprestapi.entity;

import jakarta.persistence.*;
import joaquin.thiogo.shoprestapi.entity.util.AuditableEntity;
import joaquin.thiogo.shoprestapi.entity.util.UpdateAtAware;
import joaquin.thiogo.shoprestapi.entity.util.UpdateAtListener;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
@EntityListeners(value = {
        UpdateAtListener.class
})
public class Product extends AuditableEntity<Integer> implements UpdateAtAware {

    private String name;

    private String description;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

}
