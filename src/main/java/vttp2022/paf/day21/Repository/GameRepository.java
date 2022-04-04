package vttp2022.paf.day21.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static vttp2022.paf.day21.Repository.Queries.*;

import vttp2022.paf.day21.Model.Comment;
import vttp2022.paf.day21.Model.Game;

@Repository
public class GameRepository {
    
    //connection to the database, Spring will use the information in
    //application.properties to connect to the pool  
    @Autowired
    private JdbcTemplate template;

    public List<Comment> getCommentByGid(Integer queryGid) {
        return getCommentByGid(queryGid, Integer.MAX_VALUE, 0);
    }

    public List<Comment> getCommentByGid(Integer queryGid, Integer limit) {
        return getCommentByGid(queryGid, limit, 0);
    }

    public List<Comment> getCommentByGid(Integer queryGid, Integer limit, Integer offset) {
        final SqlRowSet result = template.queryForRowSet(
            //select * from comment where gid = ? limit ? offset ?;
            SQL_SELECT_COMMENT_BY_GID, queryGid, limit, offset
        );
        
        final List<Comment> commentList = new LinkedList<>();
        while (result.next()) {
            Comment myComment = Comment.create(result);
            commentList.add(myComment);
        }
        return commentList;
    }

    public Optional<Game> getGameByGid(Integer queryGid) {
        final SqlRowSet result = template.queryForRowSet(
            //select * from game where gid = ?
            SQL_SELECT_GAME_BY_GID, queryGid
        );

        if (!result.next())
            return Optional.empty();

        //or you create a function to do this inside the Game.java class
        return Optional.of(Game.create(result));
    }
}