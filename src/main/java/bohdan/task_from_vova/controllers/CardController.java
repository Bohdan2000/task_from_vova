package bohdan.task_from_vova.controllers;

import bohdan.task_from_vova.models.Card;
import bohdan.task_from_vova.services.impl.CardServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    private final CardServiceImpl cardService;

    public CardController(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")// вивід всіх карток які є в базі
    public List<Card> findAll(){
        return cardService.findAll();
    }

    @PostMapping("/pushCard")//вивід інформації про картку
    public Card singCard(@RequestParam int number,
                         @RequestParam int pin
                         ){
        Card byNumberCard = cardService.getByNumberCard(number);
        if (byNumberCard.getPinCode()==pin) {

            return byNumberCard;
        }
        else return null;
    }

    @PostMapping("/addCash")
    public Card addCash(@RequestParam int number,
                        @RequestParam int pin,
                        @RequestParam int cash
                      ){
        Card byNumberCard = cardService.getByNumberCard(number);//пошук данаї картки за номером
        if ((byNumberCard.getPinCode()==pin) &&(cash==100||cash==200||cash==500)) { //перевірка її пінкоду
            byNumberCard.setCash(byNumberCard.getCash()+cash);
            cardService.save(byNumberCard);
            return byNumberCard;
        }
        else return null;

    }

    @PostMapping("/takeCash")
    public Card takeCash(@RequestParam int number,
                         @RequestParam int pin,
                         @RequestParam int cash){

        Card byNumberCard = cardService.getByNumberCard(number);
        if ((byNumberCard.getPinCode()==pin) &&(cash==100||cash==200||cash==500)) {
            byNumberCard.setCash(byNumberCard.getCash()-cash);
            if (byNumberCard.getCash()>0){ //перевірка для того щоб ми не могли зняти більше чим є на картці
                cardService.save(byNumberCard);
            }
            return byNumberCard;
        }
        else return null;
    }

    @PostMapping("/toForwardCash")
    public List<Card> forwardCash(@RequestParam int number,
                                  @RequestParam int number2,
                                  @RequestParam int pin,
                                  @RequestParam int cash){
        Card byNumberCard = cardService.getByNumberCard(number);
        Card byNumberCard2 = cardService.getByNumberCard(number2);
        if (byNumberCard.getPinCode()==pin) {
            byNumberCard.setCash(byNumberCard.getCash()-cash);
            byNumberCard2.setCash(byNumberCard2.getCash()+cash);
            if (byNumberCard.getCash()>0){ //перевірка для того щоб ми не могли зняти більше чим є на картці
                cardService.save(byNumberCard);
                cardService.save(byNumberCard2);
            }
        }
        return cardService.findAll();
    }

}
