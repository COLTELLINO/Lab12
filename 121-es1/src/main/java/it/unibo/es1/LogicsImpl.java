package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final List<Integer> values = new ArrayList<>();

	public LogicsImpl(int size) {
		for (int i = 0; i < size; i++) {
			this.values.add(0);
		}
	}

	@Override
	public int size() {
		return this.values.size();
	}

	@Override
	public List<Integer> values() {		
		return Collections.unmodifiableList(values);
	}

	@Override
	public List<Boolean> enablings() {
		return this.values().stream().map(n -> n < this.values.size()).toList();
	}

	@Override
	public int hit(int elem) {
		int value = this.values.get(elem);
		this.values.set(elem, ++value);
		return value;
	}

	@Override
	public String result() {
		return values().stream().map(String::valueOf).collect(Collectors.joining("|","<<",">>"));
	}

	@Override
	public boolean toQuit() {
		return values().stream().distinct().count() == 1;
	}
}
