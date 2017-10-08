package zzz_BiShiTi;

import java.util.ArrayList;
import java.util.List;



public class RangeTest {
	public static void main(String[] args) {
		Range r1=new Range(4, 8);
		Range r2=new Range(9, 13);
		Range r2_5 = new Range(1,3);
		Range r3=new Range(6, 12);
		Range r4=new Range(13, 25);
		
		Range[] aR=new Range[]{r1,r2};
		Range[] bR=new Range[]{r2_5,r3,r4};
		
		ArrayList<Range> result=getRangeSet(aR, bR);
		
		for(int i=0;i<result.size();i++){
		System.out.println(result.get(i));
		}
	}
	public static ArrayList<Range> getRangeSet(Range[] aR, Range[] bR){
		ArrayList<Range> ranges=new ArrayList<Range>();
		int k=0;
		for(int i=0;i<bR.length;i++){
			for(int j=k;j<aR.length;j++){
				int x = aR[j].left;
				int y = aR[j].right;
				if(isLefter(x, bR[i]) && isLefter(y,bR[i])){
					continue;
				}
				if(isRighter(x, bR[i]) && isRighter(y,bR[i])){
					break;
				}
				if(isMiddle(x, bR[i]) && isMiddle(y,bR[i])){
					Range range=new Range(x, y);
					ranges.add(range);
					k++;
					continue;
				}
				if(isLefter(x, bR[i]) && isRighter(y,bR[i])){
					Range range=new Range(bR[i].left, bR[i].right);
					ranges.add(range);
					break;
				}
				if(isLefter(x, bR[i]) && isMiddle(y,bR[i])){
					Range range=new Range(bR[i].left, y);
					ranges.add(range);
					continue;
				}
				if(isMiddle(x, bR[i]) && isRighter(y,bR[i])){
					Range range=new Range(x, bR[i].right);
					ranges.add(range);
					break;
				}
			}
		}
		return ranges;
	}
	
	private static boolean isLefter(int a, Range x){
		return a<x.left;
	}

	private static boolean isRighter(int a, Range x){
		return a>x.right;
	}
	
	private  static boolean isMiddle(int a, Range x){
		return !isLefter(a,x) && !isRighter(a,x);
	}
}


class Range{
	int left;
	int right;
	public Range(int num1, int num2){
		left=num1;
		right=num2;}
	public String toString(){
		return " [left=" + left + ", right=" + right + "]";
    }
}