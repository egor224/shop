package ru.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shop.model.Meal;
import ru.shop.repository.MealRepository;
import ru.shop.util.ValidationUtil;

import java.time.LocalDateTime;
import java.util.Collection;

import static ru.shop.util.ValidationUtil.checkNotFoundWithId;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public Meal get(int id, int userId) {
        return ValidationUtil.checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) {
        ValidationUtil.checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public Collection<Meal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        Assert.notNull(startDateTime, "startDateTime must not be null");
        Assert.notNull(endDateTime, "endDateTime  must not be null");
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Meal update(Meal meal, int userId) {
        Assert.notNull(meal, "meal must not be null");
        return ValidationUtil.checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }

    @Override
    public Meal save(Meal meal, int userId) {
        Assert.notNull(meal, "meal must not be null");
        return repository.save(meal, userId);
    }
}
