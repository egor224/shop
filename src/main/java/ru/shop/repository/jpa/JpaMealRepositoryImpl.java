package ru.shop.repository.jpa;

import org.springframework.stereotype.Repository;
import ru.shop.model.Meal;
import ru.shop.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkisline
 * Date: 26.08.2014
 */

@Repository
public class JpaMealRepositoryImpl implements MealRepository {

    @Override
    public Meal save(Meal meal, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Meal get(int id, int userId) {
        return null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return null;
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}