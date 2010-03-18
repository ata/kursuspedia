package com.kursuspedia.domain



import javax.persistence.*;
// import com.google.appengine.api.datastore.Key;

@Entity
class User implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id
	
	@ManyToOne(cascade=[CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH])
	UserGroup group
	
	
	String username
	String password
	String email
	

    static constraints = {
    	id visible:false
	}
}
