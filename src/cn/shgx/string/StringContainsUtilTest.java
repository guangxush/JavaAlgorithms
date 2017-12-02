package cn.shgx.string;

public class StringContainsUtilTest {
	public static void main(String[] args) {
		String str1 = "ABCDEFG",str2="BDBG",str3="BDBQ";
		System.out.println(StringContainUtil.contains(str1, str2));
		System.out.println(StringContainUtil.contains(str1, str3));
		System.out.println(StringContainUtil.contains2(str1, str2));
		System.out.println(StringContainUtil.contains2(str1, str3));
		System.out.println(StringContainUtil.contains3(str1, str2));
		System.out.println(StringContainUtil.contains3(str1, str3));
		System.out.println(StringContainUtil.contains4(str1, str2));
		System.out.println(StringContainUtil.contains4(str1, str3));
		System.out.println(StringContainUtil.contains5(str1, str2));
		System.out.println(StringContainUtil.contains5(str1, str3));
	}
}
