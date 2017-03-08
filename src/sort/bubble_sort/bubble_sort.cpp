#include<iostream>

using namespace std;

void bubble_sort(int arr[], int len){
	for(int i=0; i<len-1; i++){
		for(int j=i+1; j<len; j++){
			if(arr[i]>arr[j]){
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}
	}
}

int main(){
	int arr[] = {4,9,2,1,0,7,2};
	int size = sizeof(arr)/sizeof(int);
	bubble_sort(arr,size);
	for(int i=0; i<size; i++){
		cout<<arr[i]<<endl;
	}
}