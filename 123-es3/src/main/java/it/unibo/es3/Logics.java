package it.unibo.es3;

import java.util.Set;

public interface Logics{
	
	void tick();
	
	boolean isOver();
	
	Set<Pair<Integer,Integer>> getPositions();
    
}