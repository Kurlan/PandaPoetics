package pandapoetics.engine;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import pandapoetics.board.Board;
import pandapoetics.board.Spot;
import pandapoetics.tile.LetterTile;
import pandapoetics.tile.LetterValueTuple;
import pandapoetics.tile.PandaTile;

import org.junit.Test;


public class PandaProcessorTest {
	
	@Test
	public void testComputeScoreOneLetter() {
		
		List<Spot> word = new ArrayList<Spot>();
		word.add(new Spot(new LetterTile(new LetterValueTuple("a", 10)), new Point()));
		Integer score = PandaProcessor.computeWordScore(word);
		assertTrue(score.equals(10));
	}
	
	@Test
	public void testComputeScoreEmptyList() {
		
		List<Spot> word = new ArrayList<Spot>();
		Integer score = PandaProcessor.computeWordScore(word);
		assertTrue(score.equals(0));
	}

	
	@Test
	public void testComputePandaScoreOnePanda() {
		List<Spot> pandas = new ArrayList<Spot>();
		pandas.add(new Spot(new PandaTile(), new Point(3,3)));
		Integer pandaScore = PandaProcessor.computePandaScore(pandas);
		assertTrue(pandaScore.equals(50));
	}
	
	@Test
	public void testComputePandaScoreTwoPanda() {
		List<Spot> pandas = new ArrayList<Spot>();
		pandas.add(new Spot(new PandaTile(), new Point(3,3)));

		pandas.add(new Spot(new PandaTile(), new Point(1,3)));
		Integer pandaScore = PandaProcessor.computePandaScore(pandas);
		assertTrue(pandaScore.equals(100));
	}
	
	@Test
	public void testComputePandaScoreNoPanda() {
		List<Spot> pandas = new ArrayList<Spot>();
		Integer pandaScore = PandaProcessor.computePandaScore(pandas);
		assertTrue(pandaScore.equals(0));
	}
	
	@Test
	public void testComputePandaScoreSquare2x1() {
		List<Spot> pandas = new ArrayList<Spot>();
		pandas.add(new Spot(new PandaTile(), new Point(3,3)));

		pandas.add(new Spot(new PandaTile(), new Point(2,3)));
		Integer pandaScore = PandaProcessor.computePandaScore(pandas);
		assertTrue(pandaScore.equals(200));
	}
	
	@Test
	public void testComputePandaScoreSquare2x2() {
		List<Spot> pandas = new ArrayList<Spot>();
		pandas.add(new Spot(new PandaTile(), new Point(3,3)));
		pandas.add(new Spot(new PandaTile(), new Point(2,3)));
		pandas.add(new Spot(new PandaTile(), new Point(3,2)));
		pandas.add(new Spot(new PandaTile(), new Point(2,2)));
		Integer pandaScore = PandaProcessor.computePandaScore(pandas);
		assertTrue(pandaScore.equals(800));
	}
	
	@Test
	public void testComputePandaScoreSquare2x2and1x1() {
		List<Spot> pandas = new ArrayList<Spot>();
		pandas.add(new Spot(new PandaTile(), new Point(3,3)));
		pandas.add(new Spot(new PandaTile(), new Point(2,3)));
		pandas.add(new Spot(new PandaTile(), new Point(3,2)));
		pandas.add(new Spot(new PandaTile(), new Point(2,2)));
		pandas.add(new Spot(new PandaTile(), new Point(1,2)));
		Integer pandaScore = PandaProcessor.computePandaScore(pandas);
		assertTrue(pandaScore.equals(850));
	}
	
	@Test
	public void testComputePandaScoreSquare2x1and3x1() {
		Board board = new Board();
		board.setSpot(3, 2, new PandaTile());
		board.setSpot(3, 1, new PandaTile());
		board.setSpot(3, 0, new PandaTile());
		board.setSpot(2, 2, new PandaTile());
		board.setSpot(2, 1, new PandaTile());

		Integer score = PandaProcessor.computePanda(board);
		assertTrue(score.equals(850));
	}
	
	@Test
	public void testComputePandaScoreSquare3x1and2x1() {
		Board board = new Board();
		board.setSpot(3, 2, new PandaTile());
		board.setSpot(3, 1, new PandaTile());
		board.setSpot(2, 0, new PandaTile());
		board.setSpot(2, 2, new PandaTile());
		board.setSpot(2, 1, new PandaTile());
		Integer score = PandaProcessor.computePanda(board);
		assertTrue(score.equals(850));
	}
	
	@Test
	public void testComputePandaScoreSquare3x1and2x1and1x1() {
		Board board = new Board();
		board.setSpot(3, 2, new PandaTile());
		board.setSpot(3, 1, new PandaTile());
		board.setSpot(2, 0, new PandaTile());
		board.setSpot(2, 2, new PandaTile());
		board.setSpot(2, 1, new PandaTile());
		board.setSpot(4, 2, new PandaTile());
		Integer score = PandaProcessor.computePanda(board);
		assertTrue(score.equals(900));
	}
	
	@Test
	public void testComputePandaScoreSquare4x1and2x1and1x1() {
		Board board = new Board();

		board.setSpot(2, 3, new PandaTile());
		board.setSpot(3, 2, new PandaTile());
		board.setSpot(3, 1, new PandaTile());
		board.setSpot(2, 0, new PandaTile());
		board.setSpot(2, 2, new PandaTile());
		board.setSpot(2, 1, new PandaTile());
		board.setSpot(4, 2, new PandaTile());

		Integer score = PandaProcessor.computePanda(board);
		assertTrue(score.equals(1050));
	}
}
