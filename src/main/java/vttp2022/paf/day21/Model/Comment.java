package vttp2022.paf.day21.Model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Comment {
    private String c_id;
    private String user;
    private Integer rating;
    private String c_text;
    private Integer gid;

    public static Comment create(SqlRowSet rs) {
        Comment myComment = new Comment();
        myComment.setC_id(rs.getString("c_id"));
        myComment.setUser(rs.getString("user"));
        myComment.setRating(rs.getInt("rating"));
        myComment.setC_text(rs.getString("c_text"));
        myComment.setGid(rs.getInt("gid"));
        return myComment;
    }
    
    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getC_text() {
        return c_text;
    }
    public void setC_text(String c_text) {
        this.c_text = c_text;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    
}
