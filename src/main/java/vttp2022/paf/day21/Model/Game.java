package vttp2022.paf.day21.Model;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer users_rated;
    private String url;
    private String image;
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getRanking() {
        return ranking;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Integer getUsers_rated() {
        return users_rated;
    }
    public void setUsers_rated(Integer users_rated) {
        this.users_rated = users_rated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    //create a game object here
    public static Game create(SqlRowSet rs) {
        Game myGame = new Game();
        myGame.setGid(rs.getInt("gid"));
        myGame.setName(rs.getString("name"));
        System.out.println(">>>>>>> " + rs.getString("name"));
        myGame.setYear(rs.getInt("year"));
        myGame.setRanking(rs.getInt("ranking"));
        myGame.setUsers_rated(rs.getInt("users_rated"));
        myGame.setUrl(rs.getString("url"));
        myGame.setImage(rs.getString("image"));
        return myGame;
    }

    //or create a json object to return
    public JsonObject toJson(SqlRowSet rs) {
       return Json.createObjectBuilder()
        .add("gid", getGid())
        .add("name", getName())
        .add("year", getYear())
        .add("ranking", getRanking())
        .add("users_rated", getUsers_rated())
        .add("url", getUrl())
        .add("image", getImage())
        .build();
    }
}