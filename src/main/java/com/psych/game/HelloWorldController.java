package com.psych.game;

import com.psych.game.model.GameMode;
import com.psych.game.model.Player;
import com.psych.game.model.Question;
import com.psych.game.repository.PlayerRepository;
import com.psych.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dev-test")
public class HelloWorldController {

    @Autowired
    private  PlayerRepository playerRepository ;

    @Autowired
   private QuestionRepository questionRepository;

    @GetMapping("/")
    public  String hello() {
        return "Hello, World";
    }

    @GetMapping("/populate")
    public String populateDb() {
        //add some data
        Player luffy = new Player.Builder()
                .alias("luffy")
                .email("luffy@gmail.com")
                .saltedHashedPassword("strrawhat")
                .build();

        playerRepository.save(luffy);

        //add some data
        Player robin = new Player.Builder()
                .alias("robin")
                .email("robin@gmail.com")
                .saltedHashedPassword("strrrons")
                .build();

        playerRepository.save(robin);

        questionRepository.save(new Question("What is the most important Poneglyph",
                    "Rio Poneglyph", GameMode.IS_THIS_A_FACT));


        return "populated";
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Optional<Question> getQuestionById(@PathVariable(name = "id")  Long id) {
        return questionRepository.findById(id);
    }
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Optional<Player> getAllPlayers(@PathVariable(name = "id")  Long id) {
        return playerRepository.findById(id);
    }

    //Games
    //players
    //Admins
    //questions
    //Rounds
    //ContentWriters

}
//localhost:8080/dev-test
