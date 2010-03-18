package com.kursuspedia.domain



import javax.persistence.*;
// import com.google.appengine.api.datastore.Key;

@Entity
class Role implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id
	
	String name

    static constraints = {
    	id visible:false
	}
}
