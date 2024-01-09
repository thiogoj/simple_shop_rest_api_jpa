package joaquin.thiogo.shoprestapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends AuditableEntity<Integer> implements UpdateAtAware {

    private String name;

    private String description;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @JsonBackReference
    private Brand brand;

}
