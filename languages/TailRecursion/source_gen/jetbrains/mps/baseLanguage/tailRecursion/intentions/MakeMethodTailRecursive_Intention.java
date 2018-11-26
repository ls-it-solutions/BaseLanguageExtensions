package jetbrains.mps.baseLanguage.tailRecursion.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class MakeMethodTailRecursive_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public MakeMethodTailRecursive_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:6df770e3-0000-4824-9d7d-6d58a2073987(jetbrains.mps.baseLanguage.tailRecursion.intentions)", "9009622095742545593"));
  }
  @Override
  public String getPresentation() {
    return "MakeMethodTailRecursive";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xf142cd5eea1d466aL, 0x86a852891b6256a4L, 0x3bfd4b2e2a91bbb4L, "jetbrains.mps.baseLanguage.tailRecursion.structure.TailRecursion"))) == null;
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new MakeMethodTailRecursive_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Make Method Tail Recursive";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNodeFactoryOperations.setNewAttribute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xf142cd5eea1d466aL, 0x86a852891b6256a4L, 0x3bfd4b2e2a91bbb4L, "jetbrains.mps.baseLanguage.tailRecursion.structure.TailRecursion")), MetaAdapterFactory.getConcept(0xf142cd5eea1d466aL, 0x86a852891b6256a4L, 0x3bfd4b2e2a91bbb4L, "jetbrains.mps.baseLanguage.tailRecursion.structure.TailRecursion"));
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return MakeMethodTailRecursive_Intention.this;
    }
  }
}
