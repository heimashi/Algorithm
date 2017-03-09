import java.util.ArrayList;

public class HeapSort {

        private ArrayList<Integer> minHeap;

        public HeapSort() {
            minHeap = new ArrayList();
            minHeap.add(-1);
        }

        public void push(int num) {
            minHeap.add(num);
            int curIndex = minHeap.size()-1;
            while (curIndex > 1) {
                int p = curIndex / 2;
                if (minHeap.get(p) > minHeap.get(curIndex)) {
                    int tmp = minHeap.get(p);
                    minHeap.set(p, minHeap.get(curIndex));
                    minHeap.set(curIndex, tmp);
                    curIndex = curIndex / 2;
                } else {
                    break;
                }
            }
        }


        public int pop() {
            if (minHeap.size() < 1) return -1;
            int res = minHeap.get(1);
            minHeap.set(1, minHeap.get(minHeap.size() - 1));
            minHeap.remove(minHeap.size() - 1);
            int curIndex = 1;
            int len = (minHeap.size() - 1);
            while (curIndex < len) {
                if ((curIndex * 2 + 1) <= len) {
                    int mi;
                    if(minHeap.get(curIndex*2)<minHeap.get(curIndex*2+1)){
                        mi = curIndex*2;
                    }else {
                        mi = curIndex*2+1;
                    }
                    if(minHeap.get(curIndex)>minHeap.get(mi)){
                        int tmp = minHeap.get(curIndex);
                        minHeap.set(curIndex, minHeap.get(mi));
                        minHeap.set(mi, tmp);
                    }
                    curIndex = mi;
                } else if (curIndex * 2 <= len) {
                    if(minHeap.get(curIndex)>minHeap.get(curIndex*2)){
                        int tmp = minHeap.get(curIndex);
                        minHeap.set(curIndex, minHeap.get(curIndex*2));
                        minHeap.set(curIndex*2, tmp);
                    }
                    break;
                } else {
                    break;
                }

            }

            return res;
        }


        public static void main(String args[]){
			int arr[] = {4,3,2,9,5,0,-9,88,9,2,6};
			HeapSort heapSort = new HeapSort();
            for(int i=0; i<arr.length ; i++){
                heapSort.push(arr[i]);
            }

			for(int i=0; i<arr.length; i++){
			   System.out.println(heapSort.pop());
		    }
	   }


}