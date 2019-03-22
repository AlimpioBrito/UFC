package lab1.ufc.crateus.br;

public interface Map<K, V> {
	
	public void put(K key, V value);
	public V get(K key);
	public void remove(K key);
	public <K, V> Iterable<K> keys();
	public int size();
	
}
