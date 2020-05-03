package com.mrsisa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin_cc")
public class AdminCC extends UserAccount{

}
