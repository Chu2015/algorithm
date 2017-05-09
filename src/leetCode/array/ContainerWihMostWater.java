package leetCode.array;

public class ContainerWihMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length- 1;
        int max = 0;
        
        while(left < right){
        	max = Math.max(max, (right - left)*Math.min(height[left], height[right]));
        	
        	if(height[left] < height[right]){
        		int i = 1;
        		while(height[left+i]<height[left]){
        			i++;
        		}
        		left += i;
        	}else{
        		int j = 1;
        		while(height[right-j]<height[right]){
        			j++;
        		}
        		right -=j;
        	}
        }
		return max;   
    }
    
    public static void main(String[] args){
    	System.out.println(new ContainerWihMostWater().maxArea(new int[]{1,2,1}));
    }
}
