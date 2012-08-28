/**
 * 
 */
package org.paukov.combinatorics.permutations;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

/**
 * @author Dmytro Paukov
 * 
 */
public class PermutationsTest {

	@Test
	public void simplePermutation() {

		ICombinatoricsVector<Integer> corePermutation = Factory
				.createVector(new Integer[] { 1, 2, 3 });
		Generator<Integer> generator = Factory.createPermutationGenerator(
				corePermutation);

		System.out.println("Number of permutations is: "
				+ generator.getNumberOfGeneratedObjects());
		assertEquals(6, generator.getNumberOfGeneratedObjects());

		Iterator<ICombinatoricsVector<Integer>> iterator = generator
				.iterator();

		while (iterator.hasNext()) {
			iterator.next();
			System.out.println(iterator);
		}

		List<ICombinatoricsVector<Integer>> list = generator
				.generateAllObjects();

		assertEquals(6, list.size());

		assertEquals("CombinatoricsVector=([1, 2, 3], size=3)", list.get(0)
				.toString());
		assertEquals("CombinatoricsVector=([1, 3, 2], size=3)", list.get(1)
				.toString());
		assertEquals("CombinatoricsVector=([3, 1, 2], size=3)", list.get(2)
				.toString());
		assertEquals("CombinatoricsVector=([3, 2, 1], size=3)", list.get(3)
				.toString());
		assertEquals("CombinatoricsVector=([2, 3, 1], size=3)", list.get(4)
				.toString());
		assertEquals("CombinatoricsVector=([2, 1, 3], size=3)", list.get(5)
				.toString());
	}

	@Test
	public void simpleOnePermutation() {

		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);

		ICombinatoricsVector<Integer> corePermutation = Factory
				.createVector(array);
		Generator<Integer> generator = Factory.createPermutationGenerator(
				corePermutation);

		System.out.println("Number of permutations is: "
				+ generator.getNumberOfGeneratedObjects());
		assertEquals(1, generator.getNumberOfGeneratedObjects());

		Iterator<ICombinatoricsVector<Integer>> iterator = generator
				.iterator();

		while (iterator.hasNext()) {
			iterator.next();
			System.out.println(iterator);
		}

		List<ICombinatoricsVector<Integer>> list = generator
				.generateAllObjects();

		assertEquals(1, list.size());

		assertEquals("CombinatoricsVector=([1], size=1)", list.get(0)
				.toString());
	}

	@Test
	public void simpleEmptyPermutation() {

		ArrayList<Integer> array = new ArrayList<Integer>();

		ICombinatoricsVector<Integer> corePermutation = Factory
				.createVector(array);
		Generator<Integer> generator = Factory.createPermutationGenerator(
				corePermutation);

		System.out.println("Number of permutations is: "
				+ generator.getNumberOfGeneratedObjects());
		assertEquals(0, generator.getNumberOfGeneratedObjects());

		Iterator<ICombinatoricsVector<Integer>> iterator = generator
				.iterator();

		while (iterator.hasNext()) {
			iterator.next();
			System.out.println(iterator);
		}

		List<ICombinatoricsVector<Integer>> list = generator
				.generateAllObjects();

		assertEquals(0, list.size());
	}
	
	
	@Test
	@Ignore("Permutation generator doesn't treat repeated elements as identical yet")
	public void identicalPermutation() {

		ICombinatoricsVector<String> initialVector = Factory
				.createVector(new String[] { "a", "a", "b" });
		Generator<String> generator = Factory.createPermutationGenerator(
				initialVector);

		System.out.println("Number of permutations is: "
				+ generator.getNumberOfGeneratedObjects());
		assertEquals(3, generator.getNumberOfGeneratedObjects());

		Iterator<ICombinatoricsVector<String>> iterator = generator
				.iterator();

		while (iterator.hasNext()) {
			iterator.next();
			System.out.println(iterator);
		}

		List<ICombinatoricsVector<String>> list = generator
				.generateAllObjects();

		assertEquals(3, list.size());

		assertEquals("CombinatoricsVector=([a, a, b], size=3)", list.get(0)
				.toString());
		assertEquals("CombinatoricsVector=([a, b, a], size=3)", list.get(1)
				.toString());
		assertEquals("CombinatoricsVector=([b, a, a], size=3)", list.get(2)
				.toString());
	}
	
	@Test
	public void abcPermutation() {

		ICombinatoricsVector<String> originalVector = Factory
				.createVector(new String[] { "a", "b", "c" });
		Generator<String> generator = Factory.createPermutationGenerator(
				originalVector);

		System.out.println("Number of permutations is: "
				+ generator.getNumberOfGeneratedObjects());
		assertEquals(6, generator.getNumberOfGeneratedObjects());

		for (ICombinatoricsVector<String> perm : generator)	{
				System.out.println(perm);
		}

		List<ICombinatoricsVector<String>> list = generator
				.generateAllObjects();

		assertEquals(6, list.size());

		assertEquals("CombinatoricsVector=([a, b, c], size=3)", list.get(0)
				.toString());
		assertEquals("CombinatoricsVector=([a, c, b], size=3)", list.get(1)
				.toString());
		assertEquals("CombinatoricsVector=([c, a, b], size=3)", list.get(2)
				.toString());
		assertEquals("CombinatoricsVector=([c, b, a], size=3)", list.get(3)
				.toString());
		assertEquals("CombinatoricsVector=([b, c, a], size=3)", list.get(4)
				.toString());
		assertEquals("CombinatoricsVector=([b, a, c], size=3)", list.get(5)
				.toString());
	}
	
	@Test
	public void anyExpressionPermutation() {

		ICombinatoricsVector<String> originalVector = Factory
				.createVector(new String[] { "x", "x^2", "x+1" });
		Generator<String> generator = Factory.createPermutationGenerator(
				originalVector);

		System.out.println("Number of permutations is: "
				+ generator.getNumberOfGeneratedObjects());
		assertEquals(6, generator.getNumberOfGeneratedObjects());

		for (ICombinatoricsVector<String> perm : generator)	{
				System.out.println(perm);
		}

		List<ICombinatoricsVector<String>> list = generator
				.generateAllObjects();

		assertEquals(6, list.size());

		assertEquals("CombinatoricsVector=([x, x^2, x+1], size=3)", list.get(0)
				.toString());
		assertEquals("CombinatoricsVector=([x, x+1, x^2], size=3)", list.get(1)
				.toString());
		assertEquals("CombinatoricsVector=([x+1, x, x^2], size=3)", list.get(2)
				.toString());
		assertEquals("CombinatoricsVector=([x+1, x^2, x], size=3)", list.get(3)
				.toString());
		assertEquals("CombinatoricsVector=([x^2, x+1, x], size=3)", list.get(4)
				.toString());
		assertEquals("CombinatoricsVector=([x^2, x, x+1], size=3)", list.get(5)
				.toString());
	}
}