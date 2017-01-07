package ru.shop.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.model.Shop;
import ru.shop.repository.ShopRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static ru.shop.model.Shop.*;

/**
 * Created by Egor on 07.01.17.
 */
@Repository
@Transactional(readOnly = true)
public class ShopRepositoryImpl implements ShopRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Shop save(Shop shop) {
        if (shop.isNew()) {
            em.persist(shop);
            return shop;
        } else {
            return em.merge(shop);
        }
    }

    @Override
    public boolean delete(int id) {
        return  em.createNamedQuery(Shop.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Shop get(int id) {
        return em.find(Shop.class, id);
    }
}
