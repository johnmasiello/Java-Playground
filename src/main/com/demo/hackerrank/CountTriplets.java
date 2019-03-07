package com.demo.hackerrank;

import java.util.*;

public class CountTriplets {
	public static long countTriplets(List<Long> arr, long r) {
        HashMap<Long,LinkedList<Integer>> hashedIndicies = new HashMap<>();

        int i = 0;
        for (Long element : arr) {
        	if (hashedIndicies.containsKey(element))
        		hashedIndicies.get(element).add(i);
        	else
        		hashedIndicies.put(element, 
        				new LinkedList<Integer>(Collections.singleton(i)));
        	i++;
        }
        
        HashMap<Long, LinkedList<List<Long>>> hashedIndiciesProgressions;
        hashedIndiciesProgressions = new HashMap<>();
        LinkedList<List<Long>> tuples;
        
        Set<Map.Entry<Long, LinkedList<Integer>>> entries = hashedIndicies.entrySet();
        LinkedList<Integer> indiciesNextElementInProgression, 
        	indiciesCurrentElementInProgression;
        Iterator<Integer> currentElementIterator, nextElementIterator;
        int itIndexA, itIndexB, count;
        long numberOfPartialRegressions;
        
        // Create a hashmap that maps a set of tuples to the first element in a two-element
        // Progression. 
        // The key is the first element in the two-element progression.
        // The value is a list of tuples (x, y) where x is the index of the first element,
        // and y is the number of ways to choose the two-element progression over indices >= x
        for (Map.Entry<Long, LinkedList<Integer>> entry : entries) {
        	indiciesCurrentElementInProgression = entry.getValue();
        	indiciesNextElementInProgression = hashedIndicies.get(entry.getKey() * r);
        	if (indiciesNextElementInProgression == null)
        		continue;
        	currentElementIterator = indiciesCurrentElementInProgression.descendingIterator();
        	nextElementIterator = indiciesNextElementInProgression.descendingIterator();
        	
        	tuples = new LinkedList<>();
        	count = 0;
        	numberOfPartialRegressions = 0;
        	itIndexB = nextElementIterator.hasNext() ?
        			nextElementIterator.next() : -1;
        	COUNT_PROGRESSIONS:
        	while (currentElementIterator.hasNext()) {
        		itIndexA = currentElementIterator.next();
        		if (itIndexB != -1) {
        			while (itIndexB > itIndexA) {
        				count++;
        				if (!nextElementIterator.hasNext()) {
        					numberOfPartialRegressions += count;
                			tuples.addFirst(Arrays.asList((long)itIndexA, numberOfPartialRegressions));
                			itIndexB = -1;
        					continue COUNT_PROGRESSIONS;
        				}
        				itIndexB = nextElementIterator.next();
        			}
        			numberOfPartialRegressions += count;
        			tuples.addFirst(Arrays.asList((long)itIndexA, numberOfPartialRegressions));
        		} else {
        			// [The number of ways to choose the element at this index 
    				// and then choose the next progressive element. 'count' is
        			// incidentally, the number of ways to choose the next
        			// progressive element]
        			// Plus
        			// [The number of ways to choose the next two progressive elements
        			// to the right of this index; for example, if this element points
        			// to 9, and 9-27 is a progression, then the number of ways
        			// to choose 9-27 where the 9 occurs to the right of this index]
        			
        			numberOfPartialRegressions += count;
        			tuples.addFirst(Arrays.asList((long)itIndexA, numberOfPartialRegressions));
        			while (currentElementIterator.hasNext()) {
        				numberOfPartialRegressions += count;
        				tuples.addFirst(Arrays.asList((long)currentElementIterator.next(), 
        						numberOfPartialRegressions));
        			}
        			break;
        		}
        	}
        	hashedIndiciesProgressions.put(entry.getKey(), tuples);
        }
        
        // Use both previously constructed hashmaps to count all progressions of three elements
        long numberOfRegressions = 0;
        List<Long> tupleList = null;
        int indexHead;
        long indexTail;
        Iterator<List<Long>> numberOfWaysToSelectProgressionIterator;
        for (Map.Entry<Long, LinkedList<Integer>> entry : entries) {
        	tuples = hashedIndiciesProgressions.get(entry.getKey() * r);
        	if (tuples == null)
        		continue;
        	numberOfWaysToSelectProgressionIterator = tuples.iterator();
        	currentElementIterator = entry.getValue().iterator();
        	
        	if (numberOfWaysToSelectProgressionIterator.hasNext()) {
        		tupleList = numberOfWaysToSelectProgressionIterator.next();
        		indexTail = tupleList.get(0);
        	} else {
        		indexTail = -1;
        	}
        	COUNT_COMPLETE_REGRESSIONS:
        	while (currentElementIterator.hasNext()) {
        		indexHead = currentElementIterator.next();
        		if (indexTail  == -1)
        			break;
        		if (indexHead < indexTail) {
        			numberOfRegressions += tupleList.get(1);
        			continue;
        		}
        		while (numberOfWaysToSelectProgressionIterator.hasNext()) {
        			tupleList = numberOfWaysToSelectProgressionIterator.next();
        			if (indexHead < tupleList.get(0)) {
        				numberOfRegressions += tupleList.get(1);
        				indexTail = tupleList.get(0);
            			continue COUNT_COMPLETE_REGRESSIONS;
        			}
        		}
        		break;
        	}
        }
        return numberOfRegressions;
    }
}
