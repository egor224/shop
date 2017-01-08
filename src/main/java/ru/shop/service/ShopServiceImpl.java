package ru.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shop.model.Shop;
import ru.shop.repository.ShopRepository;
import ru.shop.util.ValidationUtil;
import ru.shop.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Egor on 08.01.17.
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository repository;

    @Override
    public Shop get(int id) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Collection<Shop> getAll() {
        return repository.getAll();
    }

    @Override
    public Shop update(Shop shop) throws NotFoundException {
        Assert.notNull(shop, "shop must not be null");
        return repository.save(shop);
    }

    @Override
    public Shop save(Shop shop) {
        Assert.notNull(shop, "shop must not be null");
        return repository.save(shop);
    }
}
