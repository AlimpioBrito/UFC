package lab1.ufc.crateus.br;

public interface OrderedMap<K extends Comparable<K>, V> extends Map<K, V> {
	
	public K min();
	public K max();
	public K ceiling(K val);
	public K floor(K val);
	
}
