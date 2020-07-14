/*
 *
 */
package com.cdk.shopping.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Data;

@MappedSuperclass
@EntityListeners({AbstractEntity.AbstractEntityListener.class})

/**
 * Instantiates a new abstract entity.
 */
@Data
public abstract class AbstractEntity implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The uid. */
  @Id
  @Column(name = "ID", length = 36)
  protected String uid;

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object o) {
    return o == this || (o instanceof AbstractEntity && uid().equals(((AbstractEntity) o).uid()));
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return uid().hashCode();
  }

  /**
   * Uid.
   *
   * @return the string
   */
  String uid() {
    if (uid == null) {
      uid = UUID.randomUUID().toString();
    }
    return uid;
  }

  /**
   * The listener interface for receiving abstractEntity events. The class that is interested in
   * processing a abstractEntity event implements this interface, and the object created with that
   * class is registered with a component using the component's <code>addAbstractEntityListener
   * <code> method. When the abstractEntity event occurs, that object's appropriate method is
   * invoked.
   *
   */
  public static class AbstractEntityListener {

    /**
     * On pre persist.
     *
     * @param abstractEntity the abstract entity
     */
    @PrePersist
    public void onPrePersist(AbstractEntity abstractEntity) {
      abstractEntity.uid();
    }
  }
}
