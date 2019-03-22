package lab1.ufc.crateus.br;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMap<K, V> implements Map<K, V> {
	
	class Entry {
		K key;
		V value;
		Entry next;
		
		public Entry(K key, V value, LinkedListMap<K, V>.Entry next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
	}
	
	Entry first;
	
	@Override
	public void add(K key, V value) {
		Entry aux = getEntry(key);
		
		if(aux == null) {
			first = new Entry(key, value, first);
		}else {
			aux.value = value;
		}
	}
	
	public Entry getEntry(K key) {		
		for(Entry r = first; r != null; r = r.next) {
			if(r.key.equals(key)) {
				return r;
			}
		}
		return null;	
	}

	@Override
	public V get(K key) {	
		Entry aux = getEntry(key);	
		return (aux != null)? aux.value : null;
	}

	@Override
	public void remove(Object key) {
		Entry l = new Entry(null, null, first);
		
		for(Entry prev = l; l.next != null; prev = prev.next) {
			if(key.equals(prev.next.key)) {
				prev.next = prev.next.next;
				break;
			}
		}
		
		first = l.next;
	}
		
	@Override
	public Iterable keys() {
		List<K> keys = new LinkedList<>();
		for(Entry r = first; r != null; r = r.next) {
			keys.add(r.key);
		}
		return keys;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
