package TailRecursion.sandbox.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;

public class CornerCaseTailSpecialist {
  public static _FunctionTypes._void_P0_E0 noArgsVoidFunction = new _FunctionTypes._void_P0_E0() {
    public void invoke() {
      if (1 < 5) {
        return;
      }
      invoke();
    }
  };
  public static _FunctionTypes._return_P0_E0<? extends Integer> noArgsFunction = new _FunctionTypes._return_P0_E0<Integer>() {
    public Integer invoke() {
      while (true) {
        if (1 < 5) {
          return 1;
        }
      }
    }
  };
  public static _FunctionTypes._void_P1_E0<? super Integer> voidFunction = new _FunctionTypes._void_P1_E0<Integer>() {
    public void invoke(Integer a) {
      if (1 < 5) {
        return;
      }
      invoke(a);
    }
  };
  public CornerCaseTailSpecialist() {
  }
  public static void noArgsVoidMethod() {
    noArgsVoidMethod();
  }
  public static int noArgMethod() {
    while (true) {
      if (1 < 5) {
        return 1;
      }
    }
  }
  public static void voidMethod(int a) {
    voidMethod(a);
  }
}
