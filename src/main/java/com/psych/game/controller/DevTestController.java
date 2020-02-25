package com.psych.game.controller;

import com.psych.game.model.*;
import com.psych.game.repository.GameRepository;
import com.psych.game.repository.PlayerRepository;
import com.psych.game.repository.QuestionRepository;
import com.psych.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dev-test")
public class DevTestController {

    @Autowired
    private  PlayerRepository playerRepository ;

    @Autowired
   private QuestionRepository questionRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public  String hello() {
        return "Hello, World";
    }

    @GetMapping("/populate")
    public String populateDb() {
        for(Player player : playerRepository.findAll()) {
            player.getGames().clear();
            playerRepository.save(player);
        }

        gameRepository.deleteAll();
        playerRepository.deleteAll();
        questionRepository.deleteAll();
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

        Game game = new Game();
        game.setGameMode(GameMode.IS_THIS_A_FACT);
        game.setLeader(luffy);
        game.getPlayers().add(luffy);
        gameRepository.save(game);
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

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
    @GetMapping("/game/{id}")
    public Optional<Game> getGameById(@PathVariable(name = "id") Long id) {
        return gameRepository.findById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable(name = "id")  Long id) {
        return userRepository.findById(id);
    }


    //Games
    //players
    //Admins
    //questions
    //Rounds
    //ContentWriters

}
//localhost:8080/dev-test
