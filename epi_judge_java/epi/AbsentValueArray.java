package epi;
import java.util.BitSet;
import java.util.Iterator;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class AbsentValueArray {

  static int COUNT = 1 << 16;
  @EpiTest(testDataFile = "absent_value_array.tsv")
  public static int findMissingElement(Iterable<Integer> stream) {
    int[] cnt = new int[COUNT];
    Iterator<Integer> it = stream.iterator();
    while(it.hasNext()){
      int x = it.next();
      cnt[x >>> 16]++;
    }

    for(int i=0;i<COUNT;++i){
      if(cnt[i] < COUNT){
        it = stream.iterator();
        BitSet bitSet = new BitSet(COUNT);
        while(it.hasNext()){
          int x = it.next();
          if((x >>> 16) == i){
            bitSet.set((COUNT - 1) & x);
          }
        }

        for(int j=0;j<COUNT;++j){
          if(!bitSet.get(j)){
            return (i << 16) | j;
          }
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AbsentValueArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
