package Generic;

public class Main2编写泛型 {
	public static void main(String[] args) {
		Pair<String> Stringpair = new Pair("a", "b");
		System.out.println(Stringpair.getFirst()+Stringpair.getLast());
		Pair<Integer> integerPair = new Pair(1,2);
		System.out.println(integerPair.getFirst()+integerPair.getLast());
		Stringpair = Stringpair.create("c","d" );
		System.out.println(Stringpair.getFirst()+Stringpair.getLast());
		System.out.println();
		
		Pair2<String,Integer> pair2 = new Pair2("a", 1);
		System.out.println(pair2.getFirst()+pair2.getLast());
		pair2 = pair2.create("b", 2);
		System.out.println(pair2.getFirst()+pair2.getLast());		
			
	}
}

class Pair<T> {
	private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}

class Pair2<T1,T2>{
	private T1 first;
	private T2 last;
	public Pair2(T1 first,T2 last) {
		this.first = first;
		this.last = last;
	}
	public T1 getFirst() {
		return first;
	}
	public T2 getLast() {
		return last;	
	}
	
	public static <K1,K2> Pair2<K1,K2> create(K1 first,K2 last) {
		return new Pair2<K1,K2>(first, last);
	}
}