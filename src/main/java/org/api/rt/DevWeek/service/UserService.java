package org.api.rt.DevWeek.service;

import org.api.rt.DevWeek.model.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    User findById(Long id);
    User create (User userToCreate);
}
