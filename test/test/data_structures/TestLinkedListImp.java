package test.data_structures;

<<<<<<< HEAD
public class TestLinkedListImp {

	
	
	
	
	
=======
import org.junit.Test;

import model.data_structures.LinkedListImp;

public class TestLinkedListImp<T extends Comparable<T>> {

	private LinkedListImp<String> arreglo;
	//	@Before
	public void setUp1() {
		arreglo = new LinkedListImp<String>();
	}

	public void setUp2() {

	}


	@Test
	public void testArregloDinamico() {
		// TODO
	}

	@Test
	public void testDarElemento() {
		setUp2();
		// TODO
	}

>>>>>>> branchJ
}
