package bohdan.task_from_vova.services;

import bohdan.task_from_vova.models.Card;

import java.util.List;

public interface CardService {
    List<Card> findAll();
    Card getByNumberCard(int number);
    void save(Card card);
}
