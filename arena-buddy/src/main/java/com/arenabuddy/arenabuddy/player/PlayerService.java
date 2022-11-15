package com.arenabuddy.arenabuddy.player;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;



    public void addPlayer(Player player_request) {
        Player n = new Player();
        n.setPlayer_name(player_request.getPlayer_name());
        n.setPlayer_rank(player_request.getPlayer_rank());
        n.setPlayer_rating(player_request.getPlayer_rating());
        n.setPlayer_level(player_request.getPlayer_level());
        n.setPlayer_spec(player_request.getPlayer_spec());
        n.setPlayer_wowclass(player_request.getPlayer_wowclass());
        n.setPlayer_realm(player_request.getPlayer_realm());
        playerRepository.save(n);
    }

    public Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void loadLadderData() throws IOException {

        final String url = "https://worldofwarcraft.com/en-us/game/pvp/leaderboards/3v3";







        // Add columns


        int numPlayers = 0;
        try {
            // get raw html document
            final Document document = Jsoup.connect(url).get();
            // int to skip random data I dont want
            int counter = 0;
            for (Element row : document.select(

                    // get necessary data from wow arena ladder
                    "div.SortTable-body " +
                            "div.SortTable-row ")) {
                // skip random data I dont want
                if (counter < 4) {
                    counter ++;
                    continue;
                }
                // parse function test
                        /*String[] test = getName(row.text());
                        names[numNames] = test[2];
                        numNames++;*/

                //make new player in players array
                playerRepository.save(makePlayer(row.text()));

            }


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        // test comment




    }

    static Player makePlayer(String rowString) {

        String[] split = rowString.split(" ");
        Player n = new Player();
        n.setPlayer_name(split[2]);
        n.setPlayer_rank(Integer.parseInt(split[0]));
        n.setPlayer_rating(Integer.parseInt(split[1]));
        n.setPlayer_level(Integer.parseInt(split[3]));
        n.setPlayer_spec(split[4]);
        n.setPlayer_wowclass(split[5]);
        n.setPlayer_realm(split[6]);

        return n;
    }

}
