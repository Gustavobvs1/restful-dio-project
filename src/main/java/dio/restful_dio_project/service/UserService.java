package dio.restful_dio_project.service;

import dio.restful_dio_project.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);
}
