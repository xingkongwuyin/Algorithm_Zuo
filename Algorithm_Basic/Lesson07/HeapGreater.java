package lesson07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class HeapGreater<T> {

//	T一定要是非基础类型，有基础类型需求包一层
	private ArrayList<T> heap;
	private HashMap<T, Integer> indexMap;
	private int heapSize;
	private Comparator<? super T> comp;
	
	// 1. constructor
	public HeapGreater(Comparator<? super T> c) {
		
		heap = new ArrayList<>();
		indexMap = new HashMap<>();
		heapSize = 0;
		comp = c ;
	}
	
	// 2. isEmpty
	public boolean isEmpty() {
		return heapSize == 0;
	}
	
	// 3. size
	public int size() {
		return heapSize;
	}
	
	// 4. whether contains the T obj
	public boolean contains(T obj) {
		return indexMap.containsKey(obj);
	}
	
	// 5. peek
	public T peek() {
		return heap.get(0);
	}
	
	// 6. push
	public void push(T obj) {
		
		heap.add(obj);
		indexMap.put(obj, heapSize);
		heapInsert(heapSize++);
	}
	
	// 7. pop
	public T pop() {
		
		T ans = heap.get(0);
		swap(0, heapSize - 1);
		indexMap.remove(ans);
		heap.remove(--heapSize);
		heapify(0);
		return ans;
	}
	
	// 8. remove  
	public void remove(T obj) {
		
		T replace = heap.get(heapSize - 1);
		int num = indexMap.get(obj);
		indexMap.remove(obj);
		
		if(obj != replace) {
			heap.set(num, replace);
			indexMap.put(replace, num);
			resign(replace);
		}
	}
	
	// 9. resign 
	public void resign(T obj) {
		heapInsert(indexMap.get(obj));
		heapify(indexMap.get(obj));
	}
	
	// 10. 返回堆上的所有元素
	public List<T> getALlElements(){
		List<T> ans = new ArrayList<>();
		for(T c : heap) {
			ans.add(c);
		}
		return ans;
	}
	
	// 11. heapInsert
	private void heapInsert(int index) {
		int R = (index - 1) / 2;
		// 比较器返回负数，第一个参数放在前面，返回正数第二个参数返回前面
		while(comp.compare(heap.get(index), heap.get(R)) < 0) {
			swap(index, R);
			index = R;
			R = (index - 1) / 2;
		}
	}
	
	// 12. heapify
	private void heapify(int index) {
		int L = (index * 2) + 1;
		while(L < heapSize) {
			boolean b = comp.compare(heap.get(L + 1), heap.get(L))< 0;
			int best = (L + 1 < heapSize - 1) && (comp.compare(heap.get(L + 1), heap.get(L))< 0) 
					   ? L + 1 : L; 
			if(best == index ) {
				break;
			}
			swap(best, index);
			index = best;
			best = (index * 2) + 1;
		}
	}

	// 13. swap
	public void swap(int i, int j) {
		T t1 = heap.get(i);
		T t2 = heap.get(j);
		heap.set(i, t2);
		heap.set(j, t1);
		indexMap.put(t1, j);
		indexMap.put(t2, i);
	}
	
}
