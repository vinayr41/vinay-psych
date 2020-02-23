package com.psych.game.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "rounds")
public class Round  extends Auditable{
    @ManyToOne
    @Getter
    @Setter
    @NotNull
    private Game game;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    private Question question;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Map<Player, PlayerAnswer> playerAnswers = new HashMap<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Map<Player, PlayerAnswer> selectedAnswers = new HashMap<>();

    @NotNull
    @Getter
    @Setter
    private int roundNumber;

    @ManyToOne
    @Getter @Setter
    private EllenAnswer ellenAnswer;


}
