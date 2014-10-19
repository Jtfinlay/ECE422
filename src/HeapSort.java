import java.util.*;

/**
 * Created by James on 10/19/2014.
 */
public class HeapSort
{
    int[] values;
    int mem;

    /**
     * Perform heap sorting. Algorithm from wikipedia
     */
    public int[] sort(int[] a)
    {
        this.values = a;

        heapify();

        int end = values.length-1;
        mem+=2;
        while (end > 0)
        {
            swap(end, 0);
            end--;
            siftDown(0, end);
            mem+=2;
        }

        return values;
    }

    /**
     * Puts elements into heap order
     */
    public void heapify()
    {
        int start = (int) Math.floor((values.length - 2) / 2);
        mem+=2;
        while (start >= 0)
        {
            siftDown(start, values.length-1);
            start--;
            mem+=3;
        }
    }

    /**
     * Sift down the node at index start to the proper place such that all
     * nodes below the start index are in heap order.
     * @param start: Index start
     * @param end: Index end
     */
    public void siftDown(int start, int end)
    {
        int root = start;
        mem+=2;

        while (root * 2 + 1 <= end)
        {
            int child = root * 2 + 1;
            int swap = root;
            mem+=6;

            if (values[swap] < values[child])
            {
                swap = child;
                mem+=6;
            } else mem+=4;

            if (child + 1 <= end && values[swap] < values[child+1])
            {
                swap = child + 1;
                mem+=6;
            } else mem+=3; // taking average of conditional


            if (swap != root)
            {
                swap(root, swap);
                root = swap;
                mem+=6;
            }
            else { mem+=2; return; }
        }
    }

    /**
     * Swap two values in the values array.
     * @param a: First index
     * @param b: Second index
     */
    public void swap(int a, int b)
    {
        int tmp = values[a];
        values[a] = values[b];
        values[b] = tmp;
        mem+=10;
    }

}

