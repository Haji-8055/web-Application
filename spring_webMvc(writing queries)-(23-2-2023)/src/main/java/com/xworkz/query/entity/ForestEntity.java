package com.xworkz.query.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "forest")
@NamedQuery(name = "findByName",query = "select entity from ForestEntity  entity where entity.name='Bandipur' ")
@NamedQuery(name = "findByState",query = "select entity from ForestEntity  entity where entity.state='goa' ")
@NamedQuery(name = "findByNameAndStateAndArea",query = "select entity from ForestEntity  entity where entity.name='Bandipur' and entity.state='Karnataka' and entity.area='874km^2' ")
@NamedQuery(name = "findAreaByName",query = "select entity.area from ForestEntity  entity where entity.name='Sundarbans' ")
@NamedQuery(name = "findIdByNameAndState",query = "select entity.id  from ForestEntity  entity where entity.name='Gir National Park' and entity.state='Gujarat' ")
@NamedQuery(name = "findNameById",query = "select entity.name from ForestEntity  entity where entity.id='5' ")
@NamedQuery(name = "findStateByNameAndArea",query = "select entity.state from ForestEntity  entity where entity.name='Shettihalli' and area='395km^2' ")
@NamedQuery(name = "findCount",query = "select count(entity) from ForestEntity entity")
public class ForestEntity {

	@Column(name = "id")
	@Id
	private int id;

	@Column(name = "f_name")
	private String name;

	@Column(name = "f_state")
	private String state;

	@Column(name = "f_area")
	private String area;

	@Column(name = "f_type")
	private String type;

}
