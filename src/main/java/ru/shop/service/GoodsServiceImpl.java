package ru.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shop.model.Goods;
import ru.shop.model.Shop;
import ru.shop.repository.GoodsRepository;
import ru.shop.util.ValidationUtil;
import ru.shop.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Egor on 08.01.17.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository repository;

    @Override
    public Goods get(int id) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public List<Goods> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Goods> getByShop(Shop shop) {
        return repository.getByShop(shop);
    }

    @Override
    public Goods update(Goods goods) throws NotFoundException {
        Assert.notNull(goods, "goods must not be null");
        return repository.save(goods);
    }

    @Override
    public Goods save(Goods goods) {
        Assert.notNull(goods, "goods must not be null");
        return repository.save(goods);
    }
}
