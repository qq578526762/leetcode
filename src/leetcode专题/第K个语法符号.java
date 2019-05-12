package leetcode专题;

public class 第K个语法符号 {
	public static void main(String[] args) {
		System.out.print(kthGrammar(20,2000));
	}

	public static int kthGrammar(int N, int K) {
		int ans=0;
        --K;
        while(K>0){
            ans+=K%2;
            K>>=1;
        }
        return ans%2;
	}
}
