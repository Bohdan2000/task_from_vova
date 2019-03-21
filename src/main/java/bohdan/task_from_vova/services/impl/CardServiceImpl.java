package bohdan.task_from_vova.services.impl;

import bohdan.task_from_vova.dao.CardDao;

import bohdan.task_from_vova.models.Card;
import bohdan.task_from_vova.services.CardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardDao cardDao;

    public CardServiceImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }
    @Transactional
    @PostConstruct
    public void postConstruct(){
        Card card1 = new Card(123456789, 1234, 1000);
        Card card2 = new Card(987654321, 4321, 5000);
        Card card3 = new Card(676767676, 4444, 200);
        this.cardDao.save(card1);
        this.cardDao.save(card2);
        this.cardDao.save(card3);
    }

    @Override
    public Card getByNumberCard(int number) {
        return cardDao.getByNumberCard(number);
    }

    @Override
    public List<Card> findAll() {
        return cardDao.findAll();
    }

    @Override
    public void save(Card card) {
        cardDao.save(card);
    }
}
