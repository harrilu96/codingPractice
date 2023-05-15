package DCP_9_2_MostSimilarWebsites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {

    Pair<String,Integer>[] heap;

    public Heap(List<Pair<String,Integer>> dataList) {
        heap = new Pair[100];
        for(int i = 0; i < dataList.size(); i++) {
            this.insert(dataList.get(i));
        }
    }
    public Pair<String,Integer>[] getHeap() {
        return this.heap;
    }

    public boolean hasLeftChild(int index) {
        return this.heap[2*index+1] != null;
    }

    public int putLeftChild(int index, Pair<String,Integer> node) {
        int indexToPut = 2*index+1;
        this.heap[indexToPut] = node;
        return indexToPut;
    }

    public boolean hasRightChild(int index) {
        return this.heap[2 * index + 2] != null;
    }

    public int putRightChild(int index, Pair<String,Integer> node) {
        int indexToPut = 2*index+2;
        this.heap[2*index+2] = node;
        return indexToPut;
    }

    public int getParentIndex(int index) {
        if (index == 0) return -1;
        return (index - 1) / 2;
    }

    private int insertNodeAtBottom(Pair<String, Integer> node) {
        if (heap[0] == null) {
            heap[0] = node;
            return 0;
        }

        List<Integer> indicesAtCurrentLevel = List.of(0);
        List<Integer> indicesAtNextLevel = new ArrayList<>();

        // figure out where to insert the node. tree should always remain balanced
        while(true) {
            for (Integer index : indicesAtCurrentLevel) {
                if (!this.hasLeftChild(index)) {
                    return this.putLeftChild(index, node);
                } else {
                    indicesAtNextLevel.add(2 * index + 1);
                }
            }
            for (Integer index : indicesAtCurrentLevel) {
                if (!this.hasRightChild(index)) {
                    return this.putRightChild(index, node);
                } else {
                    indicesAtNextLevel.add(2*index+2);
                }
            }
            indicesAtCurrentLevel = indicesAtNextLevel;
            indicesAtNextLevel = new ArrayList<>();
        }
    }

    public void insert(Pair<String, Integer> node) {
        int currentNodeIndex = insertNodeAtBottom(node);

        // once node is inserted, ensure spot is correct
        while(getParentIndex(currentNodeIndex) >= 0 && heap[currentNodeIndex].getRight() > heap[getParentIndex(currentNodeIndex)].getRight()) {
            Pair<String, Integer> currentNode= heap[currentNodeIndex];
            heap[currentNodeIndex] = heap[getParentIndex(currentNodeIndex)];
            heap[getParentIndex(currentNodeIndex)] = currentNode;
            currentNodeIndex = getParentIndex(currentNodeIndex);
        }
    }



}
