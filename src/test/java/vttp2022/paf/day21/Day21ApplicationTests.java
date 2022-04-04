package vttp2022.paf.day21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp2022.paf.day21.Model.Comment;
import vttp2022.paf.day21.Model.Game;
import vttp2022.paf.day21.Repository.GameRepository;

@SpringBootTest
class Day21ApplicationTests {

	@Autowired
	private GameRepository gameRepo;

	@Test
	void shouldReturnAGame() {

		Optional<Game> opt = gameRepo.getGameByGid(10);
		assertTrue(opt.isPresent(), "gid = 10");
	}

	@Test
	void shouldReturnEmptyGameObj () {

		Optional<Game> opt = gameRepo.getGameByGid(100000);
		assertFalse(opt.isPresent(), "gid = 100000");
	}

	@Test
	void shouldReturn42Comments() {
		//specifically gid=10 has 42 comments
		List<Comment> commentList = gameRepo.getCommentByGid(10);
		assertEquals(42, commentList.size(), "number of comments for gid = 10 is 42");
	}

	@Test
	void shouldReturnEmptyList() {
		List<Comment> commentList = gameRepo.getCommentByGid(6543465);
		assertTrue(commentList.isEmpty());
	}
}
