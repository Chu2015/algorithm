package cc150;

public class Finder2 {

       public int findString(String[] str, int n, String x) {
        // write code here
    	   int lo = 0;
           int hi = n-1;
           
           while(lo<=hi){
           	int mid = (lo+hi)/2;
               if(str[mid]==" "){
               	    mid = next(str,mid,lo,hi);
               	    if(mid==-1){
               	    	return -1;
               	    }
               }
               if(str[mid].equals(x)){
            	   return mid;
               }else if(str[mid].compareTo(x)>0){
            	   hi = mid-1;
               }else {
            	   lo = mid+1;
               }
           }
		   return 0;   
	   }

	private int next(String[] str, int mid,int lo,int hi) {
		
		while(mid<=hi && str[mid]==" "){
			mid = mid+1;
		}
		if(mid>hi){
			while(mid>=lo && str[mid]==" "){
				mid = mid-1;
			}
		}
		if(mid<lo){
			return -1;
		}
		return mid;
	}
}
