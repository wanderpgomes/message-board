package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.model.Message;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAllByAndOriginalMessageIdIsNull();

    List<Message> findByUserIdAndOriginalMessageIdIsNull(Long userId);

    List<Message> findByOriginalMessageId(Long originalMessageId);

    @Transactional
    void deleteByText(String text);

    @Transactional
    void deleteByOriginalMessageIdIsNotNull();

}
