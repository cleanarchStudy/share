package repository.mybatis;

import repository.domain.User;

public interface UserMapper {

  void insert(User user);

  void update(User user);

  User findById(Long id);

  User findByEmail(String email);

  boolean deleteById(Long id);

}
