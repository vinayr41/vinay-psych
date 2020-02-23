package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "games")
public class Game extends Auditable {
    @ManyToMany
    @Getter
    @Setter
    Set<Player> players = new HashSet<>();

    @Setter @Getter
    @Enumerated(EnumType.STRING)
    @NotNull
    private GameMode gameMode;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Round> rounds = new ArrayList<>();

    @Getter
    @Setter
    private Boolean hasEllen = false;

    @Getter
    @Setter
    private int numRounds = 10;

    @ManyToOne
    @Getter
    @Setter
    @NotNull
    private Player leader;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Map<Player, Stats> playerStats = new HashMap<>();

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private GameStatus gamestatus;

    @ManyToMany
    @Getter
    @Setter
    private Set<Player> readyPlayers = new HashSet<>();


}
