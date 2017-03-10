/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.docl.docl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.docl.docl.SetType#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.diverse.docl.docl.SetType#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.docl.docl.DoclPackage#getSetType()
 * @model
 * @generated
 */
public interface SetType extends OclType
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.inria.diverse.docl.docl.DoclPackage#getSetType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.inria.diverse.docl.docl.SetType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Element Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element Type</em>' containment reference.
   * @see #setElementType(OclType)
   * @see fr.inria.diverse.docl.docl.DoclPackage#getSetType_ElementType()
   * @model containment="true"
   * @generated
   */
  OclType getElementType();

  /**
   * Sets the value of the '{@link fr.inria.diverse.docl.docl.SetType#getElementType <em>Element Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element Type</em>' containment reference.
   * @see #getElementType()
   * @generated
   */
  void setElementType(OclType value);

} // SetType
