package vttp2022.paf.day21.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.paf.day21.Model.Game;
import vttp2022.paf.day21.Repository.GameRepository;

@Service
public class GameServices {
    
    @Autowired
    private GameRepository gameRepo;

    public Optional<Game> getComments(Integer gid) {
        Optional<Game> opt = gameRepo.getGameByGid(gid);
        
        if (opt.isEmpty())
            return Optional.empty();

        Game game = opt.get();
        game.setCommentList(gameRepo.getCommentByGid(gid));
        return Optional.of(game);
    }

}
