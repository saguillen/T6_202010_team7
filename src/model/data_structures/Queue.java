package model.data_structures;

import java.util.Iterator;

public class Queue<T extends Comparable<T>> implements Iterator<T> {

    private Node<T> primero;

    private Node<T> ultimo;

    private int size;

    public Queue() {
        size = 0;
    }


    public Node<T> darPrimero()
    {
        return primero;
    }

    public Node<T> darUltimo()
    {
        Node<T> actual = primero;

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

    public T enqueue(T pNuevo)
    {
        Node<T> nenqueue = new Node<T>(pNuevo, null, null);

        if(isEmpty()){

            primero= nenqueue;
            ultimo = primero;
        }else{
            Node<T> nuevoNodo = nenqueue;
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
        T valor = primero.darValor();
        primero = primero.darSiguiente();
        size--;

//        return valor;
    }

    public int darTamano()
    {
        return size;
    }

    public Node<T> darActual(int pPosicion)
    {
        Node<T> actual = primero;
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
    public T next() {
        return null;
    }
}
