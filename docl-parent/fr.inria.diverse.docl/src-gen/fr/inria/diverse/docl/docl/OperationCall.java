/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.docl.docl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.docl.docl.OperationCall#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.docl.docl.DoclPackage#getOperationCall()
 * @model
 * @generated
 */
public interface OperationCall extends OclExpression
{
  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
   * The list contents are of type {@link fr.inria.diverse.docl.docl.OclExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference list.
   * @see fr.inria.diverse.docl.docl.DoclPackage#getOperationCall_Arguments()
   * @model containment="true"
   * @generated
   */
  EList<OclExpression> getArguments();

} // OperationCall