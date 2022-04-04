package vttp2022.paf.day21.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.paf.day21.Model.Comment;
import vttp2022.paf.day21.Model.Game;
import vttp2022.paf.day21.Repository.GameRepository;

@Controller
@RequestMapping(path="/game")
public class GameController {
    
    @Autowired
    private GameRepository gameRepo;
    
    @GetMapping(path="/{gid}")
    public String getDetails(@PathVariable String gid,@RequestParam(required = false, defaultValue = "0") String offset, Model m) 
    {
        if (Integer.parseInt(offset) < 0) {
            offset = "0";
        }

        Game myGame = new Game();
        Optional<Game> myGameOpt = Optional.of(myGame);
        myGameOpt = gameRepo.getGameByGid(Integer.parseInt(gid));
        m.addAttribute("game", myGameOpt.get());

        List<Comment> commentsList = gameRepo.getCommentByGid(Integer.parseInt(gid), 5, Integer.parseInt(offset));
        m.addAttribute("comments", commentsList);

        m.addAttribute("offset", offset);

        return "gameDetails";
    }
}
