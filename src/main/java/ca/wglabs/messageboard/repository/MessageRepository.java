package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    public Iterable<Message> findAllByOrderByIdAsc();

}
