package vttp2022.paf.day21.Repository;

public interface Queries {
    //first ? is 1 not 0
    public static final String SQL_SELECT_GAME_BY_GID = "select * from game where gid = ?";
    public static final String SQL_SELECT_COMMENT_BY_GID = "select * from comment where gid = ? limit ? offset ?";

}
