package jetbrains.mps.baseLanguage.memoize.sandbox.test;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.baseLanguage.memoize.util.caches.KeyCalculator;
import jetbrains.mps.baseLanguage.memoize.util.caches.Memoizator;
import jetbrains.mps.baseLanguage.memoize.util.caches.NullValue;
import java.util.Map;
import junit.framework.Assert;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;

public class MemoizeTest_Test extends TestCase {
  private static final Integer TEN = Integer.valueOf(10);
  private int closureCounter = 0;
  private _FunctionTypes._return_P2_E0<? extends Integer, ? super Integer, ? super Integer> add = (memoizedCacheForClosures_0_Closure = new _FunctionTypes._return_P2_E0<Integer, Integer, Integer>() {
    public Integer invoke(final Integer a, final Integer b) {
      final KeyCalculator key = new KeyCalculator();
      key.addKey(a);
      key.addKey(b);
      Object value = Memoizator.retrieveFromCache(memoizedCacheForClosures_0, key);
      if (value == null) {
        final _FunctionTypes._return_P2_E0<? extends Integer, ? super Integer, ? super Integer> function = new _FunctionTypes._return_P2_E0<Integer, Integer, Integer>() {
          public Integer invoke(Integer a, Integer b) {
            closureCounter += 1;
            return a + b;
          }
        };
        final Object result = function.invoke(a, b);
        Memoizator.storeInCache(memoizedCacheForClosures_0, key, (result != null ? result : NullValue.NULL_CACHED_VALUE));
        value = result;
      }
      return (value == NullValue.NULL_CACHED_VALUE ? null : (Integer) value);
    }
  });
  private _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> fibonacci = (memoizedCacheForClosures_1_Closure = new _FunctionTypes._return_P1_E0<Long, Integer>() {
    public Long invoke(final Integer n) {
      final KeyCalculator key = new KeyCalculator();
      key.addKey(n);
      Object value = Memoizator.retrieveFromCache(memoizedCacheForClosures_1, key);
      if (value == null) {
        final _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> function = new _FunctionTypes._return_P1_E0<Long, Integer>() {
          public Long invoke(Integer n) {
            closureCounter += 1;
            if (n <= 2) {
              return 1L;
            }
            return memoizedCacheForClosures_1_Closure.invoke(n - 2) + memoizedCacheForClosures_1_Closure.invoke(n - 1);
          }
        };
        final Object result = function.invoke(n);
        Memoizator.storeInCache(memoizedCacheForClosures_1, key, (result != null ? result : NullValue.NULL_CACHED_VALUE));
        value = result;
      }
      return (value == NullValue.NULL_CACHED_VALUE ? null : (Long) value);
    }
  });
  private final Map<Integer, Object> memoizedCacheForClosures_0 = Memoizator.buildMemoizeCache(0);
  private _FunctionTypes._return_P2_E0<? extends Integer, ? super Integer, ? super Integer> memoizedCacheForClosures_0_Closure;
  private final Map<Integer, Object> memoizedCacheForClosures_1 = Memoizator.buildMemoizeCache(0);
  private _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> memoizedCacheForClosures_1_Closure;
  private final Map<Integer, Object> memoizedCacheForClosures_2 = Memoizator.buildMemoizeCache(0);
  private _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> memoizedCacheForClosures_2_Closure;
  private final Map<Integer, Object> memoizedCacheForClosures_3 = Memoizator.buildMemoizeCache(0);
  private _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> memoizedCacheForClosures_3_Closure;
  public void test_instanceMethod() throws Exception {
    Calculator calculator = new Calculator();
    Assert.assertEquals(TEN, calculator.add(6, 4));
    Assert.assertEquals(TEN, calculator.add(6, 4));
    Assert.assertEquals(TEN, calculator.add(3, 7));
    Assert.assertEquals(TEN, calculator.add(6, 4));
    Assert.assertEquals(2, calculator.retrieveCounter());
  }
  public void test_fibonacci() throws Exception {
    Calculator calculator = new Calculator();
    Assert.assertEquals(Long.valueOf(55), calculator.fibonacci(10));
    Assert.assertEquals(10, calculator.retrieveCounter());
    Assert.assertEquals(Long.valueOf(12586269025L), calculator.fibonacci(50));
  }
  public void test_nestedFibonacci() throws Exception {
    Calculator calculator = new Calculator();
    Calculator.NestedCalculator nestedCalculator = calculator.createNestedCalculator();
    Assert.assertEquals(Long.valueOf(55), nestedCalculator.fibonacci(10));
    Assert.assertEquals(10, calculator.retrieveCounter());
    Assert.assertEquals(Long.valueOf(12586269025L), nestedCalculator.fibonacci(50));
  }
  public void test_staticNestedFibonacci() throws Exception {
    Calculator.StaticNestedCalculator nestedCalculator = new Calculator.StaticNestedCalculator();
    Assert.assertEquals(Long.valueOf(55), nestedCalculator.fibonacci(10));
    Assert.assertEquals(10, nestedCalculator.retrieveCounter());
    Assert.assertEquals(Long.valueOf(12586269025L), nestedCalculator.fibonacci(50));
  }
  public void test_staticMethod() throws Exception {
    Assert.assertEquals(TEN, Calculator.adds(6, 4));
    Assert.assertEquals(TEN, Calculator.adds(6, 4));
    Assert.assertEquals(TEN, Calculator.adds(3, 7));
    Assert.assertEquals(TEN, Calculator.adds(6, 4));
    Assert.assertEquals(2, Calculator.staticCounter);
  }
  public void test_staticNestedClassStaticMethod() throws Exception {
    Assert.assertEquals(TEN, Calculator.StaticNestedCalculator.adds(6, 4));
    Assert.assertEquals(TEN, Calculator.StaticNestedCalculator.adds(6, 4));
    Assert.assertEquals(TEN, Calculator.StaticNestedCalculator.adds(3, 7));
    Assert.assertEquals(TEN, Calculator.StaticNestedCalculator.adds(6, 4));
    Assert.assertEquals(2, Calculator.staticCounter);
  }
  public void test_closure() throws Exception {
    Assert.assertEquals(TEN, add.invoke(6, 4));
    Assert.assertEquals(TEN, add.invoke(6, 4));
    Assert.assertEquals(TEN, add.invoke(3, 7));
    Assert.assertEquals(TEN, add.invoke(6, 4));
    Assert.assertEquals(2, closureCounter);
  }
  public void test_fibonacciClosure() throws Exception {
    Assert.assertEquals(Long.valueOf(55), fibonacci.invoke(10));
    Assert.assertEquals(10, closureCounter);
    Assert.assertEquals(Long.valueOf(12586269025L), fibonacci.invoke(50));
  }
  public void test_factorial() throws Exception {
    Assert.assertEquals(Long.valueOf(3628800), Calculator.factorial.invoke(10));
    Assert.assertEquals(10, Calculator.staticCounter);
    Assert.assertEquals(Long.valueOf(479001600), Calculator.factorial.invoke(12));
    Assert.assertEquals(12, Calculator.staticCounter);
  }
  public void test_staticNestedFactorial() throws Exception {
    Assert.assertEquals(Long.valueOf(3628800), Calculator.StaticNestedCalculator.factorial.invoke(10));
    Assert.assertEquals(10, Calculator.staticCounter);
    Assert.assertEquals(Long.valueOf(479001600), Calculator.StaticNestedCalculator.factorial.invoke(12));
    Assert.assertEquals(12, Calculator.staticCounter);
  }
  public void test_instanceFactorial() throws Exception {
    Calculator calculator = new Calculator();
    Assert.assertEquals(Long.valueOf(3628800), calculator.instanceFactorial.invoke(10));
    Assert.assertEquals(10, calculator.retrieveCounter());
    Assert.assertEquals(Long.valueOf(479001600), calculator.instanceFactorial.invoke(12));
    Assert.assertEquals(12, calculator.retrieveCounter());
  }
  public void test_nestedInstanceFactorial() throws Exception {
    Calculator calculator = new Calculator();
    Calculator.NestedCalculator nestedCalculator = calculator.createNestedCalculator();
    Assert.assertEquals(Long.valueOf(3628800), nestedCalculator.nestedInstanceFactorial.invoke(10));
    Assert.assertEquals(10, calculator.retrieveCounter());
    Assert.assertEquals(Long.valueOf(479001600), nestedCalculator.nestedInstanceFactorial.invoke(12));
    Assert.assertEquals(12, calculator.retrieveCounter());
  }
  public void test_staticNestedInstanceFactorial() throws Exception {
    Calculator.StaticNestedCalculator nestedCalculator = new Calculator.StaticNestedCalculator();
    Assert.assertEquals(Long.valueOf(3628800), nestedCalculator.nestedInstanceFactorial.invoke(10));
    Assert.assertEquals(10, nestedCalculator.retrieveCounter());
    Assert.assertEquals(Long.valueOf(479001600), nestedCalculator.nestedInstanceFactorial.invoke(12));
    Assert.assertEquals(12, nestedCalculator.retrieveCounter());
  }
  public void test_closureInMethodCall() throws Exception {
    final Wrappers._int localCounter = new Wrappers._int(0);
    Assert.assertEquals(Long.valueOf(65), addFib(10, (memoizedCacheForClosures_2_Closure = new _FunctionTypes._return_P1_E0<Long, Integer>() {
      public Long invoke(final Integer n) {
        final KeyCalculator key = new KeyCalculator();
        key.addKey(n);
        Object value = Memoizator.retrieveFromCache(memoizedCacheForClosures_2, key);
        if (value == null) {
          final _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> function = new _FunctionTypes._return_P1_E0<Long, Integer>() {
            public Long invoke(Integer n) {
              localCounter.value += 1;
              if (n <= 2) {
                return 1L;
              }
              return memoizedCacheForClosures_2_Closure.invoke(n - 2) + memoizedCacheForClosures_2_Closure.invoke(n - 1);
            }
          };
          final Object result = function.invoke(n);
          Memoizator.storeInCache(memoizedCacheForClosures_2, key, (result != null ? result : NullValue.NULL_CACHED_VALUE));
          value = result;
        }
        return (value == NullValue.NULL_CACHED_VALUE ? null : (Long) value);
      }
    })));
    Assert.assertEquals(10, localCounter.value);
  }
  public void test_repeatedClosureInMethodCall() throws Exception {
    final Wrappers._int localCounter = new Wrappers._int(0);
    _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> function = (memoizedCacheForClosures_3_Closure = new _FunctionTypes._return_P1_E0<Long, Integer>() {
      public Long invoke(final Integer n) {
        final KeyCalculator key = new KeyCalculator();
        key.addKey(n);
        Object value = Memoizator.retrieveFromCache(memoizedCacheForClosures_3, key);
        if (value == null) {
          final _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> function = new _FunctionTypes._return_P1_E0<Long, Integer>() {
            public Long invoke(Integer n) {
              localCounter.value += 1;
              if (n <= 2) {
                return 1L;
              }
              return memoizedCacheForClosures_3_Closure.invoke(n - 2) + memoizedCacheForClosures_3_Closure.invoke(n - 1);
            }
          };
          final Object result = function.invoke(n);
          Memoizator.storeInCache(memoizedCacheForClosures_3, key, (result != null ? result : NullValue.NULL_CACHED_VALUE));
          value = result;
        }
        return (value == NullValue.NULL_CACHED_VALUE ? null : (Long) value);
      }
    });
    Assert.assertEquals(Long.valueOf(65), addFib(10, function));
    Assert.assertEquals(10, localCounter.value);
    localCounter.value = 0;
    Assert.assertEquals(Long.valueOf(65), addFib(10, function));
    Assert.assertEquals(0, localCounter.value);
  }
  public void setUp() {
    closureCounter = 0;
    Calculator.staticCounter = 0;
  }
  public Long addFib(int n, _FunctionTypes._return_P1_E0<? extends Long, ? super Integer> fibClosure) {
    return n + fibClosure.invoke(n);
  }
}
