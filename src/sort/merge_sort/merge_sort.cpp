//归并排序

#include<iostream>
using namespace std;

//将有序数组a[]和b[]合并到c[]中
void merge_sorted_array(int a[], int a_len, int b[], int b_len, int c[]){
	int i,j,k;
	i=j=k=0;
	while(i<a_len&&j<b_len){
		if(a[i]<b[j]){
			c[k++]=a[i++];
		}else{
			c[k++]=b[j++];
		}
	}
	while(i<a_len){
		c[k++]=a[i++];
	}
	while(j<b_len){
		c[k++]=b[j++];
	}
}

void merge_array(int arr[], int first, int mid, int last, int tmp[]){
	int i=first,j=mid,k=0;
	while(i<mid&&j<last){
		if(arr[i]<=arr[j]){
			tmp[k++]=arr[i++];
		}else{
			tmp[k++]=arr[j++];
		}
	}
	while(i<mid){
		tmp[k++]=arr[i++];
	}
	while(j<last){
		tmp[k++]=arr[j++];
	}
	for (i = 0; i < k; i++)  
        arr[first + i] = tmp[i]; 
}

void merge_sort_util(int arr[], int first, int last, int tmp[]){
	if(first<(last-1)){
		int mid = (first+last)/2;
		merge_sort_util(arr,first,mid,tmp);
		merge_sort_util(arr,mid,last,tmp);
		merge_array(arr,first,mid,last,tmp);
	}
}

bool merge_sort(int arr[], int len){
	int *p = new int[len];
	if(p==NULL){
		return false;
	}
	merge_sort_util(arr,0,len,p);
	delete[] p;
	return true;
}

int main(){
	int arr[]={4,3,2,9,5};
	bool res = merge_sort(arr,5);
	cout<<"res:"<<res<<endl;
	for(int i=0; i<5; i++){
		cout<<arr[i]<<endl;
	}
}