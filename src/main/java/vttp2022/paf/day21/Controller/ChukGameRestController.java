package vttp2022.paf.day21.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import vttp2022.paf.day21.Model.Game;
import vttp2022.paf.day21.Services.GameServices;

@RestController
@RequestMapping(path="/game")
public class ChukGameRestController {
    
    @Autowired
    private GameServices gameSvc;

    @GetMapping(path="/{gid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGameAndCommentById(@PathVariable Integer gid) {
        Optional<Game> opt = gameSvc.getComments(gid);
        JsonObjectBuilder builder = Json.createObjectBuilder();

        if (opt.isEmpty())
            return ResponseEntity.status(404).body(builder.add("error", "not found: %s".formatted(gid)).build().toString());
        
        Game game = opt.get();
        builder.add("gid", game.getGid());
        builder.add("name", game.getName());
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        //do for loop or
        // for (Comment c : game.getCommentList()) {
        //     arrBuilder.add("/comment/%s".formatted(c.getC_id()));
        // }
        //or stream().forEach()
        game.getCommentList().stream().forEach(c -> {
            arrBuilder.add("/comment/%s".formatted(c.getC_id()));
        });

        return ResponseEntity.ok(builder.build().toString());
    }
}
