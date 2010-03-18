

package com.kursuspedia.domain

class UserGroupController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ userGroupInstanceList: UserGroup.list( params ), userGroupInstanceTotal: UserGroup.count() ]
    }

    def show = {
        def userGroupInstance = UserGroup.get( params.id )

        if(!userGroupInstance) {
            flash.message = "UserGroup not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ userGroupInstance : userGroupInstance ] }
    }

    def delete = {
		UserGroup.withTransaction {
	        def userGroupInstance = UserGroup.get( params.id )
	        if(userGroupInstance) {
	            try {
	                userGroupInstance.delete(flush:true)
	                flash.message = "UserGroup ${params.id} deleted"
	                redirect(action:list)
	            }
	            catch(org.springframework.dao.DataIntegrityViolationException e) {
	                flash.message = "UserGroup ${params.id} could not be deleted"
	                redirect(action:show,id:params.id)
	            }
	        }
	        else {
	            flash.message = "UserGroup not found with id ${params.id}"
	            redirect(action:list)
	        }			
		}
    }

    def edit = {
        def userGroupInstance = UserGroup.get( params.id )

        if(!userGroupInstance) {
            flash.message = "UserGroup not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ userGroupInstance : userGroupInstance ]
        }
    }

    def update = {
		UserGroup.withTransaction {
	        def userGroupInstance = UserGroup.get( params.id )
	        if(userGroupInstance) {
	            if(params.version) {
	                def version = params.version.toLong()
	                if(userGroupInstance.version > version) {
	                    
	                    userGroupInstance.errors.rejectValue("version", "userGroup.optimistic.locking.failure", "Another user has updated this UserGroup while you were editing.")
	                    render(view:'edit',model:[userGroupInstance:userGroupInstance])
	                    return
	                }
	            }
	            userGroupInstance.properties = params
	            if(!userGroupInstance.hasErrors() && userGroupInstance.save()) {
	                flash.message = "UserGroup ${params.id} updated"
	                redirect(action:show,id:userGroupInstance.id)
	            }
	            else {
	                render(view:'edit',model:[userGroupInstance:userGroupInstance])
	            }
	        }
	        else {
	            flash.message = "UserGroup not found with id ${params.id}"
	            redirect(action:list)
	        }			
		}
    }

    def create = {
        def userGroupInstance = new UserGroup()
        userGroupInstance.properties = params
        return ['userGroupInstance':userGroupInstance]
    }

    def save = {
        def userGroupInstance = new UserGroup(params)
		UserGroup.withTransaction {
	        if(userGroupInstance.save(flush:true)) {
	            flash.message = "UserGroup ${userGroupInstance.id} created"
	            redirect(action:show,id:userGroupInstance.id)
	        }
	        else {
	            render(view:'create',model:[userGroupInstance:userGroupInstance])
	        }
		}
    }
}
