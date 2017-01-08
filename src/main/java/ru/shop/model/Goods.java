package ru.shop.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Egor on 07.01.17.
 */
@NamedQueries({
        @NamedQuery(name = Goods.DELETE, query = "DELETE FROM Goods u WHERE u.id=:id"),
        @NamedQuery(name = Goods.BY_SHOP, query = "SELECT u FROM Goods u  WHERE u.id=:shop"),
        @NamedQuery(name = Goods.ALL_SORTED, query = "SELECT u FROM Goods u  ORDER BY u.name"),
})
@Entity
@Table(name = "goods")
public class Goods extends BaseEntity {

    public static final String DELETE = "Goods.delete";
    public static final String BY_SHOP = "Goods.getByShop";
    public static final String ALL_SORTED = "Goods.getAllSorted";

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
