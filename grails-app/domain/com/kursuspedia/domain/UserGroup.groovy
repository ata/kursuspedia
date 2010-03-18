package com.kursuspedia.domain



import javax.persistence.*;
// import com.google.appengine.api.datastore.Key;

@Entity
class UserGroup implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id
	
	String name
	
	@OneToMany(mappedBy="group")
	List<User> users
	
    static constraints = {
    	id visible:false
	}
	
	String toString()
	{
		return name
	}
}
