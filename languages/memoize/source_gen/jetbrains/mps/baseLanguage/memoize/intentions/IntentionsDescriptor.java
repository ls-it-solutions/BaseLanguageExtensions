package jetbrains.mps.baseLanguage.memoize.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntentionsDescriptor;
import jetbrains.mps.intentions.IntentionsManager;

public class IntentionsDescriptor extends BaseIntentionsDescriptor {
  public void init() {
    IntentionsManager.getInstance().registerIntentionFactory(new MakeClosureMemoized_Intention());
    IntentionsManager.getInstance().registerIntentionFactory(new MakeClosureNotMemoized_Intention());
    IntentionsManager.getInstance().registerIntentionFactory(new MakeMethodMemoized_Intention());
    IntentionsManager.getInstance().registerIntentionFactory(new MakeMethodNotMemoized_Intention());
  }
}
