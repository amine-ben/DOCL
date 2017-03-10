/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.docl.docl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.docl.docl.TupleExp#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.docl.docl.DoclPackage#getTupleExp()
 * @model
 * @generated
 */
public interface TupleExp extends OclExpression
{
  /**
   * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
   * The list contents are of type {@link fr.inria.diverse.docl.docl.TuplePart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' containment reference list.
   * @see fr.inria.diverse.docl.docl.DoclPackage#getTupleExp_Parts()
   * @model containment="true"
   * @generated
   */
  EList<TuplePart> getParts();

} // TupleExp