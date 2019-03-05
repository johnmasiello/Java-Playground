package com.demo.hackerrank;

import java.util.ArrayList;

public class ArrayManipulation {
	public static long arrayManipulation_basic(int n, int[][] queries) {
        long maximum_value = 0;

        // Create a new array. Accommodate 1-indexing
        long arr[] = new long[n + 1];
        long firstValueInRange;
        long newValue;
        int query[];
        int endOfRange;
        long queryAdd;

        for (int i = 0; i < queries.length; i++) {
            query = queries[i];
            queryAdd = query[2];
            firstValueInRange = arr[query[0]];
            newValue = firstValueInRange + queryAdd;
            if (newValue > maximum_value)
                maximum_value = newValue;
            endOfRange = query[1] + 1;
            for (int j = query[0]; j < endOfRange; j++) {
                if (arr[j] == firstValueInRange) {
                    arr[j] = newValue;
                    continue;
                }
                firstValueInRange = arr[j];
                newValue = firstValueInRange + queryAdd;
                arr[j] = newValue;
                if (newValue > maximum_value)
                    maximum_value = newValue;
            }
        }
        return maximum_value;
    }
	
	private static class Query implements Comparable<Query> {
		private int leftIndex;
		private int rightIndex;
		private long value;
		
		public Query(int leftIndex, int rightIndex, long value) {
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
			this.value = value;
		}
		
		public int getLeftIndex() {
			return leftIndex;
		}

		public int getRightIndex() {
			return rightIndex;
		}
		
		public long getValue() {
			return value;
		}

		@SuppressWarnings("unused")
		public void setLeftIndex(int leftIndex) {
			this.leftIndex = leftIndex;
		}

		public void setRightIndex(int rightIndex) {
			this.rightIndex = rightIndex;
		}

		public void incrementValue(long value) {
			this.value += value;
		}

		@Override
		public boolean equals(Object o) {
			return o instanceof Query &&
					leftIndex == ((Query)o).leftIndex &&
					rightIndex == ((Query)o).rightIndex;
		}
		
		@Override
		public int compareTo(Query o) {
			return leftIndex - o.leftIndex;
		}
	}
	
	private static class QueryProcessor {
		private ArrayList<Query> chunks;
		
		public QueryProcessor(int n) {
			chunks = new ArrayList<>(n);
			chunks.add(new Query(1, n, 0));
		}
		
		private int indexOfNearestMatch(Query query) {
			int left = 0;
			int right = chunks.size() - 1;
			int middle = -1;
			
			while (left <= right) {
				middle = (left + right) >> 1;
			
				if (query.compareTo(chunks.get(middle)) < 0)
					right = middle - 1;
				else if (query.compareTo(chunks.get(middle)) == 0)
					return middle;
				else
					left = middle + 1;
			}
			// returns the largest element < query
			return right;
		}
		
		private long consumeQuery(Query query, long currentMax) {
			long updateByVal = query.getValue();
			int index = indexOfNearestMatch(query);
			Query chunk, newChunk;
			int rightIndex;
			
			while (index < chunks.size()) {
				chunk = chunks.get(index);
				rightIndex = chunk.getRightIndex();
				if (chunk.compareTo(query) < 0) {
					// The left side of chunk precedes the left side of query
					chunk.setRightIndex(query.getLeftIndex() - 1);
					if (rightIndex <= query.getRightIndex()) {
						newChunk = new Query(
								query.getLeftIndex(),
								rightIndex,
								chunk.getValue() + updateByVal);
						currentMax = getMax(newChunk, currentMax);
						chunks.add(index + 1, newChunk);
						if (rightIndex == query.getRightIndex()) {
							// The right side of the chunk coincides
							// with the right side of query
							break;
						}
						// The right side of chunk precedes
						// the right side of query
						index += 2;
					} else {
						// The right side of chunk succeeds 
						// the right side of query
						newChunk = new Query(
								query.getLeftIndex(),
								query.getRightIndex(),
								chunk.getValue() + updateByVal);
						currentMax = getMax(newChunk, currentMax);
						chunks.add(index + 1, newChunk);
						newChunk = new Query(
								query.getRightIndex() + 1,
								rightIndex,
								chunk.getValue());
						chunks.add(index + 2, newChunk);
						break;
					}
				} else if (rightIndex <= query.getRightIndex()) {
					chunk.incrementValue(updateByVal);
					currentMax = getMax(chunk, currentMax);
					if (rightIndex == query.getRightIndex()) {
						// The right side of the chunk coincides
						// with the right side of query
						break;
					}
					// The right side of chunk precedes
					// the right side of query
					index++;
				} else {
					// The right side of chunk succeeds 
					// the right side of query
					newChunk = new Query(
							query.getRightIndex() + 1,
							rightIndex,
							chunk.getValue());
					chunks.add(index + 1, newChunk);
					// Modify the pre-existing chunk which preceded newChunk
					chunk.setRightIndex(query.getRightIndex());
					chunk.incrementValue(updateByVal);
					currentMax = getMax(chunk, currentMax);
					break;
				}
			}
			return currentMax;
		}
		
		private long getMax(Query chunk, long b) {
			return chunk.getValue() > b ? chunk.getValue() : b;
		}
	}
	
	public static long arrayManipulation_Query(int n, int[][] queries) {
		QueryProcessor qp = new QueryProcessor(n);
		long max = 0;
		for (int[] query : queries) {
			max = qp.consumeQuery(new Query(query[0], query[1], query[2]), 
					max);
		}
		return max;
	}
	
	// https://www.geeksforgeeks.org/difference-array-range-update-query-o1/
	// queries uses 1-based counting on the indicies
	public static long arrayManipulation(int n, int[][] queries) {
		long[] diff = new long[n + 1];
		
		// Aggregate all of the query updates utilizing a difference array
		for (int[] query : queries) {
			diff[--query[0]] += query[2];
			diff[query[1]] -= query[2];
		}

		// Iterate over the values of the array by applying the difference array
		// to determine the maximum value after all of the query updates
		long max = diff[0];
		for (int i = 1; i < n; i++) {
			diff[i] += diff[i - 1];
			if (diff[i] > max)
				max = diff[i];
		}
		return max;
	}
}
