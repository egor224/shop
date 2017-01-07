package ru.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shop.model.User;
import ru.shop.repository.UserRepository;
import ru.shop.util.exception.NotFoundException;
import ru.shop.util.ValidationUtil;

import java.util.List;

import static ru.shop.util.ValidationUtil.checkNotFound;
import static ru.shop.util.ValidationUtil.checkNotFoundWithId;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return ValidationUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return ValidationUtil.checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        repository.save(user);
    }
}
