package functional.tools;

import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("unchecked")
class Enumerate<T>  implements Iterator<T> , Iterable<T>{
	private Iterator it ;
	private int current;

	public Enumerate(Collection<T> t){
		it = t.iterator();
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public T next() {
		return (T) it.next();
	}

	@Override
	public void remove() {
		it.remove();
	}

	@Override
	public Iterator <T> iterator() {
		return this;
	}
}