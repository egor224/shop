package ru.shop.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.model.Goods;
import ru.shop.model.Shop;
import ru.shop.model.User;
import ru.shop.repository.GoodsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Goods.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Goods get(int id) {
        return em.find(Goods.class, id);
    }

    @Override
    public List<Goods> getByShop(Shop shop) {
        return em.createNamedQuery(Goods.BY_SHOP).setParameter("shop", shop).getResultList();
    }

    @Override
    public List<Goods> getAll() {
        return em.createNamedQuery(Goods.ALL_SORTED).getResultList();
    }
}
