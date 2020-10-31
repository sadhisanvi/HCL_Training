package lab_assignment6.q1;

import java.util.*;

public class Tester {

	public static void main(String[] args) {

		List<Integer> lists = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		add(lists);
		addAll(lists);

		System.out.println("---------List Iterator----------");
		for (Integer list : lists) {
			System.out.println(list);
		}
		remove(lists);
		Object[] arr = new Integer[size(lists)];
		arr = lists.toArray();

		System.out.println("list in array");
		for (Object item : arr) {
			System.out.print(item + " ");
		}

		size(lists);
		contains(lists);
		removeAll(lists);
		clear(lists);
		System.out.println();

		add(set);
		addAll(set);
		remove(set);
		contains(set);

		System.out.println("----------------set------------------");
		for (Integer setItem : set) {
			System.out.println(setItem);
		}

		Object[] arrSet = new Integer[size(set)];
		arrSet = set.toArray();

		System.out.println("set in array");
		for (Object item : arrSet) {
			System.out.print(item + " ");
		}
		size(set);
		remove(set);
		removeAll(set);
		clear(set);

	}

	private static void contains(Set<Integer> set) {
		System.out.println(set.contains(new Integer(20)));

	}

	private static void contains(List<Integer> list) {
		System.out.println(list.contains(10));

	}

	private static int size(Set<Integer> set) {
		return set.size();

	}

	private static int size(List<Integer> list) {
		return list.size();
	}

	private static void clear(Set<Integer> set) {
		set.clear();

	}

	private static void clear(List<Integer> list) {
		list.clear();

	}

	private static void removeAll(Set<Integer> set) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(20);
		set1.add(10);
		set.removeAll(set1);

	}

	private static boolean remove(Set<Integer> set) {

		return set.remove(new Integer(10));
	}

	private static void removeAll(List<Integer> list) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(20);
		list1.add(10);
		list.removeAll(list1);

	}

	private static boolean remove(List<Integer> list) {
		return list.remove(new Integer(10));
	}

	private static void addAll(Set<Integer> set) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(20);
		set1.add(30);
		set.addAll(set1);
	}

	private static void addAll(List<Integer> list) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(20);
		list1.add(30);
		list.addAll(list1);

	}

	private static void add(Set<Integer> set) {
		set.add(70);
		set.add(20);

	}

	private static void add(List<Integer> list) {
		list.add(20);
		list.add(40);
		list.add(50);
		list.add(80);
		System.out.println("added to the list");
	}

}
