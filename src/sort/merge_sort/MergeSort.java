
public class MergeSort{


	public static void mergeArray(int arr[], int first, int mid, int last, int tmp[]){
		int i=first,j=mid,k=0;
		while(i<mid&&j<last){
			if(arr[i]<=arr[j]){
				tmp[k++]=arr[i++];
			}else {
				tmp[k++]=arr[j++];
			}
		}
		while(i<mid){
			tmp[k++]=arr[i++];
		}
		while(j<last){
			tmp[k++]=arr[j++];
		}
		for(i=0; i<k; i++){
			arr[i+first]=tmp[i];
		}
	}

	public static void mergeSortUtil(int arr[],int first,int last,int tmp[]){
		if(first<(last-1)){
			int mid = (first+last)/2;
			mergeSortUtil(arr,first,mid,tmp);
			mergeSortUtil(arr,mid,last,tmp);
			mergeArray(arr,first,mid,last,tmp);
		}
	}

	public static void mergeSort(int arr[]){
		if(arr==null) return;
		int tmp[] = new int[arr.length];
		mergeSortUtil(arr,0,arr.length,tmp);
	}


	public static void main(String args[]){
		int arr[] = {4,3,2,9,5};
		MergeSort.mergeSort(arr);
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}