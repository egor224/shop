package ru.shop.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shop.model.User;
import ru.shop.service.UserService;
import ru.shop.util.ValidationUtil;

import java.util.List;

/**
 * User: gkislin
 */
public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public User create(User user) {
        ValidationUtil.checkNew(user);
        log.info("create " + user);
        return service.save(user);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(User user, int id) {
        ValidationUtil.checkIdConsistent(user, id);
        log.info("update " + user);
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail " + email);
        return service.getByEmail(email);
    }
}
