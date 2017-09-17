package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.model.Message;
import ca.wglabs.messageboard.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<Message> findAllByOrderByIdAsc();

    @Transactional
    Long deleteByName(String name);

}
