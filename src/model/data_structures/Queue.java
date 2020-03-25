package model.data_structures;

import java.util.Iterator;

public class Queue<K extends Comparable<K>> implements Iterator<K> {

    private Node<K> primero;

    private Node<K> ultimo;

    private int size;

    public Queue() {
        size = 0;
    }


    public Node<K> darPrimero()
    {
        return primero;
    }

    public Node<K> darUltimo()
    {
        Node<K> actual = primero;

        while(actual!= null && actual.darSiguiente()!=null)
        {
            actual = actual.darSiguiente();
        }

        return actual;
    }

    public boolean isEmpty()
    {

        return primero == null;
    }

    public K enqueue(K pNuevo)
    {
        Node<K> nenqueue = new Node<K>(pNuevo, null, null);

        if(isEmpty()){

            primero= nenqueue;
            ultimo = primero;
        }else{
            Node<K> nuevoNodo = nenqueue;
            ultimo.cambiarSiguiente(nuevoNodo);
            nuevoNodo.cambiarAnterior(ultimo);
            ultimo = nuevoNodo;
        }
        size++;

        return nenqueue.darValor();

    }

    public void dequeue(){

//        if(!isEmpty())
//        {
//            return null;
//        }
        K valor = primero.darValor();
        primero = primero.darSiguiente();
        size--;

//        return valor;
    }

    public int darTamano()
    {
        return size;
    }

    public Node<K> darActual(int pPosicion)
    {
        Node<K> actual = primero;
        int posicion = 0;
        while (actual!=null&&posicion!=pPosicion)
        {
            actual = actual.darSiguiente();
            posicion++;
        }
        return actual;

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }
}
