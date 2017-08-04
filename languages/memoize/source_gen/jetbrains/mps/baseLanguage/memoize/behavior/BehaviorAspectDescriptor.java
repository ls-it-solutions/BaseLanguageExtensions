package jetbrains.mps.baseLanguage.memoize.behavior;

/*Generated by MPS */

import jetbrains.mps.core.aspects.behaviour.BaseBehaviorAspectDescriptor;
import jetbrains.mps.core.aspects.behaviour.api.BHDescriptor;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.lang.smodel.ConceptSwitchIndex;
import jetbrains.mps.lang.smodel.ConceptSwitchIndexBuilder;
import jetbrains.mps.smodel.adapter.ids.MetaIdFactory;

public final class BehaviorAspectDescriptor extends BaseBehaviorAspectDescriptor {
  private final BHDescriptor myMemoizeAnnotation__BehaviorDescriptor = new MemoizeAnnotation__BehaviorDescriptor();

  public BehaviorAspectDescriptor() {
  }

  @Nullable
  public BHDescriptor getDescriptor(@NotNull SAbstractConcept concept) {
    SAbstractConcept cncpt_a0e = concept;
    switch (index_846f5o_a0e.index(cncpt_a0e)) {
      case 0:
        return myMemoizeAnnotation__BehaviorDescriptor;
      default:
    }
    return null;
  }
  private static final ConceptSwitchIndex index_846f5o_a0e = new ConceptSwitchIndexBuilder().put(MetaIdFactory.conceptId(0x9f9722b27c9743c8L, 0x9771bea4630e2676L, 0x182d299b1158e74fL)).seal();
}
