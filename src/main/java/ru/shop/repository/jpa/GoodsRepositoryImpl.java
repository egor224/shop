package ru.shop.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.model.Goods;
import ru.shop.model.Shop;
import ru.shop.repository.GoodsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Egor on 07.01.17.
 */
@Repository
@Transactional(readOnly = true)
public class GoodsRepositoryImpl implements GoodsRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Goods save(Goods goods) {
        if (goods.isNew()) {
            em.persist(goods);
            return goods;
        } else {
            return em.merge(goods);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Goods.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Goods get(int id) {
        return em.find(Goods.class, id);
    }

    @Override
    public Goods getByShop(Shop shop) {
        return null;
    }
}
