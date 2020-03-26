package model.data_structures;

import java.util.*;

public class HashTableSeparateChaining<K extends Comparable<K>, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<K, Value>[] st;  // array of linked-list symbol tables
    private int nRehashes; // numero de rehashes de la tabla
    /**
     * Initializes an empty symbol table.
     */
    public HashTableSeparateChaining() {
        this(INIT_CAPACITY);
    } 

    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    public HashTableSeparateChaining(int m) {

        
        this.m = m;
        st = (SequentialSearchST<K, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<>();
        
    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
    	HashTableSeparateChaining<K, Value> temp = new HashTableSeparateChaining<K, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (K key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
        
        nRehashes++;
        
    }

    // hash value between 0 and m-1
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    } 

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(K key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(K key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
//        if (n >= 10*m) resize(2*m);
        if ( n/m >= 5.0) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    } 

    // return keys in symbol table as an Iterable
    public Iterable<K> keys() {
        Queue<K> queue = new Queue<>();
        for (int i = 0; i < m; i++) {
            for (K key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
    
    public int tamanoInicial()
    {
    	return INIT_CAPACITY;
    }
    
    public int tamanoFinal()
    {
		return m;
    	
    }
    public float factorDeCargaFinal()
    {
    	return n/m;
    }
    
    public double numeroRehashes()
    {
    	return nRehashes;
    }
    
    } 


