package ancm.springframework.sftpetclinic.services.map;

import ancm.springframework.sftpetclinic.model.Owner;
import ancm.springframework.sftpetclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}



}
