package br.ufc.quixada.eda.listaprioridades;
import java.util.*;

/**
 * Minimum heap implementation. See [Cormen et al 1999] for formal theory. 
 * Maintains all elements in a min-heap, such that the minimum element will
 * be the top-most node in the heap at all times. Among many other uses, heaps are ideal for 
 * representing priority queues. 
 */
public class HeapMinimo<T> {
  private int n;
  final private List<No> heap;
  final private Comparator<T> comparador;

  private class No {
    public T elemento;
    public int posicao;
  }    

  public HeapMinimo( Comparator<T> comparador ) {
    n = 0;
    heap = new ArrayList<No>();
    this.comparador = comparador;
    //initialy clear
    //for (int i=0;i<maxSize;i++) heap[i] = null;
  }

  /**
   * Insert element into the heap. O(lg n) where n is the number of elements/nodes in the heap  
   * @param elemento new element to be inserted
   */
  public void inserir( final T elemento ) {
    n++;
    No no = new No();
    no.elemento = elemento;
    no.posicao = n-1;
    heap.add(no);
    decreaseKey( no );
    //return node;
  }

  public final void apagar() {
    heap.clear();
    n = 0;
  }

  /**
   * Return a reference to the top-most element on the heap. The method does not change the state
   * of the heap in any way. O(k).
   * @return Reference to top-most element of heap
   */
  public final T subir() {
    return heap.get(0).elemento;
  }

  //bound check missing

  /**
   * Pop an element of the heap. O(lg n) where n is the number of elements in heap.
   */
  public T pop() {
    T returnNode = subir();
    exchange( 0, n-1 );
    heap.remove(n-1);
    n--;

    //if any elements left in heap, do minHeapify
    if (n>0) {
      minHeapify( heap.get(0) );
    }
    
    return returnNode;
  }

  //  private final void reinsert( final Node n ) {
  //    if ( !decreaseKey(n) ) {
  //      minHeapify(n);
  //    }
  //  }

  public final int size() {
    return n;
  }


  private final boolean decreaseKey( final No node ) {
    int index = node.posicao;
    boolean modified = false;

    //    while ( index>0 &&  (heap[parent(index)]).compareTo( heap[index]) >= 0 ) {
    while ( index>0 &&  comparador.compare(heap.get(parent(index)).elemento, heap.get(index).elemento ) >= 0 ) {
      exchange( index, parent(index) );
      index = parent(index);
      modified = true;
    }

    return modified;
  }

  private final void minHeapify( final No node ) {
    int smallest;
    int index = node.posicao;
    int left = left(index);
    int right = right(index);

    //  if (left<size && (heap[left]).compareTo(heap[index]) <= 0 )
    if (left<n && comparador.compare(heap.get(left).elemento, heap.get(index).elemento) <= 0 )
      smallest= left;
    else
      smallest = index;

    //    if (right<size && (heap[right]).compareTo(heap[smallest]) <=0 )
    if (right<n && comparador.compare(heap.get(right).elemento, heap.get(smallest).elemento ) <=0 )
      smallest= right;
    if (smallest!= index) {
      exchange( index, smallest );
      minHeapify( heap.get(smallest) );
    }
  }

  private final void exchange( final int index, final int index2 ) {
    No temp = heap.get(index);
    temp.posicao = index2;

    No temp2 = heap.get(index2);
    temp2.posicao = index;

    heap.set(index, temp2 );
    heap.set( index2, temp);


    //Update posistion in Node
    //    heap.get(index).position=index;
    //    heap.get(index2).position=index2;
  }


  private final int parent(final int i) {
    return i/2;
  }

  private final int left(final int i) {
    return 2*i;
  }

  private final int right(final int i) {
    return 2*i+1;
  }

  /**
   * Returns an iterator that iterates over all elements of the heap, in no particular order
   * @return
   */
  public final Iterator<T> iterator() {
    return new Iterator<T>() {
      private Iterator<No> iterator = heap.iterator(); 
      @Override
      public boolean hasNext() { return iterator.hasNext(); }
      @Override
      public T next() { return iterator.next().elemento; }
      @Override
      public void remove() { }
    };
  }

  //  public void printHeap() {
  //    int step =1;
  //    int i = 0;
  //    for (int n=0;n<size;n++) {
  //      i++;
  //      //System.out.print(""+ ((Contact)heap[n].item).relativeV + "*");
  //      if (i%step == 0 ) {
  //        step *=2; i=0;
  //        System.out.println("");
  //      }
  //    }
  //
  //    System.out.println("");
  //  }
}