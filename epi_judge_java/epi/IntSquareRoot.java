package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IntSquareRoot {
  @EpiTest(testDataFile = "int_square_root.tsv")

  //Implemented using top-coder article concept: Note how we have calculated the mid in this case. This is case 2 when we want to fid the last x for which p(x) = false;
  public static int squareRoot(int k) {
    long beg = 0, en = k;
    while(beg < en){
     long mid = beg + (en - beg + 1)/2;
     if(mid * mid > k){
       en = mid - 1;
     }
     else {
       beg = mid;
     }
    }
    return (int)beg;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntSquareRoot.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
