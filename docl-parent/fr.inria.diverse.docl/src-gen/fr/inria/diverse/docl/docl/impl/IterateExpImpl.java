/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.docl.docl.impl;

import fr.inria.diverse.docl.docl.DoclPackage;
import fr.inria.diverse.docl.docl.IterateExp;
import fr.inria.diverse.docl.docl.Iterator;
import fr.inria.diverse.docl.docl.LocalVariable;
import fr.inria.diverse.docl.docl.OclExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.docl.docl.impl.IterateExpImpl#getIterators <em>Iterators</em>}</li>
 *   <li>{@link fr.inria.diverse.docl.docl.impl.IterateExpImpl#getResult <em>Result</em>}</li>
 *   <li>{@link fr.inria.diverse.docl.docl.impl.IterateExpImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterateExpImpl extends OclExpressionImpl implements IterateExp
{
  /**
   * The cached value of the '{@link #getIterators() <em>Iterators</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIterators()
   * @generated
   * @ordered
   */
  protected EList<Iterator> iterators;

  /**
   * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResult()
   * @generated
   * @ordered
   */
  protected LocalVariable result;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected OclExpression body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IterateExpImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DoclPackage.Literals.ITERATE_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Iterator> getIterators()
  {
    if (iterators == null)
    {
      iterators = new EObjectContainmentEList<Iterator>(Iterator.class, this, DoclPackage.ITERATE_EXP__ITERATORS);
    }
    return iterators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalVariable getResult()
  {
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResult(LocalVariable newResult, NotificationChain msgs)
  {
    LocalVariable oldResult = result;
    result = newResult;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DoclPackage.ITERATE_EXP__RESULT, oldResult, newResult);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResult(LocalVariable newResult)
  {
    if (newResult != result)
    {
      NotificationChain msgs = null;
      if (result != null)
        msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DoclPackage.ITERATE_EXP__RESULT, null, msgs);
      if (newResult != null)
        msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DoclPackage.ITERATE_EXP__RESULT, null, msgs);
      msgs = basicSetResult(newResult, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DoclPackage.ITERATE_EXP__RESULT, newResult, newResult));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OclExpression getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(OclExpression newBody, NotificationChain msgs)
  {
    OclExpression oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DoclPackage.ITERATE_EXP__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(OclExpression newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DoclPackage.ITERATE_EXP__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DoclPackage.ITERATE_EXP__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DoclPackage.ITERATE_EXP__BODY, newBody, newBody));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DoclPackage.ITERATE_EXP__ITERATORS:
        return ((InternalEList<?>)getIterators()).basicRemove(otherEnd, msgs);
      case DoclPackage.ITERATE_EXP__RESULT:
        return basicSetResult(null, msgs);
      case DoclPackage.ITERATE_EXP__BODY:
        return basicSetBody(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DoclPackage.ITERATE_EXP__ITERATORS:
        return getIterators();
      case DoclPackage.ITERATE_EXP__RESULT:
        return getResult();
      case DoclPackage.ITERATE_EXP__BODY:
        return getBody();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DoclPackage.ITERATE_EXP__ITERATORS:
        getIterators().clear();
        getIterators().addAll((Collection<? extends Iterator>)newValue);
        return;
      case DoclPackage.ITERATE_EXP__RESULT:
        setResult((LocalVariable)newValue);
        return;
      case DoclPackage.ITERATE_EXP__BODY:
        setBody((OclExpression)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DoclPackage.ITERATE_EXP__ITERATORS:
        getIterators().clear();
        return;
      case DoclPackage.ITERATE_EXP__RESULT:
        setResult((LocalVariable)null);
        return;
      case DoclPackage.ITERATE_EXP__BODY:
        setBody((OclExpression)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DoclPackage.ITERATE_EXP__ITERATORS:
        return iterators != null && !iterators.isEmpty();
      case DoclPackage.ITERATE_EXP__RESULT:
        return result != null;
      case DoclPackage.ITERATE_EXP__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //IterateExpImpl
