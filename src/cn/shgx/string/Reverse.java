package cn.shgx.string;

public class Reverse {
	/**
	 * 在对换的位置翻转字符串
	 * @param  str   [description]
	 * @param  start [description]
	 * @param  end   [description]
	 * @return       [description]
	 */
    public static String reverse2(String str,int start,int end) {
    	char[] array = str.toCharArray();
    	int mid = (end-start)/2+start;
    	for(int i =0;i<=mid-start;i++){
    		swap(array,start+i,end-i);
    	}
    	return String.valueOf(array);
    }
    /**
     * 字数组指定位置互换
     * @param array [description]
     * @param left  [description]
     * @param right [description]
     */
    private static void swap(char[] array,int left ,int right){
    	char temp = array[left];
    	array[left] = array[right];
    	array[left] = temp;
    }
    public static String rotate(String str,int index){
    	str = reverse2(str,0,index);
    	str = reverse2(str,index+1,str.length()-1);
    	str = reverse2(str,0,str.length()-1);
    	return str;
    }
}
