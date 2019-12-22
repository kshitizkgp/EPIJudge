package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    int carry = 1;
    List<Integer> ans = new ArrayList<>();
    for(int i=A.size()-1;i>=0;--i){
      int sum = (carry + A.get(i))%10;
      carry = (carry + A.get(i))/10;
      ans.add(sum);
    }
    if(carry > 0)
      ans.add(carry);
    Collections.reverse(ans);
    return ans;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
