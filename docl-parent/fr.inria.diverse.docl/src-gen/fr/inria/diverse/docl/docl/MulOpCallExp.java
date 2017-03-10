/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.docl.docl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mul Op Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.docl.docl.MulOpCallExp#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.docl.docl.DoclPackage#getMulOpCallExp()
 * @model
 * @generated
 */
public interface MulOpCallExp extends OclExpression
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(OclExpression)
   * @see fr.inria.diverse.docl.docl.DoclPackage#getMulOpCallExp_Source()
   * @model containment="true"
   * @generated
   */
  OclExpression getSource();

  /**
   * Sets the value of the '{@link fr.inria.diverse.docl.docl.MulOpCallExp#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(OclExpression value);

} // MulOpCallExp
