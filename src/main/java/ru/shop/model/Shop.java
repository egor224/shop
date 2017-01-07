package ru.shop.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Egor on 07.01.17.
 */
@NamedQueries({
        @NamedQuery(name = Shop.DELETE, query = "DELETE FROM Shop u WHERE u.id=:id"),
        @NamedQuery(name = Shop.ALL_SORTED, query = "SELECT u FROM Shop u  ORDER BY u.name"),
})

@Entity
@Table(name = "shop")
public class Shop extends BaseEntity {

    public static final String DELETE = "Shop.delete";
    public static final String ALL_SORTED = "Shop.getAllSorted";

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "addres", nullable = false)
    @NotEmpty
    private String addres;

    public Shop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
